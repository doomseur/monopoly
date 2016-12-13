/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Ui.IHM;

/**
 *
 * @author bonnetfa
 */
public class Main2 {
    

    public static void main(String[] args) {
        
        IHM ihm = new IHM();
        
        Controleur2 controleur = new Controleur2(ihm);
        controleur.start();
    }
    
}
