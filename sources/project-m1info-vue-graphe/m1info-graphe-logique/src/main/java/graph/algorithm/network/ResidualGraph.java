/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
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

package graph.algorithm.network;

import fr.edu.bp.m1info.structure.graph.FlowNetworkGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

public class ResidualGraph<Edge extends EdgeFlow, Node extends Vertex> {

    /**
     * Using:
     * ResidualGraph<Edge,Node> residual = new ResidualGraph<Edge, Node>();
     * residual.createResidualGraph(graph,path.pathTo(sick),newFlow);
     *
     * @param graph
     * @param path
     * @param newflow
     * @return
     */
    public Graph<Edge, Node> createResidualGraph(FlowNetworkGraph<Edge, Node> graph,
                                                 Iterable<Edge> path, int newflow) {

        for (Edge edge : path) {
            edge.setCapacity(edge.capacity() - newflow);
            //il faut ameliore le recherche d'un arête
            Edge toFrom = graph.containsEdge((Node) edge.to(), (Node) edge.from());
            if (toFrom != null) {
                toFrom.setCapacity(toFrom.capacity() - toFrom.flow() + newflow);
                edge.setCapacity(edge.capacity() + toFrom.flow());
            } else {
                graph.addEdge((Node) edge.to(), (Node) edge.from(), newflow);
            }
        }

        return graph;
    }


    public void createResidualGraph(FlowNetworkGraph<Edge, Node> graph) {
        for (Node node : graph.getVertex()) {
            for (Edge edge : graph.adjacencys(node.getValue())) {
                if (edge.flow() > 0) {
                    edge.setCapacity(edge.capacity() - edge.flow());
                    Edge toFrom = graph.containsEdge((Node) edge.to(), (Node) edge.from());
                    if (toFrom != null) {
                        toFrom.setCapacity(toFrom.capacity() - toFrom.flow() + edge.flow());
                        edge.setCapacity(edge.capacity() + toFrom.flow());
                        toFrom.setFlow(0);
                    } else {
                        graph.addEdge((Node) edge.to(), (Node) edge.from(), edge.flow());
                    }
                    edge.setFlow(0);
                }
            }
        }
    }
}
