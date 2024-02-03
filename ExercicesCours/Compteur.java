package ExercicesCours;

public class Compteur {

    private int valeur;

    public Compteur(int valInit) {
        valeur = valInit;
    }

    public void raz() {
        valeur = 0;
    }

    public void incrementer() {
        valeur++;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "compteur=" + valeur;
    }
}