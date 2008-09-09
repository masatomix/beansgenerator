/******************************************************************************
 * Copyright (c) 2008 Masatomi KINO and others. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *      Masatomi KINO - initial API and implementation
 * $Id$
 ******************************************************************************/

package nu.mine.kino.plugin.beangenerator.sheetdata;

import java.util.List;

import net.java.amateras.xlsbeans.annotation.HorizontalRecords;
import net.java.amateras.xlsbeans.annotation.LabelledCell;
import net.java.amateras.xlsbeans.annotation.LabelledCellType;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * �N���X�����i�[����N���X�ł�
 * 
 * @author Masatomi KINO and JavaBeans Creator Plug-in
 * @version $Revision$
 */
public class ClassInformation implements IClassInformation {

    /**
     * �t�B�[���h���̃��X�g�ł�
     */
    private List<IFieldInformation> fieldInformations;

    /**
     * ���{��̃N���X�����i�[����t�B�[���h�ł��B
     */
    private String classNameJ;

    /**
     * �����̃t�B�[���h�ł�
     */
    private String description;

    /**
     * �p�b�P�[�W���̃t�B�[���h�ł�
     */
    private String packageName;

    /**
     * ���ۂ̃N���X���ł��B
     */
    private String className;

    /**
     * toString���o�͂��邩�A���i�[����t�B�[���h�ł�
     */
    private String toString;

    /**
     * extends��implements�Ȃǂ̏����i�[����t�B�[���h�ł�
     */
    private String addedInfo;

    /**
     * �t�B�[���h���̃��X�g���Z�b�g����B
     * 
     * @param fieldInformations
     *            �t�B�[���h���̃��X�g
     */
    @HorizontalRecords(tableLabel = "�N���X���", recordClass = FieldInformation.class)//$NON-NLS-1$	
    public void setFieldInformations(List<IFieldInformation> fieldInformations) {
        this.fieldInformations = fieldInformations;
    }

    /**
     * �N���X�����{��t�B�[���h���Z�b�g����B
     * 
     * @param classNameJ
     *            �N���X�����{��t�B�[���h
     */
    @LabelledCell(label = "�N���X�����{��", type = LabelledCellType.Right)//$NON-NLS-1$	
    public void setClassNameJ(String classNameJ) {
        this.classNameJ = classNameJ;
    }

    /**
     * �����t�B�[���h���Z�b�g����B
     * 
     * @param description
     *            �����t�B�[���h
     */
    @LabelledCell(label = "����", type = LabelledCellType.Right)//$NON-NLS-1$	
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * �p�b�P�[�W���t�B�[���h���Z�b�g����B
     * 
     * @param packageName
     *            �p�b�P�[�W���t�B�[���h
     */
    @LabelledCell(label = "�p�b�P�[�W��", type = LabelledCellType.Right)//$NON-NLS-1$	
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * �N���X���t�B�[���h���Z�b�g����B
     * 
     * @param className
     *            �N���X���t�B�[���h
     */
    @LabelledCell(label = "�N���X��", type = LabelledCellType.Right)//$NON-NLS-1$	
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * toString�t�B�[���h���Z�b�g����B
     * 
     * @param toString
     *            toString�t�B�[���h
     */
    @LabelledCell(label = "toString", type = LabelledCellType.Right)//$NON-NLS-1$	
    public void setToString(String toString) {
        this.toString = toString;
    }

    /**
     * �t�����t�B�[���h���Z�b�g����B
     * 
     * @param addedInfo
     *            �t�����t�B�[���h
     */
    @LabelledCell(label = "�t�����", type = LabelledCellType.Right)//$NON-NLS-1$	
    public void setAddedInfo(String addedInfo) {
        this.addedInfo = addedInfo;
    }

    /**
     * �t�B�[���h���̃��X�g���擾����B
     * 
     * @return �t�B�[���h���̃��X�g
     */
    public List<IFieldInformation> getFieldInformations() {
        return fieldInformations;
    }

    /**
     * �N���X�����{��t�B�[���h���擾����B
     * 
     * @return �N���X�����{��t�B�[���h
     */
    public String getClassNameJ() {
        return classNameJ;
    }

    /**
     * �����t�B�[���h���擾����B
     * 
     * @return �����t�B�[���h
     */
    public String getDescription() {
        return description;
    }

    /**
     * �p�b�P�[�W���t�B�[���h���擾����B
     * 
     * @return �p�b�P�[�W���t�B�[���h
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * �N���X���t�B�[���h���擾����B
     * 
     * @return �N���X���t�B�[���h
     */
    public String getClassName() {
        return className;
    }

    /**
     * toString�t�B�[���h���擾����B
     * 
     * @return toString�t�B�[���h
     */
    public String getToString() {
        return toString;
    }

    /**
     * �t�����t�B�[���h���擾����B
     * 
     * @return �t�����t�B�[���h
     */
    public String getAddedInfo() {
        return addedInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("�t�B�[���h���̃��X�g",
                fieldInformations).append("�N���X�����{��t�B�[���h", classNameJ).append(
                "�����t�B�[���h", description).append("�p�b�P�[�W���t�B�[���h", packageName)
                .append("�N���X���t�B�[���h", className).append("toString�t�B�[���h",
                        toString).append("�t�����t�B�[���h", addedInfo).toString();
    }
}