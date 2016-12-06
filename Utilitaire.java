package Util;

 import java.lang.Math; 

public class Utilitaire {
  
    private int valdes1 ;
    private int valdes2 ;
    
public int lancerdés(){
            int  i1 = valdes1;
            int  i2 = valdes2;
           //retourne un chiffre entre 0 et 6
            i1 = (int) (Math.random() * 7 );           
            i2 = (int) (Math.random() * 7 ); 
            return i1 + i2 ;
                }
}