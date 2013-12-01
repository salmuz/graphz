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

package fr.edu.bp.m1info.structure.graph;

import fr.edu.bp.m1info.structure.common.GraphProperties;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

public class FlowNetworkGraph<Edge extends EdgeFlow, Node extends Vertex>
        extends DirectedGraph<Edge, Node> {

    private Node source; // source
    private Node sink; // puit

    public FlowNetworkGraph(Node source, Node sink) {
        this(source, sink, GraphProperties.GUI);
    }

    public FlowNetworkGraph(Node source, Node sink,int type) {
        super(type);
        this.source = source;
        this.sink = sink;
    }

    public void addEdge(Node source, Node target, int capacity) {
        Edge edgeS = super.addEdge(source,target);
        edgeS.setCapacity(capacity);
        // implementation with double link
        // source : http://algs4.cs.princeton.edu/
        //int to = indexOfVertex(target);
        //adjacencys[to].add(edgeS);
    }

    public Node sink() {  // source
        return sink;
    }

    public Node source() { // puit
        return source;
    }

    /**
     *
     * @return string, graph adj list
     */
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        for (Node v : getVertex()){
            buff.append(v.getValue() + " = degre (In:"+v.indegree()+",Out"+v.outdegree()+") ->");
            for (Edge w : adjacencys(v))
                buff.append("(("+w.from().getValue()+","+w.to().getValue()+"), "+w.capacity()+", "+w.flow()+")");
            buff.append("\n");
        }
        return buff.toString();
    }

}
