package Util;

public class Utilitaire {
  
    private int valdes1 ;
    private int valdes2 ;
    
public int lancerdés(){
           
           //retourne un chiffre entre 0(je voudrais pas pouvoir faire 0 perso) et 6
            valdes1 = (int) (Math.random() * 6 )+1;           
            valdes2 = (int) (Math.random() * 6 )+1; 
            return valdes1 + valdes2;
                }


}
