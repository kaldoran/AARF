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
public class CodeFreeman {
    private String Code;
    private final Erreurs err = new Erreurs();

    public CodeFreeman(int[][] matrice) throws Erreurs.MatriceVide {
        int vect = 2;
        int i = 0,j = 0;
        int x = 0, y = 0;
        
        while(matrice[j][i] == 0){
            if(i == matrice[j].length){
                ++j;
            }
            else{
                ++i;
            }
        }
        if(matrice[j][i] == 1){
            x = i;
            y = j;
        }
        else{
            throw err.new MatriceVide();
        }
                
        
    }
    
    
    /*Entrée : A : Matrice n * m 
      (x0, y0) : point de départ
        d <- 2 
        i <- x0
        j <- y0
        Faire
            d <- (d+5) % 8 
            Faire 
                x <- prochainX(dcom)
                y <- prochainY(dcom)
                dcom <- (dcom + 1) % 6
            Tant que A[i+x][j+y] != 1
            i <- i + x
            j <- j + y
            si (dcom = 0)
                dcom <- 7
            sinon 
                dcom <- dcom - 1
            code <- code . dcom
            d <- dcom
        Tant que i != x0 et j != y0

    prochainX(d) 
        si d = 0 OU d = 4 
            renvoyer 0
        sinon si d = 1 OU d = 2 OU d = 3
            renvoyer 1
        sinon si d = 5 OU d = 6 OU d = -1
            renvoyer -1
        sinon
           Erreur()*/

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
}
