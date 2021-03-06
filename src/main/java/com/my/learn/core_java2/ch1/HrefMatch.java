package com.my.learn.core_java2.ch1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yidianadmin on 14-9-18.
 */
public class HrefMatch {
    public static void main(String[] args) {
        String urlString;
        if (args.length > 0){
            urlString = args[0];
        }
        else {
            urlString = "http://www.java.com";
        }
        try {
            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());
            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch=in.read()) != -1){
                input.append((char)ch);
            }
            String patternString =  "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>])\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                int start = matcher.start();
                int end = matcher.end();
                String match = input.substring(start, end);
                System.out.println(match);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
