package Modele;

import Util.Groupe;

public class ProprieteAConstruire extends Propriete{
    
    private Groupe group;
    public ProprieteAConstruire(int num, String nom, int prix,int loyernu, Groupe grp){
        super(num, nom,prix,loyernu);
        this.setGroup(grp);
        this.group.addPropriete(this);
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
                this.setProprietaire(j);
    }



    @Override
    public int calculLoyer(int valdés) {
       if(this.getProprietaire().AToutLeGroupe(this.getGroup())){
           
            return this.getLoyer() *2;
        }
        else{    
           
        return this.getLoyer() ;
        }
    }
    
    
    @Override
    public String getType() {
         return "PropiereAConstruire";
    }

   
}