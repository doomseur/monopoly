
package Controleur;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Modele.Carreau;
import Modele.Joueur;
import Modele.ProprieteAConstruire;
import Modele.Gare;
import Modele.Compagnie;
import Modele.AutreCarreau;
import Ui.IHM;
import Util.CouleurPropriete;
import Util.Groupe;
import Util.Utilitaire;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import Util.Messages;
import static javafx.application.Platform.exit;

public class Controleur implements Observer{
    
        private HashMap<CouleurPropriete,Groupe> groupes = new HashMap<>();
        private IHM ihm;
        private HashMap<Integer,Carreau> cases;
        private ArrayList<Joueur> joueurs = new ArrayList<>();
        private int joueurActif;
        
        public Controleur(IHM ihm){
            
            this.setIhm(ihm);
            this.getIhm().addObserver(this);
            this.setCases(new HashMap<Integer,Carreau>());
            this.buildGamePlateau("src/Data/data.txt");
            this.setJoueurActif(1);
        }
        
        
        public void start(){
            this.ihm.afficheMenu();
        }
        
        
        
        
    @Override
    public void update(Observable o, Object arg){
       
        if(arg==Messages.INSCRIRE_JOUEURS){
            this.ihm.inscriptionJoueurs();
            
        }else if(arg==Messages.INSCRIRE_FIN){
            ArrayList<String> nomJoueurs = this.ihm.getNomJoueurs();
            for(int i=0; i<nomJoueurs.size(); i++){
                this.joueurs.add(new Joueur(nomJoueurs.get(i),this.cases.get(1),(Utilitaire.lancerdés()+Utilitaire.lancerdés())));
            }
            this.ihm.afficheMenu();
            
        }else if(arg==Messages.COMMENCER_JEU){
            //on vérifi si il y as de joueurs
            if(this.joueurs.size()!=0){
                //vecteur de joueur temporaire
                ArrayList<Joueur> joueursTemp = new ArrayList<>();
                //on réordonne les joueurs en fonction de leur scores au dés    
                for(int i=12; i>=2; i--){
                    for(int j =0; j< this.joueurs.size(); j++){
                        if(this.joueurs.get(j).getValDésOrdre()==i){
                            joueursTemp.add(this.joueurs.get(j));
                        }
                    }
                }
                this.joueurs = joueursTemp;
                
                
                //this.ihm.messageDebutTour(joueurActif, joueurActif, joueurActif);
            }else{
                this.ihm.message("Veillez inscrire des joueurs pour pouvoir jouer");
                this.ihm.message("");
                this.ihm.afficheMenu();
            }
            
        }else if(arg==Messages.LANCER_DES){
             setJoueurActif(getJoueurActif() + 1);
             if(this.getJoueurActif()>joueurs.size()){
                this.setJoueurActif(this.getJoueurActif() - joueurs.size());
             }
             
             int valDés= Util.Utilitaire.lancerdés();
             Joueur jCourant = joueurs.get(getJoueurActif());
             this.avancer(jCourant, valDés);
             this.ihm.messageDebutTour(this.getJoueurActif(), jCourant.getNomJoueur(), jCourant.getCash(), valDés);
             Carreau caseCourant = jCourant.getPositionCourante();
             String type = caseCourant.getType();
             if(type=="AutreCarreau"){
                 this.ihm.messageCaseVide();
             }else{
                 if(caseCourant.get){
                     
                 }
             }
            
        }else if(arg==Messages.QUITTER){
            exit();
        }
        
        
    }
    
    
    
    
    private void avancer(Joueur joueur, int valdés) { 
            int nouveauNum = calculNouvPosition(joueur.getPositionCourante().getNumero(), valdés) ;
            joueur.Avancer(cases.get(nouveauNum));     
	}
    
    

	public int calculNouvPosition(int position, int valDés) {
            int nouvPosition = position + valDés;
            
            if(nouvPosition > 40){
                nouvPosition = nouvPosition -40;
            }
            
            return nouvPosition;
        }
        
        
        
