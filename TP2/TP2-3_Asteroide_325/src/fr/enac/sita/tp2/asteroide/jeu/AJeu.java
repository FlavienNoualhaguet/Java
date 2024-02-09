/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.sita.tp2.asteroide.jeu;

import java.util.Random;

/**
 *
 * @author noualhfl
 */
public abstract class AJeu implements IJeu {
    
    private String nom;
    private final Random random;

    public AJeu(String nom) {
        this.nom = nom;
        this.random = new Random();

    }

    public String getNom() {
        return nom;
    }

    public Random getRandom() {
        return random;
    }
    
    
    
}
