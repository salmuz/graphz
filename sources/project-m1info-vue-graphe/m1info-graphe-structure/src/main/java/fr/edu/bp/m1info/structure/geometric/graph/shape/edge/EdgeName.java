package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.common.GraphProperties;
import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.graph.shape.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.Message;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;


public class EdgeName extends EdgeDecorator {

    private String message;

    public EdgeName(AbstractEdgeShape edgeShape, String message) {
        super(edgeShape);
        this.message = message;
        AbstractEdgeShape parent = (AbstractEdgeShape) edgeShape.parentComponent();
        createWeight(parent.from(), parent.to());
    }

    public void createWeight(Point from, Point to) {
        Line line = new Line(from,to);
        Point point = line.centre();
        if (shape == null) {
            shape = (Message) ShapePlaneFactory.createShape(Message.class, point.getX(), point.getY());
        } else {
            ((Message)shape).getPoint().setX(point.getX());
            ((Message)shape).getPoint().setY(point.getY());
        }

        if(this.message == null)
            this.message = "edge empty";

        ((Message)shape).setMessage(message.toString());
        shape.setColor(GraphProperties.EDGE_NAME_COLOR);
    }

    public void draw(Graphics graphics) {
        super.draw(graphics);
        AbstractEdgeShape parent = (AbstractEdgeShape) edgeShape.parentComponent();
        Line line = new Line(((EdgeShape)parent).from(),((EdgeShape)parent).to());
        ((Message)shape).getPoint().setX(line.centre().getX());
        ((Message)shape).getPoint().setY(line.centre().getY());
        shape.draw(graphics);
    }

}
