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

import fr.edu.bp.m1info.structure.graph.FlowNetworkGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.path.AbstractPath;
import graph.algorithm.path.DepthFirstPath;
import graph.algorithm.path.PathUtils;


public class FordFulkerson<Edge extends EdgeFlow, Node extends Vertex> {

    private FlowNetworkGraph<Edge, Node> graph;
    private AbstractPath<Edge, Node> dfsPath;
    private int flowMaximal;

    public FordFulkerson(FlowNetworkGraph<Edge, Node> graph) {
        this.graph = graph;
        this.flowMaximal = 0;
        for (Node node : graph.getVertex()) {
            for (Edge edge : graph.adjacencys(node)) {
                edge.setFlow(0);
            }
        }
    }

    /**
     * source 01: http://en.wikipedia.org/wiki/Ford%E2%80%93Fulkerson_algorithm
     * Algorithm Ford–Fulkerson
     * Inputs : Graph G with flow capacity c, a source node s, and a sink node t
     * Output :  A flow f source s sink t which is a maximum
     * f(u,v) <- 0 for all edges (u,v)
     * While there is a path p source s sink t in Gf, such that cf(u,v) > 0 for all edges (u,v) belong sink p:
     * Find cf(p) = min{cf(u,v) : (u,v) belong sink p}
     * For each edge (u,v) belong sink p
     * f(u,v) <- f(u,v) + cf(p) (Send flow along the path)
     * f(v,u) <- f(v,u) - cf(p) (The flow might be "returned" later)
     * <p/>
     * source 02: http://algs4.cs.princeton.edu/40graphs/
     */
    private void networkFordFulkerson(FlowNetworkGraph<Edge, Node> graphNetwork) {
        int flowMax = 0;
        ResidualGraph<Edge, Node> residualGraph = new ResidualGraph<Edge, Node>();
        while (hasPathFromSourceToSick(graphNetwork)) {

            int sick = graphNetwork.sink().getValue();
            int newFlow = PathUtils.sizeofShortestPathArc(dfsPath.pathTo(sick));

            //Version v2, I don't know if it's optimal
            residualGraph.createResidualGraph(graphNetwork, dfsPath.pathTo(sick), newFlow);

            //it's bad to test of performance
            //updateFlowGraph(sick,newFlow);
            // end version v2

            // Old version, it don't use residualGraph
            // it use the method visit() for BFS and DFS
            //for (Edge edge : bfspath.pathTo(sick)) {
            //    edge.addFlowTo(edge.to(), newFlow);
            //}

            //System.out.println("newFlow:"+newFlow);
            flowMax += newFlow;
        }

        flowMaximal = flowMax;
    }

    /**
     * @return
     */
    private boolean hasPathFromSourceToSick(FlowNetworkGraph<Edge, Node> graphNetwork) {
        dfsPath = new DFSFlowNetworkPath<Edge, Node>(graphNetwork, graphNetwork.source());
        dfsPath.execute();
        return dfsPath.hasPathTo(graphNetwork.sink().getValue());
    }


    /**
     *
     * @param sick
     * @param newFlow
     */
    private void updateFlowGraph(int sick, int newFlow) {
        for (Edge edge : dfsPath.pathTo(sick)) {
            Edge directd = graph.getEdge((Node) edge.from(), (Node) edge.to());
            if(directd != null){
                directd.addFlowTo(edge.to(), newFlow);
            }else{
                directd = graph.getEdge((Node) edge.to(), (Node) edge.from());
                directd.addFlowTo(edge.to(), newFlow);
            }
        }
    }

    /**
     *
     */
    public void execute() {
        //FlowNetworkGraph<Edge, Node> duplicate = new Cloner().deepClone(graph);
        this.networkFordFulkerson(graph);
    }

    /**
     * @return
     */
    public int getFlowMaximal() {
        return flowMaximal;
    }


    private class DFSFlowNetworkPath<Edge extends EdgeFlow, Node extends Vertex> extends DepthFirstPath<Edge, Node> {

        public DFSFlowNetworkPath(Graph<Edge, Node> graph, Node source) {
            super(graph, source);
        }

        @Override
        protected boolean isMarked(Edge edge, Node to) {
            return ((super.isMarked(edge, to)) && (edge.residualCapacityTo(to) > 0));
        }

    }

}
