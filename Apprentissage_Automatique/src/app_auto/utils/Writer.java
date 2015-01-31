/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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

    
    public boolean enregistrer(String chiffre, int[][] matrice, String freeman){
        try {  
            int id = dernierId(chiffre);
            FileWriter redacBase = new FileWriter(repertoire + "Base", true);
            FileWriter redacMatrice = new FileWriter(repertoire + chiffre + File.separator + id, true);
            
            ChiffreMatriceFreeman obj = new ChiffreMatriceFreeman(id, chiffre, matrice, freeman);
            redacBase.write(obj.resume());
            redacMatrice.write(obj.chaineMatrice());
            
            redacBase.close();
            redacMatrice.close();
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public int dernierId(String chiffre){
        File rep = new File(repertoire + chiffre);
        return rep.list().length;
    }
}
