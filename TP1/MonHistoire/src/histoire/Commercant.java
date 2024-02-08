/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package histoire;

/**
 *
 * @author flavien
 */
public class Commercant extends Humain {

    public Commercant(String nom, int argent) {
        super(nom, "The", argent);
    }
    
    public void seFaireExtorquer() {
        int a = this.getArgent();
        this.perdreArgent(a);
        
        String msg = String.format("Le monde est injuste !");
        this.parler(msg);
    }
    
    public void faireDesAffaires(Humain h, int montant) {
        h.perdreArgent(montant);
        this.gagnerArgent(montant);
        
        String msg = String.format("Merci a l'humain %s pour les affaires !", h.getNom());
        this.parler(msg);
    }
    
    
}
