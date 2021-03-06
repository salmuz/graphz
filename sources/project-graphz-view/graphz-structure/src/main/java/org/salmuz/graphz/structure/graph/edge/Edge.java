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
 * Contributor(s):  
 *
 * Changes
 * -------
 * 20/01/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.graph.edge;


import org.salmuz.graphz.structure.graph.vertex.Vertex;

/* *
 * Ici nous avons une classe public  et qui herite certaine methode de la class EdgeShapeGraph>
 * et de la class AbstractEdge<Shape>
 */
public class Edge extends AbstractEdge {


    /**
     * C'est une methode qui contienne une parameter
     *
     * @parameter value  value
     * @parameter source Vertex
     * @parameter target  Vertex
     *
     */
    public Edge(Vertex source, Vertex target) {
        super(source, target);
    }
}
