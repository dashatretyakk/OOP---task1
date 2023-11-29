package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        SerializableObject object = new SerializableObject("Hello, Server!");

        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            objectOutputStream.writeObject(object);
            System.out.println("Sent object to server");
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}
