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
 * Portions Copyrighted 2008 Sun Microsystems, Inc.
 */


package org.netbeans.modules.uml.propertysupport.options.panels;

import java.util.prefs.Preferences;
import javax.swing.JComboBox;
import org.netbeans.modules.uml.util.DummyCorePreference;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;

/**
 *
 * @author  krichard
 */
public class GeneralOptionsPanelForm extends javax.swing.JPanel {

    private final String PSK_ALWAYS = "PSK_ALWAYS";
    private final String PSK_NEVER = "PSK_NEVER";
    private final String PSK_SELECTED = "PSK_SELECTED";

    public final String PSK_RESIZE_ASNEEDED = "PSK_RESIZE_ASNEEDED";
    public final String PSK_RESIZE_EXPANDONLY = "PSK_RESIZE_EXPANDONLY";
    public final String PSK_RESIZE_UNLESSMANUAL = "PSK_RESIZE_UNLESSMANUAL";
    public final String PSK_RESIZE_NEVER = "PSK_RESIZE_NEVER";    
    
    //for menu display
    private final String ALWAYS = NbBundle.getMessage(GeneralOptionsPanelForm.class, "ALWAYS");
    private final String NEVER = NbBundle.getMessage(GeneralOptionsPanelForm.class, "NEVER");
    private final String SELECTED = NbBundle.getMessage(GeneralOptionsPanelForm.class, "SELECTED");
    private final String ASNEEDED = NbBundle.getMessage(GeneralOptionsPanelForm.class, "ASNEEDED");
    private final String EXPANDONLY = NbBundle.getMessage(GeneralOptionsPanelForm.class, "EXPANDONLY");
    private final String UNLESSMANUAL = NbBundle.getMessage(GeneralOptionsPanelForm.class, "UNLESSMANUAL");
    private final String RESIZE_NEVER = NbBundle.getMessage(GeneralOptionsPanelForm.class, "RESIZE_NEVER");
    
    //for Display Seq Diagram Messages
    private final String SHOW_NOTHING = NbBundle.getMessage(GeneralOptionsPanelForm.class,"SMT_NOTHING");
    private final String SHOW_OPERATION = NbBundle.getMessage(GeneralOptionsPanelForm.class, "SMT_OPERATION");
    private final String SHOW_NAME = NbBundle.getMessage(GeneralOptionsPanelForm.class, "SMT_NAME");
            
    private final String[] SQD_MSG = { SHOW_NOTHING, SHOW_OPERATION, SHOW_NAME} ;
            
//    private final Integer[] mapped_SQD_MSG = {IShowMessageType.SMT_NONE, IShowMessageType.SMT_OPERATION, IShowMessageType.SMT_NAME};
    private final Integer[] mapped_SQD_MSG = {0, 1, 2};
    
    private final String[] displayChoices = {ALWAYS, SELECTED, NEVER};
    private final String[] mappedChoices = {PSK_ALWAYS, PSK_SELECTED, PSK_NEVER};

    private final String[] resizeDisplayChoices = {ASNEEDED, EXPANDONLY, UNLESSMANUAL, RESIZE_NEVER};
    private final String[] resizeMappedChoices = {PSK_RESIZE_ASNEEDED, PSK_RESIZE_EXPANDONLY, PSK_RESIZE_UNLESSMANUAL, PSK_RESIZE_NEVER};
    
    /** Creates new form GeneralOptionsPanel */
    public GeneralOptionsPanelForm() {
        initComponents();
    }

