package com.my.learn.core_java.ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

/**
 * Created by tianzy on 3/26/14.
 */
public class AlgorithmAnimation {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new AnimationFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}


class AnimationFrame extends JFrame {
    public AnimationFrame() {
        ArrayComponent component = new ArrayComponent();
        add(component, BorderLayout.CENTER);

        final Sorter sorter = new Sorter(component);
        JButton runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setRun();
            }
        });

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setStep();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(runButton);
        buttons.add(stepButton);
        add(buttons, BorderLayout.NORTH);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

       new Thread(sorter).start();
    }

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
}

class Sorter implements Runnable {
    public Sorter(ArrayComponent component) {
        values = new Double[VALUES_LENGTH];
        for (int i = 0; i < values.length; i ++) {
            values[i] = new Double(Math.random());
        }
        this.component = component;
        this.gate = new Semaphore(1);
        this.run = false;
    }

    public void setRun() {
        this.run = true;
        this.gate.release();;
    }

    public void setStep() {
        run = false;
        gate.release();
    }


    @Override
    public void run() {
        Comparator<Double> comp = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                component.setValues(values, o1, o2);
                try {
                    if (run) Thread.sleep(DELAY);
                    else gate.acquire();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return o1.compareTo(o2);
            }
        };
        Arrays.sort(values, comp);
        component.setValues(values, null, null);

    }

    private Double[] values;
    private ArrayComponent component;
    private Semaphore gate;
    private static final int DELAY = 100;
    private volatile boolean run;
    private static final int VALUES_LENGTH = 30;
}


class ArrayComponent extends JComponent {

    public synchronized void setValues(Double[] values, Double marked1, Double marked2) {
        this.values = values.clone();
        this.marked1 = marked1;
        this.marked2 = marked2;
        repaint();
    }

    public synchronized void paintComponent(Graphics g) {
        if (values == null ) {return;}
        Graphics2D g2 = (Graphics2D)g;
        int width = getWidth() / values.length;
        for (int i = 0; i < values.length; i ++) {
            double height = values[i] * getHeight();
            Rectangle2D bar = new Rectangle2D.Double(width * i , 0, width, height);
            if (values[i] == marked2 || values[i] == marked1) {
                g2.fill(bar);
            } else {
                g2.draw(bar);
            }
        }
    }

    private Double marked1;
    private Double marked2;
    private Double[] values;

}