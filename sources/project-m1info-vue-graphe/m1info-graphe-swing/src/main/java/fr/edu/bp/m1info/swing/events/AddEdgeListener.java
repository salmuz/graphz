/* ==========================================
 * GrapheMultiPlateforme : a free Java graph-theory library
 * ==========================================
 * 
 * salmuz : Carranza Alarcon Yonatan Carlos
 * 
 * (C) Copyright 2013, by salmuz and Contributors.
 * 
 * Project Info:  https://github.com/salmuz/Graphes_Multi_Plateformes
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
package fr.edu.bp.m1info.swing.events;

import fr.edu.bp.m1info.structure.geometric.graph.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.graph.VertexShapeGraph;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.design.GraphCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEdgeListener extends MouseAdapter {

    protected GraphCanvas canvas;
    protected boolean isSelection;
    protected Vertex vertex0;
    protected AbstractEdge edge;
    protected Color dragged = Color.RED;

    public AddEdgeListener(GraphCanvas canvas) {
        super();
        this.canvas = canvas;
        this.isSelection = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double x0 = e.getPoint().getX();
        double y0 = e.getPoint().getY();

        vertex0 = canvas.getGraph().getVertexShape(x0, y0);
        if (vertex0 != null) {
            this.isSelection = true;
            edge = canvas.getGraph().createEdge(vertex0,null);
            canvas.getDraftEdge().add(edge);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            Vertex vertex1 = canvas.getGraph().getVertexShape(x1, y1);
            if (vertex0 != null && vertex1 != null && !vertex1.equals(vertex0)) {
 				edge.setTarget(vertex1);
                if (!canvas.getGraph().containsEdge(edge)) {
                    VertexShapeGraph v0 = (VertexShapeGraph) vertex0.getVertex();
                    VertexShapeGraph v1 = (VertexShapeGraph) vertex1.getVertex();
                    EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getEdge();
                    e0.getPointStart().setX(v0.centreShape().getX());
                    e0.getPointStart().setY(v0.centreShape().getY());
                    e0.getPointEnd().setX(v1.centreShape().getX());
                    e0.getPointEnd().setY(v1.centreShape().getY());
                    edge.getEdge().setColor(Color.BLUE);
                    canvas.getGraph().addEdge(edge);
                }

            } else {
                canvas.getGraph().removeEdge(edge);
            }
            canvas.repaint();
        }

        x1 = -1;
        y1 = -1;
        vertex0 = null;
        edge = null;
        isSelection = false;
        canvas.getDraftEdge().clear();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            VertexShapeGraph v0 = (VertexShapeGraph) vertex0.getVertex();
            EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getEdge();
            if (e0 == null) {
                edge.setEdge(ShapePlaneFactory.createShape(canvas.getGraph().getClazzEdgeShape(),
                        v0.centreShape().getX(), v0.centreShape().getY(), x1, y1));
            } else {
                e0.getPointEnd().setX(x1);
                e0.getPointEnd().setY(y1);
            }
            edge.getEdge().setColor(dragged);
            canvas.repaint();
        }
    }
}
