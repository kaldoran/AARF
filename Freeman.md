TrouveCodeFreeman: c
    Entrée : A : Matrice n * m 
    (x0, y0) : point de départ
    ```
        d <- 2 // Direction par défaut
        i <- x0
        j <- y0
        Faire
            d <- (d+5) % 8 
            Faire 
                x <- prochainX(dcom)
                y <- prochainY(dcom)
    ```    
  ```      
    prochainX(d) 
        si d = 0 OU d = 4 
            renvoyer 0
        sinon si d = 1 OU d = 2 OU D = 3
            renvoyer 1
        sinon si d = 5 OU d = 6 OU d = -1
            renvoyer -1
        sinon
           Erreur()
  ```
prochainY(d) même principe
