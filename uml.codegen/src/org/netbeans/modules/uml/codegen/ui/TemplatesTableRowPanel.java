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
package org.netbeans.modules.uml.codegen.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.DefaultComboBoxModel;
import org.netbeans.modules.uml.codegen.dataaccess.DomainTemplatesRetriever;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;

/**
 *
 * @author  IBM USER
 */
public class TemplatesTableRowPanel extends javax.swing.JPanel 
    implements ActionListener
{
    public TemplatesTableRowPanel()
    {
        this("", "", "", "<None Selected>");
    }
    
    public TemplatesTableRowPanel(
        String filenameFormat, 
        String extension,
        String folder,
        String templateFilename)
    {
        initComponents();
        populateTemplateFilesComboBox();
        
        filenameFormatText.setText(filenameFormat);
        extensionText.setText(extension);
        folderText.setText(folder);
        templateFileCombo.setSelectedItem(templateFilename);
    }
    
    
    private void populateTemplateFilesComboBox()
    {
	FileObject root = FileUtil.getConfigFile(
            DomainTemplatesRetriever.TEMPLATES_BASE_FOLDER); // NOI18N
        
        // FileObject[] templateFiles = root.getChildren();
        
        DefaultComboBoxModel selectionModel = 
            ((DefaultComboBoxModel)templateFileCombo.getModel());
        
        selectionModel.addElement(NbBundle.getMessage(
            TemplatesTableRowPanel.class, "VAL_ElementType_NoneSelected")); // NOI18N
        
        Enumeration templateFiles = root.getChildren(true);
        
        while (templateFiles.hasMoreElements())
        {
            FileObject template = (FileObject)templateFiles.nextElement();

            if (!template.isFolder())
            {
                selectionModel.addElement(template.getPath().substring(
                    DomainTemplatesRetriever.TEMPLATES_BASE_FOLDER.length()+1));
            }
        }
    }
    
    public void actionPerformed(ActionEvent event)
    {
        
    }

    @Override
    public void requestFocus()
    {
        filenameFormatText.requestFocus();
    }
    

    public String getFilenameFormat()
    {
        return filenameFormatText.getText();
    }
    
    public String getExtension()
    {
        return extensionText.getText();
    }
    
    public String getFolder()
    {
        return folderText.getText();
    }
    
    public String getTemplateFilename()
    {
        return templateFileCombo.getSelectedItem().toString();
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filenameFormatLabel = new javax.swing.JLabel();
        filenameFormatText = new javax.swing.JTextField();
        extensionLabel = new javax.swing.JLabel();
        extensionText = new javax.swing.JTextField();
        folderLabel = new javax.swing.JLabel();
        folderText = new javax.swing.JTextField();
        templateFileLabel = new javax.swing.JLabel();
        templateFileCombo = new javax.swing.JComboBox();

        filenameFormatLabel.setLabelFor(filenameFormatText);
        org.openide.awt.Mnemonics.setLocalizedText(filenameFormatLabel, org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "filenameFormatLabel.text")); // NOI18N

        extensionLabel.setLabelFor(extensionText);
        org.openide.awt.Mnemonics.setLocalizedText(extensionLabel, org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "extensionLabel.text")); // NOI18N

        folderLabel.setLabelFor(folderText);
        org.openide.awt.Mnemonics.setLocalizedText(folderLabel, org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "folderLabel.text")); // NOI18N

        templateFileLabel.setLabelFor(templateFileCombo);
        org.openide.awt.Mnemonics.setLocalizedText(templateFileLabel, org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "templateFileLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filenameFormatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(folderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(extensionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(templateFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(extensionText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(folderText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(filenameFormatText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(templateFileCombo, 0, 219, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filenameFormatLabel)
                    .addComponent(filenameFormatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(extensionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extensionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(folderLabel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(templateFileCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(templateFileLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filenameFormatText.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSN_FilenameFormat")); // NOI18N
        filenameFormatText.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSD_FilenameFormat")); // NOI18N
        extensionText.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSN_Extension")); // NOI18N
        extensionText.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSD_Extension")); // NOI18N
        folderText.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSN_Folder")); // NOI18N
        folderText.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSD_Folder")); // NOI18N
        templateFileCombo.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSN_TemplateFile")); // NOI18N
        templateFileCombo.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSD_TemplateFile")); // NOI18N

        getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSN_TemplatesTableRowPanel")); // NOI18N
        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(TemplatesTableRowPanel.class, "ACSD_TemplatesTableRowPanel")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel extensionLabel;
    private javax.swing.JTextField extensionText;
    private javax.swing.JLabel filenameFormatLabel;
    private javax.swing.JTextField filenameFormatText;
    private javax.swing.JLabel folderLabel;
    private javax.swing.JTextField folderText;
    private javax.swing.JComboBox templateFileCombo;
    private javax.swing.JLabel templateFileLabel;
    // End of variables declaration//GEN-END:variables
    
}
