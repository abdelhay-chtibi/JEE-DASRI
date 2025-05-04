package org.example.exam;

import java.io.*;
import java.net.*;

public class TCPClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

        // Thread pour lire les messages du serveur
        new Thread(() -> {
            String msg;
            try {
                while ((msg = fromServer.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (IOException e) {
                System.out.println("Déconnecté.");
            }
        }).start();

        System.out.println("Client 2 connecté. Tape ton message :");

        // Lire et envoyer
        String line;
        while ((line = clavier.readLine()) != null) {
            toServer.writeBytes("Client2: " + line + "\n");
        }

        socket.close();
    }
}
