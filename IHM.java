package Ui;

import Util.Messages;
import Util.Utilitaire;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class IHM extends Observable{
    
        private ArrayList<String> nomJoueurs;
        
        public IHM(){
            this.setNomJoueurs(new ArrayList<>());
        }
        
        public void message(String texte){
            System.out.println(texte);
        }
        
       public void afficheMenu(){
           
           System.out.println("+------------------------------+");
           System.out.println("|  1. Inscrire les joueurs     |");
           System.out.println("|  2. Commencer le jeu         |");
           System.out.println("|  3. Quitter                  |");
           System.out.println("+------------------------------+");
           System.out.println("");
           int choix = 0;
           System.out.println("Choisir une option:");
           Scanner sc = new Scanner(System.in);
           choix = sc.nextInt();
           while(choix!=1 && choix!=2 && choix!=3){
                System.out.println("Saisie incorrecte, veuillez recommencer. (1,2 ou 3)");
                choix = sc.nextInt();
           }
           System.out.println("");
            switch (choix) {
                case 1:
                    setChanged();
                    notifyObservers(Messages.INSCRIRE_JOUEURS);
                    clearChanged();
                    break;
                case 2:
                    setChanged();
                    notifyObservers(Messages.COMMENCER_JEU);
                    clearChanged();
                    break;
                default:
                    setChanged(); 
                    notifyObservers(Messages.QUITTER);
                    clearChanged();
                    break;
            }
           
       }
       
       
       public void inscriptionJoueurs(){

           int nbJoueurs = 0;
           boolean continuer = true;
           String choix ="";
           Scanner sc = new Scanner(System.in);
           while(nbJoueurs <6 && continuer){
               System.out.println("Entrez le nom du joueur " + (nbJoueurs+1) +" :");
               choix = sc.next();
               getNomJoueurs().add(choix);
               nbJoueurs++;
               System.out.println("Voulez vous inscrire un nouveau joueur ? (oui/non)");
               choix = sc.next();
               while(!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non")){
                    System.out.println("Saisie incorrecte, veuillez recommencer.(oui/non)");
                    choix = sc.next();
               }
               if (choix.equalsIgnoreCase("non")){
                   if(nbJoueurs >=2){
                       continuer = false;
                   }else{
                       System.out.println("Pas assez de joueurs pour continuer.(2 minimum)");
                   }
                            
               }
           }
           setChanged();
           notifyObservers(Messages.INSCRIRE_FIN);
           clearChanged();
       }
       
       
       
       public void jouerTour(){
           
       }
	

	public void message(int aType, String aNomProp, int aPrix) {
		throw new UnsupportedOperationException();
	}

	public void message(int aType, String aNomProp, int aLoyer, int aCash) {
		throw new UnsupportedOperationException();
	}

	public void message(int aType, String aNomProp) {
		throw new UnsupportedOperationException();
	}

	private void notifierObservateurs() {
		throw new UnsupportedOperationException();
	}

   
    public ArrayList<String> getNomJoueurs() {
        return nomJoueurs;
    }

    
    private void setNomJoueurs(ArrayList<String> nomJoueurs) {
        this.nomJoueurs = nomJoueurs;
    }
}