import java.util.Scanner;

public class Jeu {
    public static void main (String[] args) {
        Tamagotchi[] tamagotchis;
        int n = Integer.parseInt(args[0]);

        tamagotchis = new Tamagotchi[n];
        Scanner scanner = new Scanner (System.in);
        String msg;
        for (int i=0; i<n; i++) {
            // Demande du nom du Tamagotchi numero i
            msg = String.format("Tamagotichi %d: ", i+1);
            System.out.print(msg);
            // Creation du Tamagotchi
            tamagotchis[i] = new Tamagotchi(scanner.next());
        }

        boolean unMort=false;
        int nbMature=0;
        while (!unMort && nbMature < n) {
            nbMature = 0;
            for (int i=0; i<n; i++) {
                msg = String.format("(%d): ", i);
                System.out.print(msg);
                tamagotchis[i].parler();
            }

            System.out.println("Quelle numero de tamagotchi voulez-vous nourrir ?");
            int numero=scanner.nextInt();

            tamagotchis[numero].manger();
            
            for (Tamagotchi t: tamagotchis) {
                if (t.evoluer()) {
                    unMort=true;
                    break;
                }

                else if (t.aAtteintAgeLimit() && t.estEnVie()) {
                    nbMature++;
                }
            }
        }

        if (unMort) {
            System.out.println("Perdu !!!!");
        }
        else {
            System.out.println("Gagné !!!!");
        }
    }
}