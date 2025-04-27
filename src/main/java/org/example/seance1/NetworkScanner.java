package org.example.seance1;

import java.net.InetAddress;

public class NetworkScanner {
    public static void main(String[] args) {
        String subnet = "192.168.1"; // adapte ça à ton réseau local
        int timeout = 100; // délai du ping en ms

        for (int i = 1; i < 255; i++) {
            String host = subnet + "." + i;
            try {
                InetAddress address = InetAddress.getByName(host);
                if (address.isReachable(timeout)) {
                    System.out.println("Machine trouvée : " + host + " (" + address.getHostName() + ")");
                }
            } catch (Exception e) {
                System.out.println("Erreur avec : " + host);
            }
        }
    }
}

