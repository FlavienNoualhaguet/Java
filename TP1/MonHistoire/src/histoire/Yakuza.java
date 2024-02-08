/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package histoire;

/**
 *
 * @author flavien
 */
public class Yakuza extends Humain implements Mechant {

    private final String clan;
    private int reputation;
    
    public Yakuza(String nom, String boisson, int argent, String clan) {
        super(nom, boisson, argent);
        this.clan = clan;
        this.reputation = 0;
    }

    
    @Override
    public void direBonjour() {
        String msg = String.format("Mon clan est %s, ma boisson prefere est %s et j'ai %d euros.", this.clan, this.getBoisson(), this.getArgent());
        this.parler(msg);
    }
    
    @Override
    public void extorquer(Commercant c) {
        int argent = c.getArgent();
        this.gagnerArgent(argent);
        this.reputation++;
        c.seFaireExtorquer();
        
        String msg = String.format("Je viens d'extorquer %s, j'ai gagner %d euros (%d) et j'ai %d points de reputation", 
                                    c.getNom(), argent, this.getArgent(), this.reputation);
        this.parler(msg);
    }

    public String getClan() {
        return clan;
    }
    
    @Override
    public void gagnerDuel() {
        this.reputation++;
        String msg = String.format("J'ai gagne !");
        this.parler(msg);
        
    }

    @Override
    public void perdreDuel() {
        this.perdreArgent(this.getArgent());
        this.reputation--;
        
        String msg = String.format("J'ai perdu !");
        this.parler(msg);
    }

    @Override
    public int getReputation() {
        return this.reputation;
    }
}