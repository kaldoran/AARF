/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto;

import app_auto.ig.FenetrePrincipale;
import app_auto.utils.IgConstante;
import app_auto.utils.Reader;

/**
 *
 * @author kaldoran
 */
public class Apprentissage_Automatique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reader reader = new Reader();
        IgConstante.BASE_APPRENTISSAGE = reader.recupTotal();
        new FenetrePrincipale();
    }

}
