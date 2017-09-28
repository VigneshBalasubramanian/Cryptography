package com.crypto.communication;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public void send(File file) {
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        String host = Server.SERVER;

        try {
            socket = new Socket(host, Server.SOCKET_PORT);
            byte[] bytes = new byte[16 * 1024];
            in = new FileInputStream(file);
            out = socket.getOutputStream();

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
        } catch (Exception e) {
        }

        try {
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
        }
    }
}
