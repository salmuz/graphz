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

import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.graph.VertexShapeGraph;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Cette classe permet de créer des objets graphes orientés
 *
 * Elle possède comme parametre deux l'Edge et le Vertex qui sont des Edge
 * pour relier les vertex et des  Vertex sont les sommets
 * @param <ShapeEdge>
 * @param <ShapeVertex>
 *
 */
public class GraphNoOrient<ShapeEdge extends ShapeGeometric & EdgeShapeGraph,
        ShapeVertex extends ShapeGeometric & VertexShapeGraph,ValueEdge, ValueVertex>
        extends Graph<Edge<ValueEdge,ShapeEdge>, Vertex<ValueVertex, ShapeVertex>> {
    /**
     * C'est un constructeur du graphe
     */
    public GraphNoOrient() {
        super();
        edgeList = new ArrayList<Edge<ValueEdge,ShapeEdge>>();
        vertexList = new ArrayList<Vertex<ValueVertex, ShapeVertex>>();
    }

    /**
     * C'est une methode qui est redefinie de la classe graphe et qui permet de verifier si un Edge existe ou pas dans le graphes
     *
     * c'est l'edge quand verifie
     * @param shapeEdgeEdge
     *
     * @return vrai ou faux sur l'existance de l'edge dans le graphes
     */
    @Override
    public boolean containsEdge(Edge<ValueEdge,ShapeEdge> shapeEdgeEdge) {
        Iterator<Edge<ValueEdge,ShapeEdge>> it = edgeList.iterator();
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
    /**
     * C'est une methode qui est redefinie de la classe graphe et qui permet de supprimer  un Edge dans le graphes
     *
     * c'est l'edge quand suprime qui se trouve entre les deux sommet
     * @param source
     * @param target
     *
     */
    @Override
    public void removeEdge(Vertex<ValueVertex, ShapeVertex> source, Vertex<ValueVertex, ShapeVertex> target) {
       edgeList.remove(getEdge(source,target));
    }

    @Override
    public Edge<ValueEdge, ShapeEdge> getEdge(Vertex<ValueVertex, ShapeVertex> source, Vertex<ValueVertex, ShapeVertex> target) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            Vertex v0 = edge.getSource();
            Vertex v1 = edge.getTarget();
            if ((v0.equals(source) && v1.equals(target)) ||
                    (v0.equals(target) && v1.equals(source))) {
                return edge;
            }
        }
        return null;
    }
}


