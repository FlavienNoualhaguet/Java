package fr.enac.sita.tp3.cercle;

import java.awt.Color;

/**
 * Point modelise un point geometrique dans un plan equipe d'un repere
 * cartesien. Un point peut etre affiche et translate. Sa distance par rapport a
 * un autre point peut etre obtenue. Le point peut etre dessine sur un
 * afficheur.
 * @author Xavier Cregut
 * @author Sebastien Leriche
 * @version 2016.03.01
 */
public class Point {

    private double x; // abscisse
    private double y; // ordonnee
    private Color couleur; // couleur du point

    /**
     * Construire un point a partir de son abscisse et de son ordonnee.
     * @param vx abscisse
     * @param vy ordonnee
     */
    public Point(double vx, double vy) {
        this.x = vx;
        this.y = vy;
        this.couleur = Color.green;
    }

    /**
     * Obtenir l'abscisse du point.
     * @return abscisse du point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Obtenir l'ordonnee du point.
     * @return ordonnee du point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Changer l'abscisse du point.
     * @param vx nouvelle abscisse
     */
    public void setX(double vx) {
        this.x = vx;
    }

    /**
     * Changer l'ordonnee du point.
     * @param vy nouvelle ordonnee
     */
    public void setY(double vy) {
        this.y = vy;
    }

    /**
     * Obtenir la couleur du point.
     * @return la couleur du point
     */
    public Color getCouleur() {
        return this.couleur;
    }

    /**
     * Changer la couleur du point.
     * @param nouvelleCouleur nouvelle couleur
     */
    public void setCouleur(Color nouvelleCouleur) {
        this.couleur = nouvelleCouleur;
    }

    /**
     * Distance par rapport a un autre point.
     * @param autre l'autre point
     *
     * @return distance entre this et autre
     */
    public double distance(Point autre) {
        return Math.sqrt(Math.pow(autre.x - this.x, 2)
                + Math.pow(autre.y - this.y, 2));
    }

    /**
     * Translater le point.
     * @param dx deplacement suivant l'axe des X
     * @param dy deplacement suivant l'axe des Y
     */
    public void translater(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /** Afficher le point. */
    public void afficher() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    /*
     * La methode finalize est appelee avant que le recuperateur de
     * memoire ne detruise l'objet. Attention toutefois, on ne sait pas quand
     * ces ressources seront liberees et il est donc dangereux de s'appuyer
     * sur ce mecanisme pour liberer des ressources qui sont en nombre
     * limite. D'autre part, pour etre sur que les methodes << finalize >>
     * sont appelees avant la fermeture de Java, il faut appeler la
     * methode statique System.runFinalizersOnExit(true)
     * protected void finalize() { 
     *     System.out.print("DESTRUCTION du point : ");
     *     this.afficher(); System.out.println(); 
     * }
     */
}
