/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.ig.graph.FenetreGraphe;

/**
 *
 * @author kevin
 */
public class ControleurIGImpl implements InterfaceControleurIG{
    private InterfaceModele modele;
    private FenetreGraphe vue;
    
    public ControleurIGImpl(InterfaceModele modele) {
        this.modele = modele;
        
    }

    @Override
    public void initialiserApplication() {
        
    }
    
    
    
}
