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

package org.netbeans.modules.uml.core.preferenceframework;

import org.netbeans.modules.uml.core.coreapplication.ICoreProduct;
import org.netbeans.modules.uml.core.coreapplication.IPreferenceManager2;
import org.netbeans.modules.uml.core.support.umlsupport.ProductRetriever;
import org.openide.util.NbBundle;

/**
 * @author sumitabhk
 *
 */
public class PreferenceAccessor implements IPreferenceAccessor{

	private static PreferenceAccessor m_Instance = null;
        private static String unknownClassifierType = "DataType";
	
	private PreferenceAccessor()
	{
	}
	
	public static PreferenceAccessor instance()
	{
		if (m_Instance == null)
		{
			m_Instance = new PreferenceAccessor();
		}
		return m_Instance;
	}

	/**
	 * Retrieves the default name to use for a new project from the preference file.
	 *
	 * @param name[out]	The default name
	 *
	 * @return HRESULT
	 *
	 */
	public String getDefaultProjectName() {
		//all callers removed.
            throw new UnsupportedOperationException("DefaultProjectName pref no longer valid.");
	}

	/**
	 * Gets the IDType preference from the preference file.  This is the
	 * type of id to create when generating a unique id.
	 *
	 * @param type[out]	The id type found in the file
	 *
	 * @return HRESULT
	 *
	 */
	public int getIDType() {
            //kris richards - "IDType" pref expunged. Also, this method is never called.
            throw new UnsupportedOperationException ("IDType pref no longer valid.") ;
	}

	/**
	 * Gets the default element name from the preferences file.  This is the
	 * name to be used when a new element is created.
	 * 
	 *
	 * @param *name[out] The name to use for unnamed elements
	 *
	 * @return HRESULT
	 *
	 */
	public String getDefaultElementName() {
            //kris richards - "DefaultElementName" pref expunged. Set to "Unnamed"
            
            return NbBundle.getMessage(PreferenceAccessor.class, "UNNAMED");
        }

	/**
	 * Gets a flag from the preferences file which tells us whether or not to create a classifier
	 * if Describe cannot resolve it to the model or any of its imported packages.
	 * 
	 *
	 * @param val[out]	Whether or not to create
	 *
	 * @return HRESULT
	 *
	 */
	public boolean getUnknownClassifierCreate() {
            //kris richards - "UnknownClassifierCreate" pref expunged. Set to true.
		
            return true ;
	}

	/**
	 * When Describe has been told to create a classifier if it cannot 
	 * be resolved in the model or any imported packages, this is the 
	 * type of element to create.  This is retrieved from the preferences file.
	 *
	 * @param val[out]	The type of element to create
	 *
	 * @return HRESULT
	 *
	 */
	public String getUnknownClassifierType() {
            //kris richards - "UnknownClassifierType" pref expunged. Set to "DataType"
            //change default to Class: see issue 110338
//            return "DataType" ; //returning "Class" causes other problems (see issue 111821)
            return unknownClassifierType;
            
	}
        
        // workaround for 110338, default type for creating unknown lifeline representing classifier is different
        public synchronized void setUnknownClassifierType(String type) {
            unknownClassifierType = type;
        }

	/**
	 * The default mode of a new Describe session found in the preferences file.
	 *
	 * @param *val[out]	The mode
	 *
	 * @return HRESULT
	 *
	 */
	public String getDefaultMode() {
            //kris richards - all calls to this have been removed.
	
            throw new UnsupportedOperationException ("DefaultMode pref no longer valid.");
	}

	/**
	 * The default language for a new Describe session based on the mode in the preferences file.
	 *
	 * @param mode[in]	The mode
	 * @param val[out]	The default language
	 *
	 * @return HRESULT
	 *
	 */
	public String getDefaultLanguage(String mode) {
            String lang = "Java" ;
            if ( ! mode.equals("Implementation")) 
                lang = "UML" ;

                return lang ;
	}

