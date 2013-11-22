package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Arrow;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.shape.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.plane.LineArrow;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;

public class EdgeDirected extends EdgeDecorator{

    public EdgeDirected(AbstractEdgeShape edgeShape) {
        super(edgeShape);
        AbstractEdgeShape parent = (AbstractEdgeShape) edgeShape.parentComponent();
        this.shape = ShapePlaneFactory.createShape(LineArrow.class, parent.from(), parent.to());
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