    public void store() {
        int autoResizeIndex = autoResizeElementsComboBox.getSelectedIndex();
        int displayCompartmentIndex = displayCompartmentTitlesComboBox.getSelectedIndex();
        int sqdDisplayMsgIndex = this.seqDiagMsgCB.getSelectedIndex() ;
        
        Preferences prefs = NbPreferences.forModule(DummyCorePreference.class);

        prefs.putBoolean("UML_Show_Aliases", showAlias.isSelected());
        prefs.putBoolean("UML_Open_Project_Diagrams", openProjectDiagramsCB.isSelected());

        prefs.put("UML_Automatically_Size_Elements", resizeMappedChoices[autoResizeIndex]);
        prefs.put("UML_Display_Compartment_Titles", mappedChoices[displayCompartmentIndex]);

        prefs.putBoolean("UML_Display_Empty_Lists", displayEmpty.isSelected());
        prefs.putBoolean("UML_Gradient_Background", gradient.isSelected());
        prefs.putBoolean("UML_Reconnect_to_Presentation_Boundary", reconnect.isSelected());
        prefs.putBoolean("UML_Resize_with_Show_Aliases_Mode", resizeCB.isSelected());
        prefs.putBoolean("UML_Show_Stereotype_Icons", showStereotype.isSelected());
        prefs.putBoolean("UML_Ask_Before_Layout", askLayoutCB.isSelected());

        prefs.putInt("UML_SQD_DEFAULT_MSG", mapped_SQD_MSG[sqdDisplayMsgIndex]);
    }

    public void load() {
        Preferences prefs = NbPreferences.forModule(DummyCorePreference.class);

        if (prefs.getBoolean("UML_Show_Aliases", false)) {
            showAlias.setSelected(true);
        } else {
            showAlias.setSelected(false);
        }        
        if (prefs.getBoolean("UML_Open_Project_Diagrams", true)) {
            openProjectDiagramsCB.setSelected(true);
        } else {
            openProjectDiagramsCB.setSelected(false);
        }
        if (prefs.getBoolean("UML_Display_Empty_Lists", true)) {
            displayEmpty.setSelected(true);
        } else {
            displayEmpty.setSelected(false);
        }
        if (prefs.getBoolean("UML_Gradient_Background", true)) {
            gradient.setSelected(true);
        } else {
            gradient.setSelected(false);
        }
        if (prefs.getBoolean("UML_Reconnect_to_Presentation_Boundary", true)) {
            reconnect.setSelected(true);
        } else {
            reconnect.setSelected(false);
        }
        if (prefs.getBoolean("UML_Resize_with_Show_Aliases_Mode", false)) {
            resizeCB.setSelected(true);
        } else {
            resizeCB.setSelected(false);
        }
        if (prefs.getBoolean("UML_Show_Stereotype_Icons", true)) {
            showStereotype.setSelected(true);
        } else {
            showStereotype.setSelected(false);
        }
        if (prefs.getBoolean("UML_Ask_Before_Layout", true)) {
            askLayoutCB.setSelected(true);
        } else {
            askLayoutCB.setSelected(false);
        }
        String autoResizeValue = prefs.get("UML_Automatically_Size_Elements", null);
        String displayCompartmentValue = prefs.get("UML_Display_Compartment_Titles", null);
//        Integer sqdMsgVal = prefs.getInt("UML_SQD_DEFAULT_MSG", IShowMessageType.SMT_NONE) ;
        Integer sqdMsgVal = prefs.getInt("UML_SQD_DEFAULT_MSG", 0);
        
        int autoResizeIndex = getMappedIndex(resizeMappedChoices, autoResizeValue);
        int compartmentIndex = getMappedIndex(mappedChoices, displayCompartmentValue);
        int sqdMsgIndex = getMappedIndex(mapped_SQD_MSG, sqdMsgVal);
        
        autoResizeElementsComboBox.setSelectedIndex(autoResizeIndex);
        seqDiagMsgCB.setSelectedIndex(sqdMsgIndex);
        displayCompartmentTitlesComboBox.setSelectedIndex(compartmentIndex);
    }

    public void cancel() {
        //do nothing ;
    }

