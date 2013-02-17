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
import java.util.Iterator;

public class MoveVertexListener extends MouseAdapter {

    private GraphCanvas canvas;
    private Vertex vertex0;
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

        vertex0 = canvas.getGraph().getVertexShape(x0, y0);
        if (vertex0 != null) {
            this.isSelection = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            Vertex vertex1 = new Vertex();
            vertex1.setVertex(ShapePlaneFactory.createShape(canvas.getGraph().getClazzVertexShape(), x1, y1));
             if(!canvas.getGraph().isVertexSamePlace(vertex1,vertex0)){
                moveShapes(x1,y1,Color.ORANGE,Color.BLUE);
             }else{
                moveShapes(x0, y0, Color.ORANGE, Color.BLUE);
             }
            canvas.repaint();
            this.isSelection=false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            moveShapes(x1,y1,Color.RED,Color.RED);
            canvas.repaint();
        }
    }

    private void moveShapes(double x1,double y1,Color vertex,Color edgec) {
        vertex0.getVertex().setBackground(vertex);
        VertexShapeGraph v0 = (VertexShapeGraph) vertex0.getVertex();
        Iterator<AbstractEdge> itEdges = canvas.getGraph().getEdgesOfVertex(vertex0).iterator();
        while (itEdges.hasNext()) {
            AbstractEdge edge = itEdges.next();
            EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getEdge();
            edge.getEdge().setColor(edgec);
            if (e0.getPointEnd().equals(v0.centreShape())) {
                e0.getPointEnd().setX(x1);
                e0.getPointEnd().setY(y1);
            } else {
                if(e0.getPointStart().equals(v0.centreShape())){
                    e0.getPointStart().setX(x1);
                    e0.getPointStart().setY(y1);
                }
            }
        }
        // the new center of circle
        v0.centreShape().setX(x1);
        v0.centreShape().setY(y1);
    }
}
