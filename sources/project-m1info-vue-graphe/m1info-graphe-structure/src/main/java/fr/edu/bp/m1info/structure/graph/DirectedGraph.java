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
 * 12/02/13 : Version 01
 * 11/11/13 : Adiction of algorithm's flow maximal
 *
 */
package fr.edu.bp.m1info.structure.graph;

import fr.edu.bp.m1info.structure.common.GraphProperties;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.AbstractEdgeShape;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeDirected;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeName;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeShape;
import fr.edu.bp.m1info.structure.geometric.plane.CurvedArrow;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.EdgeFactory;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.Iterator;

/**
 * Cette classe permet de créer des objets graphes orientés
 * <p/>
 * Elle possède comme parametre deux l'Arc et le vertex qui sont des arc
 * pour l'orientation et des Vertex qui sont relier par les Arcs
 *
 * @param <Edge>
 * @param <Node>
 */
public class DirectedGraph<Edge extends IEdge, Node extends Vertex>
        extends Graph<Edge, Node> {

    /**
     * C'est un constructeur pour crées l'objet de la classe et
     * en meme temps initialiser
     * <p/>
     * n'a pas de parametre
     */
    public DirectedGraph() {
        super();
    }

    public DirectedGraph(int type) {
        super(type);
    }

    @Override
    public Edge addEdge(Node source, Node target) {
        int index = indexOfVertex(source);

        Edge edgeS = (Edge) EdgeFactory.createEdge(this.clazzEdge, source, target, null);

        if (TYPE_EXECUTION != GraphProperties.CONSOLE) {

            Class<? extends ShapeGeometric>  clazz = this.clazzEdgeShape;
            Edge edgeT = containsEdge(target,source);
            if(edgeT != null){
                clazz = CurvedArrow.class;
                AbstractEdgeShape shapeT = new EdgeShape(clazz,
                        target.getVertex().parentComponent().shape().centre(),
                        source.getVertex().parentComponent().shape().centre());
                 EdgeDirected directed = new EdgeDirected(new EdgeName(shapeT, "0"));
                ((AbstractEdge) edgeT).setShape(directed);
            }

            AbstractEdgeShape shapeS = new EdgeShape(clazz,
                    source.getVertex().parentComponent().shape().centre(),
                    target.getVertex().parentComponent().shape().centre());

            ((AbstractEdge) edgeS).setShape(new EdgeDirected(new EdgeName(shapeS, "0")));

        }

        adjacencys[index].add(edgeS);

        edges.add(edgeS);

        return edgeS;
    }


    @Override
    public Edge containsEdge(Node source, Node target) {
        int from = indexOfVertex(source);
        int to = indexOfVertex(target);
        if (from != NOT_FOUND_KEY || to != NOT_FOUND_KEY)
            return adjacencys[from].containsEdge(to);

        return null;
    }

    @Override
    public boolean containsEdge(Edge e) {
        Iterator<Edge> it = edges.iterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            Vertex v0 = edge.from();
            Vertex v1 = edge.to();
            if (v0.equals(e.from()) && v1.equals(e.to())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeEdge(Node source, Node target) {
        adjacencys[source.getValue()].remove(target);
        edges.remove(getEdge(source, target));
    }

    @Override
    public Edge getEdge(Node source, Node target) {
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            Node v0 = (Node) edge.from();
            Node v1 = (Node) edge.to();
            if ((v0.getValue() == source.getValue() && v1.getValue() == target.getValue())) {
                return edge;
            }
        }
        return null;

    }
}
