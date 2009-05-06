/******************************************************************************
 * Copyright (c) 2008-2009 Masatomi KINO and others. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *      Masatomi KINO - initial API and implementation
 * $Id$
 ******************************************************************************/
//�쐬��: 2006/05/17
package nu.mine.kino.plugin.log4j.ui.preferencepages;

import nu.mine.kino.plugin.log4j.Log4jPlugin;
import nu.mine.kino.plugin.log4j.PreferenceConstants;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Log4j�̐ݒ�t�@�C���̏ꏊ���w�肷�邽�߂̐ݒ�y�[�W���쐬����N���X�ł��B
 * 
 * @author Masatomi KINO
 * @version $Revision$
 */
public class Log4jPreferencePage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    public Log4jPreferencePage() {
        super(GRID);
        setPreferenceStore(Log4jPlugin.getDefault().getPreferenceStore());
        setDescription("Log4j�̐ݒ�t�@�C��(XML�`��)�̏ꏊ���w�肵�Ă��������B");
    }

    /*
     * (�� Javadoc)
     * 
     * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
     */
    protected void createFieldEditors() {
        addField(new FileFieldEditor(PreferenceConstants.DEFAULT_LOG4J_PATH,
                "&�ݒ�t�@�C��:", getFieldEditorParent()));
    }

    /*
     * (�� Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
    }

    /*
     * (�� Javadoc)
     * 
     * @see org.eclipse.jface.preference.IPreferencePage#performOk()
     */
    public boolean performOk() {
        boolean b = super.performOk();
        // �n�j�Ȃǂ��������ꂽ�Ƃ��A�ݒ�t�@�C�����ēǍ�����B
        Log4jPlugin.getDefault().configure();
        return b;
    }
}