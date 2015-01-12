# TrouveCodeFreeman: c
```
    Entrée : A : Matrice n * m 
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
     
     
    prochainX(d) 
        si d = 0 OU d = 4 
            renvoyer 0
        sinon si d = 1 OU d = 2 OU d = 3
            renvoyer 1
        sinon si d = 5 OU d = 6 OU d = -1
            renvoyer -1
        sinon
           Erreur()
  ```
prochainY(d) même principe
