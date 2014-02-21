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
 * 20/01/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.geometric.plane;


import org.salmuz.graphz.structure.common.GraphProperties;
import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;

/**
 * nous avons une class appelle circle et qui herite certaine methode de la class ShapeGeometric
 * et elle est implementé dans la class VertexShapeGraph
 */
public class Circle extends ShapeGeometric {

    private Point center;
    private double radio;

    /**
     * Cette methode contient deux parameter un point et un reel
     *
     * @parameter center et radio
     */
     public Circle(Point center, double radio) {
        this.center = center;
        this.radio = radio;
        this.color = GraphProperties.VERTEX_COLOR;
        this.background = GraphProperties.VERTEX_BACKGROUND;
    }

    /**
     * Cette methode permette de recupére le contenu du variable center
     *
     * @return elle retourn le point center
     *
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Cette methode permette de modifier le contenu du variable center
     *
     * @parameter center
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * cette methode permette de recupére le contenu du variable radio
     *
     * @return elle retourn un type reel radio
     *
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Cette methode permette de modifier le contenu du variable radio
     *
     *  @parameter radio
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

    /**
     * Cette methode permettent de dessiner la graphic
     */
    @Override
    public void draw(Graphics graphics) {
       this.shapeAWT = graphics.draw(this);
    }

    /**
     * C'est un methode qui verifie si un point appartient
     *
     * ce le coordonnées du point
     * @param x  origine
     * @param y  ordonées
     *
     * @return  boolean
     */
    @Override
    public boolean contains(double x, double y) {
        return this.shapeAWT.contains(x,y);
    }

    /**
     * C'est une methode qui calcule le centre d'un cercle
     *
     * @return un point
     */
    public Point centre() {
        return this.getCenter();
    }

    /**
     * c'est la methode qui est redefinie pour le cercle intersect du cercle
     *
     * @param shapeGeometric     ce la variable a tester
     *
     *
     * @return  un boolean
     */
    @Override
    public boolean intersects(ShapeGeometric shapeGeometric) {
        Circle circle = (Circle)shapeGeometric;

        if(this.shapeAWT == null){
          return false;
        }

        return this.shapeAWT.intersects(circle.getCenter().getX()-circle.getRadio(),
                circle.getCenter().getY()-circle.getRadio(),
                2*circle.getRadio(),
                2*circle.getRadio());
    }

    public boolean intersect(Point point) {

        if(this.shapeAWT == null){
          return false;
        }

        return this.shapeAWT.intersects(point.getX(),point.getY(),
                1.5*getRadio(), 1.5*getRadio());
    }
    /**
     *  C'est une methode qui permet de verifie qui si des objet des cette classe sont different
     *
     *  @param o c'est l'objet quand teste
     *
     * @return  un boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.radio, radio) != 0) return false;
        if (center != null ? !center.equals(circle.center) : circle.center != null) return false;

        return true;
    }
    /**
     * C'est une methode qui decrit le code ou le reference de la classe
     *
     * @return    un code
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center != null ? center.hashCode() : 0;
        temp = radio != +0.0d ? Double.doubleToLongBits(radio) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * c'est une methode qui traduit le variable en srting
     *
     * @return un string avec le variable
     */
    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radio=" + radio +
                '}';
    }
}
