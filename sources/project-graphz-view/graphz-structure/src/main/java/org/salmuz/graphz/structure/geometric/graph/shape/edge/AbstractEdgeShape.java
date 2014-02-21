package org.salmuz.graphz.structure.geometric.graph.shape.edge;

import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;
import org.salmuz.graphz.structure.geometric.graph.shape.Shape;

public abstract class AbstractEdgeShape implements Shape {

    protected ShapeGeometric shape;

    public ShapeGeometric shape() {
        return shape;
    }

    public Shape parentComponent(){
        return this;
    }

    public Point from(){
        throw new UnsupportedOperationException("Operation not support in abstract class");
    }

    public Point to(){
        throw new UnsupportedOperationException("Operation not support in abstract class");
    }
}
