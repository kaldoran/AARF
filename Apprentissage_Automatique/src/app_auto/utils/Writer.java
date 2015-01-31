/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class Writer {
    private File listeBase;

    public Writer(String repertoire) {
        this.listeBase = new File(repertoire + "/Base");
        
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
            ObjectOutputStream redacteur = new ObjectOutputStream(new FileOutputStream(listeBase));
            
            ChiffreMatriceFreeman obj = new ChiffreMatriceFreeman(chiffre, matrice, freeman);
            redacteur.writeObject(obj);
            
            redacteur.close();
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
