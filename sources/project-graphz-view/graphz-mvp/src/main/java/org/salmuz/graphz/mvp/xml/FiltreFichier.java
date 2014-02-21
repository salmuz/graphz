package org.salmuz.graphz.mvp.xml;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Antonio
 * Date: 29/03/13
 * Time: 02:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class FiltreFichier extends javax.swing.filechooser.FileFilter {

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = getExtension(f);

        if(extension.equals("xls"))
            return true;
        else
            return false;
    }

    public String getDescription() {
        return "Fichier excel (*.xls)";
    }

    public String getExtension(File f)
    {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }


}
