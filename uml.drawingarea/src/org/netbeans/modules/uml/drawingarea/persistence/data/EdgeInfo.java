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
package org.netbeans.modules.uml.drawingarea.persistence.data;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.netbeans.modules.uml.core.metamodel.core.foundation.IPresentationElement;

/**
 *
 * @author jyothi
 */
public class EdgeInfo
{

    private String PEID;
    private String MEID;
    private List wayPoints = new ArrayList<Point>();
    private IPresentationElement sourcePE;
    private IPresentationElement targetPE;
    private ArrayList<EdgeLabel> labels = new ArrayList();
    private ArrayList<EndDetails> ends = new ArrayList();
    private boolean hasContainedElements = false;
    private HashMap properties = new HashMap();
    private String semanticModelBridgePresentation = "";

    public ArrayList<EdgeInfo.EdgeLabel> getLabels()
    {
        return labels;
    }

    public ArrayList<EdgeInfo.EndDetails> getEnds()
    {
        return ends;
    }

    public boolean isHasContainedElements()
    {
        return hasContainedElements;
    }

    public String getMEID()
    {
        return MEID;
    }

    public String getPEID()
    {
        return PEID;
    }

    public IPresentationElement getSourcePE()
    {
        return sourcePE;
    }

    public Object setProperty(String key, Object value) {
        return properties.put(key, value);
    }
    public Object getProperty(String key) {
        return properties.get(key);
    }

    public void setSourcePE(IPresentationElement sourcePE)
    {
        this.sourcePE = sourcePE;
    }

    public void setTargetPE(IPresentationElement targetPE)
    {
        this.targetPE = targetPE;
    }

    public IPresentationElement getTargetPE()
    {
        return targetPE;
    }

    public List getWayPoints()
    {
        return wayPoints;
    }

    public void setMEID(String MEID)
    {
        this.MEID = MEID;
    }

    public void setPEID(String PEID)
    {
        this.PEID = PEID;
    }

    public void setEnds(ArrayList<EdgeInfo.EndDetails> ends)
    {
        this.ends = ends;
    }

    public void setHasContainedElements(boolean hasContainedElements)
    {
        this.hasContainedElements = hasContainedElements;
    }

    public void setLabels(ArrayList<EdgeInfo.EdgeLabel> labels)
    {
        this.labels = labels;
    }

    public void setWayPoints(List wayPoints)
    {
        this.wayPoints = wayPoints;
    }

    public HashMap getProperties()
    {
        return properties;
    }

    public void setProperties(HashMap properties)
    {
        this.properties = properties;
    }

    public String getSemanticModelBridgePresentation()
    {
        return semanticModelBridgePresentation;
    }

    public void setSemanticModelBridgePresentation(String semanticModelBridgePresentation)
    {
        this.semanticModelBridgePresentation = semanticModelBridgePresentation;
    }
    
    

    public class EdgeLabel
    {

        private String label;
        private Point position;
        private Dimension size;
        private HashMap<String, String> labelProperties = new HashMap();

        public EdgeLabel()
        {
        }

        public String getLabel()
        {
            return label;
        }

        public void setLabel(String label)
        {
            this.label = label;
        }

        public Point getPosition()
        {
            return position;
        }

        public void setPosition(Point position)
        {
            this.position = position;
        }

        public Dimension getSize()
        {
            return size;
        }

        public void setSize(Dimension size)
        {
            this.size = size;
        }

        public HashMap<String, String> getLabelProperties()
        {
            return labelProperties;
        }

        public void setLabelProperties(HashMap<String, String> labelProperties)
        {
            this.labelProperties = labelProperties;
        }
        
        
    }

    public class EndDetails
    {

        private String ID;
        private ArrayList<EdgeLabel> endEdgeLabels = new ArrayList();

        public EndDetails()
        {

        }

        public String getID()
        {
            return ID;
        }

        public void setID(String ID)
        {
            this.ID = ID;
        }

        public ArrayList<EdgeInfo.EdgeLabel> getEndEdgeLabels()
        {
            return endEdgeLabels;
        }

        public void setEndEdgeLabels(ArrayList<EdgeInfo.EdgeLabel> endEdgeLabels)
        {
            this.endEdgeLabels = endEdgeLabels;
        }
    }

    
    @Override
    public String toString()
    {
        StringBuilder buff = new StringBuilder();
        buff.append(", PEID=").append(getPEID()).append(", MEID=")
            .append(getMEID())
            .append(", sourcePE=")
//            .append(", position=" + getPosition())
            .append(getSourcePE().getDisplayElementID())
//            .append(", position=" + getPosition())
            .append(", targetPE=")
            .append(getTargetPE().getDisplayElementID())
            .append(", hasContaintedElements=")
//            .append(", showName=" + isShowName())
//            .append(", stereotypeVisible=" + isStereotypeVisible())
            .append(isHasContainedElements())
//            .append(", showName=" + isShowName())
//            .append(", stereotypeVisible=" + isStereotypeVisible())
            .append(", lables=")
            .append(getLabels())
            .append(", ends=")
            .append(getEnds())
            .append(", wayPoints=")
            .append(getWayPoints());
            
        return buff.toString();
    }
}
