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
 * 12/02/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.graph;

import org.salmuz.graphz.structure.common.GraphProperties;
import org.salmuz.graphz.structure.geometric.graph.shape.edge.AbstractEdgeShape;
import org.salmuz.graphz.structure.geometric.graph.shape.edge.EdgeShape;
import org.salmuz.graphz.structure.graph.edge.AbstractEdge;
import org.salmuz.graphz.structure.graph.edge.Edge;
import org.salmuz.graphz.structure.graph.edge.EdgeFactory;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

import java.util.Iterator;

/**
 * Cette classe permet de créer des objets graphes orientés
 * <p/>
 * Elle possède comme parametre deux l'Edge et le Vertex qui sont des Edge
 * pour relier les vertex et des  Vertex sont les sommets
 *
 * @param <E>
 * @param <N>
 */
public class UnDirectedGraph<E extends Edge, N extends Vertex>
        extends Graph<E, N> {

    /**
     * C'est un constructeur du graphe
     */
    public UnDirectedGraph() {
        super();
    }

    public UnDirectedGraph(int typeExecution) {
        super(typeExecution);
    }

    /**
     * @param source
     * @param target
     * @param weigth
     */
    @Override
    public E addEdge(N source, N target, Number weigth) {
        int index = indexOfVertex(source);

        E edgeS = (E) EdgeFactory.createEdge(Edge.class, source, target, null);
        E edgeT = (E) EdgeFactory.createEdge(Edge.class, target, source, null);

        if (TYPE_EXECUTION != GraphProperties.CONSOLE) {
            // it just works with a edge shape !!
            AbstractEdgeShape shapeS = new EdgeShape(this.clazzEdgeShape,
                    source.getVertex().parentComponent().shape().centre(),
                    target.getVertex().parentComponent().shape().centre());
            ((AbstractEdge) edgeS).setShape(shapeS);

            AbstractEdgeShape shapeT = new EdgeShape(this.clazzEdgeShape,
                    target.getVertex().parentComponent().shape().centre(),
                    source.getVertex().parentComponent().shape().centre());
            ((AbstractEdge) edgeT).setShape(shapeT);
        }

        adjacencys[index].add(edgeS);
        index = indexOfVertex(target);
        adjacencys[index].add(edgeT);

        edges.add(edgeS);

        return edgeS;
    }

    /**
     * @param source
     * @param target
     * @return
     */
    @Override
    public E containsEdge(N source, N target) {
        int from = indexOfVertex(source);
        int to = indexOfVertex(target);
        if (from != NOT_FOUND_KEY || to != NOT_FOUND_KEY) {
            E e = adjacencys[from].containsEdge(to);
            if (e != null)
                return adjacencys[to].containsEdge(from) != null ? e : null;

        }

        return null;
    }

    /**
     * C'est une methode qui est redefinie de la classe graphe et qui permet de verifier si un Edge existe ou pas dans le graphes
     * <p/>
     * c'est l'edge quand verifie
     *
     * @param
     * @return vrai ou faux sur l'existance de l'edge dans le graphes
     */
    @Override
    public boolean containsEdge(E shapeEdgeEdge) {
        Iterator<E> it = edges.iterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            Vertex v0 = edge.from();
            Vertex v1 = edge.to();
            if ((v0.equals(shapeEdgeEdge.from()) && v1.equals(shapeEdgeEdge.to())) ||
                    (v0.equals(shapeEdgeEdge.to()) && v1.equals(shapeEdgeEdge.from()))) {
                return true;
            }
        }

        return false;
    }

    /**
     * C'est une methode qui est redefinie de la classe graphe et qui permet de supprimer  un Edge dans le graphes
     * <p/>
     * c'est l'edge quand suprime qui se trouve entre les deux sommet
     *
     * @param source
     * @param target
     */
    @Override
    public void removeEdge(N source, N target) {
        adjacencys[source.getValue()].remove(target);
        adjacencys[target.getValue()].remove(source);
        edges.remove(getEdge(source, target));
    }

    @Override
    public E getEdge(N source, N target) {
        for (int i = 0; i < edges.size(); i++) {
            E edge = edges.get(i);
            N v0 = (N) edge.from();
            N v1 = (N) edge.to();
            if ((v0.getValue() == source.getValue() && v1.getValue() == target.getValue()) ||
                    (v0.getValue() == target.getValue() && v1.getValue() == source.getValue())) {
                return edge;
            }
        }
        return null;
    }
}


