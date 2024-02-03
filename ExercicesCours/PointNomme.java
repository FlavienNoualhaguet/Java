package ExercicesCours;

public class PointNomme extends Point {

    private String nom;

    public PointNomme(String a, int x, int y) {
        super(x, y);
        this.nom = a;
    }

    @Override
    public String toString() {
        return nom + super.toString();
    }

}