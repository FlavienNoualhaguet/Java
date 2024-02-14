/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.enac.sita.tp3.cercle;

import static fr.enac.sita.tp3.cercle.FonctionsCercleTest.EPSILON;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author noualhfl
 */
public class SupplementsCercleTest {
    
    public final static double EPSILON = 0.001;
   
    // Les points du sujet
    private Point A, B;

    // Les cercles du sujet
    private Cercle C1;
    
    @Before
    public void setUp() {
        // Construire les points
        A = new Point(1, 1);
        B = new Point(-1, -1);

        // Construire les cercles
        C1 = new Cercle(A, B);
    }
    
    @Test
    public void testE12() {
        Point centre = C1.getCentre();
        assertEquals("Cercle avec points diametralement oppose : centreX", 0, centre.getX(), EPSILON);
        assertEquals("Cercle avec points diametralement oppose : centreY", 0, centre.getY(), EPSILON);
        assertEquals("Cercle avec points diametralement oppose : diametre", 2*Math.sqrt(2), C1.getDiametre(), EPSILON);
        assertEquals("Cercle avec points diametralement oppose : rayon", Math.sqrt(2), C1.getRayon(), EPSILON);

    }
}
