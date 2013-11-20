package fr.edu.bp.m1info.structure.geometric.graph.shape.vertex;

import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.shape.Shape;

public abstract class AbstractVertexShape implements Shape{

    protected ShapeGeometric shape;

    public ShapeGeometric shape() {
        return shape;
    }
}
