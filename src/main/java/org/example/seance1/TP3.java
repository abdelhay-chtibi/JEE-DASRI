package org.example.seance1;

import java.net.InetAddress;
public class TP3 { //public class AllAdresses
    public static void main(String[] args) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            for(int j = 0; j < addresses.length; j++) {
                System.out.println(addresses[j].getHostAddress());
            }
        } catch (Exception e) {
            System.out.println("Exception !!!");
        }
    }
}
