package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.shape.Shape;

public abstract class AbstractEdgeShape implements Shape {

    protected ShapeGeometric shape;

    public ShapeGeometric shape() {
        return shape;
    }
}
