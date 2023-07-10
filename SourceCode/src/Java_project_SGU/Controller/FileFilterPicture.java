package Java_project_SGU.Controller;

import java.io.File;
import javax.swing.filechooser.FileFilter;

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author ADMIN
// */
public class FileFilterPicture extends FileFilter {
    public static final String JPG  = "jpg";
    public static final String PNG = "png";
    public static final String GIF = "gif";

    private static String getTailFile (File file) {
        String tailFile = "";
        var fileName = file.getName();
        int positionTailNameFile = fileName.lastIndexOf(".");
        if (positionTailNameFile > -1) {
            tailFile = fileName.substring(positionTailNameFile + 1);
        }
        return tailFile;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        } 
        String tailFileName = getTailFile(f);
      
        if (tailFileName != null) {
            if (tailFileName.toLowerCase().equals(JPG) ||  
                tailFileName.toLowerCase().equals(PNG) ||
                tailFileName.toLowerCase().equals(GIF)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Image file";
    }
    
}
