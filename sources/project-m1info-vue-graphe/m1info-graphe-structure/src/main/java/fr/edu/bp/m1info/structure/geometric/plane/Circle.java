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
 * 20/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.geometric.plane;


import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.VertexShapeGraph;

/*nous avons une class appelle circle et qui herite certaine methode de la class ShapeGeometric
       et elle est implementé dans la class VertexShapeGraph*/
public class Circle extends ShapeGeometric implements VertexShapeGraph {

           /*on a declare deux variable privée une etant un point et l'autre contient un reel*/

    private Point center;
    private double radio;

           /*@parameter center et radio cette methode contient deux parameter un point et un reel*/
    public Circle(Point center, double radio) {
        this.center = center;
        this.radio = radio;
    }
        /*  @return elle retourn le point center
        * cette methode permette de recupére le contenu du variable center*/
    public Point getCenter() {
        return center;
    }

   /* @parameter center
   * cette methode permette de modifier le contenu du variable center*/
    public void setCenter(Point center) {
        this.center = center;
    }

           /*  @return elle retourn un type reel radio
        * cette methode permette de recupére le contenu du variable radio*/
    public double getRadio() {
        return radio;
    }

     /* @parameter radio
   * cette methode permette de modifier le contenu du variable radio*/
    public void setRadio(double radio) {
        this.radio = radio;
    }

           /*cette methode permettent de dessiner la graphic */
    @Override
    public void draw(Graphics graphics) {
       graphics.draw(this);
    }
}
