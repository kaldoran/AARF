/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class ChiffreMatriceFreeman implements Serializable, Comparable<ChiffreMatriceFreeman>{

    private String chiffre;
    private int[][] matrice;
    private String freeman;
    private double distance = 0;

    public ChiffreMatriceFreeman(String chiffre, int[][] matrice, String freeman) {
        this.chiffre = chiffre;
        this.matrice = matrice;
        this.freeman = freeman;
    }

    public String getChiffre() {
        return chiffre;
    }

    public void setChiffre(String chiffre) {
        this.chiffre = chiffre;
    }

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }

    public String getFreeman() {
        return freeman;
    }

    public void setFreeman(String freeman) {
        this.freeman = freeman;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String resume() {
        return chiffre + "#" + chaineMatrice() + "#" + freeman + "\n";
    }
    
    public int[][] getConvMatrice(int larg,int haut){
        return convMatrice(this.matrice, larg, haut);
    }
    
    public String chaineMatrice() {
        String chaineMatrice = "";
        int j,i;
        for(j = 0; j < matrice.length-1; ++j){
            for(i = 0; i < matrice[j].length; ++i){
                chaineMatrice += matrice[j][i];
            }
            chaineMatrice += "@";
        }
        
        for(i = 0; i < matrice[j].length; ++i){
            chaineMatrice += matrice[j][i];
        }
        
        return chaineMatrice;
    }
    
    public BufferedImage matriceToImage(){
        int l = matrice[0].length;
        int h = matrice.length;
        
        BufferedImage image = new BufferedImage(l, h, BufferedImage.TYPE_BYTE_BINARY);
        
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < l; i++) {
                 image.setRGB(i, j, pixel(matrice[j][i]));
            }
        }
        
        return image;
    }
    
    public int pixel(int caseM){
        if(caseM == 1){
            return IgConstante.WHITE;
        }
        return IgConstante.BLACK;
    }

    public static void testerFreeman(String morgan, String ligne) {
        CodeFreeman free = new CodeFreeman();

        try {
            int[][] mat = free.freemanToMatrice(morgan);
            
            String nomF = "imageTestFreeman_";
            String suff;
            if(ligne.equals("X")){
                int nbT = Writer.verifDossier(FichierConstante.REPERTOIRE_APPRENTISSAGE).list().length;
                if(nbT > 1){
                    nbT--;
                }
                suff =  "T" + nbT;
            }
            else{
                suff = "L" + ligne;
            }
            
            ChiffreMatriceFreeman cmf = Writer.enregistrerSous(FichierConstante.REPERTOIRE_APPRENTISSAGE + "testFreeman", suff, mat, morgan);
            
            BufferedImage imgMatrice = cmf.matriceToImage();
            
            //BufferedImageToMatrix.printMatrice(matrice);
            
            BufferedImageToMatrix.enregister(imgMatrice, nomF + suff);
        } catch (Erreurs.FreemanFaux ex) {
            Logger.getLogger(ChiffreMatriceFreeman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int[][] completerMatrice(int[][] matrice){
        int compLong = matrice[0].length+1;
        int[][] matriceComp = new int[matrice.length+1][compLong];
        int j,i;
        
        for(j = 0; j < matrice.length; ++j) {
            for(i = 0; i < matrice[0].length; ++i) {
                matriceComp[j][i] = matrice[j][i];
            }
            matriceComp[j][i] = 0;
        }
        for(i = 0; i < compLong; ++i) {
            matriceComp[j][i] = 0;
        }
        
        return matriceComp;
    }
    
    public int[][] convMatrice(int[][] matriceBase, int larg, int haut){
        int[][] matrice = completerMatrice(matriceBase);
        int largConv = matrice[0].length/larg;
        int hautConv = matrice.length/haut;
        int tmpJ = 0, tmpI = 0;
        int tmpH = 0, tmpL = 0;
        int c = 0;
        //int q = 1/(larg*haut);
        int i,j,n,m;
        int[][] matriceConv = new int[hautConv][largConv];
        
        for(j = 0; j < hautConv; ++j) {
            for(i = 0; i < largConv; ++i) {
                tmpI = i*larg;
                tmpL = larg + tmpI;
                
                tmpJ = j*haut;
                tmpH = haut + tmpJ;
                
                for(n = tmpJ; n < tmpH; ++n){
                    for(m = tmpI; m < tmpL; ++m){
                        c += matrice[n][m];//*q;
                    }
                }
                if(c > 0){
                matriceConv[j][i] = c;
                c = 0;
                }
            }       
        }
        
        return matriceConv;
    }

    @Override
    public int compareTo(ChiffreMatriceFreeman cmf) {
        if(this.distance < cmf.distance) {
            return -1;
        }
        
        if(this.distance == cmf.distance) {
            return 0;
        }
        
        return 1;
    }
}
