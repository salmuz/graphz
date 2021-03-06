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
 * 21/01/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.geometric.plane;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.Arrow;
import org.salmuz.graphz.structure.geometric.ConstantsGeometric;
import org.salmuz.graphz.structure.geometric.Point;

import java.awt.*;

/**
 * nous avons une class appelle LineArrow et qui herite certaine methode de la class Line
 * et elle est implementé dans la class  Arrow et  EdgeShapeGraph
 */
public class LineArrow extends Line implements Arrow {

    private PLACE_OF_ARROW placeOfArrow;
    private double margin;
    private Color cfecha;

    /**
     * C'est le constructeur de la classe
     *
     * @parameter start,end,placeOfArrow cette methode contient 3 parameter
     * et les deux premier  points serons herité de la class curve
     */
    public LineArrow(Point start, Point end, PLACE_OF_ARROW placeOfArrow) {
        super(start, end);
        this.margin = ConstantsGeometric.RADIO;
        this.placeOfArrow = placeOfArrow;
        this.cfecha = Color.GRAY;
    }

    /**
     * cette methode permette de recupére le contenu du variable placeOfArrow
     *
     *  @return elle retourn placeOfArrow
     */
    public PLACE_OF_ARROW getPlaceOfArrow() {
        return placeOfArrow;
    }
    /**
     *  cette methode permette de modifier le contenu du variable placeOfArrow
     *
     *  @parameter placeOfArrow
     */
    public void setPlaceOfArrow(PLACE_OF_ARROW placeOfArrow) {
        this.placeOfArrow = placeOfArrow;
    }

    /**
     * cette methode permette de recupére le contenu du variable cfecha
     *
     * @return qui retoune un color
     */
    public Color getCfecha() {
        return cfecha;
    }

    /**
     * cette methode permette de modifier le contenu du variable cfecha qui est un couleur
     *
     * @param cfecha      qui est un couleur
     *
     */
    public void setCfecha(Color cfecha) {
        this.cfecha = cfecha;
    }

    /**
     *
     * @return
     */
    public double getMargin() {
        return margin;
    }

    /**
     *
     * @param margin
     */
    public void setMargin(double margin) {
        this.margin = margin;
    }

    /**
     * cette methode permettent de dessiner le ligne et le fleche
     *
     * @parameter graphics qui permet de tracer grace a cet objet
     */
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);  // designer le ligne
        graphics.draw(this); // ajouter seulement fleche
    }
}
