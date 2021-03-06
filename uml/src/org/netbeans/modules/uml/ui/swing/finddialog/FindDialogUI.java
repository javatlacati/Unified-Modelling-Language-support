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



package org.netbeans.modules.uml.ui.swing.finddialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import org.netbeans.modules.uml.ui.support.commondialogs.IErrorDialog;
import org.netbeans.modules.uml.ui.support.commondialogs.MessageIconKindEnum;
import org.netbeans.modules.uml.ui.support.finddialog.DefaultFindDialogResource;
import org.netbeans.modules.uml.ui.support.finddialog.FindController;
import org.netbeans.modules.uml.ui.support.finddialog.FindResults;
import org.netbeans.modules.uml.common.generics.ETPairT;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IElement;
import org.netbeans.modules.uml.core.metamodel.diagrams.IProxyDiagram;
import org.netbeans.modules.uml.core.support.umlutils.ETList;

import org.netbeans.modules.uml.ui.support.finddialog.FindUtilities;
import org.netbeans.modules.uml.ui.swing.commondialogs.JCenterDialog;
import org.netbeans.modules.uml.ui.swing.commondialogs.SwingErrorDialog;

public class FindDialogUI extends JCenterDialog 
{
	/** Creates new form finddialog */
	public FindDialogUI(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		initDialog();
		center(parent);
	}
	
