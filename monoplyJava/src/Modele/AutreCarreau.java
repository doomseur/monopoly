package Modele;

public class AutreCarreau extends Carreau{
    
        public AutreCarreau(int num, String nom){
            super(num, nom);
        
        }

    @Override
    public String getType() {
         return "AutreCarreau";
    }
}