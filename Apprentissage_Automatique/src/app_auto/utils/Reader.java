/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class Reader {
    private String repertoire;
    private File listeBase;

    public Reader(String repertoire) {
        this.repertoire = repertoire;
        this.listeBase = new File(repertoire + "/Base");
        
        if(!listeBase.exists()){
            try {
                listeBase.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
