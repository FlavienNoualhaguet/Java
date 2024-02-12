/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.sita.tp2.asteroide.jeu;

/**
 *
 * @author noualhfl
 */
public class PileFace extends AJeu {
    
    public PileFace(String nom) {
        super(nom);
    }

    @Override
    public String jouerUnCoup() {
        // (0 for Pile, 1 for Face)
        int val = this.getRandom().nextInt(2);
        return (val == 0) ? "Pile" : "Face";
    }

    @Override
    public Integer arbitrer(String coup1, String coup2) {
        if (coup1.equals(coup2)) {
            return 0;
        } else if (coup1.equals("Pile")) {
            return -1; // Player 1 wins (assuming Pile is a winning move)
        } else {
            return 1; // Player 2 wins (assuming Face is a winning move)
        }
    }
      
}