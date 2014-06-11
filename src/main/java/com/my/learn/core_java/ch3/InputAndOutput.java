package com.my.learn.core_java.ch3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputAndOutput {

    public static void copyFile(String inFile, String outFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(inFile));
        //scanner = new Scanner(new BufferedReader(new FileReader(new File(inFile))));
        PrintWriter printWriter = new PrintWriter(new File(outFile));
        String line = null;

        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            printWriter.write(line);
            printWriter.write("\n");
            System.out.println(line);
        }
        scanner.close();
        printWriter.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inFile = "src/test/resources/job.properties";
        String outFile = inFile + ".copy";
        copyFile(inFile, outFile);
    }
}
