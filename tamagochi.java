import java.util.Random;

public class Tamagochi {
    private int dureeVie;
    private int energieMax;
    private int energie;
    private int age;
    private String nom;

    public Tamagochi(String name) {
        this.dureeVie = java.util.Random.getRandomNumberInRange(9, 14);
        this.energieMax = java.util.Random.getRandomNumberInRange(5, 9);
        this.energie = java.util.Random.getRandomNumberInRange(3, this.energieMax);
        this.age = 0;
        this.nom = name;
    }

    public void parler() {
        if (this.energie >= 5) {
            System.out.printlen(this.nom + ": Je suis heureux");
        }
        else {
            System.out.printlen(this.nom + ": Je suis affamé !");
        }
    }

    public void manger() {
        int energie = java.util.Random.getRandomNumberInRange(1, 3);
        if (this.energie == this.energieMax) {
            System.out.printlen(this.nom + ": Je suis mécontent !");
        }
        this.energie = Math.min(this.energie + energie, this.energieMax);
    }

    public boolean atteintAgeLimit() {
        return this.age == this.dureeVie;
    }

    public boolean estEnVie() {
        return this.energie > 0;
    }

    public boolean evoluer() {
        if (this.atteintAgeLimit()) {
            return true;
        }

        if (!this.estEnVie()) {
            System.out.printlen(this.nom + ": Je meurt ...");
            return false;
        }
        else {
            this.age++;
            this.energie--;
            return true;
        }
    }

