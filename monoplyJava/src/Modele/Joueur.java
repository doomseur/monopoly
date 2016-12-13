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
         private int valDésOrdre;

    public Joueur(String nomJoueur, Carreau position, int valDés) {
        this.setNomJoueur(nomJoueur);
        this.setPositionCourante(position);
        this.setValDésOrdre(valDés);
    }
    // on enlève la somme indiquée par loyer au cash du joueur.
    public void perdreCash(int loyer) {
	this.setCash(this.getCash()-loyer);
    }
    // on ajoute la somme indiquée par loyer au cash du joueur.
    public void recevoirCash(int loyer) {
	this.setCash(this.getCash()+loyer);
    }     
         
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
    // on utilise cette méthode pour changer la position courante du joueur sans rendre public le setteur.
    public void Avancer(Carreau positionCourante){  
        this.setPositionCourante(positionCourante);        
    }
    public int getNbGares() {
        return this.getGares().size();
    }
    
    //on utilise un add différent pour chaque type de propriété afin de pouvoir plus facilement calculer les loyers de gares et compagnie.
    public void addGare(Gare g) {
	this.gares.add(g);
    }
    public void addPropriete (ProprieteAConstruire p) {
	this.proprietes.add(p);
    }
    public void addCompagnie(Compagnie c) {
	this.compagnies.add(c);
    }

// si le joueur possède toute les propriétés qui font partie du groupe grp, alors il renvoie vrai.
public boolean AToutLeGroupe(Groupe grp){
    return this.getProprietes().containsAll(grp.getProprietes());
    }

   
    public int getValDésOrdre() {
        return valDésOrdre;
    }

    
    public void setValDésOrdre(int ValDésOrdre) {
        this.valDésOrdre = ValDésOrdre;
    }
}