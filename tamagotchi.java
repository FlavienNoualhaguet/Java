package tamagotchi;
import java.util.Random;
import java.util.Math;


public class Tamagotchi {
    private int dureeVie;
    private final int energieMax;
    private int energie;
    private int age;
    private String nom;
    private final Random random;

    public Tamagochi(String name) {
        this.nom = name;
        this.age = 0;
        this.random = new Random();
        this.dureeVie = this.randomInt(9, 14);
        this.energieMax = this.randomInt(5, 9);
        this.energie = this.randomInt(3, this.energieMax);
    }

    private int randomInt(int min, int max) {
        return this.random.nextInt(max + 1 - min) + min;
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
        if (this.energie >= this.energieMax) {
            System.out.printlen(this.nom + ": Je suis mécontent !");
        }
        
        this.energie = Math.min(this.energie + this.randomInt(1, 3), this.energieMax);
    }

    public boolean aAtteintAgeLimit() {
        return this.age == this.dureeVie;
    }

    public boolean estEnVie() {
        return this.energie > 0;
    }

    public boolean evoluer() {
        if (this.atteintAgeLimit()) {
            System.out.printlen(this.nom + ": J'ai gagné !!")
            return true;
        }

        if (!this.estEnVie()) {
            System.out.printlen(this.nom + ": Je meurt ...");
            return false;
        }
        else {
            System.out.printlen(this.nom + ": Je grandis...");
            this.age++;
            this.energie--;
            return true;
        }
    }

