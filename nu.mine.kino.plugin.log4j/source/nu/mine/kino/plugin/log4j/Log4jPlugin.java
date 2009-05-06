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
package nu.mine.kino.plugin.log4j;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class Log4jPlugin extends AbstractUIPlugin {
    private static final Logger logger = Logger.getLogger(Log4jPlugin.class);

    // The shared instance.
    private static Log4jPlugin plugin;

    /**
     * The constructor.
     */
    public Log4jPlugin() {
        plugin = this;
    }

    /**
     * This method is called upon plug-in activation
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        configure();
    }

    /**
     * This method is called when the plug-in is stopped
     */
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
        plugin = null;
    }

    /**
     * Returns the shared instance.
     */
    public static Log4jPlugin getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path.
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(
                "nu.mine.kino.plugin.log4j", path);
    }

    public void configure() {
        String log4jPath = getPreferenceStore().getString(
                PreferenceConstants.DEFAULT_LOG4J_PATH);
        DOMConfigurator.configure(log4jPath);
        logger.debug(log4jPath + " でLog4jを初期化しました。");
        print();
    }

    public static void log(String message, Exception e) {
        IStatus status = new Status(IStatus.ERROR, getPluginId(),
                IStatus.ERROR, message, e);
        getDefault().getLog().log(status);
    }

    public static void log(String message) {
        log(message, null);
    }

    public static void log(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        String message = stringWriter.getBuffer().toString();
        log(message, e);
    }

    public static String getPluginId() {
        return getDefault().getBundle().getSymbolicName();
    }

    private void print() {
        Logger rootLogger = Logger.getRootLogger();
        logger.info("---------------------------------------");
        // rootのレベルを確認するために、Root Loggerを使用している
        rootLogger.debug("Root Logger は DEBUG を出力します。");
        rootLogger.info("Root Logger は INFO  を出力します。");
        rootLogger.warn("Root Logger は WARN  を出力します。");
        rootLogger.error("Root Logger は ERROR を出力します。");
        rootLogger.fatal("Root Logger は FATAL を出力します。");
        logger.info("---------------------------------------");
    }
}
