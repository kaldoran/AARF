/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import javax.swing.JFrame;


/**
 *
 * @author kevin
 */
public class FenetrePrincipale{
    
    /** Attribut de la fenetre*/
    private JFrame cadre;
    private BarreMenu barre_menu;
    private PanneauPrincipal panneau_principal;
    
    public FenetrePrincipale() {
        this.setBaseConf();
    }      

    private void setBaseConf() {
        cadre = new javax.swing.JFrame("Apprentissage Automatique");
        
        barre_menu = new BarreMenu();
        panneau_principal = new PanneauPrincipal();
                        
        cadre.setJMenuBar(barre_menu);
        cadre.setLocation(200, 100);
        cadre.setContentPane(panneau_principal);
        cadre.pack();
        cadre.setVisible(true);
        cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
