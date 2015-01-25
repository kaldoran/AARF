/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kaldoran
 */
public class ZoneCodeFreeman extends JPanel {
    
    private TitledBorder bordure;
    private JTextField code_freeman;
    public ZoneCodeFreeman() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(250, 50));
        this.setLocation(100, 1000);
        
        bordure = new TitledBorder("Code Freeman");
        code_freeman = new TexteCodeFreeman();
        
        this.setBorder(bordure);
        this.add(code_freeman);
        
    }
    
}
