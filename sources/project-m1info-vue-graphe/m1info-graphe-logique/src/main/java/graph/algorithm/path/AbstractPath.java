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

package graph.algorithm.path;

import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.IterativeView;

import java.util.Stack;

public abstract class AbstractPath<Edge extends IEdge,Node extends Vertex> {

    protected Graph<Edge,Node> graph;
    protected IterativeView<Edge, Node> iterativeView;
    protected Node source;
    protected boolean marked[];
    protected Edge[] edgeTo;
    protected Node[] nodeTo;

    public AbstractPath(Graph<Edge,Node> graph, Node source,IterativeView<Edge, Node> iterative){
        this.graph = graph;
        this.source = source;
        marked = new boolean[graph.sizeVertex()];
        edgeTo = (Edge[]) new IEdge[graph.sizeVertex()];
        nodeTo = (Node[]) new Vertex[graph.sizeVertex()];
        for(int i=0;i<graph.sizeVertex();i++){
            marked[i] = false;
            edgeTo[i] = null;
            nodeTo[i] = null;
        }
        this.iterativeView = iterative;
    }

    public AbstractPath(Graph<Edge, Node> graph, Node source) {
        this(graph,source,new IterativeView<Edge, Node>() {
            public void updateView(Node node, Edge edge) {
            }
        });
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Node> pathTo(Node v){
        Stack<Node> path = new Stack<Node>();

        if (!hasPathTo(v.getValue())) return path;
        if (nodeTo[v.getValue()] == null) return path;

        for(Node x = v;
            x != null && x.getValue() != source.getValue();
            x = nodeTo[x.getValue()]){
            path.push(x);
        }

        // size of edge among the source and the target
        path.push(nodeTo[source.getValue()]);

        return path;
    }

    public Iterable<Edge> pathTo(int v){
        Stack<Edge> path = new Stack<Edge>();

        if (!hasPathTo(v)) return path;
        if (edgeTo[v] == null) return path;

        for(Edge x = edgeTo[v];
                x != null && x.getTarget().getValue() != source.getValue();
                x = edgeTo[x.getSource().getValue()]){
            path.push(x);
        }

        // size of edge among the source and the target
        //path.push(edgeTo[source]);

        return path;
    }

    public abstract void execute();


}
