/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.algo;

import app_auto.utils.FichierConstante;
import app_auto.utils.Writer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.Utils;

/**
 *
 * @author Kevin
 */
public class ReseauNeurones {
    MultilayerPerceptron rdn; 

    public ReseauNeurones() {
        rdn = new MultilayerPerceptron();
    }
    
    public void training(String ficArff){    
        try {
            FileReader trainreader = new FileReader(Writer.verifFichier(FichierConstante.PREFIX_ARFF + "300" + FichierConstante.ARFF, 300));

            Instances train = new Instances(trainreader);
            train.setClassIndex(train.numAttributes() - 1);
            
            rdn.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 4"));
            rdn.buildClassifier(train);
            
            trainreader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
