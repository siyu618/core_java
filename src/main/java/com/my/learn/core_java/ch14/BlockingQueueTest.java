package com.my.learn.core_java.ch14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by tianzy on 3/26/14.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory (e.g. /usr/local/jdk1.6.0/src) ;");
        String directory = in.nextLine();
        System.out.println("Enter keyword (e.g. volatile )");
        String keyword = in.nextLine();

        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;
        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);

        FileEnumerationTask enumerationTask = new FileEnumerationTask(queue, new File(directory));
        new Thread(enumerationTask).start();
        for (int i = 0; i <= SEARCH_THREADS; i ++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }
}


/**
 * enumerates all files in a directory and its subdirectory.
 */

class FileEnumerationTask implements Runnable {

    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try {
            enumerate(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            }
            else {
                queue.put(file);
            }
        }
    }

    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;
}

class SearchTask implements Runnable {

    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        try {
            boolean done = false;
            while (!done) {
                File file = queue.take();
                if (file == FileEnumerationTask.DUMMY) {
                    queue.put(file);
                    done = true;
                } 
                else {
                    search(file);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void search(File file) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(file));
        int lineNumber = 0;
        while (in.hasNextLine()) {
            lineNumber ++;
            String line = in.nextLine();
            if (line.contains(keyword)) {
                System.out.printf("%s:%s:%d:%s%n", Thread.currentThread(), file.getPath(), lineNumber, line);
            }
        }
        in.close();
    }

    private BlockingQueue<File> queue;
    private String keyword;
}
