/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.sita.visuradar.communication;

import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyClient;
import fr.dgac.ivy.IvyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noualhfl
 */
public class Ex3Question3_CommunicationManager {
        private Ivy bus;
        private static final String regexp ="^TrackMovedEvent Flight=(.*) CallSign=(.*) Ssr=(.*) Sector=(.*) Layers=(.*) X=(.*) Y=(.*) Vx=(.*) Vy=(.*) Afl=(.*) Rate=(.*) Heading=(.*) GroundSpeed=(.*) Tendency=(.*) Time=(.*)$";

    public Ex3Question3_CommunicationManager() throws IvyException {
            try {
                this.bus = new Ivy("Ex3Question3_CommunicationManager", "Ex3Question3_CommunicationManager Ready", null);
                this.bus.bindMsg(regexp, 
                                (IvyClient client, String[] strings) -> {
                                    System.out.println(strings[0]);
                            }
                );
                
                // start the bus on the default domain
                bus.start(null);
            } catch (IvyException ex) {
                Logger.getLogger(Ex3Question3_CommunicationManager.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

        
}
