package org.example.seance1;

import java.net.InetAddress;
public class TP2 { //
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Host name: " + address.getHostName());
            System.out.println("IP address: " + address.getHostAddress());
        } catch (Exception e) {
            System.out.println("Exception !!!");
        }
    }
}
