/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.sita.tp2.asteroide;

import fr.enac.sita.tp2.asteroide.console.ConsoleJavaBoy;
import fr.enac.sita.tp2.asteroide.jeu.IJoueur;
import java.lang.Math;

/**
 *
 * @author noualhfl
 */
public class PetitPrince implements ISujet, IJoueur {
    
    private String nom;
    private Integer argent;
    private ConsoleJavaBoy consoleJavaBoy;

    public PetitPrince(String nom) {
        this.nom = nom;
        this.argent = 100;
        this.consoleJavaBoy= new ConsoleJavaBoy(this);
    }
    
    
    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getArgent() {
        return this.argent;
    }

    @Override
    public void run() {
        String msg = String.format("Bonjour je m'appelle %s et j'ai %d euros !", this.getNom(), this.getArgent());
        this.consoleJavaBoy.parler(msg);
        this.consoleJavaBoy.seDirigerVers(0);
        
        int[][] V = this.consoleJavaBoy.regarder();
        

    }
    
    private int chercherLePlusProche(int[][] V) {
        double minactuel = 2*20;
        int cxy;
        double distance;
        int leplusproche;
        for (int x=0; x< V.length; x++) {
            for (int y=0; y< V[x].length; y++) {
                cxy = V[x][y];
                if (cxy != 0) {
                    distance = Math.sqrt(Math.pow(10-x, 2) + Math.pow(10-y, 2));
                    if (distance <minactuel) {
                        minactuel=distance;
                        leplusproche=cxy;
                    }
                }
                
            }
        }
        return leplusproche;  
    }
    
    public static void main(String[] args) {
        PetitPrince monPetitPrince = new PetitPrince("Chess.com");        
    }

    @Override
    public void gagner(int montant) {
        this.argent += montant;
    }

    @Override
    public void perdre(int montant) {
        this.argent -= montant;
    }
}
