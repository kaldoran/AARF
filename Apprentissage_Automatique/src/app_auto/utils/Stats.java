/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

/**
 *
 * @author Kevin
 */
public class Stats {
    int nbTests;
    int nbBons;
    int nbMauvais;
    int[][] chiffreBonsMauvais;

    public Stats() {
        this.nbTests = 0;
        this.nbBons = 0;
        this.nbMauvais = 0;
        this.chiffreBonsMauvais = new int[10][2];
        
        for(int i = 0; i < 10; ++i){
            chiffreBonsMauvais[i][0] = 0;
            chiffreBonsMauvais[i][1] = 0;
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
    
    @Override
    public String toString(){
        String chaine = nbTests + "s" + nbBons + "s" + nbMauvais + "\n";
        
        for(int i = 0; i < 10; ++i){
            chaine += i + "s" + chiffreBonsMauvais[i][0] + "s" + chiffreBonsMauvais[i][1] + "\n";
        }
        
        return chaine;
    }
}
