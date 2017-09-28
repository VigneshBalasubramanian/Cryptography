package com.crypto.communication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static int SOCKET_PORT = 8888;
    public static String SERVER = "127.0.0.1";

    public void receive(String filePath) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(SOCKET_PORT);
        } catch (IOException ex) {
            System.out.println("Can't setup server on this port number. ");
        }

        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            socket = serverSocket.accept();
        } catch (IOException ex) {
            System.out.println("Can't accept client connection. ");
        }

        try {
            in = socket.getInputStream();
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }

        try {
            out = new FileOutputStream(filePath);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. ");
        }

        byte[] bytes = new byte[16 * 1024];

        int count;
        try {
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
        } catch (Exception e) {
        }

        try {
            out.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
        }
    }
}
