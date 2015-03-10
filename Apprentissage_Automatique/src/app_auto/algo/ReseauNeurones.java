/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.algo;

import app_auto.utils.FichierConstante;
import app_auto.utils.Writer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public ReseauNeurones(String hiddenLay) {
        rdn = initRdN(hiddenLay);
    }

    public void training(String ficArff) {
        try {
            FileReader trainreader = new FileReader(Writer.verifFichier(FichierConstante.PREFIX_ARFF + "300" + FichierConstante.ARFF, 300));

            Instances train = new Instances(trainreader);
            train.setClassIndex(train.numAttributes() - 1);

            rdn.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 4"));
            rdn.buildClassifier(train);

            sauverRdN();
            
            trainreader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static final MultilayerPerceptron initRdN(String hiddenLay){
        File ficRdN = new File(FichierConstante.PREFIX_RDN + hiddenLay);
        
        if(ficRdN.isFile()){
            return chargerRdN(ficRdN);
        }
        else{
            MultilayerPerceptron rdn = new MultilayerPerceptron();
            rdn.setHiddenLayers(hiddenLay);
            
            return rdn;
        }
    }

    private static MultilayerPerceptron chargerRdN(File ficRdN) {
        if (ficRdN.isFile()) {
            try {
                FileInputStream save = new FileInputStream(ficRdN);
                ObjectInputStream ois = new ObjectInputStream(save);

                MultilayerPerceptron rdn = (MultilayerPerceptron) ois.readObject();

                ois.close();
                
                return rdn;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }

    private void sauverRdN() {
        File ficRdN = Writer.verifFichier(FichierConstante.PREFIX_RDN + rdn.getHiddenLayers(), 0);
        
        try {
            FileOutputStream save = new FileOutputStream(ficRdN);
            ObjectOutputStream oos = new ObjectOutputStream(save);

            oos.writeObject(rdn);

            oos.flush();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
