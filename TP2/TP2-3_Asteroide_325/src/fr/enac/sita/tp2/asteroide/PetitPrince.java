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

    private class Tuple {
        private final int  x;
        private final int y;
        private final double distance;
        private final int sujet;

        public Tuple(int x, int y, double distance, int sujet) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.sujet = sujet;
        } 

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public double getDistance() {
            return distance;
        }

        public int getSujet() {
            return sujet;
        }
    }
    
    public PetitPrince(String nom) {
        this.nom = nom;
        this.argent = 1000;
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
       // String msg = String.format("Bonjour je m'appelle %s et j'ai %d euros !", this.getNom(), this.getArgent());
       // this.consoleJavaBoy.parler(msg);     
        // Find matrix
        int[][] V = this.consoleJavaBoy.regarder();
        Tuple adversaire = this.chercherLePlusProche(V);
        
        List<AJeu> jeux = Arrays.asList(new De("De from "+ this.getNom()), 
                                        new Shifumi("Shifumi from " + this.getNom()),
                                        new PileFace("Coin game from " + this.getNom()));
        
       if (adversaire.getSujet() == -1) {
            this.consoleJavaBoy.seDirigerVers(0);
       }
       else if (adversaire.getDistance()<= 1) {
                AJeu jeu = jeux.get(this.random.nextInt(jeux.size()));
                this.consoleJavaBoy.jouer(jeu, adversaire.getSujet());
            }
            else {
                this.consoleJavaBoy.seDirigerVers(adversaire.getSujet());
            }
    }
    
    private double calculDistance(int x, int y){
        return Math.sqrt(Math.pow(10-x, 2) + Math.pow(10-y, 2));
    }
    
    
    private Tuple chercherLePlusProche(int[][] V) {
        double minactuel = Double.MAX_VALUE;
        int X=-1;
        int Y=-1;
        int sujet=-1;
        int cxy;
        for (int x = 0; x < V.length; x++) {
            for (int y = 0; y < V[x].length; y++) {
                cxy = V[x][y];
                if (cxy != 0) {
                    double distance = this.calculDistance(x, y);
                    if (distance < minactuel) {
                        minactuel = distance;
                        X = x;
                        Y = y;
                        sujet=cxy;
                    }
                }
            }
        }
        Tuple tuple = new Tuple(X, Y, minactuel, sujet);
        return tuple;
    }
    
    public static void main(String[] args) {
        PetitPrince monPetitPrince = new PetitPrince("PPO");        
    }

    @Override
    public void gagner(int montant) {
        this.consoleJavaBoy.parler(this.getNom()+" : J'ai gagne ;)");
        this.argent += montant;
    }

    @Override
    public void perdre(int montant) {
        this.consoleJavaBoy.parler(this.getNom()+" : J'ai perdu !!!! :(");
        this.argent -= montant;
    }
}
