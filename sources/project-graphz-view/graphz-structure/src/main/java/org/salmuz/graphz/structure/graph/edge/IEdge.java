package org.salmuz.graphz.structure.graph.edge;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.graph.shape.edge.AbstractEdgeShape;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

/**
 * Created with IntelliJ IDEA.
 * User: salmuz
 * Date: 19/11/2013
 * Time: 09:42
 * To change this template use File | Settings | File Templates.
 */
public interface IEdge<Value extends Number> {

    /**
     *
     * @param graphics
     */
    public void draw(Graphics graphics);

    /**
     *
     * @return
     */
    public Vertex from();

    /**
     *
     * @return
     */
    public Vertex to();

    /**
     *
     * @return
     */
    public AbstractEdgeShape getShape();

    /**
     *
     * @return
     */
    public Value weight();

    /**
     *
     * @return
     */
    public void setWeight(Value value);

    /**
     *
     * @return
     */
    public Value capacity();

    /**
     *
     * @return
     */
    public Value flow();

}
