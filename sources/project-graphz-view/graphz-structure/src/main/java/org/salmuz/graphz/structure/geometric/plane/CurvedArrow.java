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
 * Contributor(s):
 *
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
 * Nous avons une class appelle CurvedArrow et qui herite certaine methode de la class Curve
 *et elle est implementé dans la class Arrow
 */
public class CurvedArrow extends Curve implements Arrow{

    private PLACE_OF_ARROW placeOfArrow;
    private Color cfecha;
    private double margin;

    /**
     * C'est un constructeur
     * @parameter start,end,firstCurve,secondCurve cette methode contient 4 parameter
     * et ces point serons herité de la class curve
     */
    public CurvedArrow(Point start, Point end, PLACE_OF_ARROW placeOfArrow) {
        super(start, end);
        this.placeOfArrow = placeOfArrow;
        this.margin = ConstantsGeometric.RADIO;
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
     * cette methode permettent de dessiner la graphic
     *
     *  @parameter graphic
     *
     */
    public void draw(Graphics graphic) {
        super.draw(graphic);  // designer la curve
        graphic.draw(this);
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
}
