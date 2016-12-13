package Ui;

import Util.Messages;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class IHM extends Observable{
    
        private ArrayList<String> nomJoueurs;
        private int numJoueur;
        private int numCase;
        public IHM(){
            this.setNomJoueurs(new ArrayList<>());
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
           System.out.println("Entrez les noms des joueurs un par ligne, sautez une ligne pour finir. (2 houeurs minimum)");
           while(nbJoueurs <6 && continuer){
               
               choix = sc.nextLine();
              if (!choix.isEmpty()){ 
               getNomJoueurs().add(choix);
               nbJoueurs++;}
              
              else if (choix.isEmpty()){
                    if(nbJoueurs >=2){
                        continuer = false;
                    }
                    else{
                        System.out.println("Pas assez de joueurs pour continuer.(2 minimum)");
                    }                            
                }
           }
           setChanged();
           notifyObservers(Messages.INSCRIRE_FIN);
           clearChanged();
}
        public void message(String texte){
            System.out.println(texte);
        }
        public void messageInscription(){
            System.out.println("Veillez inscrire des joueurs pour pouvoir jouer");
        }
        public void messageAvancer(String nomJoueur, int valdés, String nomCase){
        System.out.println(nomJoueur + " avance de " + valdés +" cases et arrive en " + nomCase + " .");}
        public void messageDefaite(){
            System.out.println("Vous êtes ne pouvez pas payer ce loyer, vous avez perdu.");
        }
       
       public void messageDebutTour(String nomJoueur, int cash,String collec){
           System.out.println("C'est le tour de " + nomJoueur +", il possède acutellement " + cash +" euros, ainsi que le patrimoine suivant : "+ collec);
           System.out.println("");
       }
       
       public void messageVictoire(String vainqueur){
           System.out.println("Partie terminée, le vainqueur est : " +vainqueur + "!");
           
       }
       public void messageDouble(){
           System.out.println("Vous avez fait un double, vous aurez le droit de rejouer !");
 
       }
       public void messagePosition(String position){
           System.out.println("Vous êtes sur " + position);
           
       }
       public void messageCase(String action,int i, int numcase){
           if (action.equals("pauvre")){
               System.out.println("Vous ne pouvez pas acheter ceci car vous n'avez pas assez d'argent.");
           }
           else if(action.equals("caseVide")){
               System.out.println("Cette case est vide, vous ne pouvez rien faire.");
           }
           else if(action.equals("proprietaire")){
               System.out.println("Vous êtes propriétaire de cette case, bienvenue chez vous !");
           }
           else if(action.equals("loyer")){
           System.out.println("Cette case est possédée par un autre joueur, vous aller devoir payer le loyer.");
           }
           else if(action.equals("achat")){
               System.out.println("Vous pouvez acheter ceci. Voulez-vous l'acheter ?(oui/non)");
               Scanner sc = new Scanner(System.in);
                    String var = sc.next();
                        while(!var.equalsIgnoreCase("oui") && !var.equalsIgnoreCase("non")){
                            System.out.println("Saisie incorrecte, veuillez recommencer.");
                               var = sc.next();
                        }
                        if ("non".equals(var)){
                            System.out.println(" L'achat n'a pas été effectué.");
                        }
                        else if ("oui".equals(var)){  
                        this.setNumeroJoueur(i);
                        this.setNumeroCase(numcase);
                        setChanged(); 
                        notifyObservers(Messages.ACHETER);
                        clearChanged();
                            System.out.println("Paiement effectué, vous êtes désormais propriétaire de cette propriété !");
                        }
           }
           else {
               System.out.println("erreur.");
           }
       }

   
    public ArrayList<String> getNomJoueurs() {
        return nomJoueurs;
    }

    
    private void setNomJoueurs(ArrayList<String> nomJoueurs) {
        this.nomJoueurs = nomJoueurs;
    }
    
    public int getNumJoueur(){
        return numJoueur;
    }
    private void setNumeroJoueur(int numj) {
        this.numJoueur = numj;
    }
    public int getNumCase(){
        return numCase;
    }
    private void setNumeroCase(int numc) {
        this.numCase = numc;
    }
}

