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

import java.awt.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstPath<Edge extends IEdge, Node extends Vertex>
        extends AbstractPath<Edge, Node> {

    public BreadthFirstPath(Graph<Edge, Node> graph, Node source) {
        super(graph, source);
    }

    public BreadthFirstPath(Graph<Edge, Node> graph, Node source, IterativeView<Edge, Node> iterative) {
        super(graph, source,iterative);
    }

    public void execute(){
        iterativeView.updateView(source,null, Color.RED,Color.RED);
        breadthFirstSearch(source);
    }

    /**
     * The research the path shortest
     * Obs:
     *  (1) It do not function with cycle in the same vertex.
     * @param source
     */
    protected void breadthFirstSearch(Node source) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(source.getValue());
        marked[source.getValue()] = true;
        nodeTo[source.getValue()] = source;
        dist[source.getValue()] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (AdjacencyList.Neighbor w : graph.adjacencysNeighbor(v)) {
                Node node = (Node) w.getNode();
                Edge edge = (Edge) w.getEdge();
                if (isMarked(edge, node)) {
                    queue.offer(node.getValue());
                    marked[node.getValue()] = true;
                    edgeTo[node.getValue()] = edge;
                    nodeTo[node.getValue()] = (Node) w.getEdge().from();
                    dist[node.getValue()] = dist[v] + 1;
                    iterativeView.updateView(node,edge,Color.RED,Color.RED);
                }
            }
        }
    }

    /**
     * The method es added because some algorithms the target or the source
     * are equals sink the node adjacent. If they are equals, a loop is generate
     * at the time of traverse a graph.
     *
     * Obs:
     * It is used when the graph are used references to the same Edge object
     * @param w
     * @param from
     * @return
     */
    @Deprecated
    protected Node visit(AdjacencyList.Neighbor w, int from) {
        if(from == w.getEdge().to().getValue()){
            return (Node) w.getEdge().from();
        }
        return (Node) w.getNode();
    }

    /**
     * It is the condition for marked a Node, in a particular cause
     * can be overloaded.
     * @param edge
     * @param to
     * @return
     */
    protected boolean isMarked(Edge edge, Node to){
        return !marked[to.getValue()] && dist[to.getValue()]== -1;
    }

}