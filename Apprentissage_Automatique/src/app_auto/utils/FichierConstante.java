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
 * @author kaldoran
 */
public class FichierConstante {
    public String REPERTOIRE_APPRENTISSAGE;

   public FichierConstante() {
        String os = System.getProperties().getProperty("os.name").toLowerCase();
        File verif;
        
        if(os.contains("win")){
            REPERTOIRE_APPRENTISSAGE = System.getProperties().getProperty("user.dir") + "\\Base_Apprentissage\\";
        }
        else{
            REPERTOIRE_APPRENTISSAGE = System.getProperties().getProperty("user.dir") + "/Base_Apprentissage/";
            
        }
        
        verif = new File(REPERTOIRE_APPRENTISSAGE);
        
        if(!verif.exists() || !verif.isDirectory()){
            verif.mkdirs();
        }
        for(int i = 0; i < 10; ++i){
            File repM = new File(REPERTOIRE_APPRENTISSAGE + i);
            if(!repM.exists() || !repM.isDirectory()){
                repM.mkdir();
            }
        }
    }
}
