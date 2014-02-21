/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
 * ==========================================
 * 
 * salmuz : Carranza Alarcon Yonatan Carlos
 * 
 * (C) Copyright 2013, by salmuz and Contributors.
 * 
 * Project Info:  https://github.com/salmuz/Cross-Platform-GraphZ
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

package org.salmuz.graphz.graph.algorithm.network;

import org.salmuz.graphz.graph.algorithm.IterativeView;
import org.salmuz.graphz.graph.algorithm.IterativeViewAdapter;

import org.salmuz.graphz.structure.graph.FlowNetworkGraph;
import org.salmuz.graphz.structure.graph.edge.decorator.EdgeFlow;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

public class AbstractNetwork<Edge extends EdgeFlow, Node extends Vertex> {

    protected FlowNetworkGraph<Edge, Node> graph;
    protected IterativeView<Edge, Node> iterativeView;
    protected int flowMaximal;
    protected int maxCapacity; // max capacity
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
        this.maxCapacity = Integer.MIN_VALUE;
        for (Node node : graph.getVertex()) {
            for (Edge edge : graph.adjacencys(node)) {
                edge.setFlow(0);
                if(this.maxCapacity < edge.capacity()){
                    this.maxCapacity = edge.capacity();
                }
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
