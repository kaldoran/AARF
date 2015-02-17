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
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author kevin
 */
public class PanneauGraphes extends JPanel {

    private Dimension dimension;
    private ChartPanel  chart_representationDonneeApprentissage,
                        chart_evaluationRF;
    
    public PanneauGraphes() {
        super();
        this.setLayout(new GridLayout(2, 2));
        dimension = new Dimension(200, 200);
        chart_representationDonneeApprentissage = new ChartPanel(null);
        chart_evaluationRF = new ChartPanel(null);
        /*JPanel p1 = new JPanel();
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
        */
        this.add(chart_representationDonneeApprentissage);
        this.add(chart_evaluationRF);
    }
    
    public void setChartRepresentationDonneeApprentissage(JFreeChart c) {
        this.chart_representationDonneeApprentissage.setChart(c);
//        this.repaint();
    }
    
    public void setChartEvaluationRF (JFreeChart c) {
        this.chart_evaluationRF.setChart(c);
    }
}
