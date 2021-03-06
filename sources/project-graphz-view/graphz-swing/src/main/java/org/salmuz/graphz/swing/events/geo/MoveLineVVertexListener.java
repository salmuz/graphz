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
 * 12/02/13 : Version 01;
 *
 */
package org.salmuz.graphz.swing.events.geo;

import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.plane.Point2D;
import org.salmuz.graphz.structure.graph.ModelGeometric01;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

import java.awt.event.MouseAdapter;

public class MoveLineVVertexListener extends MouseAdapter {
                   /*
    private ModelGeometric01Canvas canvas;
    private ModelGeometric01.VertexVerticalLine vertexLine;
    private boolean isSelection;
    private Point debut;
    private GraphCanvas canvasGraphe;
    private JScrollPane jspGraphe;

    public MoveLineVVertexListener(ModelGeometric01Canvas canvas, GraphCanvas canvasGraphe,JScrollPane jspGraphe) {
        this.canvas = canvas;
        this.canvasGraphe = canvasGraphe;
        this.jspGraphe = jspGraphe;
        isSelection = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double x0 = e.getPoint().getX();
        double y0 = e.getPoint().getY();

        vertexLine = canvas.getModelGeometric().getVexterVerticalLine(x0, y0);
        if (vertexLine != null) {
            if (canvas.getModelGeometric().isLowerSearch()) {
                debut = (Point) vertexLine.getLower().getCenter().clone();
            } else {
                if (canvas.getModelGeometric().isTopSearch()) {
                    debut = (Point) vertexLine.getTop().getCenter().clone();
                }
            }
            this.isSelection = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double x1 = e.getPoint().getX();

        if (this.isSelection) {
            Point point = new Point2D(x1, debut.getY());
            if (canvas.getModelGeometric().isTopSearch()) {
                if (!canvas.getModelGeometric().isVertexInSamePlaceTop(point, vertexLine)) {
                    moveShapes(x1, Color.ORANGE, Color.RED);
                    canvas.getModelGeometric().modifyVertexVerticalLine(vertexLine,jspGraphe.getBounds());
                } else {
                    moveShapes(debut.getX(), Color.ORANGE, Color.RED);
                }
            } else {
                if (canvas.getModelGeometric().isLowerSearch()) {
                    if (!canvas.getModelGeometric().isVertexInSamePlaceLower(point, vertexLine)) {
                        moveShapes(x1, Color.ORANGE, Color.RED);
                        canvas.getModelGeometric().modifyVertexVerticalLine(vertexLine,jspGraphe.getBounds());
                    } else {
                        moveShapes(debut.getX(), Color.ORANGE, Color.RED);
                    }
                }
            }

            canvas.repaint();
            canvasGraphe.repaint();
        }
        this.isSelection = false;
        canvas.getModelGeometric().setLowerSearch(false);
        canvas.getModelGeometric().setTopSearch(false);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double x1 = e.getPoint().getX();

        if (this.isSelection) {
            moveShapes(x1, Color.RED, Color.RED);
            canvas.repaint();
        }
    }

    private void moveShapes(double x1, Color vertexC, Color lineC) {
        ModelGeometric01.VertexVerticalLine verticalLine = vertexLine;
        verticalLine.getLine().setColor(lineC);
        if (canvas.getModelGeometric().isTopSearch()) {
            verticalLine.getTop().setBackground(vertexC);
            verticalLine.getLine().getStart().setX(x1);
            verticalLine.getTop().getCenter().setX(x1);
            verticalLine.getMessageTop().getPoint().setX(x1);
        } else {
            if (canvas.getModelGeometric().isLowerSearch()) {
                verticalLine.getLower().setBackground(vertexC);
                verticalLine.getLine().getEnd().setX(x1);
                verticalLine.getLower().getCenter().setX(x1);
                verticalLine.getMessageLower().getPoint().setX(x1);
            } else {
                throw new UnsupportedOperationException("Unsupported the moved");
            }
        }

    }                         */
}
