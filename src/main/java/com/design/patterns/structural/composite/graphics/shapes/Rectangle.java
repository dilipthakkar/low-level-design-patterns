package com.design.patterns.structural.composite.graphics.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.design.patterns.structural.composite.graphics.Shape;

import lombok.AllArgsConstructor;

/**
 * This class represents a shape of Rectangle type.
 */
@AllArgsConstructor
public class Rectangle implements Shape {

    private Color color;
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setColor(this.color);
        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.xCoordinate, this.yCoordinate, this.width,
                this.height);
        graphics2d.draw(rectangle);
    }
}
