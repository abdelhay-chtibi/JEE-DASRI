package org.example.seance1;

import java.net.InetAddress;

public class TP5 {
    public static void main(String[] args) {
        try {
            byte[] ipAdd = new byte[4];
            ipAdd[0] = (byte) 192;
            ipAdd[1] = (byte) 168;
            ipAdd[2] = (byte) 137;

            for (int i = 1; i <= 256; i++) {
                ipAdd[3] = (byte) i;

                InetAddress address = InetAddress.getByAddress(ipAdd);
                if (address.isReachable(100)) {
                    System.out.println("----------------Machine trouvée : " + address.getHostName());
                } else {
                    System.out.println("Machine non atteinte : " + address.getHostAddress());
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
