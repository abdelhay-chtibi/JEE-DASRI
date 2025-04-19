package org.example.seance1;

        import java.net.*;
public class TP1 {
    public static void main(String[] args) {
        try {
            InetAddress adrLocale = InetAddress.getLocalHost();
            System.out.println("Adresse locale = " + adrLocale.getHostAddress());
            System.out.println("Adresse locale = " + adrLocale.getHostName());
            System.out.println("Adresse google = " + adrLocale.getByName("www.google.com"));
            System.out.println("Adresse google = " + adrLocale.getByName("www.youtube.com"));
        } catch (Exception e) {
            System.out.println("HostLocalinnaccessible");
        }
    }
}
