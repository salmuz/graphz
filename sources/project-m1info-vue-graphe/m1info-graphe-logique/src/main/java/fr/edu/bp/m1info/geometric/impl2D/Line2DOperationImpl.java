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
 *                  Aden Nouh Abdirazak
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
         /*cette class Line2OperationImpl est implementé dans la class LineOperation*/
public class Line2DOperationImpl implements LineOperation{

             /* @ return elle retourn a un point
              *@ parameter Line  elle contient comme parameter une ligne
              * cette methode est implementé dans la class LineOperation */
    public Point calculateMidPoint(Line line) {
                               /* Declaraion d'un nouveau point avec deux coordonnée (x,y)*/
        Point midPoint = new Point2D(0.0,0.0);
          /* ces instruction suivantes permettent de calculer le milieux d'une ligne avec les corrdonnée (Line,Line)
                  *   */
        double midX = (line.getStart().getX() + line.getEnd().getX()) /2;
        double midY = (line.getStart().getY() + line.getEnd().getY()) /2;

        midPoint.setX(midX);  /*le coordonnée du nouveaux point sera midPoint=(midX,midY)*/
        midPoint.setY(midY);

        return midPoint;
    }

         /* @ return elle retourn la taille ou la distance d'un point
              *@ parameter Line
              * cette methode est implementé dans la class LineOperation */
    public double calculateSize(Line line) {
                  /*on declare une variable size qui va contenir la taille de la droite */
        double size = Math.sqrt(Math.pow(line.getStart().getX() - line.getEnd().getX(),2) +
                                Math.pow(line.getStart().getY() - line.getEnd().getY(),2));

        return size;
    }
}
