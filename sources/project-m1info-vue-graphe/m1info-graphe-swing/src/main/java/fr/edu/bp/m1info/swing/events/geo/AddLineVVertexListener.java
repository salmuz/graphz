/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
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
 * 12/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.swing.events.geo;

import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.swing.design.GraphCanvas;
import fr.edu.bp.m1info.swing.design.ModelGeometric01Canvas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddLineVVertexListener extends MouseAdapter {

    private ModelGeometric01Canvas canvas;
    private GraphCanvas canvasGraphe;
    protected boolean isSelection;
    private Line draftLine;
    private JScrollPane jspGraphe;

    public AddLineVVertexListener(ModelGeometric01Canvas canvas, GraphCanvas canvasGraphe, JScrollPane jspGraphe) {
        this.canvas = canvas;
        this.canvasGraphe = canvasGraphe;
        this.jspGraphe = jspGraphe;
        isSelection = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double x0 = e.getPoint().getX();
        double y0 = e.getPoint().getY();
        draftLine = new Line(new Point2D(x0, y0), new Point2D(x0, y0));
        canvas.getDraftLine().add(draftLine);
        isSelection = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            draftLine.to().setX(x1);
            draftLine.to().setY(y1);
//            if (canvas.getModelGeometric().intersect(draftLine)) {
//                canvas.getModelGeometric().addLineVertex(
//                        new Line((Point) draftLine.getStart().clone(), (Point) draftLine.sink().clone()),
//                        null, jspGraphe.getBounds(),null);
//            }
            canvas.repaint();
            canvasGraphe.repaint();
        }

        x1 = -1;
        y1 = -1;
        isSelection = false;
        canvas.getDraftLine().clear();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            draftLine.to().setX(x1);
            draftLine.to().setY(y1);
            canvas.repaint();
        }
    }
}
