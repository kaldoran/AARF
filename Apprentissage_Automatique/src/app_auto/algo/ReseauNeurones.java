/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.algo;

import app_auto.utils.AlgosConstantes;
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
import weka.classifiers.Evaluation;
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
    
    public static final MultilayerPerceptron initRdN(String hiddenLay){
        File ficRdN = new File(FichierConstante.PREFIX_RDN + hiddenLay);
        
        if(ficRdN.isFile()){
            return chargerRdN(ficRdN);
        }
        else{
            MultilayerPerceptron rdn = new MultilayerPerceptron();
            
            return rdn;
        }
    }

    public void training(int nbInput) {
        try {
            FileReader trainReader = new FileReader(Writer.verifFichier(FichierConstante.PREFIX_ARFF_TEST + nbInput + FichierConstante.ARFF, nbInput));
            Instances train = new Instances(trainReader);
            train.setClassIndex(train.numAttributes() - 1);

            FileReader validReader = new FileReader(Writer.verifFichier(FichierConstante.PREFIX_ARFF_VALID + nbInput + FichierConstante.ARFF, nbInput));
            Instances valid = new Instances(validReader);
            valid.setClassIndex(valid.numAttributes() - 1);
            
            System.out.println("Training avec option : " + AlgosConstantes.RDN_OPTIONS);

            rdn.setOptions(Utils.splitOptions(AlgosConstantes.RDN_OPTIONS));
            rdn.buildClassifier(train); 
            sauverRdN();
            
            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(rdn, valid);
            
            Writer.logTestRdn(eval.toSummaryString("Résultats pour les options :" + AlgosConstantes.RDN_OPTIONS, false));
            
            trainReader.close();
            validReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tester(int[][] matrice){
      
        
        
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
