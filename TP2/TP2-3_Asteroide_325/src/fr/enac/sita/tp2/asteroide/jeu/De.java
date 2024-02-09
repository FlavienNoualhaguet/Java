/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.sita.tp2.asteroide.jeu;

/**
 *
 * @author noualhfl
 */
public class De extends AJeu {
    
    public De(String nom) {
        super(nom);
    }

    @Override
    public String jouerUnCoup() {
        int val = this.getRandom().nextInt(6) + 1;
        return String.valueOf(val);
    }

    @Override
    public Integer arbitrer(String coup1, String coup2) {
        return coup1.compareTo(coup2);
    }
      
}
