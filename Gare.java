package Modele;

public class Gare extends Propriete {
	

        public Gare(int num, String nom, int p){
            super(num, nom, p);
        
        }


        @Override
	public void acheterPropriete(Joueur j) {
		j.perdreCash(this.getPrix());
                j.addGare(this);
	}


        @Override
	public int getLoyer() {

            return 25*this.getProprietaire().getNbGares();
	}
}