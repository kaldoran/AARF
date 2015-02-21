/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig.graph;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author kevin
 */
public class FenetreGraphe extends JFrame {
    
    private PanneauGraphes panneauGraphes;
    
    public FenetreGraphe() throws HeadlessException {
        
        super("Statistiques de Mini-François");
        panneauGraphes = new PanneauGraphes();
        this.setLocation(400, 50);
        this.setContentPane(panneauGraphes);
        this.pack();
        this.setVisible(false);
        this.setResizable(false);
    }
    
    public PanneauGraphes getPanneauGraphes() {
        return panneauGraphes;
    }
    
}
