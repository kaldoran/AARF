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
            BufferedReader lectResume = new BufferedReader(new FileReader(Writer.verifFichier(FichierConstante.FICHIER_BASE)));
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
            BufferedReader lectResume = new BufferedReader(new FileReader(Writer.verifFichier(FichierConstante.FICHIER_BASE)));
            
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
    
    public final static Stats recupStats(){
        Stats stats;
        int i = 0;
        BufferedReader lectResume;
        
        String ligne;
        String[] champs;
        int[] tbm = new int[3];
        int[][] cbm = new int[10][2];
        
        try {
            lectResume = new BufferedReader(new FileReader(Writer.verifFichier(FichierConstante.FICHIER_STATS)));
            
            ligne = lectResume.readLine();
            champs = ligne.split("|");
            
            tbm[0] = Integer.parseInt(champs[0]);
            tbm[1] = Integer.parseInt(champs[1]);
            tbm[2] = Integer.parseInt(champs[2]);
            
            while((ligne = lectResume.readLine()) != null) {
                champs = ligne.split("|");
                cbm[i][0] = Integer.parseInt(champs[1]);
                cbm[i][1] = Integer.parseInt(champs[2]);
                ++i;
            }
            
            if(i != 10){
                return null;
            }
            
            stats = new Stats(tbm[0], tbm[1], tbm[2], cbm);
            
            return stats;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
