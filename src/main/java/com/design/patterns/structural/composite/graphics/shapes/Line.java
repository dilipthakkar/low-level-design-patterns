package com.design.patterns.structural.composite.graphics.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import com.design.patterns.structural.composite.graphics.Shape;

import lombok.AllArgsConstructor;

/**
 * This class represents a shape of line type.
 */
@AllArgsConstructor
public class Line implements Shape {

    private Color color;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setColor(this.color);
        Line2D.Double line = new Line2D.Double(this.x1, this.y1, this.x2, this.y2);
        graphics2d.draw(line);
    }

}
