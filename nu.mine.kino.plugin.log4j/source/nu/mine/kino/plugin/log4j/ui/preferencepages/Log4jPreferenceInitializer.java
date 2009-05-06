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

import java.io.File;
import java.io.IOException;
import java.net.URL;

import nu.mine.kino.plugin.log4j.Log4jPlugin;
import nu.mine.kino.plugin.log4j.PreferenceConstants;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Log4j�̐ݒ�t�@�C���̏ꏊ�̏����l���w�肷�邽�߂̃N���X�B�f�t�H���g�� [�v���O�C���̃f�B���N�g��]/lib/log4j.xml�ł��B
 * 
 * @author Masatomi KINO
 * @version $Revision$
 */
public class Log4jPreferenceInitializer extends AbstractPreferenceInitializer {

    /*
     * (�� Javadoc)
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    public void initializeDefaultPreferences() {
        try {
            IPreferenceStore store = Log4jPlugin.getDefault()
                    .getPreferenceStore();
            URL entry = Log4jPlugin.getDefault().getBundle().getEntry("/");
            String pluginDirectory = FileLocator.resolve(entry).getPath();
            // String pluginDirectory = Platform.resolve(entry).getPath();
            File file = new File(new File(pluginDirectory, "lib"), "log4j.xml");
            store.setDefault(PreferenceConstants.DEFAULT_LOG4J_PATH, file
                    .getAbsolutePath());
        } catch (IOException e) {
            Log4jPlugin.log(e);
        }

    }
}