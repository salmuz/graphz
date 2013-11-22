package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;

public class EdgeShape extends AbstractEdgeShape{

    protected Point from;
    protected Point to;

    public EdgeShape(Point from,Point to){
        this.from = from;
        this.to = to;
    }

    public EdgeShape(Class<? extends ShapeGeometric> clazz, Point from, Point to){
        this(from,to);
        this.shape = ShapePlaneFactory.createShape(clazz, from.getX(), from.getY(), to.getX(), to.getY());
    }

    public void draw(Graphics graphics) {
        shape.draw(graphics);
    }

    @Override
    public Point to() {
        return to;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Point from() {
        return from;    //To change body of overridden methods use File | Settings | File Templates.
    }
}
