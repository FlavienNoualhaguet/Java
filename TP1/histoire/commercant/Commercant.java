package histoire.commercant;
import histoire.humain.Humain;


public class Commercant extends Humain {

    public Commercant (String nom, int argent) {
        super(nom, "The", argent);
    }

    public void seFaireExtorquer() {
        int a = this.getArgent();
        this.perdreArgent(a);
        Humain.parler("Le monte est injuste !");

    }

    public void faireDesAffaire(Humain h, int somme) {
        h.perdreArgent(somme);
        this.gagnerArgent(somme);
        Humain.parler(String.format("Merci a %s pour le commerce !", this.getNom()));
    }
}