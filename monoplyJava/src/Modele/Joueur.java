package Modele;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private ArrayList<Gare> gares = new ArrayList<>();
	private Carreau positionCourante;

    public Joueur(String nomJoueur, Carreau position) {
        this.setNomJoueur(nomJoueur);
        this.setPositionCourante(position);
       
    }

	public void payerLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

	public void recevoirLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

    public String getNomJoueur() {
        return nomJoueur;
    }

    private void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public int getCash() {
        return cash;
    }

    private void setCash(int cash) {
        this.cash = cash;
    }

    public ArrayList<Gare> getGares() {
        return gares;
    }

    private void setGares(ArrayList<Gare> gares) {
        this.gares = gares;
    }

    public Carreau getPositionCourante() {
        return positionCourante;
    }

    private void setPositionCourante(Carreau positionCourante) {
        this.positionCourante = positionCourante;
    }

    public void setPositionCourantePublique(Carreau positionCourante){  //pour pouvoir recupéré le setteur qui est privé
        setPositionCourante(positionCourante);
    }
	

	

	public void devientProprietaire(Gare aGare) {
		throw new UnsupportedOperationException();
	}

	public int getNbGares() {
		throw new UnsupportedOperationException();
	}

	public void subCash(int aPrix) {
		throw new UnsupportedOperationException();
	}

	public void addGare(Gare aGare) {
		throw new UnsupportedOperationException();
	}
}