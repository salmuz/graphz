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
 *                  Aden Nouh Abdirazak
 * Changes
 * -------
 * 20/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.geometric.plane;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.shape.EdgeShapeGraph;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * nous avons une class appelle Line et qui herite certaine methode de la class ShapeGeometric
 * et elle est implementé dans la class EdgeShapeGraph
 */
public class Line extends ShapeGeometric implements EdgeShapeGraph{

    protected Point start;
    protected Point end;

    /**
     * C'est un constructeur
     *
     * @parameter start, end, cette methode contient 2 paramete
     * et ces point serons herité de la class ShapeGeometric
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.color = Color.BLUE;
        this.background = Color.BLUE;
    }

    /**
     * cette methode permette de modifier le contenu du variable start
     *
     * @parameter start
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * Cette methode permette de modifier le contenu du variable end
     *
     * @parameter end
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * Cette methode permettent de dessiner la graphic
     *
     * @parameter graphics
     */
    @Override
    public void draw(Graphics graphics) {
        this.shape = graphics.draw(this);
    }

    /**
     * C'est une methode qui permet de recuperer le point de depart du ligne
     *
     * @return le point
     */
    public Point from() {
        return this.start;
    }

    /**
     * C'est une methode qui permet de recuperer le point de fin du ligne
     *
     * @return
     */
    public Point to() {
        return this.end;
    }

    /**
     * C'est une methode pour verifier si les objets sont different
     *
     * @param o c'est l'objet de la classe quand verifie
     * @return un boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (end != null ? !end.equals(line.end) : line.end != null) return false;
        if (start != null ? !start.equals(line.start) : line.start != null) return false;

        return true;
    }

    /**
     * C'est une methode qui decrit le code ou le reference de la classe
     *
     * @return un code
     */
    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    /**
     * c'est une methode qui traduit le variable en String
     *
     * @return un string avec le variable
     */
    @Override
    public Point centre() {
        Point midPoint = new Point2D(0.0, 0.0);
        double midX = (start.getX() + end.getX()) / 2;
        double midY = (start.getY() + end.getY()) / 2;
        midPoint.setX(midX);
        midPoint.setY(midY);
        return midPoint;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean intersect(ShapeGeometric shapeGeometric) {
        Line line = (Line) shapeGeometric;

        if (this.shape == null) {
            return false;
        }

        return ((Line2D)this.shape).intersectsLine(line.from().getX(),line.from().getY(),
                line.to().getX(),line.to().getY());
    }
}
