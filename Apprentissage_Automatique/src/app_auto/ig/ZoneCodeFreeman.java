/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kaldoran
 */
public class ZoneCodeFreeman extends JPanel {
    
    private TitledBorder bordure;

    public ZoneCodeFreeman() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(290, 50));
        
        bordure = new TitledBorder("Code Freeman");
        this.setBorder(bordure);
        
        IgConstante.CODE_FREEMAN = new TexteCodeFreeman(); 
        this.add(IgConstante.CODE_FREEMAN);
        
    }
    
}
