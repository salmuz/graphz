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
package org.salmuz.graphz.structure.design;

import org.salmuz.graphz.structure.geometric.plane.*;
import org.salmuz.graphz.structure.geometric.plane.Rectangle;

import java.awt.*;

//Visitor, le client va appeler seulement le methode draw et il aura son travail
/**
 * cette interface qui contient quatre methode et ces methode seront appeller par d'autre class
 *  pour dessiner une graphe
 */
public interface Graphics {

    /**
     *-Line line -Circle circle  - LineArrow lineArrow -Rectangle rectangle - Curve curve
     * et ces methodes permette de dessiner la graphe
     *
     * @ parameter dans chaque methode on a une parameter de son type quand veut dessiner
     */
    public Shape draw(Line line);

    public Shape draw(Circle circle);

    public void draw(LineArrow lineArrow);

    public void draw(Rectangle rectangle);

    public Shape draw(Curve curve);

    public void draw(CurvedArrow curve);

    public Shape draw(Message message);
}
