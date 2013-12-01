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

package graph.algorithm.network;

import com.rits.cloning.Cloner;
import fr.edu.bp.m1info.structure.graph.FlowNetworkGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.path.AbstractPath;
import graph.algorithm.path.BreadthFirstPath;
import graph.algorithm.path.PathUtils;

public class EdmondsKarp<Edge extends EdgeFlow, Node extends Vertex> {

    private FlowNetworkGraph<Edge, Node> graph;
    private AbstractPath<Edge, Node> bfspath;
    private int flowMaximal;

    public EdmondsKarp(FlowNetworkGraph<Edge, Node> graph) {
        this.graph = graph;
        this.flowMaximal = 0;
        for (Node node : graph.getVertex()) {
            for (Edge edge : graph.adjacencys(node)) {
                edge.setFlow(0);
            }
        }
    }

    /**
     * Research the flow max in a network
     */
    private void networkEdmondsKarp(FlowNetworkGraph<Edge,Node> graphNetwork) {
        int flowMax = 0;
        ResidualGraph<Edge, Node> residualGraph = new ResidualGraph<Edge, Node>();

        while (hasPathFromSourceToSick(graphNetwork)) {
            int sick = graphNetwork.sink().getValue();

            int newFlow = PathUtils.sizeofShortestPathArc(bfspath.pathTo(sick));

            //Version v2, I don't know if it's optimal
            residualGraph.createResidualGraph(graphNetwork, bfspath.pathTo(sick), newFlow);

            updateFlowGraph(sick, newFlow);
            // end version v2

            // Old version, it don't use residualGraph
            // it use the method visit() for BFS and DFS
            //for (Edge edge : bfspath.pathTo(sick)) {
            //    edge.addFlowTo(edge.to(), newFlow);
            //}

            flowMax += newFlow;
        }

        flowMaximal = flowMax;
    }

    /**
     *
     * @param sick
     * @param newFlow
     */
    private void updateFlowGraph(int sick, int newFlow) {
        for (Edge edge : bfspath.pathTo(sick)) {
            Edge directed = graph.getEdge((Node) edge.from(), (Node) edge.to());
            if(directed != null){
                directed.addFlowTo(edge.to(), newFlow);
            }else{
                directed = graph.getEdge((Node) edge.to(), (Node) edge.from());
                directed.addFlowTo(edge.to(), newFlow);
            }
        }
    }

    /**
     * It exist a path between source to sink
     *
     * @return true if exist un path, else false
     */
    private boolean hasPathFromSourceToSick(FlowNetworkGraph<Edge,Node> graphNetwork) {
        bfspath = new BFSFlowNetworkPath<Edge, Node>(graphNetwork, graphNetwork.source());
        bfspath.execute();
        return bfspath.hasPathTo(graphNetwork.sink().getValue());
    }

    /**
     *
     */
    public void execute() {
        FlowNetworkGraph<Edge, Node> dgraph = new Cloner().deepClone(graph);
        this.networkEdmondsKarp(dgraph);
    }

    /**
     * @return
     */
    public int getFlowMaximal() {
        return flowMaximal;
    }

    /**
     *
     * @param <Edge>
     * @param <Node>
     */
    private class BFSFlowNetworkPath<Edge extends EdgeFlow,Node extends Vertex> extends BreadthFirstPath<Edge,Node> {

        public BFSFlowNetworkPath(Graph<Edge, Node> graph, Node source) {
            super(graph, source);
        }

        protected boolean isMarked(Edge edge, Node to){
            return ((super.isMarked(edge,to)) && (edge.residualCapacityTo(to) > 0));
        }

    }
}
