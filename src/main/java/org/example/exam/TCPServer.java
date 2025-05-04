package org.example.exam;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer {
    private static final int PORT = 6789;
    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Serveur démarré sur le port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connecté : " + socket.getInetAddress());
            ClientHandler handler = new ClientHandler(socket);
            clients.add(handler);
            new Thread(handler).start();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader in;
        private DataOutputStream out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void send(String msg) throws IOException {
            out.writeBytes(msg + "\n");
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Message reçu : " + message);
                    for (ClientHandler client : clients) {
                        if (client != this) {
                            client.send("Autre client : " + message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Client déconnecté.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(this);
            }
        }
    }
}
