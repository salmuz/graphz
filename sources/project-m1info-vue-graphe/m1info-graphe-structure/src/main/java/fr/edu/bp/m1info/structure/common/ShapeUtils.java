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
 * Contributor(s):  
 *
 * Changes
 * -------
 *
 */

package fr.edu.bp.m1info.structure.common;

import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapeUtils {

    /**
     * @param shapes
     * @param excludes
     * @return
     */
    public static boolean isVertexSamePlace(List<Vertex> shapes, ShapeGeometric shape, ShapeGeometric... excludes) {

        Iterator<Vertex> it = shapes.iterator();
        while (it.hasNext()) {
            ShapeGeometric item = it.next().getVertex().parentComponent().shape();
            boolean exclude = false;
            for (int i = 0; i < excludes.length; i++) {
                if (excludes[i].equals(item)) {
                    exclude = true;
                    break;
                }
            }
            if (!exclude && item.intersects(shape)) {
                return true;
            }
        }
        return false;
    }

    public static Iterator<IEdge> getEdgesOfVertex(List<IEdge> edgeList, Vertex from) {
        List<IEdge> edges = new ArrayList<IEdge>();
        Iterator<IEdge> it = edgeList.iterator();
        while (it.hasNext()) {
            IEdge edge = it.next();
            if (edge.from().equals(from)) {
                edges.add(edge);
            } else {
                if (edge.to().equals(from)) {
                    edges.add(edge);
                }
            }
        }
        return edges.iterator();
    }



}
