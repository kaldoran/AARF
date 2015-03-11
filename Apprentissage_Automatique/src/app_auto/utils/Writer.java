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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class Writer {

    public final static ChiffreMatriceFreeman enregistrer(String chiffre, int[][] matrice, String freeman) {
        return enregistrerSous(FichierConstante.FICHIER_BASE, chiffre, matrice, freeman);
    }

    public final static ChiffreMatriceFreeman enregistrerSous(String file, String chiffre, int[][] matrice, String freeman) {
        try {
            FileWriter redac = new FileWriter(Writer.verifFichier(file, 0), true);

            ChiffreMatriceFreeman obj = new ChiffreMatriceFreeman(chiffre, matrice, freeman);
            IgConstante.DERNIERE_LIGNE = obj.resume().length();
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

    public final static void majStat(int chiffre, int resultat) {

        Stats stats = Reader.recupStats();

        if (stats != null) {
            stats.addStat(chiffre, resultat);

            Writer.remplacerStats(stats);
        }
    }

    public static final void remplacerStats(Stats stats) {
        try {
            FileWriter redac = new FileWriter(Writer.verifFichier(FichierConstante.FICHIER_STATS, 0));

            String chaineStats = stats.toString();
            redac.write(chaineStats, 0, chaineStats.length());

            redac.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void initStats() {
        Stats initStats = new Stats();

        try {
            FileWriter redac = new FileWriter(FichierConstante.FICHIER_STATS);

            String chaineStats = initStats.toString();
            redac.write(chaineStats, 0, chaineStats.length());

            redac.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public final static void ecrireEntreeArff(int[][] matrice, String chiffre, Boolean test){
        try {
            int nbInput = matrice[0].length*matrice.length;
            
            String path;
            if(test){
                path = FichierConstante.PREFIX_ARFF_TEST + nbInput + FichierConstante.ARFF;
            } else {
                path = FichierConstante.PREFIX_ARFF_VALID + nbInput + FichierConstante.ARFF;
            }
            
            FileWriter redac = new FileWriter(Writer.verifFichier(path, nbInput), true);

            String entree = "";
            int longueur = matrice.length-1;
            int largeur = matrice[0].length-1;
            int i,j;
            
            for(j = 0; j < longueur; ++j){
                for(i = 0; i < matrice[0].length; i++){
                    entree += matrice[j][i] + ",";
                } 
            }
            for(i = 0; i < largeur; i++){
                entree += matrice[j][i] + ",";
            }
            entree += matrice[j][i]+", ";
            entree += chiffre + "\n";
            
            redac.write(entree);
            
            redac.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final static void tradBaseEnArff(ArrayList<ChiffreMatriceFreeman> base, int larg, int haut, int percValid){
        if(percValid > 66){
            percValid = 66;
        } else if(percValid < 0){
            percValid = 0;
        }
        
        int nbEx = base.size();
        int nbValid = (nbEx*percValid)/100;
        int i;
        ChiffreMatriceFreeman tmp;
        int[][] tmpmat;
        
        for(i = 0; i < nbValid; ++i){
            tmp = base.get(i);
            tmpmat = tmp.getConvMatrice(larg, haut);
            Writer.ecrireEntreeArff(tmpmat, tmp.getChiffre(), false);
        }
        
        while(i < nbEx){
            tmp = base.get(i);
            tmpmat = tmp.getConvMatrice(larg, haut);
            Writer.ecrireEntreeArff(tmpmat, tmp.getChiffre(), true);
            
            ++i;
        }
        
    }
    
    private static void initArff(String path, int nbInput){
        try {
            FileWriter redac = new FileWriter(path);
            
            String init = "@relation Base_RdN_" + nbInput + "inputs\n\n";

            for(int i = 0; i < nbInput; ++i){
                init += "@attribute m"+ i +" numeric\n";
            }
            init += "@attribute chiffre {0,1,2,3,4,5,6,7,8,9}\n\n";
            init += "@data\n";
        
            
            redac.write(init);
            
            redac.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final static void logTestRdn(String resultats){
        try {
            FileWriter redac = new FileWriter(Writer.verifFichier(FichierConstante.FICHIER_LOG_RDN, 0), true);
            
            redac.write("|----------\n" + resultats + "----------|\n");
            
            redac.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final static File verifFichier(String path, int nbInput) {
        File fic = new File(path);

        if (!fic.isFile()) {
            try {
                fic.getParentFile().mkdirs();
                fic.createNewFile();

                if (path.equals(FichierConstante.FICHIER_STATS)) {
                    Writer.initStats();
                } else if(path.startsWith(FichierConstante.PREFIX_ARFF_TEST) || path.startsWith(FichierConstante.PREFIX_ARFF_VALID)) {
                    Writer.initArff(path, nbInput);
                }
            } catch (IOException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return fic;
    }

    public final static File verifDossier(String path) {
        File fic = new File(path);

        if (!fic.isDirectory()) {
            fic.mkdirs();
        }
        return fic;
    }
}
