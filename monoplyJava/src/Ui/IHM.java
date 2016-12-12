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
           System.out.println("Entrez les noms des joueurs un par ligne, saurer une ligne pour finir :");
           while(nbJoueurs <6 && continuer){
               
               choix = sc.nextLine();
               getNomJoueurs().add(choix);
               nbJoueurs++;
              
               if (choix.isEmpty()){
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
       
       
       
       public void messageDebutTour(int numJoueur, String nomJoueur, int argentJoueur, int valDés){
           System.out.println("Au tour du joueur " + numJoueur +": "+ nomJoueur );
           System.out.println("Vous avez " + argentJoueur +" euros");
           System.out.println("Vous avez fait " + valDés +" au dés");
       }
	

	public void messageAchat(String type, String nomProp, int prix) {
            System.out.println("Vous êtes sur la "+ type +""+ nomProp);
            System.out.println("Vous pouvez l'acheter. Le prix est de "
                + prix +" euros, voulez-vous l'acheter ?(oui/non)");
            Scanner sc = new Scanner(System.in);
            String choix = sc.next();
            while(!choix.equalsIgnoreCase("oui") && !choix.equalsIgnoreCase("non")){
                System.out.println("Saisie incorrecte, veuillez recommencer. (oui / non)");
                choix = sc.next();
            }
            if(choix.equalsIgnoreCase("oui")){
                System.out.println("Vous payez "+ prix +"euros pour l'acheter");
                setChanged();
                notifyObservers(Messages.ACHAT_CASE);
                clearChanged();
            }else{
                setChanged();
                notifyObservers(Messages.LANCER_DES);
                clearChanged();
            }
	}
        
        public void messagePauvre(String type, String nomProp, int prix) {
            System.out.println("Vous êtes sur la "+ type +""+ nomProp);
            System.out.println("Vous êtes PAUVRE, vous ne pouvez pas l'acheter.");
	}

	public void messageLoyer(String nomProp, int loyer) {
            System.out.println("Vous êtes sur " + nomProp);
            System.out.println("Vous devez payer le loyer qui est de "+ loyer +"euros");
	}
        
        public void messageCaseVide() {
            System.out.println("Vous êtes sur une case vide.... dommage");
            setChanged();
            notifyObservers(Messages.LANCER_DES);
            clearChanged();
	}

	public void message(int aType, String aNomProp) {
		throw new UnsupportedOperationException();
	}

	

   
    public ArrayList<String> getNomJoueurs() {
        return nomJoueurs;
    }

    
    private void setNomJoueurs(ArrayList<String> nomJoueurs) {
        this.nomJoueurs = nomJoueurs;
    }
}