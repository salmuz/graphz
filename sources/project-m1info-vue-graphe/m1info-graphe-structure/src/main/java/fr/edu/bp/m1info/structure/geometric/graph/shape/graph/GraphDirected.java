package fr.edu.bp.m1info.structure.geometric.graph.shape.graph;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;


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
