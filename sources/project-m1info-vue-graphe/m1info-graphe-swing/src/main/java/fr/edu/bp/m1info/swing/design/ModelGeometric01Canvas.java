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
 * 12/02/13 : Version 01;
 *
 */

package fr.edu.bp.m1info.swing.design;

import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.graph.ModelGeometric01;

import java.awt.*;
import java.util.*;
import java.util.List;


public class ModelGeometric01Canvas extends Canvas {

    private ModelGeometric01 modelGeometric;
    private java.util.List<Line> draftLine;

    public ModelGeometric01Canvas(ModelGeometric01 modelGeometric) {
        this.modelGeometric = modelGeometric;
        draftLine =  new ArrayList<Line>();
    }

    @Override
    public void update(java.awt.Graphics g) {
        // super.update(g); clear et call method paint
        paint(g);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Graphics2D g2D = (Graphics2D) g;
        fr.edu.bp.m1info.structure.design.Graphics graphics = new DesignGeometric2D(g2D);

        Stroke strokeDefault = g2D.getStroke();
        g.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
//        modelGeometric.getTopLine().draw(graphics);
//        modelGeometric.getLowerLine().draw(graphics);
//        g2D.setStroke(strokeDefault);
//
//        for(Line line : draftLine){
//            line.draw(graphics);
//        }
//
//        for(ModelGeometric01.VertexVerticalLine lineVertical : modelGeometric.getLineList()){
//            lineVertical.draw(graphics);
//        }

    }

    public ModelGeometric01 getModelGeometric() {
        return modelGeometric;
    }

    public List<Line> getDraftLine() {
        return draftLine;
    }

}
