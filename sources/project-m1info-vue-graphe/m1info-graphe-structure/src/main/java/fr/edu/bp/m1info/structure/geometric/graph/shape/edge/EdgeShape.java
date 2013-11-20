package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;

public class EdgeShape extends AbstractEdgeShape{

    public EdgeShape(ShapeGeometric shape) {
        this.shape = shape;
    }

    public EdgeShape(Class<? extends ShapeGeometric> clazz, Point from, Point to){
        this(ShapePlaneFactory.createShape(clazz,from.getX(), from.getY(), to.getX(),to.getY()));
    }

    public void draw(Graphics graphics) {
        shape.draw(graphics);
    }
}
