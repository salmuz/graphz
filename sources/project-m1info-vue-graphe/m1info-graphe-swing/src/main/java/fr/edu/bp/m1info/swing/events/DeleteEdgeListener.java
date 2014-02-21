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
 * 16/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.swing.events;

import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.design.GraphCanvas;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DeleteEdgeListener extends AddEdgeListener {

    public DeleteEdgeListener(GraphCanvas canvas) {
        super(canvas);
        super.dragged = Color.BLACK;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double x1 = e.getPoint().getX();
        double y1 = e.getPoint().getY();

        if (this.isSelection) {
            to = canvas.getGraph().getVertexShape(x1, y1);
            if (from != null && to != null && !to.equals(from)) {
                edgeDraft.setTarget(to);
                if (canvas.getGraph().containsEdge(edgeDraft)) {
                    canvas.getGraph().removeEdge(from, to);
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
        super.mouseDragged(e);
    }
}
