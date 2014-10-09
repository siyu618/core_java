package com.my.learn.core_java2.ch2;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * Created by yidianadmin on 14-10-9.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13));
        try {
            InputStream inputStream = socket.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }

        } finally {
            socket.close();
        }
    }
}
