/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

/**
 *
 * @author Kevin
 */
public class Erreurs {
    public class MatriceVide extends Exception {

        public MatriceVide() {
            System.out.println("La matrice à traduire en code de freeman est vide.");
        }
    }
    
    public class VecteurFaux extends Exception {
        
        public VecteurFaux() {
            System.out.println("Erreur de vecteur de Freeman.");
        }
    }
}
