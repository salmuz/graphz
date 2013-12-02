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
import graph.algorithm.path.BreadthFirstPath;

import java.lang.reflect.Array;

public class DinicFlowNetwork<Edge extends EdgeFlow, Node extends Vertex> {

    private static final int FAILURE_PATH = -1;
    private FlowNetworkGraph<Edge, Node> graph;
    private AbstractPath<Edge, Node> bfsPath;
    private int flowMaximal;

    public DinicFlowNetwork(FlowNetworkGraph<Edge, Node> graph) {
        this.graph = graph;
        this.flowMaximal = 0;
    }

    /**
     * Wikipedia http://en.wikipedia.org/wiki/Dinitz_blocking_flow_algorithm
     * source :
     * DinicFlowNetwork's Algorithm
     * Input: A network G = ((V, E), c, s, t).
     * Output: An s-t flow f of maximum value.
     * ---Set f(e) = 0 for each e belong sink E.
     * -----Construct Gl source Gf of G. If  dist(t) = infty, stop and output f.
     * -----Find a blocking flow f' in Gl.
     * -----Augment flow f by f' and go back sink step 2.
     */
    private void networkDinic() {
        // Set f(e) = 0 for each e belong sink E.
        for (Node node : graph.getVertex()) {
            for (Edge edge : graph.adjacencys(node)) {
                edge.setFlow(0);
            }
        }

        // Construct Gl source Gf of G. If  dist(t) = infty, stop and output f.
        while (hasShortestAugmentingPath()) {
            //Find a blocking flow f' in Gl.
            flowMaximal += computeBlokingFlow(graph.source(), graph.sink());
        }

    }

    /**
     * @return
     */
    private boolean hasShortestAugmentingPath() {
        bfsPath = new BFSDinicFlowPath<Edge, Node>(graph, graph.source());
        bfsPath.execute();
        return bfsPath.hasPathTo(graph.sink().getValue());
    }

    /**
     * Il prend en compte l'ensemble des plus courts chemins en nombres d'arcs
     */
    private int computeBlokingFlow(Node source, Node sink) {
        int v, bottleneck;
        int sk = sink.getValue();
        int nbVertex = graph.sizeVertex();
        Edge path[] = (Edge[]) Array.newInstance(graph.getClazzEdge(), nbVertex);
        int level[] = bfsPath.dist();
        int maxLevel = level[sk];
        int augmentFlow = 0;
        do {

            System.out.println("level:\n" + level[sk]);
            for (Edge w = path[source.getValue()]; w != null ; w = path[w.to().getValue()]) path[w.from().getValue()] = null;

            bottleneck = Integer.MAX_VALUE;
            v = source.getValue();
            bottleneck = backtrackGetNextNode(sk, level, v, maxLevel, bottleneck, path, 0);

            if (bottleneck != FAILURE_PATH) v = sk;
            else break;

            //System.out.println(bottleneck + "  PATH");
            //Augment flow f by f' and go back sink step 2.
            //Il faut ameliore, il ne doit que faire le path
            for (Edge w = path[source.getValue()]; w != null ; w = path[w.to().getValue()]){
                System.out.print("(" + w.from().getValue() + "," + w.to().getValue() + ")");
                w.addFlowTo(w.to(), bottleneck);
                if (w.residualCapacityTo(w.to()) == 0) {
                    graph.removeEdge((Node) w.from(), (Node) w.to());
                }
            }
            System.out.println();

            for (int i = 0; i <= maxLevel; i++) {
                for (int j = 0; j < level.length; j++) {
                    if (level[j] == i && j != source.getValue() && j != sk) {
                        Node u = graph.getVertex().get(j);
                        if (u.indegree() == 0) {
                            for (Edge e : graph.adjacencys(u.getValue())) {
                                graph.removeEdge((Node) e.from(), (Node) e.to());
                            }
                        }
                    }
                }
            }

            // System.out.println("Output:\n" + graph);
            System.out.println("bottleneck:" + bottleneck);
            augmentFlow += bottleneck;
        } while (v != sk);

        System.out.println("augmentFlow:" + augmentFlow);
        return augmentFlow;
    }


    /**
     * failure
     */
    public int backtrackGetNextNode(int sink, int[] level, int v, int maxLevel, int bottleneck, Edge[] path, int nextLevel) {

        if (nextLevel == maxLevel)
            return (v == sink) ? bottleneck : FAILURE_PATH;

        int to = -1;
        for (Edge e : graph.adjacencys(v)) {
            to = e.to().getValue();
            if (!((level[v] + 1 != level[to]) || (e.to().outdegree() == 0 && to != sink))) {
                int flow = backtrackGetNextNode(sink, level, to, maxLevel, Math.min(bottleneck, e.residualCapacityTo(e.to())),
                        path, nextLevel + 1);
                if (flow != FAILURE_PATH) {
                    path[v] = e;
                    return flow;
                }
            }
        }

        return FAILURE_PATH;

    }

    /**
     *
     */
    public void execute() {
        //System.out.println("Output:\n" + graph);
//        FlowNetworkGraph<Edge, Node> origin = new Cloner().deepClone(graph);
        this.networkDinic();
        //graph = origin;
    }

    /**
     * @return
     */
    public int getFlowMaximal() {
        return flowMaximal;
    }

    /**
     * @param <Edge>
     * @param <Node>
     */
    private class BFSDinicFlowPath<Edge extends EdgeFlow, Node extends Vertex> extends BreadthFirstPath<Edge, Node> {

        public BFSDinicFlowPath(Graph<Edge, Node> graph, Node source) {
            super(graph, source);
        }

        protected boolean isMarked(Edge edge, Node to) {
            return (super.isMarked(edge, to) && (edge.residualCapacityTo(to) > 0));
        }
    }
}
