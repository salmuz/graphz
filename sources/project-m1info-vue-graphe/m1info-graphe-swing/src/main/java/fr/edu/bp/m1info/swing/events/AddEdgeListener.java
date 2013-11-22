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
import fr.edu.bp.m1info.structure.geometric.graph.shape.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeShape;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.edge.EdgeFactory;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.design.GraphCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEdgeListener extends MouseAdapter {

    protected GraphCanvas canvas;
    protected boolean isSelection;
    protected Vertex from;
    protected Vertex to;
    protected AbstractEdge edgeDraft;
    protected Color dragged = Color.RED;

    /**
     * cet methode permet d'ajouter une Edge dans un liste
     *
     * @param canvas
     */
    public AddEdgeListener(GraphCanvas canvas) {
        super();
        this.canvas = canvas;
        this.isSelection = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double x0 = e.getPoint().getX();
        double y0 = e.getPoint().getY();

        from = canvas.getGraph().getVertexShape(x0, y0);
        if (from != null) {
            this.isSelection = true;
            edgeDraft = EdgeFactory.createEdge(canvas.getGraph().getClazzEdge(), from, null, null);
            canvas.getDraftEdge().add(edgeDraft);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            to = canvas.getGraph().getVertexShape(x1, y1);
            if (from != null && to != null && !to.equals(from)) {
                if (!canvas.getGraph().containsEdge(from, to)) {
                    canvas.getGraph().addEdge(from, to);
                }
            }
            canvas.repaint();
        }

        from = null;
        edgeDraft = null;
        isSelection = false;
        canvas.getDraftEdge().clear();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            ShapeGeometric v0 = from.getVertex().shape();
            if (edgeDraft.getShape() == null) {
                edgeDraft.setShape(new EdgeShape(canvas.getGraph().getClazzEdgeShape(), v0.centre(), new Point2D(x1, y1)));
            } else {
                ((EdgeShapeGraph) edgeDraft.getShape().shape()).to().setX(x1);
                ((EdgeShapeGraph) edgeDraft.getShape().shape()).to().setY(y1);
            }
            edgeDraft.getShape().shape().setColor(dragged);
            canvas.repaint();
        }
    }
}
