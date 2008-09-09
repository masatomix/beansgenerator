/******************************************************************************
 * Copyright (c) 2008 Masatomi KINO and others. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *      Masatomi KINO - initial API and implementation
 * $Id: ClassInformationSheetWithAnno.java 240 2008-08-28 12:18:46Z masatomix $
 ******************************************************************************/
//�쐬��: 2008/08/15
package nu.mine.kino.plugin.beangenerator.sheetdata.anno;

import java.util.List;

import net.java.amateras.xlsbeans.annotation.IterateTables;
import net.java.amateras.xlsbeans.annotation.Sheet;
import nu.mine.kino.plugin.beangenerator.sheetdata.IClassInformation;

/**
 * @author Masatomi KINO
 * @version $Revision: 240 $
 */
@Sheet(name = "�N���X")//$NON-NLS-1$
public class ClassInformationSheetWithAnno {
    private List<IClassInformation> classInformation;

    @IterateTables(tableLabel = "�N���X���", tableClass = ClassInformationWithAnno.class, bottom = 7)//$NON-NLS-1$
    public void setClassInformation(List<IClassInformation> classInformation) {
        this.classInformation = classInformation;
    }

    public List<IClassInformation> getClassInformation() {
        return classInformation;
    }

}
