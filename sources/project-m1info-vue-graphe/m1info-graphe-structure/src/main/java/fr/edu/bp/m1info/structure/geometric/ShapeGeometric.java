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
 *                   Aden Nouh Abdirazak
 * Changes
 * -------
 * 20/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.geometric;


import fr.edu.bp.m1info.structure.design.Graphics;

import java.awt.Color;
  /*nous avons une class abstract qui permettra de la forme du graphe*/
public abstract class ShapeGeometric {
      /*on a declare deux attribut pour la couleur des ligne et du fond de la fenetre */
    protected Color color = Color.BLACK;
    protected Color background = Color.black;

      /*@ return elle retourn la couleur de la ligne
  et cette methode getcolor permettent de recupéré la couleur des ligne qui se trouve dans la variable
   color*/
    public Color getColor() {
        return color;
    }

       /*@ parameter  elle contient deux parameter Color color
  et cette methode setcolor permettent  de modifier la couleur qui se trouve dans la variable color */
    public void setColor(Color color) {
        this.color = color;
    }

       /*@ return  elle retourn la couleur du fond de la fenetre
  et cette methode getBackground permettent de recupéré la couleur du fond de la fenetre qui
  se trouve dans la variable background*/
    public Color getBackground() {
        return background;
    }

      /*@ parameter  elle contient une  parameter Color background
  et cette methode setBackground permettent de modifier  la couleur qui se trouve dans la variable background */
    public void setBackground(Color background) {
        this.background = background;
    }

      /*cette methode permettent de dessiner la graphic */
    public abstract void draw(Graphics graphics);
}
