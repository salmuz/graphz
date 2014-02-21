package org.salmuz.graphz.structure.geometric.graph.shape.edge;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.graph.shape.EdgeShapeGraph;
import org.salmuz.graphz.structure.geometric.plane.ShapePlaneFactory;

public class EdgeDirected extends EdgeDecorator{

    public EdgeDirected(AbstractEdgeShape edgeShape) {
        super(edgeShape);
        AbstractEdgeShape parent = (AbstractEdgeShape) edgeShape.parentComponent();
        this.shape = ShapePlaneFactory.createShape(parent.shape.getClass(), parent.from(), parent.to());
    }

    public void draw(Graphics graphics) {
        super.draw(graphics);
        AbstractEdgeShape parent = (AbstractEdgeShape) edgeShape.parentComponent();
        ((EdgeShapeGraph)shape).from().setX(parent.from().getX());
        ((EdgeShapeGraph)shape).from().setY(parent.from().getY());
        ((EdgeShapeGraph)shape).to().setX(parent.to().getX());
        ((EdgeShapeGraph)shape).to().setY(parent.to().getY());
        shape.draw(graphics);
    }

}
