/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig.graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class PanneauGraphes extends JPanel {

    
    public PanneauGraphes() {
        super();
        this.setLayout(new GridLayout(2, 2));
        Dimension d = new Dimension(200, 200);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        p1.setPreferredSize(d);
        p1.setBackground(Color.yellow);
        p2.setPreferredSize(d);
        p2.setBackground(Color.BLUE);
        p3.setPreferredSize(d);
        p3.setBackground(Color.GREEN);
        p4.setPreferredSize(d);
        
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        
    }
    
    
    
}
