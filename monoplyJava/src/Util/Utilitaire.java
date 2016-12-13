package Util;

public class Utilitaire {
  

//on prend une valeur aléatoire entre 0 et 1, qu'on multiplie par 6, qu'on arrondit à l'entier inférieur pour obtenir le résultat du dé.
public static int lancerdés(){
           
           //retourne un chiffre entre 0(je voudrais pas pouvoir faire 0 perso) et 6
           int  valde = (int) (Math.random() * 6 )+1;           

            return valde;
                }


}