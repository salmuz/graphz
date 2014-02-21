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
 *                  Aden Nouh Abdirazak
 * Changes
 * -------
 * 22/01/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.geometric.plane;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;
import org.salmuz.graphz.structure.geometric.graph.shape.EdgeShapeGraph;

import java.awt.*;

/**
 * nous avons une class appelle curve et qui herite certaine methode de la class ShapeGeometric
 */
public class Curve extends ShapeGeometric implements EdgeShapeGraph{

    private Point start;
    private Point end;
    private Point control;
    private double atanCurve;

    /**
     * C'est un constructeur
     *
     * @parameter start,end,firstCurve,secondCurve cette methode contient 4 parameter
     */
    public Curve(Point start, Point end) {
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
     * @parameter graphic
     */
    @Override
    public void draw(Graphics graphics) {
       graphics.draw(this);
    }

    /**
     * C'est une methode qui permet de recuperer le point de depart d'un curve
     *
     * @return
     */
    public Point from() {
        return this.start;
    }
    /**
     * C'est une methode qui permet de recuperer le point de fin d'un curve
     *
     * @return
     */
    public Point to() {
        return this.end;
    }

    /**
     *
     * @return
     */
    public Point centre() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param atanCurve
     */
    public void setAtanCurve(double atanCurve) {
        this.atanCurve = atanCurve;
    }

    /**
     *
     * @return
     */
    public double getAtanCurve() {
        return atanCurve;
    }

    /**
     *
     * @return
     */
    public Point getControl() {
        return control;
    }

    /**
     *
     * @param control
     */
    public void setControl(Point control) {
        this.control = control;
    }
}
