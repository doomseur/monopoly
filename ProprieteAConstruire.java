package Modele;

import Util.CouleurPropriete;
import Util.Groupe;

public class ProprieteAConstruire extends Propriete{
    int loyer;
    Groupe group;
    public ProprieteAConstruire(int num, String nom, int prix,int loyernu, Groupe grp){
        super(num, nom,prix);
        this.setLoyer(loyernu);
        this.setGroup(grp);; 
    }

    private void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public Groupe getGroup() {
        return group;
    }

    private void setGroup(Groupe group) {
        this.group = group;
    }

    @Override
    public void acheterPropriete(Joueur j) {
        	j.perdreCash(this.getPrix());
                j.addPropriete(this);
    }

    @Override
    public int getLoyer() {
        if(this.getProprietaire().AToutLeGroupe(this.getGroup())){
            return loyer *2;
        }
        else{    
        return loyer ;
        }
    }
}