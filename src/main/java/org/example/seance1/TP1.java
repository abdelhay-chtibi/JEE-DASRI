package org.example.seance1;

        import java.net.*;
public class TP1 {
    public static void main(String[] args) {
        try {
            InetAddress adrLocale = InetAddress.getLocalHost();
            System.out.println("Adresse locale = " + adrLocale.getHostAddress());
            System.out.println("Nom d'hôte = " + adrLocale.getHostName());

            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Adresse google = " + google);

            InetAddress youtube = InetAddress.getByName("www.youtube.com");
            System.out.println("Adresse youtube = " + youtube);
        } catch (Exception e) {
            System.out.println("HostLocalinnaccessible");
        }
    }
}
