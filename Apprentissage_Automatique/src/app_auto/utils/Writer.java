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
    private String repertoire;

    public Writer() {
        repertoire = new FichierConstante().REPERTOIRE_APPRENTISSAGE;
        File listeBase = new File(repertoire);
        
        if(!listeBase.exists()){
            try {
                listeBase.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public ChiffreMatriceFreeman enregistrer(String chiffre, int[][] matrice, String freeman){
        return enregistrerSous("Base", chiffre, matrice, freeman);
    }
    
    public ChiffreMatriceFreeman enregistrerSous(String nomF, String chiffre, int[][] matrice, String freeman){
        try {
            FileWriter redac = new FileWriter(repertoire + nomF, true);
            
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
}
