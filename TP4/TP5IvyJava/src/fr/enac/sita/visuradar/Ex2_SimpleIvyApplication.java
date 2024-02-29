package fr.enac.sita.visuradar;

import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyClient;
import fr.dgac.ivy.IvyException;
import fr.dgac.ivy.IvyMessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;

class Ex2_SimpleIvyApplication {

    private Ivy bus;

    public Ex2_SimpleIvyApplication() throws IvyException {
        // initialize (set up the bus, name and ready message)
        bus = new Ivy("Ex2_SimpleIvyApplication", "Ex2_SimpleIvyApplication Ready", null);

        // subscribe to "Bye" messages
        bus.bindMsg("^Hello ([A-Z]{1}[a-z]*), my name is ([A-Z]{1}[a-z]*)", (IvyClient client, String[] strings) -> {
            try {
                String msg = String.format("Nice to meet you %s", strings[1]);
                // System.out.println(msg);
                // leave the bus, and as it is the only thread, quit the app
                // bus.stop();
                bus.sendMsg(msg);
            } // callback
            catch (IvyException ex) {
                Logger.getLogger(Ex2_SimpleIvyApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );
        
        // start the bus on the default domain
        bus.start(null); // adresse loopback de la machine (Windows et Linux)
        //bus.start("10.0.0.255:1234"); // adresse broadcast du réseau (Mac)
    }

    public static void main(String args[]) {
        try {
            new Ex2_SimpleIvyApplication();
        } catch (IvyException ex) {
            // Print an explicit message in case of IvyException
            throw new RuntimeException("Ivy bus had a failure. Quitting Ex2_SimpleIvyApplication...");
        }
    }
}
