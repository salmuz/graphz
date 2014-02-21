package fr.edu.bp.m1info.structure.graph.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.AbstractEdgeShape;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

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
