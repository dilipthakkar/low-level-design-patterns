package com.design.patterns.structural.composite.graphics.composite;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.design.patterns.structural.composite.graphics.Shape;

/**
 * This class represents a special complex drawing which has multiple small
 * drawing shapes.
 */
public class PicasoDrawing implements Shape {

    List<Shape> childShapes;

    public PicasoDrawing(List<Shape> childShapes) {
        this.childShapes = childShapes;
    }

    public PicasoDrawing() {
        childShapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        childShapes.add(shape);
    }

    public void remove(Shape shape) {
        childShapes.remove(shape);
    }

    @Override
    public void draw(Graphics graphics) {
        childShapes.forEach(shape -> shape.draw(graphics));
    }

}
