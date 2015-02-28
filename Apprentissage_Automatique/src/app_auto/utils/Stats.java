/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Kevin
 */
public class Stats {
    
    private int nbTests;
    private int nbBons;
    private int nbMauvais;
    private int[][] chiffreBonsMauvais;
    private HashMap<String, int[]> resultsAlgos;

    public Stats() {
        this.nbTests = 0;
        this.nbBons = 0;
        this.nbMauvais = 0;
        this.chiffreBonsMauvais = new int[10][2];
        this.resultsAlgos = new HashMap<>();
        int[] tabVide = {0,0};
        int i;
        
        for(i = 0; i < 10; ++i){
            chiffreBonsMauvais[i] = tabVide;
        }
        String[] algosLabels = AlgosConstantes.labels();
        
        for(i = 0; i < algosLabels.length; ++i){
            resultsAlgos.put(algosLabels[i], tabVide);
        }
    }
    
    public int getNbTests() {
        return nbTests;
    }

    public void setNbTests(int nbTests) {
        this.nbTests = nbTests;
    }

    public int getNbBons() {
        return nbBons;
    }

    public void setNbBons(int nbBons) {
        this.nbBons = nbBons;
    }

    public int getNbMauvais() {
        return nbMauvais;
    }

    public void setNbMauvais(int nbMauvais) {
        this.nbMauvais = nbMauvais;
    }

    public int[][] getChiffreBonsMauvais() {
        return chiffreBonsMauvais;
    }

    public void setChiffreBonsMauvais(int[][] chiffreBonsMauvais) {
        this.chiffreBonsMauvais = chiffreBonsMauvais;
    }

    public HashMap<String, int[]> getResultsAlgos() {
        return resultsAlgos;
    }

    public void setResultsAlgos(HashMap<String, int[]> resultsAlgos) {
        this.resultsAlgos = resultsAlgos;
    }
    
    public void addStat(int chiffre, int resultat, int algo){
        String label = AlgosConstantes.labelParNum(algo);
        int[] tmpLR = resultsAlgos.get(label);
        
        nbTests++;
        
        if (resultat == 0) {
            nbBons++;
            chiffreBonsMauvais[chiffre][0]++;
            tmpLR[0]++;
        } else {
            nbMauvais++;
            chiffreBonsMauvais[chiffre][1]++;
            tmpLR[1]++;
        }
        System.out.println("man" + resultsAlgos.get(AlgosConstantes.LABEL_MANH)[0] + " " + resultsAlgos.get(AlgosConstantes.LABEL_MANH)[1]);
        System.out.println("free" + resultsAlgos.get(AlgosConstantes.LABEL_FREE)[0] + " " + resultsAlgos.get(AlgosConstantes.LABEL_FREE)[1]);
        
        resultsAlgos.put(label, tmpLR);
        
    }
    
    @Override
    public String toString(){
        int i;
        String clef;
        Iterator it;
        Boolean hasNext;
        String chaine = nbTests + "#" + nbBons + "#" + nbMauvais + "@";
        
        for(i = 0; i < 9; ++i){
            chaine += i + "#" + chiffreBonsMauvais[i][0] + "#" + chiffreBonsMauvais[i][1] + "%";
        }
        chaine += i + "#" + chiffreBonsMauvais[i][0] + "#" + chiffreBonsMauvais[i][1] + "@";
        
        it = resultsAlgos.keySet().iterator();
        hasNext = it.hasNext();
        
        while(hasNext){
            clef = (String)it.next();
            int[] tmpR = resultsAlgos.get(clef);
            
            chaine += clef + "#" + tmpR[0] + "#" + tmpR[1];
            
            if(hasNext = it.hasNext()){
                chaine += "%";
            }
        }
        
        return chaine;
    }
}
