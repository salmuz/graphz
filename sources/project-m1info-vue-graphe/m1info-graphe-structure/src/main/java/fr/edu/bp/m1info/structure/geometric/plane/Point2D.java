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

import fr.edu.bp.m1info.structure.geometric.Point;

/**
 * nous avons une class appelle Point2D et qui herite certaine methode de la class Point
 */
public class Point2D implements Point {

    private double x;
    private double y;


    /**
     * C'est un constructeur qui permet d'initialiser
     *
     * @parameter double x, double y cette methode contient 2 parameter
     * et les deux parameter  serons herité de la class point
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * c'est un constructeur
     * @param x
     * @param y
     */
     public Point2D(int x, int y) {
         this.x = x;
         this.y = y;
     }

    /**
     * cette methode permette de recupére le contenu du variable x
     *
     *  @return elle retourn  x
     *
     */
    public double getX() {
        return x;
    }
    /**
    * cette methode permette de modifier le contenu du variable x
    *
    * @parameter x
    */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * cette methode permette de recupére le contenu du variable y
     *
     *  @return elle retourn  y
     *
     */
    public double getY() {
        return y;
    }

    /**
     * cette methode permette de recupére le contenu du variable z
     *
     *  @return elle retourn  z
     *
     */
    public double getZ() {
        return 0.0;
    }
    /**
     * cette methode permette de modifier le contenu du variable y
     *
     * @parameter y
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * c'est une methode qui traduit le variable en srting
     *
     * @return un string avec le variable
     */
    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
    * cette methode permette de modifier le contenu du variable z
    *
    * @parameter z
    */
    public void setZ(double z) {}

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

         Point2D point2D = (Point2D) o;

         if (Double.compare(point2D.x, x) != 0) return false;
         if (Double.compare(point2D.y, y) != 0) return false;

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
         temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
         result = (int) (temp ^ (temp >>> 32));
         temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
         result = 31 * result + (int) (temp ^ (temp >>> 32));
         return result;
     }
 }
