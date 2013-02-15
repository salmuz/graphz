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

import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.design.GraphCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEdgeListener extends MouseAdapter {

    private GraphCanvas canvas;
    private double x0;
    private double y0;
    private double x1;
    private double y1;
    private boolean isSelection;
    private Vertex vertex0;

    public AddEdgeListener(GraphCanvas canvas) {
        super();
        this.canvas = canvas;
        this.isSelection = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x0 = e.getPoint().getX();
        y0 = e.getPoint().getY();

        vertex0 = canvas.getGraph().getVertexShape(x0, y0);
        if (vertex0 != null) {
            this.isSelection = true;
        }

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        x1 = e.getPoint().getX();
        y1 = e.getPoint().getY();

        Vertex vertex1 = canvas.getGraph().getVertexShape(x1, y1);
        if (vertex0 !=null && vertex1 != null && !vertex1.equals(vertex0)) {
            AbstractEdge edge = canvas.getGraph().addEdge(vertex0,vertex1);
            edge.setEdge(ShapePlaneFactory.createShape(canvas.getGraph().getClazzEdgeShape(),
                    vertex0.getVertex().centreShape().getX(),vertex0.getVertex().centreShape().getY(),
                    vertex1.getVertex().centreShape().getX(),vertex1.getVertex().centreShape().getY()));
            canvas.getGraph().getEdgeSet().add(edge);
            canvas.repaint();
        }

        x0 = -1; y0 = -1;
        x1 = -1; y1 = -1;
        vertex0 = null;

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
