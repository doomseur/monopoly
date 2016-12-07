package Modele;

import Util.Groupe;
import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private ArrayList<Gare> gares = new ArrayList<>();
	private Carreau positionCourante;
        private ArrayList<ProprieteAConstruire> proprietes = new ArrayList<>();
         private ArrayList<Compagnie> compagnies = new ArrayList<>();

    public ArrayList<ProprieteAConstruire> getProprietes() {
        return proprietes;
    }

    private void setProprietes(ArrayList<ProprieteAConstruire> proprietes) {
        this.proprietes = proprietes;
    }

    public ArrayList<Compagnie> getCompagnies() {
        return compagnies;
    }

    private void setCompagnies(ArrayList<Compagnie> compagnies) {
        this.compagnies = compagnies;
    }
         
    public Joueur(String nomJoueur, Carreau position) {
        this.setNomJoueur(nomJoueur);
        this.setPositionCourante(position);
       
    }

	public void perdreCash(int loyer) {
		this.setCash(this.getCash()-loyer);
	}

	public void recevoirCash(int loyer) {
		this.setCash(this.getCash()+loyer);
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
    public int getNbGares() {
            return this.getGares().size();
	}

	
	public void addGare(Gare g) {
		this.gares.add(g);
	}
        public void addPropriete (ProprieteAConstruire p) {
		this.proprietes.add(p);
	}
        public void addCompagnie(Compagnie c) {
		this.compagnies.add(c);
	}


public boolean AToutLeGroupe(Groupe grp){
 int var = grp.getNbproprietes();
 if(this.getProprietes().containsAll(grp.getProprietes())){
     return true;
 }
 else{
     return false;
 }
}
}