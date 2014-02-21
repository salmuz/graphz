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
 *
 */

package org.salmuz.graphz.graph.algorithm.path;

import java.awt.Color;
import java.util.Stack;

import org.salmuz.graphz.graph.algorithm.IterativeView;

import org.salmuz.graphz.structure.graph.AdjacencyList;
import org.salmuz.graphz.structure.graph.Graph;
import org.salmuz.graphz.structure.graph.edge.IEdge;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

public class DepthFirstPath<Edge extends IEdge, Node extends Vertex> extends AbstractPath<Edge, Node> {

    public DepthFirstPath(Graph<Edge, Node> graph, Node source) {
        super(graph, source);
    }

    public DepthFirstPath(Graph<Edge, Node> graph, Node source, IterativeView<Edge, Node> iterative) {
        super(graph, source, iterative);
    }

    public void execute() {
        nodeTo[source.getValue()] = source;
        iterativeView.updateView(source, null, Color.RED, Color.RED);
        dephtFirstSearch(source);
    }

    /**
     * DFS-Iterative
     *
     * @param v
     */
    private void dephtFirstSearch(Node v) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(v);
        marked[v.getValue()] = true;
        while (!stack.isEmpty()) {
            Node u = stack.pop();
            iterativeView.updateView(u, null, Color.RED, Color.RED);
            for (AdjacencyList.Neighbor w : graph.adjacencysNeighbor(u.getValue())) {
                Node vs = (Node) w.getNode();
                Edge edge = (Edge) w.getEdge();
                if (isMarked(edge, vs)) {
                    stack.push(vs);
                    marked[vs.getValue()] = true;
                    edgeTo[vs.getValue()] = edge;
                    nodeTo[vs.getValue()] = (Node) edge.from();
                }
            }
        }
    }


    /**
     * DFS-Recursive:
     * The algorithm DFS recursive don't work with 500.000 nodes
     * because it catch a StackOverflowException at graph deeper
     * than a couple of thousand nodes.
     *
     * @param v node to look for
     */
    private void dephtFirstSearchR(Node v) {
        marked[v.getValue()] = true;
        for (AdjacencyList.Neighbor w : graph.adjacencysNeighbor(v.getValue())) {
            Node vs = (Node) w.getNode();
            Edge edge = (Edge) w.getEdge();
            if (isMarked(edge, vs)) {
                edgeTo[vs.getValue()] = edge;
                nodeTo[vs.getValue()] = (Node) w.getEdge().from();
                iterativeView.updateView((Node) w.getNode(), (Edge) w.getEdge(), Color.RED, Color.RED);
                dephtFirstSearchR(vs);
            }
        }
    }

    protected boolean isMarked(Edge edge, Node to) {
        return !marked[to.getValue()];
    }

}