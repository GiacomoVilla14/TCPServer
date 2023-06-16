package org.example;

public class ClientThread extends Thread {
    ClientHandler clientHandler;

    public ClientThread(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    public void run() { //invoca il thread
        clientHandler.manage();

        if (!clientHandler.manage()) {
            System.out.println("Non posso far funzionare il client");
        }
        System.out.println("Tutto Finito");

    }
}
