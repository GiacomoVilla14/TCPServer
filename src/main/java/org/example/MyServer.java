package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    static int portNumber = 1234;
    static ServerSocket serverSocket;

    static boolean startServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



    public static void main(String[] args) {
        UserManager usersList = new UserManager();
        usersList.addUser(new User("Giacomo", "12345"));
        usersList.addUser(new User("Lorenzo", "12345"));
        usersList.addUser(new User("Riccardo", "12345"));
        usersList.addUser(new User("Giacomo", "12343"));

        if (!startServer()) {
            return;
        }
        while (true) {
            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ClientHandler clientHandler = new ClientHandler(clientSocket, usersList);
            Thread thread = new Thread(clientHandler);
            thread.start();

            /*if (!clientHandler.manage()) {
                System.out.println("Client non funziona");
            }*/
        }
        /*BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter out = null; // allocate to write answer to client.
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s;
        try {
            while ((s = Objects.requireNonNull(in).readLine()) != null) {
                System.out.println(s);
                Objects.requireNonNull(out).println((s.toUpperCase()));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }*/
    }
}
