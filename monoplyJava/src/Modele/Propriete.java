/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.Scanner;

/**
 *
 * @author chevajer
 */
public abstract class Propriete extends Carreau{
    
    private Joueur proprietaire;
    private int prix;
    private int loyer;

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }
    public Propriete(int num, String nom, int p,int l){
        super(num, nom);
        this.setProprietaire(null);
        this.setPrix(p);
        this.setLoyer(l);
    }
    
    public Joueur getProprietaire() {
        return proprietaire;
    }

    protected void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }


    public abstract void acheterPropriete(Joueur joueur);
    public void resetProprio(){
        this.setProprietaire(null);
    }
    public void payerLoyer(Joueur payeur, Joueur payé,int valdés){
        int var = this.calculLoyer(valdés);
        if(payeur.getCash()<var){
            var = payeur.getCash();
            System.out.println("Vous êtes PAUVRE, vous avez perdu par impossibilité de payer tout le loyer.");
        }
        else{         
        }
        payeur.perdreCash(var);
        payé.recevoirCash(var); 
    } 

    
    public int getPrix() {
    	return this.prix;
    }
	
    public void setPrix(int p) {
    	this.prix = p;
    }
    public abstract int calculLoyer(int valdés);
    public int getLoyer(){
        return loyer;
    }
   
    

    
}
