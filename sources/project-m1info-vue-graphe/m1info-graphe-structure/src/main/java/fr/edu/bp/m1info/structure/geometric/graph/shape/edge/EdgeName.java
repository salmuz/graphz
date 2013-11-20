package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.plane.Message;


public class EdgeName extends EdgeDecorator {

    private Message message;

    public EdgeName(AbstractEdgeShape edgeShape, Message message) {
        super(edgeShape);
        this.message = message;
    }

    public void draw(Graphics graphics) {
        edgeShape.draw(graphics);
        message.draw(graphics);
    }

}
