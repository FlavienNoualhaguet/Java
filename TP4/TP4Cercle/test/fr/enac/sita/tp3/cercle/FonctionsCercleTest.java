package fr.enac.sita.tp3.cercle;

import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Classe de test de la classe Cercle (incomplete).
 *
 * @author Xavier Cregut
 * @author Sebastien Leriche
 * @version 2016.03.01
 */
public class FonctionsCercleTest {

    // precision pour la comparaison de reels
    public final static double EPSILON = 0.001;

    // Les points du sujet
    private Point A, B, C, D, E;

    // Les cercles du sujet
    private Cercle C1, C2;

    @Before
    public void setUp() {
        // Construire les points
        A = new Point(1, 2);
        B = new Point(2, 1);
        C = new Point(4, 1);
        D = new Point(8, 1);
        E = new Point(8, 4);

        // Construire les cercles
        C1 = new Cercle(A, 2.5);
        C2 = new Cercle(C, D, Color.yellow);
    }

    /**
     * Verifier si deux points ont memes coordonnees.
     * @param p1 le premier point
     * @param p2 le deuxieme point
     */
    static void memesCoordonnees(String message, Point p1, Point p2) {
        assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
        assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
    }

    @Test
    public void testerAffichage() {
        // Test inutile qui permet simplement d'avoir une visualisation dans le
        // terminal des cercles manipules.
        System.out.println("C1 = " + C1);
        System.out.println("C2 = " + C2);
    }

    @Test
    public void testerInitialisationC1() {
        memesCoordonnees("E11 : Centre de C1 incorrect", A, C1.getCentre());
        assertEquals("E11 : Rayon de C1 incorrect", 2.5, C1.getRayon(), EPSILON);
        assertEquals(Color.blue, C1.getCouleur());
    }

    @Test
    public void testerE1() {
        C1.translater(10, 20);
        memesCoordonnees("E1 sur C1", new Point(11, 22), C1.getCentre());
        C2.translater(3, -1);
        memesCoordonnees("E1 sur C2", new Point(9, 0), C2.getCentre());
    }

    @Test
    public void testerE2() {
        memesCoordonnees("E2 sur C1", A, C1.getCentre());
        memesCoordonnees("E2 sur C2", new Point(6, 1), C2.getCentre());
    }

    @Test
    public void testerE3() {
        assertEquals("E3 sur C1", 2.5, C1.getRayon(), EPSILON);
        assertEquals("E3 sur C2", 2.0, C2.getRayon(), EPSILON);
    }

    @Test
    public void testerE4() {
        assertEquals("E4 sur C1", 5.0, C1.getDiametre(), EPSILON);
        assertEquals("E4 sur C2", 4.0, C2.getDiametre(), EPSILON);
    }

    @Test
    public void testerE5() {
        assertTrue("E5", C1.contient(A));
        assertTrue("E5", C1.contient(B));
        assertFalse("E5", C1.contient(C));
        assertFalse("E5", C1.contient(D));
        assertFalse("E5", C1.contient(E));
        assertFalse("E5", C1.contient(C));
        assertFalse("E5", C1.contient(new Point(3, 4)));
        assertTrue("E5", new Cercle(D, 3).contient(E));
    }

    @Test
    public void testerE6() {
        assertEquals("E6", 5 * Math.PI, C1.perimetre(), EPSILON);
        assertEquals("E6", 4 * Math.PI, C2.perimetre(), EPSILON);
        assertEquals("E6", 6.25 * Math.PI, C1.aire(), EPSILON);
        assertEquals("E6", 4 * Math.PI, C2.aire(), EPSILON);
    }

    @Test
    public void testerE9() {
        assertEquals("E9", Color.blue, C1.getCouleur());
        assertEquals("E9", Color.yellow, C2.getCouleur());
    }

    @Test
    public void testerE10() {
        C1.setCouleur(Color.red);
        assertEquals("E10", Color.red, C1.getCouleur());
    }

    @Test
    public void testerToString() {
        assertEquals("E15: Methode toString() redefinie ? Correctement ?",
                "C2.5@(1.0, 2.0)", C1.toString());
    }

    @Test
    public void testerE16() {
        C1.setRayon(10);
        assertEquals("E16", 10, C1.getRayon(), EPSILON);
        C1.setRayon(20);
        assertEquals("E16", 20, C1.getRayon(), EPSILON);
    }

    @Test
    public void testerE17() {
        C1.setDiametre(10);
        assertEquals("E17", 5, C1.getRayon(), EPSILON);
        C1.setDiametre(20);
        assertEquals("E17", 10, C1.getRayon(), EPSILON);
    }

    @Test
    public void testerE18() {
        C1.getCentre().translater(10, 20);
        memesCoordonnees("E18 : Erreur si translation du centre", new Point(1,
                2), C1.getCentre());
        A.translater(10, 20);
        memesCoordonnees("E18 : Erreur si translation de A", new Point(1, 2),
                C1.getCentre());
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(FonctionsCercleTest.class.getName());
    }

}
