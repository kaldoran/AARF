/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.graph;

import app_auto.utils.ChiffreMatriceFreeman;
import app_auto.utils.Stats;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author kevin
 */
public class TraceurGraphique {
    
    
    /**
     * Prend la base de connaissance et la représente sous forme d'histogramme
     * @param base
     * @return 
     */
    public static JFreeChart creerRepresentationDonneeApprentissage ( ArrayList<ChiffreMatriceFreeman> base ) {
        
        if(base.isEmpty()) {
            return null;
        }
        long[] tab_occ_chiffre = {0,0,0,0,0,0,0,0,0,0};
        // row keys...
        String series_0 = "0";
        String series_1 = "1";
        String series_2 = "2";
        String series_3 = "3";
        String series_4 = "4";
        String series_5 = "5";
        String series_6 = "6";
        String series_7 = "7";
        String series_8 = "8";
        String series_9 = "9";

        // column keys...
        String categorie = "Chiffres appris ";
        
        // create the dataset...
        DefaultCategoryDataset donnees_apprentissage = new DefaultCategoryDataset();
        
        Iterator<ChiffreMatriceFreeman> it = base.iterator();
        
        while (it.hasNext()) {
            ChiffreMatriceFreeman cmf =  it.next();
            tab_occ_chiffre[Integer.valueOf(cmf.getChiffre())]++;
        }
        
        donnees_apprentissage.addValue(tab_occ_chiffre[0], categorie, series_0);
        donnees_apprentissage.addValue(tab_occ_chiffre[1], categorie, series_1);
        donnees_apprentissage.addValue(tab_occ_chiffre[2], categorie, series_2);
        donnees_apprentissage.addValue(tab_occ_chiffre[3], categorie, series_3);
        donnees_apprentissage.addValue(tab_occ_chiffre[4], categorie, series_4);
        donnees_apprentissage.addValue(tab_occ_chiffre[5], categorie, series_5);
        donnees_apprentissage.addValue(tab_occ_chiffre[6], categorie, series_6);
        donnees_apprentissage.addValue(tab_occ_chiffre[7], categorie, series_7);
        donnees_apprentissage.addValue(tab_occ_chiffre[8], categorie, series_8);
        donnees_apprentissage.addValue(tab_occ_chiffre[9], categorie, series_9);
        
        
        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart(
                "Nombre d'exemple en fonction de chaque chiffre", // chart title
                "Chiffre", // domain axis label
                "Nombre d'exemples", // range axis label
                donnees_apprentissage, // data
                PlotOrientation.VERTICAL, // orientation
                false, // include legend
                true, // tooltips?
                false // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        return chart;
    }
 
    public static JFreeChart creerRepresentationStats(Stats stats) {
        // row keys...
        String[] series = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        // column keys...
        String bon = "Résultats justes";
        String mauvais = "Résultats faux";

        // create the dataset...
        DefaultCategoryDataset donnees_stats = new DefaultCategoryDataset();
        int[][] cbm = stats.getChiffreBonsMauvais();
        for (int i = 0; i < 10; ++i) {
            donnees_stats.addValue(cbm[i][0], bon, series[i]);
            donnees_stats.addValue(cbm[i][1], mauvais, series[i]);
        }

        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart(
                "Résultats en fonction de chaque chiffre", // chart title
                "Chiffre", // domain axis label
                "Nombre de tests", // range axis label
                donnees_stats, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );

        return chart;
    }
    
    public static JFreeChart creerRepresentationStatsGenerales(Stats stats) {      
        DefaultPieDataset donnees_stats = new DefaultPieDataset();
        
        float nbBons = stats.getNbBons();
        float nbMauvais = stats.getNbMauvais();
        
        float nbTot = stats.getNbTests();
        
        donnees_stats.setValue("Résultats justes " + Math.round((nbBons/nbTot)*100) + "%" , nbBons);
        donnees_stats.setValue("Résultats faux " + Math.round((nbMauvais/nbTot)*100) + "%" , nbMauvais);

        JFreeChart chart = ChartFactory.createPieChart("Pourcentage de réussite", donnees_stats, false, true, false);
        
        return chart;
    }
    /*public void afficherReprensationGraphiqueBase() {
        if(chartPanel_RepresentationBase != null) {
            JFrame f = new JFrame();
            f.setContentPane(chartPanel_RepresentationBase);
            f.pack();
            f.setVisible(true);
        }
    }*/
}
