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
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.IterativeView;
import graph.algorithm.path.AbstractPath;
import graph.algorithm.path.BreadthFirstPath;
import graph.algorithm.path.PathUtils;

public class CapacityScaling<Edge extends EdgeFlow, Node extends Vertex> extends AbstractNetwork<Edge,Node>{

    private AbstractPath<Edge, Node> bfsPath;
    private int delta;

    /**
     *
     * @param graph
     */
    public CapacityScaling(FlowNetworkGraph<Edge, Node> graph) {
        super(graph);
    }

    /**
     *
     * @param graph
     * @param origin
     * @param iterativeView
     */
    public CapacityScaling(FlowNetworkGraph<Edge, Node> graph, IterativeView<Edge, Node> iterativeView) {
        super(graph, null, iterativeView);
    }


    /**
     * foreach e 2 E do fe 0;
     * delta = 2^log2(C)
     * while delta >= 1 do
     * ----Gf <- residual graph
     * ----while in Gf exist path s->t with the capacity of at least delta
     * ----------do find an augmenting path P with the capacity of at least delta
     * -------------- flow <- min{rij, (i,j) apartient P}
     * -------------- augment flow units of flow along P
     * -------------- update the Gf (update le residual graph)
     * ----delta <-  delta / 2
     * end
     * @param graphNetwork
     */
    private void capacityScaling(FlowNetworkGraph<Edge,Node> graphNetwork) {
       int C = this.maxCapacity;
       delta = (int) Math.pow(2,Math.log(C)/Math.log(2));
       ResidualGraph<Edge, Node> residualGraph = new ResidualGraph<Edge, Node>();
       while(delta >=1){
           //System.out.println("delta:"+delta);
           while(hasShortestAugmentingPath(graphNetwork)){
               // do find an augmenting path P with the capacity of at least delta
               Iterable<Edge> path = bfsPath.pathTo(graphNetwork.sink().getValue());
               // flow <- min{rij, (i,j) apartient P}
               int newFlow = PathUtils.sizeofShortestPathArc(path);

               //simulation
               iterativeView.updateView(path);

               // update the Gf
               residualGraph.createResidualGraph(graphNetwork, path, newFlow);

               //simulation
               this.iterativeView.updateView(graphNetwork);

               //augmente le flow maximum
               flowMaximal += newFlow;
           }
           delta = delta /2;
       }
    }

    /**
     * It exist a path between source to sink
     * @return
     */
    private boolean hasShortestAugmentingPath(FlowNetworkGraph<Edge,Node> graphNetwork) {
        bfsPath = new BFSCapacityScaling<Edge, Node>(graphNetwork, graphNetwork.source());
        bfsPath.execute();
        return bfsPath.hasPathTo(graphNetwork.sink().getValue());
    }

    /**
     *
     */
    public void execute() {
        capacityScaling(graph);
    }

    private class BFSCapacityScaling<Edge extends EdgeFlow,Node extends Vertex>  extends BreadthFirstPath<Edge,Node> {

        public BFSCapacityScaling(FlowNetworkGraph<Edge, Node> graph, Node source) {
            super(graph, source);
        }

        protected boolean isMarked(Edge edge, Node to){
            return ((super.isMarked(edge,to)) &&  (edge.residualCapacityTo(to) > 0) && edge.capacity() >= delta);
        }

    }
}
