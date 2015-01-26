/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kaldoran
 */
public class BoutonValidation extends JPanel {

    private JButton validation;
    private JButton reset;
    
    public BoutonValidation() {
        super();
        this.setPreferredSize(new Dimension(50, 50));
        
        validation = new JButton("Valider");
        validation.setAlignmentY(CENTER_ALIGNMENT);
        this.add(validation, BorderLayout.WEST);
        
        reset = new JButton("Reset");
        this.add(reset, BorderLayout.EAST);
        
    }
    
}
