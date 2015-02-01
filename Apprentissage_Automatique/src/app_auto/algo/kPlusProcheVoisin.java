/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.algo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kevin 
 */
public class kPlusProcheVoisin {
    
    
    public final int MANHATTAN = 0;
    public final int EUCLIDIENNE = 1;
    public final int CHEBYSHEV = 2;
    
    /**
     * Cette méthode determine la classe de x en utilisant les matrices
     * @param matrice_x
     * @param S
     * @param ALGO_DISTANCE
     * @return
     */
    public int kppv(int[][] matrice_x, HashMap<Integer, ArrayList<ArrayList>> S, int ALGO_DISTANCE) {
        int classe_y = 0;
        int taille_matrice = 0;
        
        //Récuperation de la taille de la matrice
        if(matrice_x.length == 0) {
            System.out.println("ERREUR : matrice vide !");
            return -1;
        } else {
            taille_matrice = matrice_x.length;
        }
        
        //On utilise la taille de la matrice comme clé pour rechercher les exemples
        
        if ( S.containsKey(taille_matrice)) {
            
            for (ArrayList liste_exemple : S.get(taille_matrice) ) {
                
                for (Object o : liste_exemple) {
                    int[][] matrice_exemple = (int[][]) o;
                    
                    switch(ALGO_DISTANCE) {
                        case MANHATTAN :
                            break;
                            
                        case EUCLIDIENNE :
                            break;
                            
                        case CHEBYSHEV : 
                            break;
                            
                        default: System.out.println("Algorithme non existant");
                            break;
                    }
                }
            }
        }
        
        return classe_y;
    }

}
