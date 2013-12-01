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

package graph.algorithm.path;

import fr.edu.bp.m1info.structure.graph.AdjacencyList;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.IterativeView;

public class DepthFirstPath<Edge extends IEdge, Node extends Vertex> extends AbstractPath<Edge, Node> {

    public DepthFirstPath(Graph<Edge, Node> graph, Node source) {
        super(graph, source);
    }

    public DepthFirstPath(Graph<Edge, Node> graph, Node source, IterativeView<Edge, Node> iterative) {
        super(graph, source, iterative);
    }

    public void execute() {
        nodeTo[source.getValue()] = source;
        iterativeView.updateView(source, null);
        dephtFirstSearch(source);
    }

    private void dephtFirstSearch(Node v) {
        marked[v.getValue()] = true;
        for (AdjacencyList.Neighbor w : graph.adjacencysNeighbor(v.getValue())) {
            Node vs = (Node) w.getNode();
            Edge edge = (Edge) w.getEdge();
            if (isMarked(edge, vs)) {
                edgeTo[vs.getValue()] = edge;
                nodeTo[vs.getValue()] = (Node) w.getEdge().from();
                iterativeView.updateView((Node) w.getNode(), (Edge) w.getEdge());
                dephtFirstSearch(vs);
            }
        }
    }

    protected boolean isMarked(Edge edge, Node to) {
        return !marked[to.getValue()];
    }

}