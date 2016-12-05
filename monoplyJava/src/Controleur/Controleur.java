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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Controleur {
    
        private IHM ihm;
        private HashMap<Integer,Carreau> cases;
        private  int nbjoueurs =0;
        private ArrayList<Joueur> joueurs = new ArrayList<>();
        public Controleur(IHM ihm){
            this.setIhm(ihm);
            this.cases = new HashMap<Integer,Carreau>();
            this.buildGamePlateau("src/Data/data.txt");
            for(int i : this.cases.keySet()){
                System.out.println("Num: "+ cases.get(i).getNumero() +" Nom: "+ cases.get(i).getNom());
            }
            
            boolean continuer = true;
            while(nbjoueurs <6 && continuer){
                System.out.println("Entrez le nom du joueur " + (nbjoueurs+1) +" :");
                Scanner sc = new Scanner(System.in);
                String name = sc.next();
                joueurs.add(new Joueur(name,cases.get(0)));
                nbjoueurs = nbjoueurs + 1;
                if(nbjoueurs <6){
                    System.out.println("Voulez vous inscrire un nouveau joueur ? (oui/non)");
                    String var = sc.next();
                        while(!var.equalsIgnoreCase("oui") && !var.equalsIgnoreCase("non")){
                            System.out.println("Saisie incorrecte, veuillez recommencer.");
                               var = sc.next();
                        }
                        if (nbjoueurs <2 && "non".equals(var)){
                            System.out.println("Pas assez de joueurs pour continuer.(2 minimum)");
                        }
                        else if (nbjoueurs >= 2 &&"non".equals(var)){
                            continuer = false;
                        }}}
            System.out.println("Les joueurs inscrits sont : ");
            for(int i =0; i< this.joueurs.size(); i++){
                System.out.println(joueurs.get(i).getNomJoueur());
                
             
            }
        }
	
/*
	private Carreau avancer(Joueur aJ, int aNb) {
		throw new UnsupportedOperationException();
	}
        
        
        public void miseAJour(){
            
        }

	

	public Joueur getJoueurCourant() {
		throw new UnsupportedOperationException();
	}

	public Carreau getCarreau(int aNouvNum) {
		throw new UnsupportedOperationException();
	}

	public int calculNouvPosition(int aNum, int aValDés) {
		throw new UnsupportedOperationException();
	}
        
        
    */    
        
        private void buildGamePlateau(String dataFilename)
	{
		try{
                        //lecture du fichier et stoquage ligne par ligne, coupés par les virgules
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
                                        this.getCases().put(Integer.parseInt(data.get(i)[1]),new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));     
				}
				else if(caseType.compareTo("G") == 0){
					this.getCases().put(Integer.parseInt(data.get(i)[1]),new Gare(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));
				}
				else if(caseType.compareTo("C") == 0){
					this.getCases().put(Integer.parseInt(data.get(i)[1]),new Compagnie(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));
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