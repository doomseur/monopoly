package Modele;

public class Compagnie extends Propriete{
    
        public Compagnie(int num, String nom,int prix,int loyer){
            super(num, nom,prix,loyer);
        
        }
     @Override 
    //en fonction de si le propriétaire a une ou deux compagnies, on retourne la valeur des dés *4 ou *10.
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
    //on soustrait le prix d'achat au cahs du joueur, ont ajoute la gare à sa collection et on le met en propriétaire de la compagnie. 
    @Override
    public void acheterPropriete(Joueur j) {
        j.perdreCash(this.getPrix());
        j.addCompagnie(this);
        this.setProprietaire(j);
    }


}