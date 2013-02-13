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
import fr.edu.bp.m1info.structure.geometric.graph.VertexShapeGraph;

/*nous avons une class appelle Rectangle et qui herite certaine methode de la class ShapeGeometric
      * et qui sera implementé dans la class VertexShapeGraph*/
public class Rectangle extends ShapeGeometric implements VertexShapeGraph {

    private Point point;
    private double width;
    private double height;

    /*@parameter Point point, double width, double height cette methode contient 3 parameter
           */
    public Rectangle(Point point, double width, double height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }
       /*  @return elle retourn point
        * cette methode permette de recupére le contenu du variable point*/
    public Point getPoint() {
        return point;
    }
            /* @parameter point
   * cette methode permette de modifier le contenu du variable point*/
    public void setPoint(Point point) {
        this.point = point;
    }
     /*  @return elle retourn width
        * cette methode permette de recupére le contenu du variable width*/
    public double getWidth() {
        return width;
    }
         /* @parameter width
   * cette methode permette de modifier le contenu du variable width*/
    public void setWidth(double width) {
        this.width = width;
    }
         /*  @return elle retourn height
        * cette methode permette de recupére le contenu du variable height*/
    public double getHeight() {
        return height;
    }
      /* @parameter height
   * cette methode permette de modifier le contenu du variable height*/
    public void setHeight(double height) {
        this.height = height;
    }
      /*@graphic
      * permettent de mettre le poid la longueur et le point sur la graphic*/
    @Override
    public void draw(Graphics graphics) {
        graphics.draw(this);
    }

}
