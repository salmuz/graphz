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

import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.IterativeView;

import java.util.Stack;

public class DFSFlowNetworkPath<Edge extends EdgeFlow,Node extends Vertex> extends DepthFirstPath<Edge,Node> {


    public DFSFlowNetworkPath(Graph<Edge, Node> graph, Node source) {
        super(graph, source);
    }

    public DFSFlowNetworkPath(Graph<Edge, Node> graph, Node source, IterativeView<Edge, Node> iterative) {
        super(graph, source, iterative);
    }

    @Override
    protected boolean condition(Edge edge,Node to) {
        return ((!marked[to.getValue()]) && (edge.residualCapacityTo(to) > 0));
    }

    @Override
    public Iterable<Edge> pathTo(int v) {
        Stack<Edge> path = new Stack<Edge>();

        if (!hasPathTo(v)) return path;
        if (edgeTo[v] == null) return path;

        path.push(edgeTo[v]);

        for(Node x = nodeTo[v];
            x != null && x.getValue() != source.getValue();
            x = nodeTo[x.getValue()]){
            path.push(edgeTo[x.getValue()]);
        }

        return path;
    }
}
