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


/*
 * File       : TemplateClassStateHandler.java
 * Created on : Dec 12, 2003
 * Author     : Aztec
 */
package org.netbeans.modules.uml.core.reverseengineering.parsingfacilities.translation.statehandlers;

import org.dom4j.Node;

/**
 * @author Aztec
 */
public class TemplateClassStateHandler extends ClassStateHandler
{

    public TemplateClassStateHandler(String language, String packageName)
    {
       this(language, packageName, false);
    }

    public TemplateClassStateHandler(String language, String packageName, boolean isInner)
    {
        super(language, packageName, isInner);
    }


    public StateHandler createSubStateHandler(String stateName, String language)
    {
        StateHandler retVal = null;

        if("Template Parameter".equals(stateName))
        {
            retVal = new TemplateParameterStateHandler();
        }
        else if("Class Declaration".equals(stateName))
        {
            retVal = new TemplateClassStateHandler(language, getPackageName(), true);  
        }
        else if("Interface Declaration".equals(stateName))
        {
            retVal = new TemplateInterfaceStateHandler(language, null, true);
        }
        else
        {
            retVal = super.createSubStateHandler(stateName, language);
        }

        if((retVal != null) && (retVal != this))
        {   
            Node pClassNode = getDOMNode();

            if(pClassNode != null)
            {
                retVal.setDOMNode(pClassNode);
            }
        }
        return retVal;
    }
    
    

    /* (non-Javadoc)
     * @see org.netbeans.modules.uml.core.reverseengineering.parsingfacilities.translation.statehandlers.StateHandler#stateComplete(java.lang.String)
     */
    public void stateComplete(String stateName)
    {
        super.stateComplete(stateName);
    }

}