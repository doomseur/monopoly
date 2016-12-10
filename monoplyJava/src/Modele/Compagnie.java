package Modele;

public class Compagnie extends Propriete{
    
        public Compagnie(int num, String nom,int prix,int loyer){
            super(num, nom,prix,loyer);
        
        }
     @Override 
    public int calculLoyer(int valdés){
        if (this.getProprietaire().getCompagnies().size()==2){
           
         this.setLoyer(10 *valdés);
         return 10 *valdés;
     }
     else{
         this.setLoyer(4 *valdés);
         return 4*valdés;
     }
    }
    @Override
    public void acheterPropriete(Joueur j) {
        j.perdreCash(this.getPrix());
        j.addCompagnie(this);
        this.setProprietaire(j);
    }


}