    private int getMappedIndex(Object[] a, Object s) {

        int n = a.length;

        for (int i = 0; i < n; i++) {
            if (a[i].equals(s)) {
                return i;
            }
        }

        return 0;
    }

   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showAlias = new javax.swing.JCheckBox();
        openProjectDiagramsCB = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        displayEmpty = new javax.swing.JCheckBox();
        reconnect = new javax.swing.JCheckBox();
        resizeCB = new javax.swing.JCheckBox();
        showStereotype = new javax.swing.JCheckBox();
        gradient = new javax.swing.JCheckBox();
        askLayoutCB = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        autoResizeElementsComboBox = new JComboBox(resizeDisplayChoices);
        displayCompartmentTitlesComboBox = new JComboBox (displayChoices);
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        seqDiagMsgCB = new JComboBox (SQD_MSG);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        org.openide.awt.Mnemonics.setLocalizedText(showAlias, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanelForm.showAlias.text")); // NOI18N

        openProjectDiagramsCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(openProjectDiagramsCB, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.openProjectDiagramsCB.text")); // NOI18N

        displayEmpty.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(displayEmpty, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.displayEmpty.text")); // NOI18N

        reconnect.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(reconnect, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.reconnect.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resizeCB, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.resizeCB.text")); // NOI18N

        showStereotype.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(showStereotype, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.showStereotype.text")); // NOI18N

        gradient.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(gradient, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.gradient.text")); // NOI18N

        askLayoutCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(askLayoutCB, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanelForm.askLayoutCB.text")); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanelForm.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(askLayoutCB, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(reconnect, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(displayEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(resizeCB, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(showStereotype, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(gradient, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(displayEmpty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reconnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resizeCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showStereotype)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(askLayoutCB)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        displayEmpty.getAccessibleContext().setAccessibleDescription(displayEmpty.getText());
        reconnect.getAccessibleContext().setAccessibleDescription(reconnect.getText());
        resizeCB.getAccessibleContext().setAccessibleDescription(resizeCB.getText());
        showStereotype.getAccessibleContext().setAccessibleDescription(showStereotype.getText());
        gradient.getAccessibleContext().setAccessibleDescription(gradient.getText());
        askLayoutCB.getAccessibleContext().setAccessibleDescription(askLayoutCB.getText());

        jLabel2.setLabelFor(displayCompartmentTitlesComboBox);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.jLabel2.text")); // NOI18N

        autoResizeElementsComboBox.setDoubleBuffered(true);

        jLabel1.setLabelFor(autoResizeElementsComboBox);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanel.jLabel1.text")); // NOI18N

        jLabel6.setLabelFor(seqDiagMsgCB);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanelForm.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(autoResizeElementsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayCompartmentTitlesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seqDiagMsgCB, 0, 201, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(autoResizeElementsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(displayCompartmentTitlesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(seqDiagMsgCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        displayCompartmentTitlesComboBox.getAccessibleContext().setAccessibleDescription(jLabel2.getText());
        jLabel1.getAccessibleContext().setAccessibleDescription(jLabel1.getText());
        seqDiagMsgCB.getAccessibleContext().setAccessibleDescription(jLabel6.getText());

        jLabel3.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanelForm.jLabel3.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanelForm.class, "GeneralOptionsPanelForm.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showAlias)
                            .addComponent(openProjectDiagramsCB)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(openProjectDiagramsCB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showAlias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        showAlias.getAccessibleContext().setAccessibleDescription(showAlias.getText());
        openProjectDiagramsCB.getAccessibleContext().setAccessibleDescription(openProjectDiagramsCB.getText());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox askLayoutCB;
    private javax.swing.JComboBox autoResizeElementsComboBox;
    private javax.swing.JComboBox displayCompartmentTitlesComboBox;
    private javax.swing.JCheckBox displayEmpty;
    private javax.swing.JCheckBox gradient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox openProjectDiagramsCB;
    private javax.swing.JCheckBox reconnect;
    private javax.swing.JCheckBox resizeCB;
    private javax.swing.JComboBox seqDiagMsgCB;
    private javax.swing.JCheckBox showAlias;
    private javax.swing.JCheckBox showStereotype;
    // End of variables declaration//GEN-END:variables
}
