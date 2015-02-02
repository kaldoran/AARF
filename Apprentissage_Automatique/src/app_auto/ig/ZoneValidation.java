/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author kaldoran
 */
public class ZoneValidation extends JPanel {

    private BoutonRadio bouton_radio;
    private BoutonValidation bouton_validation;
    private Logo logo;
    
    public ZoneValidation() {
        super();
        this.setLayout(new BorderLayout());
        
        bouton_radio = new BoutonRadio();
        bouton_radio.setAlignmentX(LEFT_ALIGNMENT);
        this.add(bouton_radio, BorderLayout.NORTH);
        
        bouton_validation = new BoutonValidation();
        bouton_radio.setAlignmentX(LEFT_ALIGNMENT);
        this.add(bouton_validation, BorderLayout.CENTER);   
                        
        logo = new Logo();
        this.add(logo, BorderLayout.SOUTH);
        
    }
    
}
