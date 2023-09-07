package com.design.patterns.structural.composite.graphics;

import java.awt.Graphics;

/**
 * This type represents of a shape in a drawing.
 */
public interface Shape {

    /**
     * Draws a shape using given graphics object.
     * 
     * @param graphics
     */
    void draw(Graphics graphics);

}
