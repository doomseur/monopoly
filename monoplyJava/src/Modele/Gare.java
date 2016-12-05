package Modele;

public class Gare extends Propriete {
	
        
        public Gare(int num, String nom, int p){
            super(num, nom, p);
        
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
	