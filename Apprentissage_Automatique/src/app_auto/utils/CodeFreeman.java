package app_auto.utils;

/**
 *
 * @author Kevin
 */
public class CodeFreeman {
    private String Code;
    private final Erreurs err = new Erreurs();

    public String codeFreeman(int[][] matrice) throws Erreurs.MatriceVide, Erreurs.MatriceNull {
        if (matrice == null) {
            throw err.new MatriceNull();
        }
        
        String morgan = "";
        int vect = 2, vectSv;
        int i = 0, j = 0;
        int x0, y0;
        int x = 0, y = 0;
        
        while (j < matrice.length && matrice[j][i] == 0) {
            if (i == matrice[j].length) {
                ++j;
                i = 0;
            } else {
                ++i;
            }
        }
        
        if (matrice[j][i] == 1) {
            x0 = i;
            y0 = j;
        } else {
            throw err.new MatriceVide();
        }

        do {
            vectSv = (vect + 5) % 8;

            try {
                do {
                    do{
                        x = prochainX(vectSv);
                        y = prochainY(vectSv);
                        vectSv = (vectSv + 1) % 8;
                    }while((j + y) > matrice.length || (i + x) > matrice[j].length || (j + y) < 0 || (i + x) < 0);
                } while (matrice[j + y][i + x] != 1);

                i += x;
                j += y;
            } catch (Erreurs.VecteurFaux ex) {
            }

            if (vectSv == 0) {
                vectSv = 7;
            } else {
                --vectSv;
            }

            morgan += vectSv;
            vect = vectSv;
        } while (i != x0 || j != y0);

        return morgan;
    }

    public int prochainX(int vect) throws Erreurs.VecteurFaux {
        if(vect == 0 || vect == 4) {
            return 0;
        }
        else if(vect == 1 || vect == 2 || vect == 3) {
            return 1;
        }
        else if(vect == 5 || vect == 6 || vect == 7) {
            return -1;
        }
        
        throw err.new VecteurFaux();
    }
    
     public int prochainY(int vect) throws Erreurs.VecteurFaux {
        if(vect == 6 || vect == 2) {
            return 0;
        }
        else if(vect == 5 || vect == 4 || vect == 3) {
            return 1;
        }
        else if(vect == 0 || vect == 1 || vect == 7) {
            return -1;
        }
        
        throw err.new VecteurFaux();
    }   

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
}
