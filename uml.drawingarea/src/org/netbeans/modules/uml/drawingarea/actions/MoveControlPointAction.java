/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.netbeans.modules.uml.drawingarea.actions;

import org.netbeans.api.visual.action.MoveControlPointProvider;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.Widget;

import java.awt.*;
import java.awt.event.MouseEvent;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.modules.uml.drawingarea.view.DesignerScene;

/**
 * modified action to handle case when ends points should be handled by this acxtion
 * default action from visual library cause issues like issue http://www.netbeans.org/issues/show_bug.cgi?id=138008
 * may be it can be adjusted with provider, need to reverify later
 * free provider return null for suggested location for starting/finishing points but it means lock never released
 * it may be a bug in visual library also and need to be fixed here
 * @author David Kaspar
 */
public final class MoveControlPointAction extends WidgetAction.LockedAdapter {

    private MoveControlPointProvider provider;
    private ConnectionWidget.RoutingPolicy routingPolicy;

    private ConnectionWidget movingWidget = null;
    private Point controlPointLocation;
    private int controlPointIndex;
    private Point lastLocation = null;

    public MoveControlPointAction (MoveControlPointProvider provider, ConnectionWidget.RoutingPolicy routingPolicy) {
        this.provider = provider;
        this.routingPolicy = routingPolicy;
    }

    protected boolean isLocked () {
        return movingWidget != null;
    }

    public State mousePressed (Widget widget, WidgetMouseEvent event) {
        if (isLocked ())
            return State.createLocked (widget, this);
        if (event.getButton () == MouseEvent.BUTTON1  &&  event.getClickCount () == 1) {
            if (widget instanceof ConnectionWidget) {
                ConnectionWidget conn = (ConnectionWidget) widget;
                controlPointIndex = conn.getControlPointHitAt (event.getPoint ());
                if (controlPointIndex > 0 && controlPointIndex<(conn.getControlPoints().size()-1)) {
                    movingWidget = conn;
                    controlPointLocation = new Point (conn.getControlPoints (). get (controlPointIndex));
                    lastLocation = new Point (event.getPoint ());
                    return State.createLocked (widget, this);
                } else {
                    movingWidget = null;
                }
            }
        }
        return State.REJECTED;
    }

    public State mouseReleased (Widget widget, WidgetMouseEvent event) {
        State state = move (widget, event.getPoint ());
        if (state.isConsumed ())
            movingWidget = null;
        return state;
    }

    public State mouseDragged (Widget widget, WidgetMouseEvent event) {
        State state =  move (widget, event.getPoint ());
        if (state.isConsumed ())
        {
            //mark the diagram dirty after moving the control point
            Scene scene = widget.getScene();
            if (scene instanceof DesignerScene)
            {
                ((DesignerScene)scene).getDiagram().setDirty(true);
            }
        }
        return state;
    }

    private State move (Widget widget, Point newLocation) {
        if (movingWidget != widget)
            return State.REJECTED;

        java.util.List<Point> controlPoints = movingWidget.getControlPoints ();
        if (controlPointIndex <= 0  ||  controlPointIndex >= (controlPoints.size ()-1))
            return State.REJECTED;

        Point location = new Point (controlPointLocation);
        location.translate (newLocation.x - lastLocation.x, newLocation.y - lastLocation.y);

        controlPoints = provider.locationSuggested (movingWidget, controlPointIndex, location);
        if (controlPoints == null)
            return State.REJECTED;

        if (routingPolicy != null)
            movingWidget.setRoutingPolicy (routingPolicy);
        movingWidget.setControlPoints (controlPoints, false);
        
        movingWidget.getSourceAnchor().getRelatedWidget().revalidate();
        movingWidget.getTargetAnchor().getRelatedWidget().revalidate();
        
        return State.createLocked (widget, this);
    }

}
