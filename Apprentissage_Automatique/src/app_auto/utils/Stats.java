/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Kevin
 */
public class Stats {
    int nbTests;
    int nbBons;
    int nbMauvais;
    int[][] chiffreBonsMauvais;

    public Stats(int nbTests, int nbBons, int nbMauvais, int[][] chiffreBonsMauvais) {
        this.nbTests = nbTests;
        this.nbBons = nbBons;
        this.nbMauvais = nbMauvais;
        this.chiffreBonsMauvais = chiffreBonsMauvais;
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
    
    @Override
    public String toString(){
        String chaine = nbTests + "|" + nbBons + "|" + nbMauvais + "\n";
        
        for(int i = 0; i < 10; ++i){
            chaine += i + "|" + chiffreBonsMauvais[i][0] + "|" + chiffreBonsMauvais[i][1] + "\n";
        }
        
        return chaine;
    }
}
