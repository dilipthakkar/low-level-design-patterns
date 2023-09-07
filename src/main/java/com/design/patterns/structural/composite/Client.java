package com.design.patterns.structural.composite;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.design.patterns.structural.composite.graphics.composite.NatureDrawing;
import com.design.patterns.structural.composite.graphics.composite.PicasoDrawing;
import com.design.patterns.structural.composite.graphics.shapes.Circle;
import com.design.patterns.structural.composite.graphics.shapes.Line;

/**
 * This class represents a client which creates a drawing using multiple simple
 * and complex drawing.
 */
public class Client {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Shapes Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // We have created a picaso drawing which contains a line and a circle.
                PicasoDrawing picasoDrawing = new PicasoDrawing(Arrays.asList(
                        new Line(Color.GRAY, 20, 20, 80, 80),
                        new Circle(Color.GREEN, 30, 30, 90, 90)));

                int[] natureDrawingPolygonXPoints = { 100, 23, 32, 145 };
                int[] natureDrawingPolygonYPoints = { 189, 343, 54, 133 };

                // We have created a complex nature drawing which contains a internal polygon
                // and above picaso drawing as a child.
                NatureDrawing natureDrawing = new NatureDrawing(Color.ORANGE, Arrays.asList(picasoDrawing),
                        natureDrawingPolygonXPoints, natureDrawingPolygonYPoints, natureDrawingPolygonXPoints.length);

                natureDrawing.draw(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
