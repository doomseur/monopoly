package Modele;

public class AutreCarreau extends Carreau{
    
        public AutreCarreau(int num, String nom){
            super(num, nom);
        
        }

    @Override
    public void Action(Joueur j,int valdé) {
       System.out.println("Vous êtes sur une case qui ne sert à rien, fin de votre tour, yep !");
    }
}