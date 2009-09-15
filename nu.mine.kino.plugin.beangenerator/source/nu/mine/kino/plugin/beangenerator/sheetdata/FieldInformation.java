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

package nu.mine.kino.plugin.beangenerator.sheetdata;

import net.java.amateras.xlsbeans.annotation.Column;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * �t�B�[���h�����i�[����N���X�ł�
 * 
 * @author Masatomi KINO and JavaBeans Creator Plug-in
 * @version $Revision$
 */
public class FieldInformation implements IFieldInformation {

    /**
     * �t�B�[���h���̃��X�g�ł�
     */
    private String fieldNameJ;

    /**
     * ���{��̃N���X�����i�[����t�B�[���h�ł��B
     */
    private String fieldName;

    /**
     * �����̃t�B�[���h�ł�
     */
    private String fieldType;

    /**
     * �����̃t�B�[���h�ł�
     */
    private String description;

    /**
     * �t�B�[���h�����{����Z�b�g����B
     * 
     * @param fieldNameJ
     *            �t�B�[���h�����{��
     */
    @Column(columnName = "�t�B�[���h�����{��")//$NON-NLS-1$
    public void setFieldNameJ(String fieldNameJ) {
        this.fieldNameJ = fieldNameJ;
    }

    /**
     * �t�B�[���h�����Z�b�g����B
     * 
     * @param fieldName
     *            �t�B�[���h��
     */
    @Column(columnName = "�t�B�[���h��")//$NON-NLS-1$
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * �^���Z�b�g����B
     * 
     * @param fieldType
     *            �^
     */
    @Column(columnName = "�^")//$NON-NLS-1$
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * �������Z�b�g����B
     * 
     * @param description
     *            ����
     */
    @Column(columnName = "����")//$NON-NLS-1$
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * �t�B�[���h�����{����擾����B
     * 
     * @return �t�B�[���h�����{��
     */
    public String getFieldNameJ() {
        return fieldNameJ;
    }

    /**
     * �t�B�[���h�����擾����B
     * 
     * @return �t�B�[���h��
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * �^���擾����B
     * 
     * @return �^
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * �������擾����B
     * 
     * @return ����
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("�t�B�[���h�����{��", fieldNameJ)
                .append("�t�B�[���h��", fieldName).append("�^", fieldType).append(
                        "����", description).toString();
    }
}