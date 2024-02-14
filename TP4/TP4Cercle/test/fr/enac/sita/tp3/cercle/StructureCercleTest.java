package fr.enac.sita.tp3.cercle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * L'objectif de cette classe est de verifier que la classe Cercle a ete
 * correctement programmee.
 *
 * @author Xavier Cregut
 * @author Sebastien Leriche
 * @version 2016.03.01
 */
public class StructureCercleTest {

    private Class cercle;

    private static Method getMethode(Class c, String name, Class... types) throws NoSuchMethodException {
        Method resultat = c.getMethod(name, types);
        assertNotNull("Methode " + name + "(" + types + ") non declaree !",
                resultat);
        return resultat;
    }

    private static Field getAttribut(Class c, String name) throws NoSuchFieldException {
        Field resultat = c.getDeclaredField(name);
        assertNotNull("Attribut " + name + " non declare !", resultat != null);
        return resultat;
    }

    private static List<Field> getAttributsInstance(Class c) {
        ArrayList<Field> result = new ArrayList<>(5);
        for (Field f : c.getDeclaredFields()) {
            if (!Modifier.isStatic(f.getModifiers())) {
                result.add(f);
            }
        }
        return result;
    }

    private static void verifierConstanteClasse(Class c, String name)
            throws NoSuchFieldException {
        Field PI = getAttribut(c, name);
        assertTrue(name + " : Devrait etre une constante !",
                Modifier.isFinal(PI.getModifiers()));
        assertTrue(name + " : Doit etre une constante de *classe* !",
                Modifier.isStatic(PI.getModifiers()));
        assertTrue(name + " : Pourquoi pas public ?",
                Modifier.isPublic(PI.getModifiers()));
    }

    @Before
    public void setUp() {
        this.cercle = Cercle.class;
    }

    @Test
    public void testC12() throws Exception {
        verifierConstanteClasse(cercle, "PI");
    }

    @Test
    public void testerNombreAttributs() throws Exception {
        int attendu = 3; // nombre d'attributs d'instance attendus
        int nbReel = getAttributsInstance(cercle).size();
        assertFalse("Trop d'attributs d'instance : " + nbReel + " au lieu de "
                + attendu + " !", nbReel > attendu);
        assertFalse("Pas assez d'attributs d'instance : " + nbReel
                + " au lieu de " + attendu + " !", nbReel < attendu);
    }

    @Test
    public void testAttributsPrives() throws Exception {
        for (Field f : cercle.getDeclaredFields()) {
            if (!Modifier.isFinal(f.getModifiers())) {
                assertFalse("Attribut " + f + " ne devrait pas etre public !",
                        Modifier.isPublic(f.getModifiers()));
                assertFalse("Attribut " + f + " : Pourquoi protected ?",
                        Modifier.isProtected(f.getModifiers()));
                assertTrue("Attribut " + f + " : Droit d'acces oublie ?",
                        Modifier.isPrivate(f.getModifiers()));
            }
        }
    }

    @Test
    public void testerE6() {
        assertTrue("Cercle devrait etre un Mesurable2D !",
                Mesurable2D.class.isAssignableFrom(cercle));
    }

    @Test
    public void testerE6bis() {
        boolean trouve = false;
        for (Class<?> i : cercle.getInterfaces()) {
            trouve = trouve || i == Mesurable2D.class;
        }
        assertTrue("Cercle doit directement realiser Mesurable2D !", trouve);
    }

    @Test
    public void testerNbConstructeurs() {
        int nbAttendu = 3;
        int nbConstructeurs = cercle.getConstructors().length;
        assertFalse("Trop de constructeurs : " + nbConstructeurs,
                nbConstructeurs > nbAttendu);
        assertFalse("Pas assez de constructeurs [publics] : " + nbConstructeurs,
                nbConstructeurs < nbAttendu);
    }

    @Test
    public void testerE14() throws Exception {
        Method creerCercle = null;
        try {
            creerCercle = getMethode(cercle, "creerCercle", Point.class, Point.class);
        } catch (NoSuchMethodException e) {
            fail("La methode creerCercle(Point, Point) n'existe pas !");
        }
        int modifieurs = creerCercle.getModifiers();
        assertTrue("creerCercle devrait etre publique !",
                Modifier.isPublic(modifieurs));
        assertTrue("creerCercle doit etre une methode de classe !",
                Modifier.isStatic(modifieurs));
    }

    @Test
    public void testerContructeurDefaut() {
        try {
            Constructor defaut = cercle.getConstructor();
        } catch (NoSuchMethodException e) {
            // OK
            return;
        }
        fail("Pourquoi definir un constructeur par defaut ?");

    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(StructureCercleTest.class.getName());
    }

}
