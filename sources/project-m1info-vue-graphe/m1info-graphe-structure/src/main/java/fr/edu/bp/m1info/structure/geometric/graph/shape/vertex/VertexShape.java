package fr.edu.bp.m1info.structure.geometric.graph.shape.vertex;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;


public class VertexShape extends AbstractVertexShape{

    public VertexShape(ShapeGeometric shape) {
        this.shape = shape;
    }

    public void draw(Graphics graphics) {
        this.shape.draw(graphics);
    }
}
