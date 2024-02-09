/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.sita.tp2.asteroide.jeu;

/**
 *
 * @author noualhfl
 */
public class Shifumi extends AJeu {
    private enum FiguresShifumi {
        FEUILLE,
        CISEAUX,
        PIERRE;
    }
    
    public Shifumi(String nom) {
        super(nom);
    }

    @Override
    public String jouerUnCoup() {
        int val = this.getRandom().nextInt(2);
        return FiguresShifumi.values()[val].name();
    }

    @Override
    public Integer arbitrer(String coup1, String coup2) {
        if (coup1.equals(coup2)) {
            return 0;
        }
        else if (coup1.equals("PIERRE") && coup2.equals("CISEAUX") 
                || coup1.equals("CISEAUX") && coup2.equals("FEUILLE")
                || coup1.equals("FEUILLE") && coup2.equals("PIERRE")) {
            return 1;
            }
            else {
                return -1;
            } 
    }
    
    
}
