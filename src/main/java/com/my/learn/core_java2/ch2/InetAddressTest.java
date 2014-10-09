package com.my.learn.core_java2.ch2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by yidianadmin on 14-10-9.
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress address : addresses) {
                System.out.println(address);
            }
        }
        else {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local);
        }
    }
}
