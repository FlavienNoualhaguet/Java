/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package histoire;

/**
 *
 * @author flavien
 */
public class Traitre extends Samourai implements Mechant {
    
    public Traitre(String nom, String boisson, int argent, String seigneur) {
        super(nom, boisson, argent, seigneur);
    }

    
    @Override
    public void extorquer(Commercant c) {
        this.perdreHonneur();
    }

    @Override
    public void gagnerDuel() {
        this.gagnerHonneur();
        
        String msg = String.format("J'ai gagne mais je suis mechant !");
        this.parler(msg);
    }

    @Override
    public void perdreDuel() {
        this.perdreHonneur();
        
        String msg = String.format("J'ai perdu mais je suis mechant !");
        this.parler(msg);    }

    @Override
    public int getReputation() {
        return this.getHonneur();
    }
    
    
}