	/**
	 *
	 * Based on a particular language and behavior type, this 
	 * retrieves the behavior value in the preferences file.
	 *
	 * @param lang[in]		The language
	 * @param behavior[in]	The behavior type
	 * @param *val[out]		The value of the behavior
	 *
	 * @return HRESULT
	 *
	 */
	public String getDefaultRoundTripBehavior(String lang, String behavior) {
            throw new UnsupportedOperationException ("RoundTrip prefs are no long valid.");
	}

	/**
	 * Retrieves the default customization file to be used for the property editor specified 
	 * in the preferences file.
	 * 
	 *
	 * @param val[out] The file
	 *
	 * @return HRESULT
	 *
	 */
	public String getDefaultEditorCustomizationFile() {
            throw new UnsupportedOperationException ("PropertyEditor|CustomizationFile pref is no long valid.");
	}

	/**
	 * Retrieves the default filter from the preferences file to be used for the property editor.
	 *
	 * @param *val[out] The default filter
	 *
	 * @return HRESULT
	 *
	 */
	public String getDefaultEditorFilter() {
            throw new UnsupportedOperationException ("This pref is no long valid.");
	}

	/**
	 * Retrieves the max number to select from the preference file for the property editor.
	 *
	 * @param *val[out]	The max number for selection
	 *
	 * @return HRESULT
	 *
	 */
	public int getDefaultEditorSelect() {
            //kris richards - MaxSelect pref expunged
            throw new UnsupportedOperationException ("MaxSelect pref is no long valid.");
	}

	/**
	 *	Retrieves a value for a particular expansion variable in the preferences file.
	 *
	 * @param name[in]	The variable to find
	 * @param val[in]	The value
	 *
	 * @return HRESULT
	 *
	 */
	public String getExpansionVariable(String name) {
		throw new UnsupportedOperationException ("getExpansionVariable pref is no long valid.");
	}

	/**
	 * Asks the preference manager to read the preference file and get the asked
	 * for information.
	 * 
	 *
	 * @param key[in]	"key" preference is found under, if blank, look in "Default"
	 * @param path[in]	Path to the preference (if preference is nested, this is the "|" delimited path
	 * @param name[in]	Name of preference
	 * @param pVal[out]	Preference value
	 *
	 * @return HRESULT
	 *
	 */
	private String getPreferenceValue(String key, String path, String name) {
            //throw new UnsupportedOperationException ("key="+key+"::path="+path+"::name="+name+":: Using old options.");
            
		String value = "";
		ICoreProduct prod = ProductRetriever.retrieveProduct();
		if (prod != null)
		{
			IPreferenceManager2 prefMan = prod.getPreferenceManager();
			if (prefMan != null)
			{
				if (key.length() > 0)
				{
					value = prefMan.getPreferenceValue(key, path, name);
				}
				else
				{
					value = prefMan.getPreferenceValue(path, name);
				}
			}
		}
		return value;
	}

	/**
	 * Based on a particular font category (DefaultClassFont, DefaultFont, etc), this retrieves 
	 * the font name value in the preferences file.
	 *
	 * @param category[in]	The font category
	 * @param *val[out]		The font name for this category
	 *
	 * @return HRESULT
	 */
	public String getFontName(String category) {
		String str = "Presentation|";
		str += category;
		String value = getPreferenceValue("", str, "FaceName");
		return value;
	}

	/**
	 * Based on a particular font category (DefaultClassFont, DefaultFont, etc), this retrieves 
	 * the font size value in the preferences file.
	 *
	 * @param category[in]	The font category
	 * @param *val[out]		The font size for this category
	 *
	 * @return HRESULT
	 */
	public String getFontSize(String category) {
		String str = "Presentation|";
		str += category;
		String value = getPreferenceValue("", str, "Height");
		
		// cvc - CR 6293191
		// if prefs are not read in properly, this value will be an 
		//  empty string and throw a NumberFormatException, so need
		//  to have a default in case the config default isn't available
		if (value == null || value.equals(""))
			value = "11";

		return value;
	}

