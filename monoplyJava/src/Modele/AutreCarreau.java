package Modele;

public class AutreCarreau extends Carreau{
    
        public AutreCarreau(int num, String nom){
            super(num, nom);
        
        }

    @Override
    public String action(Joueur j,int valdé) {
       return "caseVide";
    }
    @Override
    public void actionAchat(Joueur j){
        
    }
    
}