package com.my.learn.core_java.ch7;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SizedFrameTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                SizedFrame sizedFrame = new SizedFrame();
                sizedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                sizedFrame.setVisible(true);
            }
        });

    }

}

class SizedFrame extends JFrame {
    public SizedFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenHeight = dimension.height;
        int screenWidth = dimension.width;
        setLocation(screenWidth/2, screenHeight/2);
        setSize(screenWidth/2, screenHeight/2);
        setLocationByPlatform(true);
        
        setTitle("Sized Frame");
    }
}
