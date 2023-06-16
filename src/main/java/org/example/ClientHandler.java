package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        InetAddress inetAddress = this.clientSocket.getInetAddress();
        System.out.println("Connected from: " + inetAddress);
    }

    boolean manage() {

        BufferedReader in;
        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            return false;
        }

        PrintWriter out = null; // allocate to write answer to client.
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            return false;
        }

        Gson gson = new Gson();
        String s;
        while (true) {
            try {
                if ((s = in.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            Command cmd = null;
            try {
                cmd = gson.fromJson(s, Command.class);
            } catch (Exception e) {

            }
            // out.println(new Answer(false, "Command not recognised").asJson());
            String result = "";
            if (cmd != null) {
                result = executeCmd(cmd);
            } else {
                Answer a = new Answer(false, "Command not recognised");
                result = a.asJson();
            }
            out.println(result);
        }
        //if (out.equals("login")) {

        //}
        return true;
    }

    String executeCmd(Command cmd) {
        return new Answer(true, "Working on...").asJson();
    }

    @Override
    public void run() {
        manage();

    }
}
