/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.io.BufferedReader;
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
    private final Erreurs err = new Erreurs();
    
    public ArrayList<ChiffreMatriceFreeman> recupTotal() {       
        ArrayList<ChiffreMatriceFreeman> liste = new ArrayList<>();
        
        try {
            BufferedReader lectResume = new BufferedReader(new FileReader(Writer.verifFichier(FichierConstante.REPERTOIRE_APPRENTISSAGE + "Base")));
            String resume;
            while((resume = lectResume.readLine()) != null) {
                String[] champs = resume.split("#");
                
                int[][] matrice = lectureMatrice(champs[1]);
                
                ChiffreMatriceFreeman cmf = new ChiffreMatriceFreeman(champs[0], matrice, champs[2]);
                liste.add(cmf);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!liste.isEmpty()) {
                return liste;
            }
            return null;
        }
        
    }
    
    public ChiffreMatriceFreeman recupLigne(int ligne) {
        try {
            BufferedReader lectResume = new BufferedReader(new FileReader(Writer.verifFichier(FichierConstante.REPERTOIRE_APPRENTISSAGE + "Base")));
            
            if (ligne < 1) {
                throw err.new LigneNonPresente();
            }

            for (int i = 1; i < ligne; ++i) {

                if (lectResume.readLine() == null) {
                    throw err.new LigneNonPresente();
                }
            }
      
            String resume;
            if ((resume = lectResume.readLine()) == null) {
                throw err.new LigneNonPresente();
            }
            String[] champs = resume.split("#");

            int[][] matrice = lectureMatrice(champs[1]);

            ChiffreMatriceFreeman cmf = new ChiffreMatriceFreeman(champs[0], matrice, champs[2]);

            return cmf;
        } catch (IOException | Erreurs.LigneNonPresente ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public int[][] lectureMatrice(String matriceChaine){
        String[] lignes = matriceChaine.split("@");
        int i, l, h, j;
        
        l = lignes[0].length();
        h = lignes.length;
        int[][] matrice = new int[h][l];

        for (j = 0; j < h; ++j) {
            for (i = 0; i < l; ++i) {
                matrice[j][i] = Character.getNumericValue(lignes[j].charAt(i));
            }
        }
        
        return matrice;
    }
}
