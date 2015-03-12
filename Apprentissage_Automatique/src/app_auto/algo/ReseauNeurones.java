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
        rdn = initRdN();
    }
    
    public static final MultilayerPerceptron initRdN(){
        File ficRdN = new File(FichierConstante.SAVE_RDN);
        System.out.println("Initialisation Reseau de Neurones.");
        
        if(ficRdN.isFile()){
            return chargerRdN(ficRdN);
        }
        else{
            System.out.println("Nouveau Reseau.");
            MultilayerPerceptron rdn = new MultilayerPerceptron();
            
            return rdn;
        }
    }

    public void training() {
        try {
            FileReader trainReader = new FileReader(Writer.verifFichier(FichierConstante.FICHIER_ARFF_TRAIN));
            Instances train = new Instances(trainReader);
            train.setClassIndex(train.numAttributes() - 1);
            
            System.out.println("Training avec option : " + AlgosConstantes.RDN_OPTIONS);

            rdn.setOptions(Utils.splitOptions(AlgosConstantes.RDN_OPTIONS));
            rdn.buildClassifier(train);
            
            sauverRdN();
            
            trainReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int tester() {
        try {
            FileReader validReader = new FileReader(Writer.verifFichier(FichierConstante.FICHIER_ARFF_VALID));
            Instances valid = new Instances(validReader);
            valid.setClassIndex(valid.numAttributes() - 1);

            validReader.close();

            return (int)Math.round(rdn.classifyInstance(valid.lastInstance()));
        } catch (Exception ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    private static MultilayerPerceptron chargerRdN(File ficRdN) {
        if (ficRdN.isFile()) {
            try {
                FileInputStream save = new FileInputStream(ficRdN);
                ObjectInputStream ois = new ObjectInputStream(save);
                
                System.out.println("Chargement Reseau de Neurones.");
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
        File ficRdN = Writer.verifFichier(FichierConstante.SAVE_RDN);
        
        try {
            FileOutputStream save = new FileOutputStream(ficRdN);
            ObjectOutputStream oos = new ObjectOutputStream(save);
            
            System.out.println("Sauvegarde Reseau de Neurones.");
            oos.writeObject(rdn);

            oos.flush();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(ReseauNeurones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
