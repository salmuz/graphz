package org.salmuz.graphz.structure.geometric.graph.shape.vertex;

import org.salmuz.graphz.structure.geometric.ShapeGeometric;
import org.salmuz.graphz.structure.geometric.graph.shape.Shape;

public abstract class AbstractVertexShape implements Shape{

    protected ShapeGeometric shape;

    public ShapeGeometric shape() {
        return shape;
    }

    public Shape parentComponent() {
        return this;
    }
}
