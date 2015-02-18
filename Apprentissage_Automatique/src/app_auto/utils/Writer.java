/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class Writer {
    public final static ChiffreMatriceFreeman enregistrer(String chiffre, int[][] matrice, String freeman){
        return enregistrerSous(FichierConstante.REPERTOIRE_APPRENTISSAGE + "Base", chiffre, matrice, freeman);
    }
    
    public final static ChiffreMatriceFreeman enregistrerSous(String file, String chiffre, int[][] matrice, String freeman){
        try {
            FileWriter redac = new FileWriter(verifFichier(file) , true);
            
            ChiffreMatriceFreeman obj = new ChiffreMatriceFreeman(chiffre, matrice, freeman);
            redac.write(obj.resume());
            
            redac.close();
            return obj;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public final static File verifFichier(String path){
        File fic = new File(path);
        
        if(!fic.isFile()){
            try {
                fic.getParentFile().mkdirs();
                fic.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fic;
    }
    
    public final static File verifDossier(String path){
        File fic = new File(path);
        
        if(!fic.isDirectory()){
            fic.mkdirs();
        }
        return fic;
    }    
}
