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
import graph.algorithm.exception.ExistNegativeWeightCycle;

public class BellmanFordPath<Edge extends IEdge, Node extends Vertex>
    extends  AbstractPath<Edge,Node>{

    private int distance[];

    public BellmanFordPath(Graph<Edge, Node> graph, Node source){
        super(graph, source);
    }

    public BellmanFordPath(Graph<Edge, Node> graph, Node source, IterativeView<Edge, Node> iterative) {
        super(graph, source, iterative);
    }

    @Override
    public void execute() {
        distance = new int[graph.sizeVertex()];
        try {
            bellmanFordSearch(source);
        } catch (ExistNegativeWeightCycle e) {
            e.printStackTrace();
        }
    }

    /**
     *  Pseudo-code - Wikipedia
     *  source: http://fr.wikipedia.org/wiki/Algorithme_de_Bellman-Ford
     *
     *  procedure BellmanFord(list vertices, list edges, vertex source)
     *   // This implementation takes in a graph, represented as lists of vertices and edges,
     *   // and fills two arrays (distance and predecessor) with shortest-path information
     *
     *   // Step 1: initialize graph
     *   for each vertex v in vertices:
     *      if v is source then distance[v] := 0
     *      else distance[v] := infinity
     *      predecessor[v] := null
     *
     *    // Step 2: relax edges repeatedly
     *    for i from 1 to size(vertices)-1:
     *        for each edge (u, v) with weight w in edges:
     *            if distance[u] + w < distance[v]:
     *                distance[v] := distance[u] + w
     *                predecessor[v] := u
     *
     *    // Step 3: check for negative-weight cycles
     *    for each edge (u, v) with weight w in edges:
     *        if distance[u] + w < distance[v]:
     *           error "Graph contains a negative-weight cycle"
     *
     * @param source
     */
    private void bellmanFordSearch(Node source) throws ExistNegativeWeightCycle {
        // obs: edgeTo  == predecessor

        // Step 1: initialize graph
        for (Node node : graph.getVertex()) {
            if (source.getValue() == node.getValue())
                distance[source.getValue()] = 0;
            else
                distance[node.getValue()] = Integer.MAX_VALUE;
            nodeTo[node.getValue()] = null;
        }

        // Step 2: relax edges repeatedly
        for (int i = 0; i < graph.sizeVertex(); i++) {
            for (Node node : graph.getVertex()) {
                for (AdjacencyList<Edge, Node>.Neighbor neighbor : graph.adjacencysNeighbor(node.getValue())) {
                    Node u = (Node) neighbor.getEdge().from();
                    Node v = (Node) neighbor.getEdge().to();
                    int w = (Integer) neighbor.getEdge().weight();
                    if (distance[u.getValue()] + w < distance[v.getValue()]) {
                        distance[v.getValue()] = distance[u.getValue()] + w;
                        //nodeTo[v.getValue()] = (Node) neighbor.getEdge().from();
                        edgeTo[v.getValue()] = neighbor.getEdge();
                    }
                }
            }
        }

        // Step 3: check for negative-weight cycles
        for (Node node : graph.getVertex()) {
            for (AdjacencyList<Edge, Node>.Neighbor neighbor : graph.adjacencysNeighbor(node.getValue())) {
                Node u = (Node) neighbor.getEdge().from();
                Node v = (Node) neighbor.getEdge().to();
                int w = (Integer) neighbor.getEdge().weight();
                if (distance[u.getValue()] + w < distance[v.getValue()]) {
                    throw new ExistNegativeWeightCycle("Graph contains a negative-weight cycle");
                }
            }
        }

    }

    public void showIterative(){
        iterativeView.updateView(source,null);
        for(Edge edge: edgeTo){
            if(edge != null){
                iterativeView.updateView((Node) edge.from(),edge);
                iterativeView.updateView((Node) edge.to(),edge);
            }
        }
    }

}
