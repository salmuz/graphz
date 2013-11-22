package fr.edu.bp.m1info.structure.geometric.graph.shape;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;

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
