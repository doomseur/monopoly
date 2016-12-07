package Modele;

public class Gare extends Propriete {
	

        public Gare(int num, String nom, int p,int loyer){
            super(num, nom, p,loyer);
        
        }


        @Override
	public void acheterPropriete(Joueur j) {
		j.perdreCash(this.getPrix());
                j.addGare(this);
	}


    @Override
    public int calculLoyer(int valdés) {
        this.setLoyer(25*this.getProprietaire().getNbGares());
        return 25*this.getProprietaire().getNbGares();
    }
}