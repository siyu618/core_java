package com.my.learn.core_java.ch14;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianzy on 3/24/14.
 */
public class BallComponent extends JPanel {
    private List<Ball> balls = new ArrayList<Ball>();
    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }
}
