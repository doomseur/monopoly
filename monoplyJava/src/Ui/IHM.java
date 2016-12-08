package Ui;

public class IHM {
    
        
        public IHM(){
            
        }
	

	public void message(int aType, String aNomProp, int aPrix) {
		throw new UnsupportedOperationException();
	}

	public void message(int aType, String aNomProp, int aLoyer, int aCash) {
		throw new UnsupportedOperationException();
	}
	/**
	*  // affiche 
	*/
	public void affiche() {
	
        for( int i = 0 ; i < controleur.getJoueurs().size(); i++ )  {  // doit afficher dans la console les stat de chaque joueur
            System.out.println(controleur.getJoueurs().get(i).getNomJoueur());
//bogue            System.out.println(controleur.getJoueurs().get(i).getNomJoueur()+" est en "+controleur.getJoueurs().get(i).getPositionCourante().getNom()); // retourne la position du joueur met bugue
            System.out.println(controleur.getJoueurs().get(i).getNomJoueur()+" a "+controleur.getJoueurs().get(i).getProprietes().size()+ "Propriete");
            System.out.println(controleur.getJoueurs().get(i).getNomJoueur()+" a "+controleur.getJoueurs().get(i).getCompagnies().size()+"compagnie " );
            System.out.println(controleur.getJoueurs().get(i).getNomJoueur()+" a "+ controleur.getJoueurs().get(i).getNbGares()+" Gare ");
            System.out.println(controleur.getJoueurs().get(i).getNomJoueur()+" a "+controleur.getJoueurs().get(i).getCash()+"€");
	}

	private void notifierObservateurs() {
		throw new UnsupportedOperationException();
	}
}