        //
        public void jouerPlsTour(ArrayList<Joueur> joueurs){
        boolean finpartie =  false ;
            while (!finpartie) {  // tant que not jouer   
                for(int i =0; i< joueurs.size(); i++){ // boucle sur tout les joueurs
                    if(joueurs.size()>=2){     
                        //this.ihm.message("C'est le tour du joueur" + +" il gagne "++" euros");
                        jouerTour(joueurs.get(i)); //le joueur courant joue son tour
                        if (joueurs.get(i).getCash()<=0){
                            for(int j =0;  j<joueurs.get(i).getGares().size(); j++){
                                
                                 joueurs.get(i).getGares().get(j).resetProprio();
                                 joueurs.get(i).getGares().remove(j);
                            }
                            for(int k =0;  k<joueurs.get(i).getCompagnies().size(); k++){
                                
                                 joueurs.get(i).getCompagnies().get(k).resetProprio();
                                 joueurs.get(i).getCompagnies().remove(k);
                            }
                            for(int l =0;  l<joueurs.get(i).getProprietes().size(); l++){
                                
                                joueurs.get(i).getProprietes().get(l).resetProprio();
                                joueurs.get(i).getProprietes().remove(l);
                            }
                            joueurs.remove(i); //enleve le joueur de la collection 
                        }    
                    Scanner sc = new Scanner(System.in);
                    sc.next();
                    }
                    else{ 
                        finpartie= true ; 
                        System.out.println("Partie terminée, le vainqueur est : " +joueurs.get(0).getNomJoueur() + "!!!!!!!!!!!!!!!!");
                    }    // sort de la boucle while    
                }
            }   
        }
        
              
        public void jouerTour(Joueur joueur){
            boolean rdouble = true;
            while (rdouble ==true){
            int valdé = Utilitaire.lancerdés() ;
            int valdé2 = Utilitaire.lancerdés() ;
            if(valdé==valdé2){
                rdouble =true;
                 System.out.println("Vous avez fait un double, vous aurez le droit de rejouer !");
            }
            else{
                rdouble = false;
            }
            int vardés =valdé +valdé2;
              this.avancer(joueur, vardés);
               Carreau carreauJoueur = joueur.getPositionCourante();
               carreauJoueur.Action(joueur,vardés) ; //l'action fera passé au tour suivant 
            }
}


        

	
        
        
    
        
        private void buildGamePlateau(String dataFilename)
	{
		try{
                        //lecture du fichier et stoquage ligne par ligne, coupés par les virgules
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
                        
			groupes.put(CouleurPropriete.bleuFonce,new Groupe(CouleurPropriete.bleuFonce));
			groupes.put(CouleurPropriete.orange, new Groupe(CouleurPropriete.orange));
                        groupes.put(CouleurPropriete.mauve,new Groupe(CouleurPropriete.mauve));
                        groupes.put(CouleurPropriete.violet,new Groupe(CouleurPropriete.violet));
                        groupes.put(CouleurPropriete.bleuCiel,new Groupe(CouleurPropriete.bleuCiel));
                        groupes.put(CouleurPropriete.jaune,new Groupe(CouleurPropriete.jaune));
                        groupes.put(CouleurPropriete.vert,new Groupe(CouleurPropriete.vert));
                        groupes.put(CouleurPropriete.rouge,new Groupe(CouleurPropriete.rouge));
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
                                        this.getCases().put(Integer.parseInt(data.get(i)[1]),new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5]),groupes.get(CouleurPropriete.valueOf(data.get(i)[3]))));     
				}
				else if(caseType.compareTo("G") == 0){
					this.getCases().put(Integer.parseInt(data.get(i)[1]),new Gare(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]),25));
				}
				else if(caseType.compareTo("C") == 0){
					this.getCases().put(Integer.parseInt(data.get(i)[1]),new Compagnie(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]),0));
				}
				else if(caseType.compareTo("AU") == 0){
					this.getCases().put(Integer.parseInt(data.get(i)[1]),new AutreCarreau(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));
				}
				else
                                System.err.println("[buildGamePleateau()] : Invalid Data type");
                        }
                        } 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
        
        
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}

    
    public IHM getIhm() {
        return ihm;
    }

    
    public void setIhm(IHM ihm) {
        this.ihm = ihm;
    }

    
    public HashMap<Integer,Carreau> getCases() {
        return cases;
    }

    
    public void setCases(HashMap<Integer,Carreau> cases) {
        this.cases = cases;
    }

  
    public int getJoueurActif() {
        return joueurActif;
    }

    
    public void setJoueurActif(int joueurActif) {
        this.joueurActif = joueurActif;
    }
	

}
