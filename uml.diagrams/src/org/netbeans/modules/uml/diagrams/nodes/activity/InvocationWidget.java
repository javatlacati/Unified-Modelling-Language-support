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
 * 
 * Contributor(s):
 * 
 * Portions Copyrighted 2007 Sun Microsystems, Inc.
 */
package org.netbeans.modules.uml.diagrams.nodes.activity;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingUtilities;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.modules.uml.core.metamodel.common.commonactivities.IInvocationNode;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IPresentationElement;
import org.netbeans.modules.uml.diagrams.nodes.MultilineEditableCompartmentWidget;
import org.netbeans.modules.uml.diagrams.nodes.RoundedRectWidget;
import org.netbeans.modules.uml.drawingarea.view.ResourceType;
import org.netbeans.modules.uml.drawingarea.view.UMLLabelWidget;

/**
 *
 * @author thuy
 */
public class InvocationWidget extends ActivityNodeWidget {

    private static final int MIN_NODE_WIDTH = 80;
    private static final int MIN_NODE_HEIGHT = 60;

    public InvocationWidget(Scene scene) {
        super(scene, true, false);
        setMinimumSize(new Dimension(MIN_NODE_WIDTH, MIN_NODE_HEIGHT));
    }

    @Override
    public void initializeNode(IPresentationElement presentation) {
        if (presentation != null) {
            IInvocationNode invocationElem = (IInvocationNode) presentation.getFirstSubject();
            Scene scene = getScene();

            //create main view 
            RoundedRectWidget mainView = new RoundedRectWidget(scene,
                    getResourcePath(),
                    bundle.getString("LBL_body"));

            mainView.setLayout(
                    LayoutFactory.createVerticalFlowLayout(
                            LayoutFactory.SerialAlignment.JUSTIFY, 0));

            mainView.setUseGradient(useGradient);
            mainView.setCustomizableResourceTypes(
                    new ResourceType[]{ResourceType.BACKGROUND});
            mainView.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            mainView.setOpaque(true);

            // stereotype widget
            mainView.addChild(createStereoTypeWidget());
            enableStereoTypeWidget(invocationElem);

            // create multiline editable widget     
            nameWidget = new MultilineEditableCompartmentWidget(scene, "", null,
                    mainView,
                    getResourcePath(),
                    bundle.getString("LBL_text"));
            nameWidget.setAlignment(UMLLabelWidget.Alignment.CENTER);
            String labelStr = invocationElem.getNameWithAlias();
            nameWidget.setLabel(labelStr != null && labelStr.trim().length() > 0 ? labelStr : "");
            mainView.addChild(nameWidget, 1);

            // tagged value widget
            SwingUtilities.invokeLater(
                    new Runnable() {
                @Override
                public void run() {
                    mainView.addChild(createTaggedValueWidget());
                    enableTaggedValueWidget(invocationElem);
                }
            }
            );

            setCurrentView(mainView);
            setFont(getCurrentView().getFont());
        }
        super.initializeNode(presentation);
    }

    @Override
    public Dimension getDefaultMinimumSize() {
        return new Dimension(MIN_NODE_WIDTH, MIN_NODE_HEIGHT);
    }

    @Override
    public String getWidgetID() {
        return UMLWidgetIDString.INVOCATIONWIDGET.toString();
    }

    @Override
    protected void notifyFontChanged(Font font) {
        if (nameWidget != null) {
            nameWidget.setFont(font);
        }
        revalidate();
    }

}
