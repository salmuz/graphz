/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
 * ==========================================
 * 
 * salmuz : Carranza Alarcon Yonatan Carlos
 * 
 * (C) Copyright 2013, by salmuz and Contributors.
 * 
 * Project Info:  https://github.com/salmuz/Cross-Platform-GraphZ
 * Project Creator:  salmuz (https://www.assembla.com/spaces/salmuz-java) 
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc.,
 * 
 * ------------------
 * Point.java
 * ------------------
 * (C) Copyright 2013, by salmuz and Contributors
 *
 * Original Author: Carranza Alarcon Yonatan Carlos
 * Contributor(s):  
 *
 * Changes
 * -------
 *
 */

package org.salmuz.graphz.structure.geometric.graph.shape.vertex;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;
import org.salmuz.graphz.structure.geometric.plane.Message;
import org.salmuz.graphz.structure.geometric.plane.ShapePlaneFactory;

public class VertexName extends VertexDecorator{

    private String name;

    public VertexName(AbstractVertexShape abstractVertexShape, String name) {
        super(abstractVertexShape);
        this.name = name;
        createShape(abstractVertexShape.parentComponent().shape());
    }

    private void createShape(ShapeGeometric vertex) {
        Point point = vertex.centre();
        int less = getLess(name);
        if (shape == null) {
            shape = ShapePlaneFactory.createShape(Message.class,
                    point.getX() - less, point.getY() + 5);
            ((Message) shape).setMessage(name.toString());
        } else {
            ((Message) shape).getPoint().setX(point.getX() - less);
            ((Message) shape).getPoint().setY(point.getY() + 5);
        }
    }

    private int getLess(String value) {
        if (value instanceof String) {
            Integer val = Integer.valueOf(value.toString());
            return (val < 10 ? 4 : (val < 100) ? 7 : 10);
        }
        return 10;
    }

    public void draw(Graphics graphics) {
        super.draw(graphics);
        createShape(abstractVertexShape.parentComponent().shape());
        shape.draw(graphics);
    }

}
