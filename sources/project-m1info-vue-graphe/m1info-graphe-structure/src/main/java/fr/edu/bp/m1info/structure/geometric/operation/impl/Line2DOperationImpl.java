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
package fr.edu.bp.m1info.structure.geometric.operation.impl;

import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.operation.LineOperation;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;

/**
 * cette class Line2OperationImpl implemente l'interface LineOperation
 */
public class Line2DOperationImpl implements LineOperation {

    /**
     * cette methode est implementé dans la class LineOperation
     *
     * @return elle retourn a un point
     * @parameter Line  elle contient comme parameter une ligne
     */
    public Point calculateMidPoint(Line line) {
        /* Declaraion d'un nouveau point avec deux coordonnée (x,y)*/
        Point midPoint = new Point2D(0.0, 0.0);

        double midX = (line.from().getX() + line.to().getX()) / 2;
        double midY = (line.from().getY() + line.to().getY()) / 2;

        midPoint.setX(midX);  /*le coordonnée du nouveaux point sera midPoint=(midX,midY)*/
        midPoint.setY(midY);

        return midPoint;
    }

    /**
     * cette methode est implementé dans la class LineOperation
     *
     * @return elle retourn la taille ou la distance d'un point
     * @parameter Line
     */
    public double calculateSize(Line line) {
        /*on declare une variable size qui va contenir la taille de la droite */
        double size = Math.sqrt(Math.pow(line.from().getX() - line.to().getX(), 2) +
                Math.pow(line.from().getY() - line.to().getY(), 2));

        return size;
    }


    public Point getPointIntersectLines(Line pLine01, Line pLine02) {
        double px = pLine01.to().getX() - pLine01.from().getX();
        double py = pLine01.to().getY() - pLine01.from().getY();
        double qx = pLine02.to().getX() - pLine02.from().getX();
        double qy = pLine02.to().getY() - pLine02.from().getY();

        double D = px * qy - py * qx;
        if (D == 0) return null;

        double pu = -((pLine01.from().getX() - pLine02.from().getX()) * qy -
                (pLine01.from().getY() - pLine02.from().getY()) * qx) / D;
        if (pu < 0 || pu > 1) return null;

        double du = ((pLine02.from().getX() - pLine01.from().getX()) * py -
                (pLine02.from().getY() - pLine01.from().getY()) * px) / D;
        if (du < 0 || du > 1) return null;

        return new Point2D(pLine01.from().getX() + pu * (pLine01.to().getX() - pLine01.from().getX()),
                pLine01.from().getY() + pu * (pLine01.to().getY() - pLine01.from().getY()));
    }
}
