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

package org.netbeans.modules.uml.core.support.umlutils;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.netbeans.modules.uml.core.metamodel.structure.IProject;
public interface IPropertyElement
{
	/**
	 * Name of property element
	*/
	String getName();

	/**
	 * Name of property element
	*/
	void setName(String value);

	/**
	 * Value of the property element
	*/
	String getValue();

	/**
	 * Value of the property element
	*/
	void setValue(String value);

	/**
	 * Child properties of this property, get IPropertyElement[]
	*/
	List<IPropertyElement> getSubElements();
	HashMap<String, IPropertyElement> getHashedSubElements();

	/**
	 * Child properties of this property
	*/
	void setSubElements(List<IPropertyElement> value);

	/**
	 * Add a new property element to the property
	*/
	void addSubElement(IPropertyElement element);

	/**
	 * Gets a specific sub property by index
	*/
	IPropertyElement getSubElement(int index, IPropertyElement element);
	IPropertyElement getSubElement(String name, IPropertyElement element);

	/**
	 * Gets this elements corresponding definition
	*/
	IPropertyDefinition getPropertyDefinition();

	/**
	 * Gets this elements corresponding definition
	*/
	void setPropertyDefinition(IPropertyDefinition value);

	/**
	 * Gets this elements corresponding element
	*/
	Object getElement();

	/**
	 * Gets this elements corresponding element
	*/
	void setElement(Object value);

	/**
	 * Parent element of this property element
	*/
	IPropertyElement getParent();

	/**
	 * Parent element of this property element
	*/
	void setParent(IPropertyElement value);

	/**
	 * Determines whether or not this element has been modified
	*/
	boolean getModified();

	/**
	 * Determines whether or not this element has been modified
	*/
	void setModified(boolean value);

	/**
	 * Gets whether or not this element needs to be built immediately
	*/
	boolean getOnDemand();

	/**
	 * Gets whether or not this element needs to be built immediately
	*/
	void setOnDemand(boolean value);

	/**
	 * Tells a property element to store itself
	*/
	boolean save();

	/**
	 * Original value of the property element
	*/
	String getOrigValue();

	/**
	 * Original value of the property element
	*/
	void setOrigValue(String value);

	/**
	 * Tells a property element to remove itself
	*/
	void remove();

	/**
	 * Returns the path to this element by getting each of the parent names and building a | delimited string
	*/
	String getPath();

	/**
	 * Translated value of the property element
	*/
	String getTranslatedValue();

	/**
	 * The PropertyElementManager is a helper object for saving/restoring this Element in the proper language format.
	*/
	IPropertyElementManager getPropertyElementManager();

	/**
	 * The PropertyElementManager is a helper object for saving/restoring this Element in the proper language format.
	*/
	void setPropertyElementManager(IPropertyElementManager value);

        IProject getProject();

	String toString();
}
