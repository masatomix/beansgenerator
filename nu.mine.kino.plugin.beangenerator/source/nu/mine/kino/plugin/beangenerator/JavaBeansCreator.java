/******************************************************************************
 * Copyright (c) 2008 Masatomi KINO and others. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *      Masatomi KINO - initial API and implementation
 * $Id: JavaBeansCreator.java 242 2008-08-29 06:35:17Z masatomix $
 ******************************************************************************/
//�쐬��: 2008/08/15
package nu.mine.kino.plugin.beangenerator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import nu.mine.kino.plugin.beangenerator.sheetdata.IClassInformation;
import nu.mine.kino.plugin.beangenerator.sheetdata.IFieldInformation;

import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;

/**
 * @author Masatomi KINO
 * @version $Revision: 242 $
 */
public class JavaBeansCreator {

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(JavaBeansCreator.class);

    private final IJavaProject javaProject;

    public JavaBeansCreator(IJavaProject javaProject) {
        this.javaProject = javaProject;
        // Velocity������
        URL entry = Activator.getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
        try {
            String pluginDirectory = FileLocator.resolve(entry).getPath();
            File file = new File(pluginDirectory, "lib"); //$NON-NLS-1$
            Properties p = new Properties();
            p.setProperty("file.resource.loader.path", file.getAbsolutePath()); //$NON-NLS-1$
            Velocity.init(p);
            // �ǂ�����̃f�B���N�g���Ƃ����Ȃ����Ă��G���[�ɂȂ�Ȃ����ۂ��̂ŁA���̂܂܂Ԃ����Ⴈ���B
        } catch (IOException e) {
            logger.error("JavaBeansCreator()", e); //$NON-NLS-1$
            Activator.logException(e);
        } catch (Exception e) {
            logger.error("JavaBeansCreator()", e); //$NON-NLS-1$
            Activator.logException(e);
        }
    }

    // private String getProjectEncoding() {
    // try {
    // IWorkspace workspace = ResourcesPlugin.getWorkspace();
    // IProject project = workspace.getRoot().getProject(
    // javaProject.getElementName());
    // return project.getDefaultCharset();
    // } catch (CoreException e1) {
    // logger.error(e1);
    // Activator.logException(e1, false);
    // }
    // return JavaCore.getEncoding();
    // }

    public ICompilationUnit create(IClassInformation info) throws CoreException {
        logger.debug("create(ClassInformation) - start"); //$NON-NLS-1$

        // �t�B�[���h��JavaProject���C���X�^���X����A���擾�B
        IPackageFragmentRoot root = getSourceDir(javaProject);
        String pkg = info.getPackageName();
        // �p�b�P�[�W�ւ̃|�C���^�擾
        IPackageFragment pack = root.getPackageFragment(pkg);
        // �p�b�P�[�W�����݂��Ȃ�������쐬����
        if (!pack.exists()) {
            pack = root.createPackageFragment(pkg, true,
                    new NullProgressMonitor());
        }

        // �\�[�X�R�[�h�̐����J�n�B
        String mainStatement = createMain(info);
        ICompilationUnit cu = pack.createCompilationUnit(info.getClassName()
                + ".java", mainStatement, true, new NullProgressMonitor()); //$NON-NLS-1$
        // package����
        // cu.createPackageDeclaration(pkg, new NullProgressMonitor());

        IType type = cu.getType(info.getClassName());

        // �t�B�[���h����
        createField(type, info);
        // ���\�b�h�̐���
        createSetter(type, info);
        createGetter(type, info);

        // toString�̐���
        if (contains(info.getToString(), "��")) { //$NON-NLS-1$
            createToString(type, info);
        }
        // �����o���B
        cu.save(new NullProgressMonitor(), true);

        logger.debug("create(ClassInformation) - end"); //$NON-NLS-1$
        return cu;
    }

    private String executeVelocity(String vm, String[] names, Object[] objs)
            throws CoreException {
        logger.debug("executeVelocity(String, String[], Object[]) - start"); //$NON-NLS-1$

        try {
            VelocityContext context = new VelocityContext();
            for (int i = 0; i < names.length; i++) {
                context.put(names[i], objs[i]);
            }
            StringWriter out = new StringWriter();
            Template template = Velocity.getTemplate(vm, "MS932"); //$NON-NLS-1$
            template.merge(context, out);
            String result = out.toString();
            out.flush();
            logger.debug("executeVelocity(String, String[], Object[]) - end"); //$NON-NLS-1$
            return result;
        } catch (Exception e) {
            logger.error("executeVelocity(String, String[], Object[])", e); //$NON-NLS-1$
            IStatus status = new Status(IStatus.ERROR, Activator.getPluginId(),
                    IStatus.OK, e.getMessage(), e);
            throw new CoreException(status);
        }
    }

