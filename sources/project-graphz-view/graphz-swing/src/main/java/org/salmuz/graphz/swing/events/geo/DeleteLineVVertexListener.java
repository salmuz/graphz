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

import org.salmuz.graphz.structure.graph.ModelGeometric01;
import org.salmuz.graphz.structure.graph.vertex.Vertex;
import org.salmuz.graphz.swing.design.ModelGeometric01Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeleteLineVVertexListener  implements MouseListener {

    private ModelGeometric01Canvas canvas;

    public DeleteLineVVertexListener(ModelGeometric01Canvas canvas) {
        this.canvas = canvas;
    }

    public void mouseClicked(MouseEvent e) {

        Point p = e.getPoint();
//        ModelGeometric01.VertexVerticalLine vertex =
//                canvas.getModelGeometric().getVexterVerticalLine(p.getX(), p.getY());
//        if(vertex != null){
//            canvas.getModelGeometric().removeVexterVerticalLine(vertex);
//            canvas.repaint();
//        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}
