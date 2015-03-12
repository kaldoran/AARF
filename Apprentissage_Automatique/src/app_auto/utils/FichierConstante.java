    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.io.File;

/**
 *
 * @author kaldoran
 */
public class FichierConstante {
    public final static String REPERTOIRE_APPRENTISSAGE = System.getProperties().getProperty("user.dir") + File.separator + "Base_Apprentissage" + File.separator;
    
    public final static String FICHIER_BASE = REPERTOIRE_APPRENTISSAGE + "Base";
    
    public final static String FICHIER_STATS = REPERTOIRE_APPRENTISSAGE + "Stats";
    
    public final static String FICHIER_ARFF_TRAIN = REPERTOIRE_APPRENTISSAGE + "Base_train_RdN_" + AlgosConstantes.NB_ENTREE + ".arff";
    public final static String FICHIER_ARFF_VALID = REPERTOIRE_APPRENTISSAGE + "Base_valid_RdN_" + AlgosConstantes.NB_ENTREE + ".arff";
    
    public final static String SAVE_RDN = REPERTOIRE_APPRENTISSAGE + "Objet_RdN_" + AlgosConstantes.NB_ENTREE;
    
    public final static String FICHIER_LOG_RDN = REPERTOIRE_APPRENTISSAGE + "Log_tests_RdN";
}