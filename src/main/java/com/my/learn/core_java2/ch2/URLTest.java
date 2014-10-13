package com.my.learn.core_java2.ch2;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by yidianadmin on 14-10-13.
 */
public class URLTest
{
    public static void main(String args[]) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            String urlString = "";
            while (scanner.hasNextLine()) {
                urlString = scanner.nextLine().trim();
                try {
                    URL url = new URL(urlString);
                    URLConnection urlConnection = url.openConnection();
                    urlConnection.setConnectTimeout(1000);
                    urlConnection.setReadTimeout(1000);

                    InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
                    BufferedReader br = new BufferedReader(isr);

                    String str;
                    while ((str = br.readLine()) != null) {
                        System.out.println(str);
                    }

                    br.close();
                    isr.close();
                } catch (Exception e) {
                    System.out.flush();
                    System.out.println(e);
                    System.out.flush();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}