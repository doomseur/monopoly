package Modele;

public abstract class Carreau {
    
    private int numero;
    private String nom;
        
    public Carreau(int num, String nom){
        this.setNumero(num);
        this.setNom(nom);
    }

    public int getNumero() {
        return this.numero;
    }

        
    public void setNumero(int numero) {
        this.numero = numero;
    }

   
    public String getNom() {
        return nom;
    }

    
    public void setNom(String nomCarreau) {
        this.nom = nomCarreau;
    }
}