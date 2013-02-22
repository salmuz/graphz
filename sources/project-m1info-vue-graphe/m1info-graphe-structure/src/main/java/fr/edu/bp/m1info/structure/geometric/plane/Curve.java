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
 * 22/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.geometric.plane;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.EdgeShapeGraph;

/**
 * nous avons une class appelle curve et qui herite certaine methode de la class ShapeGeometric
 */
public class Curve extends ShapeGeometric implements EdgeShapeGraph{



    private Point start;
    private Point end;
    private Point firstCurve;
    private Point secondCurve;

    /**
     * C'est un constructeur
     *
     * @parameter start,end,firstCurve,secondCurve cette methode contient 4 parameter
     */
    public Curve(Point start, Point end, Point firstCurve, Point secondCurve) {
        this.start = start;
        this.end = end;
        this.firstCurve = firstCurve;
        this.secondCurve = secondCurve;
    }
    /**
     * cette methode permette de recupére le contenu du variable firstCurve
     *
     *  @return elle retourn le point firstCurve
     *
     * */
    public Point getFirstCurve() {
        return firstCurve;
    }
    /**
     *  cette methode permette de modifier le contenu du variable FirstCurve
     *
     *  @parameter FirstCurve
     */
    public void setFirstCurve(Point firstCurve) {
        this.firstCurve = firstCurve;
    }
     /**
      *  cette methode permette de recupére le contenu du variable secondCurve
      *
      *  @return elle retourn le point secondCurve
      */
    public Point getSecondCurve() {
        return secondCurve;
    }

    /**
     *  cette methode permette de modifier le contenu du variable secondCurve
     *
     *  @parameter secondCurve
     */
    public void setSecondCurve(Point secondCurve) {
        this.secondCurve = secondCurve;
    }
    /**
     *  cette methode permette de recupére le contenu du variable start
     *
     *  @return elle retourn le point start
     */
    public Point getStart() {
        return start;
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
     * cette methode permette de recupére le contenu du variable end
     *
     *  @return elle retourn le point end
     */
    public Point getEnd() {
        return end;
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
    public Point getPointStart() {
        return this.start;
    }
    /**
     * C'est une methode qui permet de recuperer le point de fin d'un curve
     *
     * @return
     */
    public Point getPointEnd() {
        return this.end;
    }
}