	/** This method is called from within the constructor to
		 * initialize the form.
		 * WARNING: Do NOT modify this code. The content of this method is
		 * always regenerated by the Form Editor.
		 */
		private void initComponents() {
			java.awt.GridBagConstraints gridBagConstraints;
			
			jPanel1 = new javax.swing.JPanel();
			jPanel4 = new javax.swing.JPanel();
			textLabel = new javax.swing.JLabel();
			m_FindCombo = new javax.swing.JComboBox();
			jPanel16 = new javax.swing.JPanel();
			jPanel3 = new javax.swing.JPanel();
			m_LoadExternalCheck = new javax.swing.JCheckBox();
			m_MatchCaseCheck = new javax.swing.JCheckBox();
			m_XpathCheck = new javax.swing.JCheckBox();
			m_WholeWordCheck = new javax.swing.JCheckBox();
			m_SearchAliasCheck = new javax.swing.JCheckBox();
			jPanel17 = new javax.swing.JPanel();
			jPanel7 = new javax.swing.JPanel();
			jPanel6 = new javax.swing.JPanel();
			m_SearchElementsRadio = new javax.swing.JRadioButton();
			m_SearchDescriptionsRadio = new javax.swing.JRadioButton();
			m_ProjectList = new javax.swing.JList();
			jPanel9 = new javax.swing.JPanel();
			m_WorkspaceRadio = new javax.swing.JRadioButton();
			m_ProjectRadio = new javax.swing.JRadioButton();
			jPanel11 = new javax.swing.JPanel();
			//m_ResultsTable = new javax.swing.JTable();
			FindTableModel model = new FindTableModel(this);
			m_ResultsTable = new JFindTable(model, this);
			gridBagConstraints = new java.awt.GridBagConstraints();
			jPanel12 = new javax.swing.JPanel();
			m_NavigateCheck = new javax.swing.JCheckBox();
			m_Status = new javax.swing.JTextField();
			jPanel2 = new javax.swing.JPanel();
			m_FindButton = new javax.swing.JButton();
			m_CloseButton = new javax.swing.JButton();

			setTitle(DefaultFindDialogResource.getString("IDS_PROJNAME2"));
			addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent evt) {
					closeDialog(evt);
				}
			});
			//jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
			//jPanel1.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5)));
			//jPanel1.add(Box.createVerticalStrut(10));
			jPanel1.setLayout(new GridBagLayout());
			jPanel4.setLayout(new GridBagLayout());
                        
			
                        //CBeckham -  added to dynamicaly adjust panel size for larger fonts
                        // Note...getFoint.getSize will not return the ide parm -fontsize
                        //in most cases of localized version, the user will use the -fontsize to start the ide
                        //regaqrdless of what the os font size setting is, however in some remote cases the user
                        //may actaully have the OS fontsize setting high
                        int fontsize;
                        java.awt.Font f = 
                            javax.swing.UIManager.getFont ("controlFont"); //NOI18N
                        if (f != null) {
                            fontsize = f.getSize();
                        } else {
                            fontsize = 12;
                        }                
                        int width  = 550;
                        int height = 400;
                        int multiplyer = 2;
                        
			java.awt.Font theFont = new java.awt.Font("Dialog", 0, fontsize);
                        
                        if (fontsize > 17 ) multiplyer =3;
                        width  = width  + Math.round(width*(multiplyer*fontsize/100f));
                        height = height + Math.round(height*(multiplyer*fontsize/100f));  
                        setSize(width,height);
                        // CBeckham - end of add                        
                        

                        
			// text label
			textLabel.setFont(theFont);
			textLabel.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_FINDWHAT")));
			textLabel.setLabelFor(m_FindCombo);
			DefaultFindDialogResource.setMnemonic(textLabel, DefaultFindDialogResource.getString("IDS_FINDWHAT"));
			DefaultFindDialogResource.setFocusAccelerator(m_FindCombo, DefaultFindDialogResource.getString("IDS_FINDWHAT"));
			textLabel.setName("findLabel");			
			gridBagConstraints.weightx=0;
			gridBagConstraints.insets=new Insets(0,4,0,0);
			jPanel4.add(textLabel,gridBagConstraints);
			
			// combo box
			m_FindCombo.setEditable(true);
			m_FindCombo.setMaximumRowCount(10);
			m_FindCombo.setFont(theFont);
			m_FindCombo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onEnterSearchCombo(evt);
				}
			});
			gridBagConstraints.weightx=9;
			gridBagConstraints.fill=GridBagConstraints.BOTH;
			gridBagConstraints.insets=new Insets(0,5,0,0);
			jPanel4.add(m_FindCombo,gridBagConstraints);
			
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=0;
			gridBagConstraints.weightx=2.0;
			gridBagConstraints.weighty=1.0;
			gridBagConstraints.insets=new Insets(2,5,0,5);
			gridBagConstraints.fill=GridBagConstraints.BOTH;
			jPanel1.add(jPanel4,gridBagConstraints);
			//jPanel1.add(jPanel16);
			
			// check boxes
			jPanel3.setLayout(new GridBagLayout());
			m_LoadExternalCheck.setFont(theFont);
			m_LoadExternalCheck.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_LOADEXTERNAL")));
			DefaultFindDialogResource.setMnemonic(m_LoadExternalCheck, DefaultFindDialogResource.getString("IDS_LOADEXTERNAL"));
			m_LoadExternalCheck.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onLoadExternalCheck(evt);
				}
			});
			//jPanel3.add(m_LoadExternalCheck);

			m_MatchCaseCheck.setSelected(true);
			m_MatchCaseCheck.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_MATCHCASE")));
			DefaultFindDialogResource.setMnemonic(m_MatchCaseCheck, DefaultFindDialogResource.getString("IDS_MATCHCASE"));
			m_MatchCaseCheck.setFont(theFont);
			m_MatchCaseCheck.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onMatchCaseCheck(evt);
				}
			});
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=0;
			gridBagConstraints.weighty=0.5;
			jPanel3.add(m_MatchCaseCheck,gridBagConstraints);

			m_XpathCheck.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_XPATHEXPRESSION")));
			DefaultFindDialogResource.setMnemonic(m_XpathCheck, DefaultFindDialogResource.getString("IDS_XPATHEXPRESSION"));
			m_XpathCheck.setFont(theFont);
			m_XpathCheck.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onXPathCheck(evt);
				}
			});
			gridBagConstraints.gridx=1;
			gridBagConstraints.gridy=0;
			gridBagConstraints.weighty=0.5;
			jPanel3.add(m_XpathCheck,gridBagConstraints);

			m_WholeWordCheck.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_MATCHWHOLE")));
			DefaultFindDialogResource.setMnemonic(m_WholeWordCheck, DefaultFindDialogResource.getString("IDS_MATCHWHOLE"));
			m_WholeWordCheck.setFont(theFont);
			m_WholeWordCheck.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onWholeWordCheck(evt);
				}
			});
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=1;
			gridBagConstraints.weighty=0.5;
			jPanel3.add(m_WholeWordCheck,gridBagConstraints);

			m_SearchAliasCheck.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_SEARCHALIAS")));
			DefaultFindDialogResource.setMnemonic(m_SearchAliasCheck, DefaultFindDialogResource.getString("IDS_SEARCHALIAS"));
			m_SearchAliasCheck.setFont(theFont);
			m_SearchAliasCheck.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onAliasCheck(evt);
				}
			});
			gridBagConstraints.gridx=1;
			gridBagConstraints.gridy=1;
			gridBagConstraints.weighty=0.5;
			jPanel3.add(m_SearchAliasCheck,gridBagConstraints);
			
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=1;
			gridBagConstraints.weightx=1.0;
			gridBagConstraints.weighty=0.5;
			gridBagConstraints.insets=new Insets(0,0,5,5);
			gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
			jPanel1.add(jPanel3,gridBagConstraints);

			//jPanel1.add(jPanel17);

			jPanel7.setLayout(new java.awt.GridBagLayout());
			jPanel6.setLayout(new java.awt.GridBagLayout());
			
  		    			
			m_WorkspaceRadio.setFont(theFont);
			m_WorkspaceRadio.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_WORKSPACE")));
			DefaultFindDialogResource.setMnemonic(m_WorkspaceRadio, DefaultFindDialogResource.getString("IDS_WORKSPACE"));
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			m_WorkspaceRadio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onWorkspaceRadio(evt);
				}
			});		
			m_WorkspaceRadio.setVisible(false);
				
			jPanel6.add(m_WorkspaceRadio, gridBagConstraints);

			m_ProjectRadio.setFont(theFont);
			// default the dialog to have the project radio button checked
			m_ProjectRadio.setSelected(true);
			m_ProjectRadio.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_PROJECTS")));
			DefaultFindDialogResource.setMnemonic(m_ProjectRadio, DefaultFindDialogResource.getString("IDS_PROJECTS"));
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 1;
			//gridBagConstraints.insets=new Insets(0,0,2,0);
			gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
			//gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			//gridBagConstraints.weightx = 1.0;
			//gridBagConstraints.weighty = 1.0;
			m_ProjectRadio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onProjectRadio(evt);
				}
			});
			jPanel6.add(m_ProjectRadio, gridBagConstraints);
			// project list
			m_ProjectList.setMinimumSize(new java.awt.Dimension(30, 52));
			m_ProjectList.setPreferredSize(new java.awt.Dimension(50, 60));
			m_ProjectList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0)));
			m_ProjectList.setFont(theFont);
			m_ProjectList.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 2;
			gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 5);
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 0.5;
			jPanel6.add(m_ProjectList, gridBagConstraints);
			
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.insets=new Insets(0,0,0,5);
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=0;
			gridBagConstraints.weightx=6;
			gridBagConstraints.weighty=1;
			jPanel7.add(jPanel6, gridBagConstraints);
						
			// element/description radio buttons
			jPanel9.setLayout(new GridBagLayout());
			javax.swing.border.TitledBorder bord = new javax.swing.border.TitledBorder(DefaultFindDialogResource.getString("IDS_SEARCHIN"));
			bord.setTitleFont(theFont);
			jPanel9.setBorder(bord);
						
			m_SearchElementsRadio.setFont(theFont);
			// default the dialog to have the element radio button checked
			m_SearchElementsRadio.setSelected(true);
			m_SearchElementsRadio.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_ELEMENTS")));
			DefaultFindDialogResource.setMnemonic(m_SearchElementsRadio, DefaultFindDialogResource.getString("IDS_ELEMENTS"));
			m_SearchElementsRadio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onSearchElementsRadio(evt);
				}
			});		
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=0;
			gridBagConstraints.insets=new Insets(10,0,5,0);
			jPanel9.add(m_SearchElementsRadio,gridBagConstraints);

			m_SearchDescriptionsRadio.setFont(theFont);
			m_SearchDescriptionsRadio.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_DESCRIPTIONS")));
			DefaultFindDialogResource.setMnemonic(m_SearchDescriptionsRadio, DefaultFindDialogResource.getString("IDS_DESCRIPTIONS"));
			m_SearchDescriptionsRadio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onSearchDescriptionsRadio(evt);
				}
			});
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=1;
			gridBagConstraints.insets=new Insets(5,0,12,0);
			jPanel9.add(m_SearchDescriptionsRadio,gridBagConstraints);
			
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.gridx=1;
			gridBagConstraints.gridy=0;
			gridBagConstraints.weightx=0;
			//gridBagConstraints.insets=new Insets(5,0,0,0);
			jPanel7.add(jPanel9, gridBagConstraints);

			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=2;
			gridBagConstraints.weightx=2.0;
			gridBagConstraints.weighty=1.0;
			gridBagConstraints.fill=GridBagConstraints.BOTH;
			gridBagConstraints.insets=new Insets(2,5,5,5);
			jPanel1.add(jPanel7,gridBagConstraints);
			
			// results grid
			jPanel11.setLayout(new GridBagLayout());
			m_ResultsTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			m_ResultsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
			
			jScrollPane2 = new JScrollPane(m_ResultsTable);                        
			GridBagConstraints gridBagConstraints2 = new java.awt.GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			jPanel11.add(jScrollPane2, gridBagConstraints2);
			
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=3;
			gridBagConstraints.weightx=2.0;
			gridBagConstraints.weighty=4.0;
			gridBagConstraints.fill=GridBagConstraints.BOTH;
			gridBagConstraints.insets=new Insets(2,10,5,5);
			jPanel1.add(jPanel11,gridBagConstraints);
			
			// navigate check
			jPanel12.setLayout(new GridBagLayout());		
			m_NavigateCheck.setFont(theFont);
			// default the navigate button to true
			m_NavigateCheck.setSelected(true);
			m_NavigateCheck.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_NAVIGATE")));
			DefaultFindDialogResource.setMnemonic(m_NavigateCheck, DefaultFindDialogResource.getString("IDS_NAVIGATE"));
			m_NavigateCheck.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onNavigateCheck(evt);
				}
			});
			gridBagConstraints.weightx=1;
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=0;
			gridBagConstraints.fill=GridBagConstraints.BOTH;
			gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
			jPanel12.add(m_NavigateCheck,gridBagConstraints);
			
			
			// status
			m_Status.setEditable(false);
			m_Status.setMaximumSize(new java.awt.Dimension(2147483647, 20));
			m_Status.setFont(theFont);
			gridBagConstraints.weightx=1;
			gridBagConstraints.fill=GridBagConstraints.BOTH;
			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=1;
			jPanel12.add(m_Status,gridBagConstraints);

			gridBagConstraints.gridx=0;
			gridBagConstraints.gridy=4;
			gridBagConstraints.weightx=2.0;
			gridBagConstraints.weighty=1.0;
			gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
			gridBagConstraints.insets=new Insets(2,10,0,5);
			jPanel1.add(jPanel12,gridBagConstraints);
			//jPanel1.add(Box.createVerticalStrut(5),gridBagConstraints);

			getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
			
			// find/close buttons