    private String createMain(IClassInformation clazz) throws CoreException {
        // �N���X��񂩂�AVelocity�Ń��C���������쐬����B
        return executeVelocity("main.vm", new String[] { "class" }, //$NON-NLS-1$ //$NON-NLS-2$
                new IClassInformation[] { clazz });
    }

    /**
     * @param type
     */
    private void createField(IType type, IClassInformation info)
            throws CoreException {
        logger.debug("createField() start"); //$NON-NLS-1$
        StringBuffer buf = new StringBuffer();
        List<IFieldInformation> fieldInformations = info.getFieldInformations();
        for (IFieldInformation field : fieldInformations) {
            String result = executeVelocity("field.vm", //$NON-NLS-1$
                    new String[] { "field" }, new IFieldInformation[] { field }); //$NON-NLS-1$
            buf.append(result);
        }
        type.createField(buf.toString(), null, true, new NullProgressMonitor());
        logger.debug("createField() end"); //$NON-NLS-1$
    }

    private void createToString(IType type, IClassInformation info)
            throws CoreException {
        StringBuffer buf = new StringBuffer();

        List<IFieldInformation> fieldInformations = info.getFieldInformations();
        for (IFieldInformation field : fieldInformations) {
            String key = field.getFieldNameJ();
            String value = field.getFieldName();
            buf.append(".append(\""); //$NON-NLS-1$
            buf.append(key);
            buf.append("\","); //$NON-NLS-1$
            buf.append(value);
            buf.append(")"); //$NON-NLS-1$
        }
        buf.append(".toString();"); //$NON-NLS-1$
        // toString�̍쐬
        String toString = executeVelocity(
                "toString.vm", new String[] { "toString" }, new String[] { new String(buf) }); //$NON-NLS-1$ //$NON-NLS-2$
        type.createMethod(toString, null, true, new NullProgressMonitor());
    }

    private void createGetter(IType type, IClassInformation info)
            throws CoreException {
        logger.debug("createGetter() start"); //$NON-NLS-1$

        List<IFieldInformation> fieldInformations = info.getFieldInformations();
        for (IFieldInformation field : fieldInformations) {
            String prefix = null;
            // �t�B�[���h�̌^��,boolean�Ƃ��̏ꍇ��get�łȂ��āAis�ɂ���B
            if (contains(field.getFieldType(), "boolean", "java.lang.Boolean")) { //$NON-NLS-1$ //$NON-NLS-2$
                prefix = "is"; //$NON-NLS-1$
            } else {
                prefix = "get"; //$NON-NLS-1$
            }
            String[] keys = new String[] { "field", "cname", "prefix" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            Object[] values = new Object[] { field,
                    WordUtils.capitalize(field.getFieldName()), prefix };
            // setter�̍쐬
            // String setter = executeVelocity("setter.vm", keys, values);
            // //$NON-NLS-1$
            // type.createMethod(setter, null, true, new NullProgressMonitor());
            // getter�̍쐬
            String getter = executeVelocity("getter.vm", keys, values); //$NON-NLS-1$
            type.createMethod(getter, null, true, new NullProgressMonitor());
        }
        logger.debug("createGetter() end"); //$NON-NLS-1$
    }

    private void createSetter(IType type, IClassInformation info)
            throws CoreException {
        logger.debug("createSetter() start"); //$NON-NLS-1$

        List<IFieldInformation> fieldInformations = info.getFieldInformations();
        for (IFieldInformation field : fieldInformations) {
            String[] keys = new String[] { "field", "cname" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            Object[] values = new Object[] { field,
                    WordUtils.capitalize(field.getFieldName()) };
            // setter�̍쐬
            String setter = executeVelocity("setter.vm", keys, values); //$NON-NLS-1$
            type.createMethod(setter, null, true, new NullProgressMonitor());
        }
        logger.debug("createSetter() end"); //$NON-NLS-1$
    }

    private boolean contains(String input, String... strs) {
        for (String str : strs) {
            // �z��ɁAinput�Ɠ����̂�����΁Atrue
            if (input.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private IPackageFragmentRoot getSourceDir(IJavaProject javaProject)
            throws CoreException {
        IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
        for (IPackageFragmentRoot root : roots) {
            if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
                // �������邩���ˁB��Ɍ��܂������ŕԂ����Ⴄ�B
                return root;
            }
        }
        // �\�[�X�f�B���N�g�����Ƃ�Ȃ��̂ŁA�G���[�B
        IStatus status = new Status(IStatus.ERROR, Activator.getPluginId(),
                IStatus.OK, Messages.JavaBeansCreator_MSG_SRCDIR_NOT_FOUND,
                null);
        throw new CoreException(status);
    }

}
