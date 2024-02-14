package fr.enac.sita.tp3.cercle;

import java.awt.Color;

public class Cercle implements Mesurable2D {
    
    private Point point;
    private double radius;
    private Color color;
    public static final double PI=Math.PI;
    
    public Cercle(Point A, double d) {
        this.point = new Point(A.getX(), A.getY());
        this.radius = d;
        this.color = Color.blue;
    }

    public Cercle(Point C, Point D, Color blue) {
        this.point = new Point((C.getX() + D.getX())/2, (C.getY()+D.getY())/2);
        this.radius = C.distance(D)/2;
        this.color = blue;
    }
    
    
    public Cercle(Point C, Point D) {
        this.point = new Point((C.getX() + D.getX())/2, (C.getY()+D.getY())/2);
        this.radius = C.distance(D)/2;
        this.color = Color.blue;
    }

    public Point getCentre() {
        return new Point(this.point.getX(), this.point.getY());
    }

    public double getRayon() {
        return this.radius;
    }

    public Color getCouleur() {
        return this.color;
    }
    
    public double getDiametre() {
        return 2*this.getRayon();
    }

    
    public void translater(double dx, int dy) {
        this.point.translater(dx, dy);
    }

    public boolean contient(Point A) {
        return this.getCentre().distance(A) <= this.getRayon();
    }

    @Override
    public double perimetre() {
        return 2*Cercle.PI*this.getRayon();
    }

    @Override
    public double aire() {
        return Cercle.PI*Math.pow(this.getRayon(), 2);
    }

    public void Couleur(Color red) {
        this.color = red;
    }

    public void setCouleur(Color red) {
        this.color = red;
    }

    public void setRayon(double nr) {
        this.radius = nr;
    }

    public void setDiametre(double d) {
        this.radius = d/2;
    }
    
    @Override
    public String toString() {
        String repr = String.format("C%s@(%s, %s)", this.getRayon(), this.point.getX(), this.point.getY());
        return repr;
    }
    
    public static Cercle creerCercle(Point A, Point B) {
        return new Cercle(A, A.distance(B));
        
    }
}
