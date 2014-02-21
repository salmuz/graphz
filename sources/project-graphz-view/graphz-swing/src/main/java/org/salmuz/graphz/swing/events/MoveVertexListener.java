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
 * Contributor(s):  Coz Velasquez Antonio
 * 					Kalil DAHER MOHAMED
 *                  Aben Nouh Abdirazak 
 *
 * Changes
 * -------
 * 15/02/13 : Version 01;
 *
 */
package org.salmuz.graphz.swing.events;

import org.salmuz.graphz.structure.common.GraphProperties;
import org.salmuz.graphz.structure.common.ShapeUtils;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;
import org.salmuz.graphz.structure.geometric.graph.shape.EdgeShapeGraph;
import org.salmuz.graphz.structure.geometric.graph.shape.vertex.AbstractVertexShape;
import org.salmuz.graphz.structure.geometric.graph.shape.vertex.VertexShape;
import org.salmuz.graphz.structure.geometric.plane.ShapePlaneFactory;
import org.salmuz.graphz.structure.graph.edge.IEdge;
import org.salmuz.graphz.structure.graph.vertex.Vertex;
import org.salmuz.graphz.swing.design.GraphCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class MoveVertexListener extends MouseAdapter {

    private GraphCanvas canvas;
    private Vertex from;
    private boolean isSelection;
    private double x0;
    private double y0;


    public MoveVertexListener(GraphCanvas canvas) {
        super();
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x0 = e.getPoint().getX();
        y0 = e.getPoint().getY();

        from = canvas.getGraph().getVertexShape(x0, y0);
        if (from != null) {
            this.isSelection = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            Vertex toVerf = new Vertex();
            ShapeGeometric sh = ShapePlaneFactory.createShape(canvas.getGraph().getClazzVertexShape(), x1, y1);
            AbstractVertexShape vertexShape = new VertexShape(sh);
            toVerf.setVertex(vertexShape);
            if (!ShapeUtils.isVertexSamePlace(canvas.getGraph().getVertex(),
                    toVerf.getVertex().shape(), from.getVertex().parentComponent().shape())) {
                moveShapes(x1, y1, GraphProperties.VERTEX_BACKGROUND, Color.BLUE);
            } else {
                moveShapes(x0, y0, GraphProperties.VERTEX_BACKGROUND, Color.BLUE);
            }
            canvas.repaint();
            this.isSelection = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            moveShapes(x1, y1, Color.RED, Color.RED);
            canvas.repaint();
        }
    }

    private void moveShapes(double x1, double y1, Color cvertex, Color cedgec) {
        ShapeGeometric v0 = from.getVertex().parentComponent().shape();
        v0.setBackground(cvertex);
        Iterator<IEdge> itEdges = ShapeUtils.getEdgesOfVertex(canvas.getGraph().getEdges(), from);
        while (itEdges.hasNext()) {
            IEdge edge = itEdges.next();
            EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getShape().parentComponent().shape();
            ((ShapeGeometric) e0).setBackground(cedgec);
            if (e0.from().equals(v0.centre())) {
                e0.from().setX(x1);
                e0.from().setY(y1);
            } else {
                if (e0.to().equals(v0.centre())) {
                    e0.to().setX(x1);
                    e0.to().setY(y1);
                }
            }
        }
        v0.centre().setX(x1);
        v0.centre().setY(y1);
    }
}
