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
 *
 * Changes
 * -------
 * 22/01/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.geometric.solid;

import org.salmuz.graphz.structure.design.Graphics;
import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;

/**
 * C'est une classe Sphere qui herite le shapeGeometric
 */
public class Sphere extends ShapeGeometric{
    /**
     *
     * @param graphics grace a l'objet graphics quand dessine
     */
    @Override
    public void draw(Graphics graphics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Point centre() {
        throw new UnsupportedOperationException();
    }
}
