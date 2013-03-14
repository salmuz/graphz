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
package fr.edu.bp.m1info.structure.geometric;


import fr.edu.bp.m1info.structure.design.Graphics;

import java.awt.*;

/**
 * nous avons une class abstract qui permettra de la forme du graphe
 */
public abstract class ShapeGeometric {

      /*on a declare deux attribut pour la couleur des ligne et du fond de la fenetre */
    protected Color color = Color.BLACK;
    protected Color background = Color.black;
    // Shape de AWT
    protected Shape shape;
    protected Object value;


    public Shape getShape() {
        return shape;
    }

    /**
     * cette methode getcolor permettent de recupéré la couleur des ligne qui se trouve dans la variable
     *
      * @return elle retourne la couleur
     *
     */
    public Color getColor() {
        return color;
    }

    /**
     * cette methode setcolor permettent  de modifier la couleur qui se trouve dans la variable color
     *
      * @param color change l'ancien par la nouvel couleur color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * cette methode getBackground permettent de recupéré la couleur du fond de la fenetre qui
     * se trouve dans la variable background
     *
     * @return la couleur du fond d'ecran
     */
    public Color getBackground() {
        return background;
    }

    /**
     * cette methode setBackground permettent de modifier  la couleur qui se trouve dans la variable background
     *
     * @param background cette couleur modifier l'ancien couleur du fond d'ecran
     */
    public void setBackground(Color background) {
        this.background = background;
    }

    /**
     * cette methode permettent de dessiner la graphic
     *
      * @param graphics grace a l'objet graphics quand dessine
     */
    public abstract void draw(Graphics graphics);

    /**
     * cet une methode qui determine s'il ya de l'intersection
     *
     * @param shapeGeometric     ce la variable a tester
     *
     * @return         une shapeGeometrique
     */
    public boolean intersect(ShapeGeometric shapeGeometric) {
        return false;
    }

    /**
     * verifie s'il cintient deux coordonnées chaque ShapeGeometrique
     *
     * @param x  origine
     * @param y  ordonées
     *
     * @return  vrai ou faux
     */
    public boolean contains(double x, double y){
        return false;
    }

}
