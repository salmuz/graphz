package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;

public abstract class EdgeDecorator extends AbstractEdgeShape {

    protected AbstractEdgeShape edgeShape;

    public EdgeDecorator(AbstractEdgeShape edgeShape) {
        this.edgeShape = edgeShape;
    }
}
