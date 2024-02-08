package histoire.humain;

public class Humain {

    private String nom;
    private String boisson;
    private int argent;

    public Humain (String nom, String boisson, int argent) {
        this.nom = nom;
        this.boisson = boisson;
        this.argent = argent;
    }

    public String getNom() {return this.nom;}
    public String getBoisson() {return this.boisson;}
    public int getArgent() {return this.argent;}


    public static void parler(string msg) {
        String txt = String.format("[%s]: %s", this.nom, msg);
        System.out.println(txt);
    }

    public direBonjour() {
        String msg = String.format("Ma boisson préféré est %s et j'ai %d euros.", this.boisson, this.argent);
        this.parler(msg);
    }

    public void boire() {
        this.parler(String.format("Ahhh, un bon verre de %s ! GLOUPS !", this.boisson));
    }

    public static void gagnerArgent(int a) {
        this.argent += a;
    } 

    public static void perdreArgent(int a) {
        this.argent -= a;
    } 
}