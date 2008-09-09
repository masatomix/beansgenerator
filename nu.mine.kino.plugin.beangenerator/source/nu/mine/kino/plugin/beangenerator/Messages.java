/******************************************************************************
 * Copyright (c) 2008 Masatomi KINO and others. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *      Masatomi KINO - initial API and implementation
 * $Id: Messages.java 202 2008-08-18 15:48:31Z masatomix $
 ******************************************************************************/
//�쐬��: 2008/08/18
package nu.mine.kino.plugin.beangenerator;

import org.eclipse.osgi.util.NLS;

/**
 * @author Masatomi KINO
 * @version $Revision: 202 $
 */
public class Messages extends NLS {
    private static final String BUNDLE_NAME = "nu.mine.kino.plugin.beangenerator.messages"; //$NON-NLS-1$

    public static String JavaBeansCreator_MSG_SRCDIR_NOT_FOUND;

    public static String JavaBeansCreatorWithProgress_MSG_BEGIN_TASK;

    public static String JavaBeansCreatorWithProgress_MSG_EXECUTE;

    public static String JavaBeansGeneratorAction_MSG_ALERT_DIALOG;

    public static String JavaBeansGeneratorAction_MSG_DIALOG_MESSAGE;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
