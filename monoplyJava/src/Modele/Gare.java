package Modele;

public class Gare extends Propriete {
	

        public Gare(int num, String nom, int p,int loyer){
            super(num, nom, p,loyer);
        
        }

//on soustrait le prix d'achat au cahs du joueur, ont ajoute la gare à sa collection et on le met en propriétaire de la gare. 
        @Override
	public void acheterPropriete(Joueur j) {
		j.perdreCash(this.getPrix());
                j.addGare(this);
                this.setProprietaire(j);
	}

// on retourne le nombre de gare possédés par le propriétaire *25 comme loyer.
    @Override
    public int calculLoyer(int valdés) {
        this.setLoyer(25*this.getProprietaire().getNbGares());
        return 25*this.getProprietaire().getNbGares();
    }
}