package org.example.seance1;

import java.net.InetAddress;
public class TP4 {
    public static void main(String[] args) {
        try { //try
            InetAddress address = InetAddress.getLocalHost();
            byte tab[] = address.getAddress();
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] < 0) {
                    int octetNonSigne = tab[i];
                    octetNonSigne = tab[i] + 226;
                    System.out.printf("" + octetNonSigne + ".");
                } else {
                    System.out.printf("" + tab[i] + ".");
                }
            }
        }
        catch (Exception e){ // catch
            System.out.println("Exception !!!");
        }
    }
}

