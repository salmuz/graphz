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
 *                  Aben Nouh Abdirazak 
 *
 * Changes
 * -------
 * 12/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.graph;

import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.EdgeFactory;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.Set;

public abstract class Graph<Edge extends AbstractEdge,Node extends Vertex> {

    public Class<Edge> clazz;
    public Set<Edge> edgeSet;
    public Set<Node> vertexSet;

    public Set<Edge> getEdgeSet() {
        return edgeSet;
    }

    public Set<Node> getVertexSet() {
        return vertexSet;
    }

    public Edge addEdge(Node source, Node target){
        Edge edge = (Edge) EdgeFactory.createEdge(clazz,source, target);
        edgeSet.add(edge);
        return edge;
    }

    public boolean addEdge(Edge edge){
        if(edgeSet.contains(edge)){
            return false;
        }
        edgeSet.add(edge);
        return true;
    }

    public boolean addVertex(Node vertex){
        if(vertexSet.contains(vertex)){
            return false;
        }
        vertexSet.add(vertex);
        return true;
    }

    public boolean containsEdge(Node source, Node target){
        throw new UnsupportedOperationException();
    }

    public boolean containsEdge(Edge edge){
       return edgeSet.contains(edge);
    }

    public boolean containsVertex(Node vertex){
       return vertexSet.contains(vertex);
    }

    public Edge removeEdge(Node source, Node target){
         throw new UnsupportedOperationException();
    }

    public boolean removeEdge(Edge edge){
        return edgeSet.remove(edge);
    }

    public boolean removeVertex(Node vertex){
        return vertexSet.remove(vertex);
    }

}
