package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server is listening on port " + PORT);

                try (Socket socket = serverSocket.accept();
                     ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
                    SerializableObject object = (SerializableObject) objectInputStream.readObject();
                    System.out.println("Received object: " + object.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found: " + e.getMessage());
                }
            } catch (IOException e) {
                System.out.println("Server exception: " + e.getMessage());
            }
        }
    }
}
