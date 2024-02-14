package fr.enac.sita.tp3.cercle;

/**
 * Definir les proprietes d'un element ferme du plan.
 *
 * @author Xavier Cregut
 * @version Revision: 1.2
 */
public interface Mesurable2D {

    /**
     * Obtenir le perimetre de l'element.
     * @return le perimetre
     */
    public double perimetre();

    /**
     * Obtenir l'aire de l'element.
     * @return l'aire
     */
    public double aire();

}
