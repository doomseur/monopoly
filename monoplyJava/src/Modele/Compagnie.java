package Modele;

public class Compagnie extends Propriete{
    
        public Compagnie(int num, String nom,int prix,int loyer){
            super(num, nom,prix,loyer);
        
        }
     @Override 
    public int calculLoyer(int valdés){
        if (this.getProprietaire().getCompagnies().size()==2){
         return 10 *valdés;
     }
     else{
         return 4*valdés;
     }
    }
    @Override
    public void acheterPropriete(Joueur j) {
        j.perdreCash(this.getPrix());
        j.addCompagnie(this);
    }








}