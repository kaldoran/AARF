/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig.graph;

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
                        chart_evaluationChiffres,
                        chart_evaluationAlgos,
                        chart_statsGenerales;
    
    public PanneauGraphes() {
        super();
        this.setLayout(new GridLayout(2, 2));
        dimension = new Dimension(200, 200);
        
        chart_evaluationChiffres = new ChartPanel(null);
        chart_evaluationChiffres.setPreferredSize(new Dimension(500, 300));
        
        chart_statsGenerales = new ChartPanel(null);
        chart_statsGenerales.setPreferredSize(new Dimension(500, 300));
        
        chart_representationDonneeApprentissage = new ChartPanel(null);
        chart_representationDonneeApprentissage.setPreferredSize(new Dimension(500, 300));
        
        chart_evaluationAlgos = new ChartPanel(null);
        chart_evaluationAlgos.setPreferredSize(new Dimension(500, 300));

        this.add(chart_representationDonneeApprentissage);
        this.add(chart_statsGenerales);
        this.add(chart_evaluationChiffres);
        this.add(chart_evaluationAlgos);
    }
    
    public void setChartRepresentationDonneeApprentissage(JFreeChart c) {
        this.chart_representationDonneeApprentissage.setChart(c);
//        this.repaint();
    }
    
    public void setChartEvaluationChiffre (JFreeChart c) {
        this.chart_evaluationChiffres.setChart(c);
    }
    
     public void setChartStatsGenerales (JFreeChart c) {
        this.chart_statsGenerales.setChart(c);
    }   
    
    public void setChartEvaluationAlgos (JFreeChart c) {
        this.chart_evaluationAlgos.setChart(c);
    }
}
