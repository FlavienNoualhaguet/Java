/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package histoire;

/**
 *
 * @author flavien
 */
public class Humain {

    private final String nom;
    private final String boisson;
    private int argent;

    public Humain (String nom, String boisson, int argent) {
        this.nom = nom;
        this.boisson = boisson;
        this.argent = argent;
    }

    public String getNom() {return this.nom;}
    public String getBoisson() {return this.boisson;}
    public int getArgent() {return this.argent;}


    public void parler(String msg) {
        String txt = String.format("[%s]: %s", this.nom, msg);
        System.out.println(txt);
    }

    public void direBonjour() {
        String msg = String.format("Ma boisson préféré est %s et j'ai %d euros.", this.boisson, this.argent);
        this.parler(msg);
    }

    public void boire() {
        this.parler(String.format("Ahhh, un bon verre de %s ! GLOUPS !", this.boisson));
    }

    public void gagnerArgent(int a) {
        this.argent += a;
    } 

    public void perdreArgent(int a) {
        this.argent -= a;
    } 
}