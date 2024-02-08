/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package histoire;

/**
 *
 * @author flavien
 */
public class MonHistoire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Humain h = new Humain("Prof", "Porto", 10);
        h.direBonjour();
        h.boire();
        Commercant c = new Commercant("Marchant", 35);
        c.direBonjour();
        Yakuza y = new Yakuza("Yaku le noir", "biere", 42, "WarSong");
        y.extorquer(c);
        
        Ronin r = new Ronin("Roro", "sake", 61);
        r.donner(c, 10);
        r.provoquerDuel(y);
        r.direBonjour(); 
        
        Traitre t = new Traitre("Flavien", "Biere", 50, "ENAC");
        Yakuza y1 = new Yakuza("Yaku le white", "Coca", 30, "Meteo");

        t.direBonjour();
        t.boire();
        t.provoquerDuel(y1);
        t.direBonjour();
    }
    
}
