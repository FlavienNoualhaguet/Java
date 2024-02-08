/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package histoire;

/**
 *
 * @author flavien
 */
public class Ronin extends Humain {
    
    private int honneur;

    public Ronin(String nom, String boisson, int argent) {
        super(nom, boisson, argent);
        this.honneur = 1;
    }

    public int getHonneur() {
        return honneur;
    }
    
    public void donner(Commercant c, int montant) {
        c.gagnerArgent(montant);
        this.perdreArgent(montant);
    }
    
    public void provoquerDuel(Mechant y) {
        if (2*this.getHonneur() > y.getReputation()) {
            int argent = y.getArgent();
            this.gagnerArgent(argent);
            this.gagnerHonneur();
            
            y.perdreDuel();
            
            String msg = String.format("J'ai gagne mon duel (%d honneur), et j'ai gagner %d euros (%d) euros", this.honneur, argent, this.getArgent());
            this.parler(msg);
        }
        
        else {
            this.perdreHonneur();
            
            y.gagnerDuel();
            
            String msg = String.format("J'ai perdu mon duel (%d honneur)", this.honneur);
            this.parler(msg);  
        }
    }
    
    public void gagnerHonneur() {
        this.honneur++;
    }
    
    public void perdreHonneur() {
        this.honneur--;
    }
}
