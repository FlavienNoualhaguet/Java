package ExercicesCours;

public class TableauUtil {

    public static int plusPetit(int[] tab) {
        int min = tab[0];
        for (int i=1; i < tab.length; i++) {
            if (tab[i] < min) {
                min = tab[i];
            }
        }
        return min;
    }
    
    public static <T extends Comparable> T plusGrand(T[], tab) {
        T max = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i].comareTo(max) > 0) {
                max = tab[i];
            }
        }
        return max;
    }
}