package org.salmuz.graphz.structure.geometric.graph.shape;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;

/**
 * Created with IntelliJ IDEA.
 * User: salmuz
 * Date: 19/11/2013
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public interface Shape {

    public void draw(Graphics graphics);

    public ShapeGeometric shape();

    public Shape parentComponent();

}
