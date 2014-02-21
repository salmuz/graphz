package org.salmuz.graphz.structure.geometric.graph.shape.edge;

import org.salmuz.graphz.structure.common.GraphProperties;
import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.plane.*;


public class EdgeName extends EdgeDecorator {

    private String message;
    private final static int SHIFT = 5;

    /**
     *
     * @param edgeShape
     * @param message
     */
    public EdgeName(AbstractEdgeShape edgeShape, String message) {
        super(edgeShape);
        this.message = message;
        AbstractEdgeShape parent = (AbstractEdgeShape) edgeShape.parentComponent();
        if(parent.shape() instanceof Line)
            createWeightLine(parent.from(), parent.to());
        else
            if(parent.shape() instanceof Curve)
                createWeightCurve(new Point2D(0.0,0.0));

    }

    /**
     *
     * @param control
     */
    public void createWeightCurve(Point control) {
        shape = (Message) ShapePlaneFactory.createShape(Message.class,control.getX(),control.getY());
        if(this.message == null)
            this.message = "edge empty";
        ((Message)shape).setMessage(message);
        shape.setColor(GraphProperties.EDGE_NAME_COLOR);
    }

    /**
     *
     * @param from
     * @param to
     */
    public void createWeightLine(Point from, Point to) {
        Line line = new Line(from,to);
        Point point = line.centre();
        double x = point.getX() - SHIFT;
        double y = point.getY() - SHIFT;
        if (shape == null) {
            shape = (Message) ShapePlaneFactory.createShape(Message.class, x, y);
        } else {
            ((Message)shape).getPoint().setX(x);
            ((Message)shape).getPoint().setY(y);
        }

        if(this.message == null)
            this.message = "edge empty";

        ((Message)shape).setMessage(message.toString());
        shape.setColor(GraphProperties.EDGE_NAME_COLOR);
    }

    /**
     *
     * @param graphics
     */
    public void draw(Graphics graphics) {
        super.draw(graphics);
        AbstractEdgeShape parent = (AbstractEdgeShape) edgeShape.parentComponent();
        if(parent.shape() instanceof Line){
            Line line = new Line(((EdgeShape)parent).from(),((EdgeShape)parent).to());
            ((Message)shape).getPoint().setX(line.centre().getX()- SHIFT);
            ((Message)shape).getPoint().setY(line.centre().getY() - SHIFT);
        }else{
            Curve curve = (Curve) parent.shape();
            ((Message)shape).getPoint().setX(curve.getControl().getX());
            ((Message)shape).getPoint().setY(curve.getControl().getY());
        }
        ((Message)shape).setMessage(message);
        shape.draw(graphics);
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
