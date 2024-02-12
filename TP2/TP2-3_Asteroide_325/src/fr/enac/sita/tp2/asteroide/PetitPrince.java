/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.sita.tp2.asteroide;

import fr.enac.sita.tp2.asteroide.console.ConsoleJavaBoy;
import fr.enac.sita.tp2.asteroide.jeu.IJoueur;
import fr.enac.sita.tp2.asteroide.jeu.AJeu;
import fr.enac.sita.tp2.asteroide.jeu.De;
import fr.enac.sita.tp2.asteroide.jeu.Shifumi;
import fr.enac.sita.tp2.asteroide.jeu.PileFace;
import java.lang.Math;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author noualhfl
 */
public class PetitPrince implements ISujet, IJoueur {
    
    private String nom;
    private Integer argent;
    private ConsoleJavaBoy consoleJavaBoy;
    private Random random;

    public PetitPrince(String nom) {
        this.nom = nom;
        this.argent = 100;
        this.consoleJavaBoy= new ConsoleJavaBoy(this);
        this.random = new Random();
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
        
        // Find matrix
        int[][] V = this.consoleJavaBoy.regarder();
        int[] XY = this.chercherLePlusProche(V);
        int x = XY[0], y = XY[1];
        
        List<AJeu> jeux = Arrays.asList(new De("De from "+ this.getNom()), 
                                        new Shifumi("Shifumi from " + this.getNom()),
                                        new PileFace("Coin game from " + this.getNom()));
        
        if (this.calculDistance(x, y) <= 1) {
            AJeu jeu = jeux.get(this.random.nextInt(jeux.size()));
            int gain = 10;
            Integer comparaison = jeu.arbitrer(jeu.jouerUnCoup(), jeu.jouerUnCoup());
            
            if (1 == comparaison) {
                this.gagner(gain);
                 msg = String.format("%s: J'ai gagne %d euros au jeu %s !!", this.getNom(), this.getArgent(), jeu.getNom());
            }
            
            else if (-1 == comparaison) {
                    this.perdre(gain);
                    msg = String.format("%s: J'ai perdu %d euros au jeu %s !!", this.getNom(), this.getArgent(), jeu.getNom());
            }
                else {
                    msg = String.format("%s: Match nul au jeu %s !!", this.getNom(), jeu.getNom());
                }
            this.consoleJavaBoy.parler(msg);
        }
    }
    
    private double calculDistance(int x, int y){
        return Math.sqrt(Math.pow(10-x, 2) + Math.pow(10-y, 2));
    }
    
    
    private int[] chercherLePlusProche(int[][] V) {
        double minactuel = Double.MAX_VALUE;
        int[] leplusproche = new int[]{-1, -1}; // Initialize with invalid coordinates

        for (int x = 0; x < V.length; x++) {
            for (int y = 0; y < V[x].length; y++) {
                int cxy = V[x][y];
                if (cxy != 0) {
                    double distance = this.calculDistance(x, y);
                    if (distance < minactuel) {
                        minactuel = distance;
                        leplusproche[0] = x;
                        leplusproche[1] = y;
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
