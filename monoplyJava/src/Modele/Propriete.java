/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author chevajer
 */
public abstract class Propriete extends Carreau{
    
    private Joueur proprietaire;
    private int prix;
    
    public Propriete(int num, String nom, int p){
        super(num, nom);
        this.setProprietaire(null);
        this.setPrix(p);
    }
    
    public Joueur getProprietaire() {
        return proprietaire;
    }

    private void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    protected abstract int calculLoyer();


    public void acheterPropriete(Joueur aJ) {
        aJ.subCash(this.getPrix());
        aJ.
    }

    public abstract void payerLoyer(Joueur aJAch, Joueur aJRec); 

    
    public int getPrix() {
    	return this.prix;
    }
	
    public void setPrix(int p) {
    	this.prix = p;
    }

    public int getLoyer(int aNb) {
	throw new UnsupportedOperationException();
    }
    
}
