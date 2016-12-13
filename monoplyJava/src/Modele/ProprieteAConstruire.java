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
    //on soustrait le prix d'achat au cahs du joueur, ont ajoute la gare à sa collection et on le met en propriétaire de la proprieté. 
    @Override
    public void acheterPropriete(Joueur j) {
        	j.perdreCash(this.getPrix());
                j.addPropriete(this);
                this.setProprietaire(j);
    }

    // si le propriétaire a toutes les propriétés du groupe de cette propriété, on double le loyer.
    @Override
    public int calculLoyer(int valdés) {
       if(this.getProprietaire().AToutLeGroupe(this.getGroup())){
           
            return this.getLoyer() *2;
        }
        else{    
           
        return this.getLoyer() ;
        }
    }

   
}