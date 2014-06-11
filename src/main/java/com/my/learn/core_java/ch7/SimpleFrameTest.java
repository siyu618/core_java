package com.my.learn.core_java.ch7;

import javax.swing.JFrame;

public class SimpleFrameTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SimpleFrame simpleFrame = new SimpleFrame();
        simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simpleFrame.setTitle("Hello World");
        simpleFrame.setVisible(true);
    }

}

class SimpleFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGTH = 200;
    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGTH);
    }
}
