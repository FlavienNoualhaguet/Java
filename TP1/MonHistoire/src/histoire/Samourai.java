/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package histoire;

/**
 *
 * @author flavien
 */
public class Samourai extends Ronin {
    
    private final String seigneur;

    public Samourai(String nom, String boisson, int argent, String seigneur) {
        super(nom, boisson, argent);
        this.seigneur = seigneur;
    }
    
    public void boire(String boisson) {
        String msg = String.format("Ahhh, un bon verre de %s ! GLOUPS !", boisson);
        this.parler(msg);
    }
    
    @Override
    public void direBonjour() {
        String msg = String.format("Ma boisson prefere est %s et j'ai %d euros. Mon seigneur est %s", this.getBoisson(), this.getArgent(), this.seigneur);
        this.parler(msg);
    }
    
    
}
