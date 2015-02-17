/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig.graph;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author kevin
 */
public class FenetreGraphe extends JFrame {
    
    private PanneauGraphes panneauGraphes;
    
    public FenetreGraphe() throws HeadlessException {
        
        super("Représentation graphique");
        panneauGraphes = new PanneauGraphes();
        this.setLocation(200, 100);
        this.setContentPane(panneauGraphes);
        this.pack();
        this.setVisible(false);
        this.setResizable(false);
    }
    
    public PanneauGraphes getPanneauGraphes() {
        return panneauGraphes;
    }
    
}