	/**
	 * Based on a particular font category (DefaultClassFont, DefaultFont, etc), this retrieves 
	 * whether the font is bold or not in the preferences file.
	 *
	 * @param category[in]	The font category
	 * @param *val[out]		Whether or not the font is bold for this category
	 *
	 * @return HRESULT
	 */
	public boolean getFontBold(String category) {
		boolean val = false;
		String str = "Presentation|";
		str += category;
		String value = getPreferenceValue("", str, "Weight");
		
		// cvc - CR 6293191
		// if prefs are not read in properly, this value will be an 
		//  empty string and throw a NumberFormatException, so need
		//  to have a default in case the config default isn't available
		if (value == null || value.equals(""))
			value = "400";

		if (Integer.parseInt(value) > 400)
			val = true;
		return val;
	}

	/**
	 * Based on a particular font category (DefaultClassFont, DefaultFont, etc), this retrieves 
	 * whether the font is italic or not in the preferences file.
	 *
	 * @param category[in]	The font category
	 * @param *val[out]		Whether or not the font is italic for this category
	 *
	 * @return HRESULT
	 */
	public boolean getFontItalic(String category) {
		boolean val = false;
		String str = "Presentation|";
		str += category;
		String value = getPreferenceValue("", str, "Italic");
		if (!value.equals("0"))
			val = true;
		return val;
	}

	/**
	 * Based on a particular font category (DefaultClassFont, DefaultFont, etc), this retrieves 
	 * whether the font is strikeout or not in the preferences file.
	 *
	 * @param category[in]	The font category
	 * @param *val[out]		Whether or not the font is strikeout for this category
	 *
	 * @return HRESULT
	 */
	public boolean getFontStrikeout(String category) {
		boolean val = false;
		String str = "Presentation|";
		str += category;
		String value = getPreferenceValue("", str, "Strikeout");
		if (!value.equals("0"))
			val = true;
		return val;
	}

	/**
	 * Based on a particular font category (DefaultClassFont, DefaultFont, etc), this retrieves 
	 * whether the font is underlined or not in the preferences file.
	 *
	 * @param category[in]	The font category
	 * @param *val[out]		Whether or not the font is underlined for this category
	 *
	 * @return HRESULT
	 */
	public boolean getFontUnderline(String category) {
		boolean val = false;
		String str = "Presentation|";
		str += category;
		String value = getPreferenceValue("", str, "Underline");
		if (!value.equals("0"))
			val = true;
		return val;
	}

	/**
	 * Based on a particular font category (DefaultClassFont, DefaultFont, etc), this retrieves 
	 * the font color value in the preferences file.
	 *
	 * @param category[in]	The font category
	 * @param *val[out]		The font color for this category
	 *
	 * @return HRESULT
	 */
	public String getFontColor(String category) {
		String str = "Presentation|";
		str += category;
		String value = getPreferenceValue("", str, "Color");
		return value;
	}

	/**
	 * Asks the preference manager to read the preference file and set the given
	 * preference.
	 * 
	 *
	 * @param key[in]	"key" preference is found under, if blank, look in "Default"
	 * @param path[in]	Path to the preference (if preference is nested, this is the "|" delimited path
	 * @param name[in]	Name of preference
	 * @param pVal[out]	Preference value
	 *
	 * @return HRESULT
	 *
	 */
	public void setPreferenceValue(String key, String path, String name, String value)
	{
                throw new UnsupportedOperationException ("key="+key+"::path="+path+"::name="+name+"::value="+value+":: Using old options.");
//		ICoreProduct prod = ProductRetriever.retrieveProduct();
//		if (prod != null)
//		{
//			IPreferenceManager2 prefMan = prod.getPreferenceManager();
//			if (prefMan != null)
//			{
//				if (key.length() > 0)
//				{
//					prefMan.setPreferenceValue(key, path, name, value);
//				}
//				else
//				{
//					prefMan.setPreferenceValue(path, name, value);
//				}
//			}
//		}
	}

}


