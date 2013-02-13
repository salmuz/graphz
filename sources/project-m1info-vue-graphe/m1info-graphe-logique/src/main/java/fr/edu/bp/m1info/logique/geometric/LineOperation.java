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
 *                   Aden Nouh Abdirazak
 * Changes
 * -------
 * 23/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.logique.geometric;


import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
/*Interface qui contient deux methode qui serons implementé dans la class Line2DOperationImpl*/

public interface LineOperation {

   /*Une methode qui permette de calculer le milieu de la ligne
   * @parameter Line elle contient une  parameter*/
    public Point calculateMidPoint(Line line);

    /**
     * Une methode qui permette de calculer la taille d'une ligne
     *
     * @parameter Line;elle contient une  parameter
     *
     */
    public double calculateSize(Line line);

}
