package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.plane.LineArrow;

public abstract class DirectedEdge extends EdgeDecorator{

    private LineArrow lineArrow;

    public DirectedEdge(AbstractEdgeShape edgeShape,LineArrow lineArrow) {
        super(edgeShape);
        this.lineArrow = lineArrow;
    }

    public void draw(Graphics graphics) {
        edgeShape.draw(graphics);
        lineArrow.draw(graphics);
    }
}
