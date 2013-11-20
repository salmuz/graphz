package fr.edu.bp.m1info.structure.graph.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

/**
 * Created with IntelliJ IDEA.
 * User: salmuz
 * Date: 19/11/2013
 * Time: 09:42
 * To change this template use File | Settings | File Templates.
 */
public interface IEdge<Value,Shape> {

    /**
     *
     * @param graphics
     */
    public void draw(Graphics graphics);

    /**
     *
     * @return
     */
    public Vertex getSource();

    /**
     *
     * @return
     */
    public Vertex getTarget();

//    public Value getCapacity();
//
//    public void setCapacity(Value value);
//
//    public Value getWeight();
//
//    public void setWeight(Value value);

}
