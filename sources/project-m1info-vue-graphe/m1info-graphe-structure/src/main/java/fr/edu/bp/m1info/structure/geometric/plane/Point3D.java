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
 * 21/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.geometric.plane;

import fr.edu.bp.m1info.structure.geometric.plane.Point2D;

/**
 * nous avons une class appelle Point3D et qui herite certaine methode de la class Point2D
 */
public class Point3D extends Point2D {

    private double z;


   /**
    * c'est un constructeur de la classe
    *
    * @parameter double x, double y, double z cette methode contient 3 parameter
    * et les deux premier parameter  serons herité de la class point2fD
    */
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    /**
     * cette methode permette de recupére le contenu du variable z
     *
     * @return elle retourn z
     */
    public double getZ() {
        return z;
    }
    /**
     * cette methode permette de modifier le contenu du variable z
     *
     * @parameter z
     */
    public void setZ(double z) {
        this.z = z;
    }
}