//			Dimension buttonSize = new Dimension(75, 25);
			jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));
			jPanel2.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5)));

			m_FindButton.setFont(theFont);
			m_FindButton.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_FIND")));
			DefaultFindDialogResource.setMnemonic(m_FindButton, DefaultFindDialogResource.getString("IDS_FIND"));
			m_FindButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					onFindButton(evt);
				}
			});
			getRootPane().setDefaultButton(m_FindButton);
			jPanel2.add(Box.createVerticalStrut(9));
			jPanel2.add(m_FindButton);

			m_CloseButton.setFont(theFont);
			m_CloseButton.setText(DefaultFindDialogResource.determineText(DefaultFindDialogResource.getString("IDS_CLOSE")));
			DefaultFindDialogResource.setMnemonic(m_CloseButton, DefaultFindDialogResource.getString("IDS_CLOSE"));
			m_CloseButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					setVisible(false);
					dispose();
				}
			});
			jPanel2.add(Box.createVerticalStrut(3));
			jPanel2.add(m_CloseButton);

			getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);
			
			//pack();
			Dimension buttonSize = getMaxButtonWidth();
			m_FindButton.setMaximumSize(buttonSize);
			m_FindButton.setPreferredSize(buttonSize);
			m_CloseButton.setPreferredSize(buttonSize);
			m_CloseButton.setMaximumSize(buttonSize);
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
		}
		private Dimension getMaxButtonWidth()
		{
			Dimension ret = null;
			Dimension d = m_FindButton.getPreferredSize();
			double max  = d.width;

			d = m_CloseButton.getPreferredSize();
			if(d.width > max){
				 max = d.width;
				 ret = d; 
			}
			return ret;

		}
		private void onEnterSearchCombo(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JComboBox)
			{
				//this was the attermp to try and perform the find
				// when hitting enter in the find combo box.  It was
				// kind of working, but this event was ALSO firing when the
				// user was typing in find and then clicking Alt+Key to change
				// the settings on the dialog
				/*
				if (evt.getActionCommand().equals("comboBoxEdited"))
				{
					String searchStr = m_FindCombo.getSelectedItem().toString();
					if (searchStr != null && searchStr.length() > 0){
						onFindButton();
					}
				}
				else
				{
					m_Done = false;
				}
				*/
			}
		}
			
		
		private void onLoadExternalCheck(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JCheckBox)
			{
				JCheckBox box = (JCheckBox)obj;
				boolean checkboxState = box.isSelected();
				if (checkboxState)
				{
					m_Controller.setExternalLoad(true);
				}
				else
				{
					m_Controller.setExternalLoad(false);
				}
			}
		}

		private void onXPathCheck(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JCheckBox)
			{
				JCheckBox box = (JCheckBox)obj;
				boolean checkboxState = box.isSelected();
				if (checkboxState)
				{
					m_Controller.setKind(1);
					m_MatchCaseCheck.setEnabled(false);
					m_SearchDescriptionsRadio.setEnabled(false);
					m_SearchElementsRadio.setEnabled(false);
					m_SearchAliasCheck.setEnabled(false);
					m_WholeWordCheck.setEnabled(false);
				}
				else
				{
					m_Controller.setKind(0);
					m_MatchCaseCheck.setEnabled(true);
					m_SearchDescriptionsRadio.setEnabled(true);
					m_SearchElementsRadio.setEnabled(true);
					m_SearchAliasCheck.setEnabled(true);
					m_WholeWordCheck.setEnabled(true);
				}
			}
		}

		private void onAliasCheck(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JCheckBox)
			{
				JCheckBox box = (JCheckBox)obj;
				boolean checkboxState = box.isSelected();
				if (checkboxState)
				{
					m_Controller.setSearchAlias(true);
					m_SearchElementsRadio.setSelected(true);
					m_SearchDescriptionsRadio.setSelected(false);
					m_SearchDescriptionsRadio.setEnabled(false);
				}
				else
				{
					m_Controller.setSearchAlias(false);
					m_SearchDescriptionsRadio.setEnabled(true);
				}
			}
		}

		private void onWholeWordCheck(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JCheckBox)
			{
				JCheckBox box = (JCheckBox)obj;
				boolean checkboxState = box.isSelected();
				if (checkboxState)
				{
					m_Controller.setWholeWordSearch(true);
				}
				else
				{
					m_Controller.setWholeWordSearch(false);

				}
			}
		}
	
	private void onMatchCaseCheck(java.awt.event.ActionEvent evt) {
		Object obj = evt.getSource();
		if (obj instanceof JCheckBox)
		{
			JCheckBox box = (JCheckBox)obj;
			boolean checkboxState = box.isSelected();
			if (checkboxState)
			{
				m_Controller.setCaseSensitive(true);
			}
			else
			{
				m_Controller.setCaseSensitive(false);

			}
		}
	}
		private void onProjectRadio(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JRadioButton)
			{
				m_Controller.setScope(0);
				m_ProjectRadio.setSelected(true);
				m_WorkspaceRadio.setSelected(false);
				m_ProjectList.setEnabled(true);
				FindUtilities.selectProjectInList( m_ProjectList );
			}
		}		
		private void onWorkspaceRadio(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JRadioButton)
			{
				m_Controller.setScope(1);
				m_WorkspaceRadio.setSelected(true);
				m_ProjectRadio.setSelected(false);
				m_ProjectList.clearSelection();
				m_ProjectList.setEnabled(false);
			}
		}
		private void onSearchElementsRadio(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JRadioButton)
			{
				m_Controller.setResultType(0);
				m_SearchElementsRadio.setSelected(true);
				m_SearchDescriptionsRadio.setSelected(false);
				m_SearchAliasCheck.setEnabled(true);
			}
		}		
		private void onSearchDescriptionsRadio(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JRadioButton)
			{
				m_Controller.setResultType(1);
				m_SearchDescriptionsRadio.setSelected(true);
				m_SearchElementsRadio.setSelected(false);
				m_SearchAliasCheck.setSelected(false);
				m_SearchAliasCheck.setEnabled(false);
			}
		}		
		private void onNavigateCheck(java.awt.event.ActionEvent evt) {
			Object obj = evt.getSource();
			if (obj instanceof JCheckBox)
			{
				JCheckBox box = (JCheckBox)obj;
				boolean checkboxState = box.isSelected();
				if (checkboxState)
				{
					m_Controller.setDiagramNavigate(true);
				}
				else
				{
					m_Controller.setDiagramNavigate(false);
				}
			}
		}
		private void onFindButton(java.awt.event.ActionEvent evt) {
                    Object obj = evt.getSource();
                    if (obj instanceof JButton) {
                        //if (!m_Done){
                        try {
                            FindUtilities.startWaitCursor(getContentPane());
                            onFindButton();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this,
                            DefaultFindDialogResource.getString("IDS_ERROR1"),
                            DefaultFindDialogResource.getString("IDS_PROJNAME2"),
                            JOptionPane.INFORMATION_MESSAGE);
                        } finally {
                            FindUtilities.endWaitCursor(getContentPane());                            
                        }
                        //}
                        //m_Done = false;
                    }
		}
		
						
		private void onFindButton() throws Exception {
			//m_Done = true;
			m_Status.setText("");
			// clear the grid
			clearGrid();
			String searchStr = (String)m_FindCombo.getSelectedItem();
			// Save the values of the search combo
			FindUtilities.saveSearchString("LastSearchStrings", m_FindCombo);
			// reset what is in the search combo
			FindUtilities.populateComboBoxes("LastSearchStrings", m_FindCombo);
			if (searchStr != null && searchStr.length() > 0)
			{
				boolean continueFlag = true;
				// if they have project selected, make sure there is a project selected
				if (m_ProjectRadio.isSelected())
				{
				   int count = m_ProjectList.getSelectedIndex();
				   if (count == -1)
				   {
					  continueFlag = false;
					  String msg = FindUtilities.translateString("IDS_ERROR2");
					  String title = FindUtilities.translateString("IDS_PROJNAME2");
					  IErrorDialog pTemp = new SwingErrorDialog(this);
					  if (pTemp != null)
					  {
					  	pTemp.display(msg, MessageIconKindEnum.EDIK_ICONINFORMATION, title);
					  }
				   }
				}
				if (continueFlag)
				{
					// do the search
					m_Controller.setSearchString(searchStr);
					FindUtilities.loadProjectListOfController(m_ProjectList, m_Controller);
					FindResults pResults = new FindResults();
					m_Controller.search(pResults);
					if (pResults != null)
					{
						ETList<IElement> pElements = pResults.getElements();
						ETList<IProxyDiagram> pDiagrams = pResults.getDiagrams();
						if ( (pElements != null) && (pDiagrams != null))
						{
							// show the results
							jPanel11.removeAll();
							ETList< Object > findResults = FindUtilities.loadResultsIntoArray(pResults);
							FindTableModel model = new FindTableModel(this, findResults);
							m_ResultsTable = new JFindTable(model, this);
							jScrollPane2 = new JScrollPane(m_ResultsTable);
							
							GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
							gridBagConstraints.fill = GridBagConstraints.BOTH;
							gridBagConstraints.weightx = 1.0;
							gridBagConstraints.weighty = 1.0;
							jPanel11.add(jScrollPane2, gridBagConstraints);
							
							//now refresh the table so that it paints, cannot use refreshUI it causes a flicker.
							m_ResultsTable.updateUI();
							jScrollPane2.doLayout();
							jPanel11.doLayout();
							this.doLayout();
							
							int count = pElements.size();
							int countD = pDiagrams.size();
							if (count > 0 || countD > 0)
							{
								long totalC = count + countD;
								String strMsg = totalC + " ";
								strMsg += FindUtilities.translateString("IDS_NUMFOUND");
								m_Status.setText(strMsg);
								//
								// This is special code to aid in the automating testing.  We had no way to access
								// the information in the grid from the automated scripts and/or VisualTest, so
								// if a flag is set in the registry, we will dump the results of the grid to a
								// specified file
								//
								/* TODO
								if( GETDEBUGFLAG_RELEASE(_T("DumpGridResults"), 0))
							    {
								 CComBSTR file = CRegistry::GetItem( CString(_T("DumpGridResultsFile")), CString(_T("")));
									 if (file.Length())
									 {
										 m_FlexGrid->SaveGrid(file, flexFileCommaText, CComVariant(FALSE));
									 }
								 }
								 */
							 }
							 else
							 {
								String noneStr = FindUtilities.translateString("IDS_NONEFOUND");
								m_Status.setText(noneStr);
							 }
						 }
						 else
						 {
							String canStr = FindUtilities.translateString("IDS_CANCELLED");
							m_Status.setText(canStr);
						 }
					}
					 else
					 {
						String str2 = FindUtilities.translateString("IDS_NONEFOUND2");
						m_Status.setText(str2);
					 }

				}
				m_FindCombo.setSelectedItem(searchStr);
			}
			else
			{
				IErrorDialog pTemp = new SwingErrorDialog(this);
				if (pTemp != null)
				{
					String msg = FindUtilities.translateString("IDS_ERROR1");
					String title = FindUtilities.translateString("IDS_PROJNAME2");
					pTemp.display(msg, MessageIconKindEnum.EDIK_ICONINFORMATION, title);
				}
			}
		}
		public void onDblClickFindResults(int row, FindTableModel model)
		{
			m_Status.setText("");
			boolean hr = FindUtilities.onDblClickFindResults(row, model, m_Controller);
			if (!hr)
			{
				String msg =  FindUtilities.translateString("IDS_NOPRESELEMENTS");
				m_Status.setText(msg);
			}
		}
		private void clearGrid()
		{
			// clear the results
			jPanel11.removeAll();
			FindTableModel model = new FindTableModel(this, null);
			m_ResultsTable = new JFindTable(model, this);
			jScrollPane2 = new JScrollPane(m_ResultsTable);
								
			GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			jPanel11.add(jScrollPane2, gridBagConstraints);
								
			//now refresh the table so that it paints, cannot use refreshUI it causes a flicker.
			m_ResultsTable.updateUI();
			jScrollPane2.doLayout();
			jPanel11.doLayout();
			this.doLayout();
		}
		
		private void initDialog()
		{
			m_Status.setText("");
			FindUtilities.populateProjectList(m_ProjectList);
			FindUtilities.selectProjectInList( m_ProjectList );
			FindUtilities.populateComboBoxes("LastSearchStrings", m_FindCombo);
		}
		
		public void setController(FindController controller)
		{
			m_Controller = controller;
			m_Controller.setDialog(this);
		}

	/** Closes the dialog */
	private void closeDialog(java.awt.event.WindowEvent evt) {
		setVisible(false);
		dispose();
	}
	
	// Variables declaration - do not modify
	private javax.swing.JButton m_FindButton;
	private javax.swing.JButton m_CloseButton;
	private javax.swing.JLabel textLabel;
	private javax.swing.JComboBox m_FindCombo;
	private javax.swing.JCheckBox m_LoadExternalCheck;
	private javax.swing.JCheckBox m_MatchCaseCheck;
	private javax.swing.JCheckBox m_NavigateCheck;
	private javax.swing.JList m_ProjectList;
	private javax.swing.JRadioButton m_ProjectRadio;
	private javax.swing.JTable m_ResultsTable;
	private javax.swing.JCheckBox m_SearchAliasCheck;
	private javax.swing.JRadioButton m_SearchDescriptionsRadio;
	private javax.swing.JRadioButton m_SearchElementsRadio;
	private javax.swing.JTextField m_Status;
	private javax.swing.JCheckBox m_WholeWordCheck;
	private javax.swing.JRadioButton m_WorkspaceRadio;
	private javax.swing.JCheckBox m_XpathCheck;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel16;
	private javax.swing.JPanel jPanel17;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel9;
	
	private javax.swing.JScrollPane jScrollPane2;
	
	 // End of variables declaration	
	private org.netbeans.modules.uml.ui.support.finddialog.FindController m_Controller = null;
	private boolean m_Done = false;
}		
