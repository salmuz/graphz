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
 * 					Moussa Kalil 
 *
 * Changes
 * -------
 * 23/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.geometric.impl2D;

import fr.edu.bp.m1info.geometric.LineOperation;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;

public class Line2DOperationImpl implements LineOperation{

    public Point calculateMidPoint(Line line) {
        Point midPoint = new Point2D(0.0,0.0);

        double midX = (line.getStart().getX() + line.getEnd().getX()) /2;
        double midY = (line.getStart().getY() + line.getEnd().getY()) /2;

        midPoint.setX(midX);
        midPoint.setY(midY);

        return midPoint;
    }

    public double calculateSize(Line line) {

        double size = Math.sqrt(Math.pow(line.getStart().getX() - line.getEnd().getX(),2) +
                                Math.pow(line.getStart().getY() - line.getEnd().getY(),2));

        return size;
    }
}
