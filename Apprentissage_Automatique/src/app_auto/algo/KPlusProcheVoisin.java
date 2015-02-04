/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.algo;

import app_auto.utils.ChiffreMatriceFreeman;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class KPlusProcheVoisin {

    
    public final int MANHATTAN = 0;
    public final int EUCLIDIENNE = 1;
    public final int CHEBYSHEV = 2;
    
    /**
     * Cette méthode determine la classe de x en utilisant les matrices
     * @param matrice_x
     * @param s
     * @param ALGO_DISTANCE
     * @return
     */
    public int kppv(int[][] matrice_x, ArrayList<ChiffreMatriceFreeman> s, int ALGO_DISTANCE) {
        int classe_y = 0;
        Iterator<ChiffreMatriceFreeman> it_s = null;
        ArrayList<ChiffreMatriceFreeman> liste_classementPoints = null;
        
        //Verification matrice n'est pas vide
        if(matrice_x.length == 0) {
            System.out.println("ERREUR : matrice vide !");
            return -1;
        } 
        
        //Verification que la base de connnaissance n'est pas vide
        if(s.isEmpty()) {
            System.out.println("ERREUR : Base de connaissance vide");
            return -1;
        }
        
        it_s = s.iterator();
        liste_classementPoints = new ArrayList<ChiffreMatriceFreeman>();
        
        while(it_s.hasNext()) {
            ChiffreMatriceFreeman cmf = it_s.next();
            
            switch(ALGO_DISTANCE) {
                
                case MANHATTAN : 
                    cmf.setDistance(manhattanDistance(matrice_x, cmf.getMatrice()));
                    break;
                    
                case EUCLIDIENNE : 
                    cmf.setDistance(euclideanDistance(matrice_x, cmf.getMatrice()));
                    break;
                    
                case CHEBYSHEV :
                    cmf.setDistance(chebyshevDistance(matrice_x, cmf.getMatrice()));
                    break;
                    
                default :
                    System.out.println("ERREUR : Algorithme de calcule de distance non existant");
                    return -1;
            }
        }
        
        //Trie par ordre croissant selon la distance (voir methode compareTo de ChiffreMatriceFreeman)
        Collections.sort(s);
        
        return classe_y;
    }
    
    /**
     * Manhattan Distance
     *
     * @param matrice_x
     * @param matrice_y
     * @return Manhattan distance between matrix x and matrix y
     */
    public double manhattanDistance(int[][] matrix_x, int[][] matrix_y) {
        //hello
        double s = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    s = s + Math.abs(matrix_x[i][j] - matrix_y[i][j]);
                }
            }
        }
        return s;
    }

    /**
     * Euclidean Distance
     *
     * @param matrix_x
     * @param matrix_y
     * @return Euclidean distance between matrix x and matrix y
     */
    public double euclideanDistance(int[][] matrix_x, int[][] matrix_y) {
        double s = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    s = s + Math.pow(matrix_x[i][j] - matrix_y[i][j], 2);
                }
            }
        }

        return Math.sqrt(s);
    }

    /**
     * Chebyshev Distance
     * 
     * @param matrix_x
     * @param matrix_y
     * @return Chebyshev Distance between matrix x and matrix y
     */
    public double chebyshevDistance(int[][] matrix_x, int[][] matrix_y) {
        double s = 0;
        double max = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    if(Math.abs(matrix_x[i][j] - matrix_y[i][j]) > max){
                        max = Math.abs(matrix_x[i][j] - matrix_y[i][j]);
                        s = max;
                    }  
                }
            }
        }
        return s;
    }
}
