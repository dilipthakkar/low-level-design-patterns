package com.design.patterns.structural.composite.graphics.composite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import com.design.patterns.structural.composite.graphics.Shape;

import lombok.AllArgsConstructor;

/**
 * This class represents a complex drawing which has a polygon and other small
 * drawings also.
 */
@AllArgsConstructor
public class NatureDrawing implements Shape {

    private Color color;

    private List<Shape> childShapes;

    private int[] xPoints;

    private int[] yPoints;

    private int numPoints;

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setColor(this.color);
        Polygon polygon = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        graphics2d.draw(polygon);

        childShapes.forEach(shape -> shape.draw(graphics));
    }

}
