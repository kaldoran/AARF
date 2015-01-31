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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class Reader {
    private String repertoire;

    public Reader() {
        repertoire = new FichierConstante().REPERTOIRE_APPRENTISSAGE;
        File listeBase = new File(repertoire);
        
        if(!listeBase.exists()) {
            try {
                listeBase.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<ChiffreMatriceFreeman> recupTotale() {
        
        ArrayList<ChiffreMatriceFreeman> liste = new ArrayList<>();
        try {
            BufferedReader lectResume = new BufferedReader(new FileReader(repertoire + "Base"));
            String resume;
            while((resume = lectResume.readLine()) != null) {
                String[] champs = resume.split("#");
                
                int[][] matrice = lectureMatrice(champs[0], champs[1]);
                
                ChiffreMatriceFreeman cmf = new ChiffreMatriceFreeman(Integer.parseInt(champs[1]), champs[0], matrice, champs[2]);
                liste.add(cmf);
                
                return liste;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public int[][] lectureMatrice(String chiffre, String id){
        try {
            File ficMatrice = new File(repertoire + chiffre + File.separator + id);
            BufferedReader lectMatrice = new BufferedReader(new FileReader(ficMatrice));
            
            long tailleTot = ficMatrice.length();
            
            int i, l, h, j;
            String ligne;
            
            try {
                ligne = lectMatrice.readLine();
                l = ligne.length();
                h = (int) tailleTot/l;
                
                int[][] matrice = new int[h][l];

                for (j = 0; j < h; ++j) {
                    for (i = 0; i < l; ++i) {
                        matrice[j][i] = Character.getNumericValue(ligne.charAt(i));
                    }
                    ligne = lectMatrice.readLine();
                }
                
                return matrice;
            } catch (IOException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    } 
}
