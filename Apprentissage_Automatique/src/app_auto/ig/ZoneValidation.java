/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.utils.IgConstante;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author kaldoran
 */
public class ZoneValidation extends JPanel {

    private BoutonValidation bouton_validation;
    private Logo logo;
    
    public ZoneValidation() {
        super();
        this.setLayout(new BorderLayout());
        
        IgConstante.BOUTON_RADIO = new BoutonRadio();
        this.add(IgConstante.BOUTON_RADIO, BorderLayout.NORTH);
        
        bouton_validation = new BoutonValidation();
        this.add(bouton_validation, BorderLayout.CENTER);   
                        
        logo = new Logo();
        this.add(logo, BorderLayout.SOUTH);
        
    }
    
}
