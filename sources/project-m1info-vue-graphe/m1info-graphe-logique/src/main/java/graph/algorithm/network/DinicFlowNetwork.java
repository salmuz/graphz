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
import graph.algorithm.IterativeView;
import graph.algorithm.path.AbstractPath;
import graph.algorithm.path.BreadthFirstPath;

import java.lang.reflect.Array;

public class DinicFlowNetwork<Edge extends EdgeFlow, Node extends Vertex> {

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
        boolean marked[] = new boolean[nbVertex];
        Edge path[] = (Edge[]) Array.newInstance(graph.getClazzEdge(), nbVertex);
        int level[] = bfsPath.dist();
        int maxLevel = level[sk];
        int augmentFlow = 0;
        do {

            //System.out.println("Input:\n" + graph);
            for (int i = 0; i < nbVertex; i++) path[i] = null;

            bottleneck = Integer.MAX_VALUE;
            v = source.getValue();
            marked[v] = true;
            for (int i = 0; i <= maxLevel; i++) {
                for (Edge e : graph.adjacencys(v)) {
                    int to = e.to().getValue();
                    if ((level[v] + 1 != level[to]) || ( e.to().outdegree() == 0 && to != sk)) continue;
                    bottleneck = Math.min(bottleneck, e.residualCapacityTo(e.to()));
                    path[v] = e;
                    v = to;
                    break;
                }
            }

            //System.out.println(bottleneck + "  PATH");
            //Augment flow f by f' and go back sink step 2.
            for (Edge w : path) {
                if (w != null) {
                    //System.out.print("(" + w.from().getValue() + "," + w.to().getValue() + ")");
                    w.addFlowTo(w.to(), bottleneck);
                    if (w.residualCapacityTo(w.to()) == 0) {
                        graph.removeEdge((Node) w.from(), (Node) w.to());
                    }
                }
            }
            //System.out.println();

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

            //System.out.println("Output:\n" + graph);
            augmentFlow += bottleneck;
        } while (v != sk);

        return augmentFlow;
    }

    /**
     *
     */
    public void execute() {
        FlowNetworkGraph<Edge, Node> origin = new Cloner().deepClone(graph);
        this.networkDinic();
        graph = origin;
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

        public BFSDinicFlowPath(Graph<Edge, Node> graph, Node source, IterativeView<Edge, Node> iterative) {
            super(graph, source, iterative);
        }

        protected boolean isMarked(Edge edge, Node to) {
            return (super.isMarked(edge, to) && (edge.residualCapacityTo(to) > 0));
        }
    }
}
