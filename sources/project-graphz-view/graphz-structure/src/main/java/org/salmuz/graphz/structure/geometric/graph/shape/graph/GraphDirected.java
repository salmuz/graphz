package org.salmuz.graphz.structure.geometric.graph.shape.graph;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;


public class GraphDirected extends GraphDecorator {

    public GraphDirected(AbstractGraphShape graphShape) {
        super(graphShape);
    }

    public void draw(Graphics graphics) {
       graphShape.draw(graphics);

    }

    public ShapeGeometric shape() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
