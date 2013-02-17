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
 *                  Aben Nouh Abdirazak 
 *
 * Changes
 * -------
 * 12/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.graph;

import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.graph.VertexShapeGraph;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.Iterator;

public class GraphNoOrient<ShapeEdge extends ShapeGeometric & EdgeShapeGraph,
        ShapeVertex extends ShapeGeometric & VertexShapeGraph>
        extends Graph<Edge<ShapeEdge>, Vertex<Integer, ShapeVertex>> {

    public GraphNoOrient() {
        super();
        edgeList = new ArrayList<Edge<ShapeEdge>>();
        vertexList = new ArrayList<Vertex<Integer, ShapeVertex>>();
    }

    @Override
    public boolean containsEdge(Edge<ShapeEdge> shapeEdgeEdge) {
        Iterator<Edge<ShapeEdge>> it = edgeList.iterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            Vertex v0 = edge.getSource();
            Vertex v1 = edge.getTarget();
            if ((v0.equals(shapeEdgeEdge.getSource()) && v1.equals(shapeEdgeEdge.getTarget())) ||
                    (v0.equals(shapeEdgeEdge.getTarget()) && v1.equals(shapeEdgeEdge.getSource()))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void removeEdge(Vertex<Integer, ShapeVertex> source, Vertex<Integer, ShapeVertex> target) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            Vertex v0 = edge.getSource();
            Vertex v1 = edge.getTarget();
            if ((v0.equals(source) && v1.equals(target)) ||
                    (v0.equals(target) && v1.equals(source))) {
                edgeList.remove(edge);
            }
        }
    }
}


