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

import fr.edu.bp.m1info.structure.graph.edge.Arc;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeWeight;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

public class FlowNetworkGraph<Edge extends EdgeWeight, Node extends Vertex>
        extends DirectedGraph<Edge, Node> {

    private Node source; // source
    private Node sink; // puit

    public FlowNetworkGraph(Node source, Node sink) {
        this.source = source;
        this.sink = sink;
        this.nodes.add(source);
        this.nodes.add(sink);
    }

    public Node to() {  // source
        return sink;
    }

    public Node from() { // puit
        return source;
    }

}
