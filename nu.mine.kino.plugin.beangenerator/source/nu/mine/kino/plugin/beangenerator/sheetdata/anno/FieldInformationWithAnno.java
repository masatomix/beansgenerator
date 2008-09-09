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

package nu.mine.kino.plugin.beangenerator.sheetdata.anno;

import net.java.amateras.xlsbeans.annotation.Column;
import nu.mine.kino.plugin.beangenerator.sheetdata.IFieldInformation;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Annotation�t���̃t�B�[���h�����i�[����N���X�ł�
 * 
 * @author Masatomi KINO and JavaBeans Creator Plug-in
 * @version $Revision$
 */
public class FieldInformationWithAnno implements IFieldInformation {

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
     * XLSBeans�̃A�m�e�[�V�������o�͂��邩���w�肷��t�B�[���h�ł��B
     */
    private String annotation;

    /**
     * XLSBeans�̃A�m�e�[�V�������o�͂���ꍇ�A �A�m�e�[�V���������w�肷��t�B�[���h�ł��B
     */
    private String annotationName;

    /**
     * XLSBeans�̃A�m�e�[�V�������o�͂���ꍇ�A �}�[�W���邩�I�v�V�������w�肷��t�B�[���h�ł��B
     */
    private String merge;

    /**
     * �Ǝ��̃A�m�e�[�V�����𒼐ڋL�q����ꍇ�Ɏg�p����t�B�[���h�ł��B
     */
    private String customAnnotation;

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
     * Annotation���Z�b�g����B
     * 
     * @param annotation
     *            Annotation
     */
    @Column(columnName = "Annotation")//$NON-NLS-1$
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    /**
     * Annotation�����Z�b�g����B
     * 
     * @param annotationName
     *            Annotation��
     */
    @Column(columnName = "Annotation��")//$NON-NLS-1$
    public void setAnnotationName(String annotationName) {
        this.annotationName = annotationName;
    }

    /**
     * �}�[�W���Z�b�g����B
     * 
     * @param merge
     *            �}�[�W
     */
    @Column(columnName = "�}�[�W")//$NON-NLS-1$
    public void setMerge(String merge) {
        this.merge = merge;
    }

    /**
     * �Ǝ��̃A�m�e�[�V�������Z�b�g����B
     * 
     * @param customAnnotation
     *            �Ǝ��̃A�m�e�[�V����
     */
    @Column(columnName = "�Ǝ��̃A�m�e�[�V����")//$NON-NLS-1$
    public void setCustomAnnotation(String customAnnotation) {
        this.customAnnotation = customAnnotation;
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

    /**
     * Annotation���擾����B
     * 
     * @return Annotation
     */
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Annotation�����擾����B
     * 
     * @return Annotation��
     */
    public String getAnnotationName() {
        return annotationName;
    }

    /**
     * �}�[�W���擾����B
     * 
     * @return �}�[�W
     */
    public String getMerge() {
        return merge;
    }

    /**
     * �Ǝ��̃A�m�e�[�V�������擾����B
     * 
     * @return �Ǝ��̃A�m�e�[�V����
     */
    public String getCustomAnnotation() {
        return customAnnotation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("�t�B�[���h�����{��", fieldNameJ)
                .append("�t�B�[���h��", fieldName).append("�^", fieldType).append(
                        "����", description).append("Annotation", annotation)
                .append("Annotation��", annotationName).append("�}�[�W", merge)
                .append("�Ǝ��̃A�m�e�[�V����", customAnnotation).toString();
    }
}