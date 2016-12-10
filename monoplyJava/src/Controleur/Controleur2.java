
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
import java.util.HashSet;
import java.util.Observer;
import java.util.Scanner;

public class Controleur2 {
        private HashMap<CouleurPropriete,Groupe> groupes = new HashMap<>();
        private IHM ihm;
        private HashMap<Integer,Carreau> cases;
        private  int nbjoueurs =0;
        private ArrayList<Joueur> joueurs = new ArrayList<>();
        private ArrayList<Integer> casesTruquées = new ArrayList<>();
        
        public Controleur2(IHM ihm){
            this.setIhm(ihm);
            this.cases = new HashMap<Integer,Carreau>();
            this.buildGamePlateau("src/Data/data.txt");
            for(int i : this.cases.keySet()){
                System.out.println("Num: "+ cases.get(i).getNumero() +" Nom: "+ cases.get(i).getNom());
            }
         
                joueurs.add(new Joueur("J1",cases.get(1),(Utilitaire.lancerdés()+Utilitaire.lancerdés())));
                joueurs.add(new Joueur("J2",cases.get(1),(Utilitaire.lancerdés()+Utilitaire.lancerdés())));
                casesTruquées.add(2);
                casesTruquées.add(3);
                casesTruquées.add(2);
                casesTruquées.add(3);
                casesTruquées.add(0);
                casesTruquées.add(2);
                casesTruquées.add(0);
                casesTruquées.add(3);
                casesTruquées.add(0);
                casesTruquées.add(1);
                casesTruquées.add(0);
                casesTruquées.add(4);
                casesTruquées.add(0);
                casesTruquées.add(4);
                casesTruquées.add(0);
                casesTruquées.add(2);
                casesTruquées.add(0);
                casesTruquées.add(3);
                casesTruquées.add(0);
                casesTruquées.add(1);
                casesTruquées.add(0);
                casesTruquées.add(1);
                casesTruquées.add(0);
                casesTruquées.add(2);
                casesTruquées.add(0);
                casesTruquées.add(2);
                casesTruquées.add(0);
                casesTruquées.add(1);
                casesTruquées.add(0);
                casesTruquées.add(1);
                casesTruquées.add(0);
                casesTruquées.add(1);
                casesTruquées.add(0);
                casesTruquées.add(8);
                casesTruquées.add(0);
                casesTruquées.add(9);
                casesTruquées.add(0);
                casesTruquées.add(1);
                casesTruquées.add(0);
                casesTruquées.add(11);
                casesTruquées.add(0);
                casesTruquées.add(11);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(20);
                casesTruquées.add(20);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                casesTruquées.add(0);
                casesTruquées.add(40);
                jouerplsTour(joueurs);
        }
	
//    avancer(joueur courant , valdes)
        private void avancer(Joueur joueur, int valdés) {
		joueur.getPositionCourante().getNumero() ; // récupère le numéro du carreau ou est le joueur 
               int nouveauNum = calculNouvPosition(joueur.getPositionCourante().getNumero(), valdés) ;
                joueur.Avancer(cases.get(nouveauNum)) ;
                System.out.println(joueur.getNomJoueur() + " avance de " + valdés +" cases et arrive en " +cases.get(nouveauNum).getNom());
              
	}
        
        public void update(Observer o, Object arg){
            
        }
        
        
        
        //
        public void jouerplsTour(ArrayList<Joueur> joueurs){
        boolean finpartie =  false ;
            while (!finpartie) {  // tant que not jouer   
                for(int i =0; i< joueurs.size(); i++){ // boucle sur tout les joueurs
                    if(joueurs.size()>=2){     
                        System.out.println("C'est le tour de " + joueurs.get(i).getNomJoueur() +" il possède acutellement " + joueurs.get(i).getCash() +" euros !!!");
                        jouerTour(joueurs.get(i)); //le joueur courant joue son tour
                      if (joueurs.get(i).getCash()<=0){
                            for(int j =0;  j<joueurs.get(i).getGares().size(); j++){
                                joueurs.get(i).getGares().remove(j);
                                 joueurs.get(i).getGares().get(j).resetProprio();
                            }
                            for(int k =0;  k<joueurs.get(i).getCompagnies().size(); k++){
                                joueurs.get(i).getCompagnies().remove(k);
                                 joueurs.get(i).getCompagnies().get(k).resetProprio();
                            }
                            for(int l =0;  l<joueurs.get(i).getProprietes().size(); l++){
                                joueurs.get(i).getProprietes().remove(l);
                                 joueurs.get(i).getProprietes().get(l).resetProprio();
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
            int valdé = casesTruquées.get(0);
            casesTruquées.remove(0);
            int valdé2 = casesTruquées.get(0);
            casesTruquées.remove(0);
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
        


        
        //calculNouvPosition(numero de la case , valeurdes dés )
	public int calculNouvPosition(int position, int valDés) {
	//joueur passe un tour complet	
            if (position + valDés > 40) {
//          getJoueurCourant().setCash(getJoueurCourant().getCash()+200 ) : // prend le joueur courant et lui ajoute 200$ car il est passé par la case départ 
            int numerocase = position + valDés - 40 ;
            return numerocase ;
            }
            else {
            return position+  valDés ; //retourne la somme du numéro de la case + la valeur des dés
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
	

}
