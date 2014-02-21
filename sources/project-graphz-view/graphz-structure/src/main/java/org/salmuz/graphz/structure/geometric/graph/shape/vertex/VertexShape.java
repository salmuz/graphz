package org.salmuz.graphz.structure.geometric.graph.shape.vertex;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;


public class VertexShape extends AbstractVertexShape{

    public VertexShape(ShapeGeometric shape) {
        this.shape = shape;
    }

    public void draw(Graphics graphics) {
        this.shape.draw(graphics);
    }
}
