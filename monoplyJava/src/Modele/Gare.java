package Modele;

public class Gare extends Carreau {
	private Joueur proprietaire;
        
        public Gare(int num, String nom){
            super(num, nom);
        
        }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    private void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

	private int calculLoyer() {
		throw new UnsupportedOperationException();
	}


	public void acheterPropriete(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public void payerLoyer(Joueur aJAch, Joueur aJRec) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Donne le prix d'une gare
	 */
	public int getPrix() {
		throw new UnsupportedOperationException();
	}

	public int getLoyer(int aNb) {
		throw new UnsupportedOperationException();
	}
}
	