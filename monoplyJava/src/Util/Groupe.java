
package Util;

import Modele.Propriete;
import java.util.ArrayList;

public class Groupe {
	private CouleurPropriete couleur;
        private ArrayList<Propriete> proprietes = new ArrayList<>();

    public ArrayList<Propriete> getProprietes() {
        return proprietes;
    }

    public void setProprietes(ArrayList<Propriete> proprietes) {
        this.proprietes = proprietes;
    }
    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }

    public Groupe(CouleurPropriete couleur) {
        this.couleur = couleur;
    }
    public void addPropriete(Propriete p){
    this.proprietes.add(p);
}
    public int getNbproprietes(){
        return this.proprietes.size();
    }
}