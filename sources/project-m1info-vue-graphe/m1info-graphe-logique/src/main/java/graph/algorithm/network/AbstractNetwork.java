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
import graph.algorithm.IterativeViewAdapter;

public class AbstractNetwork<Edge extends EdgeFlow, Node extends Vertex> {

    protected FlowNetworkGraph<Edge, Node> graph;
    protected IterativeView<Edge, Node> iterativeView;
    protected int flowMaximal;
    private FlowNetworkGraph<Edge, Node> origin;

    /**
     *
     * @param graph
     * @param origin
     * @param iterativeView
     */
    public AbstractNetwork(FlowNetworkGraph<Edge, Node> graph,
                           FlowNetworkGraph<Edge, Node> origin,
                           IterativeView<Edge, Node> iterativeView) {
        this.graph = graph;
        this.origin = origin;
        this.iterativeView = iterativeView;
        this.flowMaximal = 0;
        initFlowZero();
    }

    /**
     *
     * @param graph
     */
    public AbstractNetwork(FlowNetworkGraph<Edge, Node> graph) {
        this(graph, null, new IterativeViewAdapter<Edge, Node>());
    }

    /**
     * Inisialisation of the flow
     */
    private void initFlowZero(){
        this.flowMaximal = 0;
        for (Node node : graph.getVertex()) {
            for (Edge edge : graph.adjacencys(node)) {
                edge.setFlow(0);
            }
        }
    }

    /**
     *
     * @return
     */
    public FlowNetworkGraph<Edge, Node> getOrigin() {
        return origin;
    }

    /**
     * @return
     */
    public int getFlowMaximal() {
        return flowMaximal;
    }
}
