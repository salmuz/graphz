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
 * 21/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.geometric.plane;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.*;
import fr.edu.bp.m1info.structure.graph.EdgeShapeGraph;
           /*nous avons une class appelle LineArrow et qui herite certaine methode de la class Line
       et elle est implementé dans la class  Arrow et  EdgeShapeGraph*/
public class LineArrow extends Line implements Arrow, EdgeShapeGraph {

    private PLACE_OF_ARROW placeOfArrow;

               /*@parameter start,end,placeOfArrow cette methode contient 3 parameter
           * et les deux premier  points serons herité de la class curve */
    public LineArrow(Point start, Point end, PLACE_OF_ARROW placeOfArrow) {
        super(start, end);
        this.placeOfArrow = placeOfArrow;
    }

        /*  @return elle retourn placeOfArrow
        * cette methode permette de recupére le contenu du variable placeOfArrow*/
    public PLACE_OF_ARROW getPlaceOfArrow() {
        return placeOfArrow;
    }
        /* @parameter placeOfArrow
   * cette methode permette de modifier le contenu du variable placeOfArrow*/
    public void setPlaceOfArrow(PLACE_OF_ARROW placeOfArrow) {
        this.placeOfArrow = placeOfArrow;
    }
           /*@parameter graphics
     cette methode permettent de dessiner le ligne et le fleche  */
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);  // designer le ligne                           ss
        graphics.draw(this); // ajouter seulement fleche
    }
}
