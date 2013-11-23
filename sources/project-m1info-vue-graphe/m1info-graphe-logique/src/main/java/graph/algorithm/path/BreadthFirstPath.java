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

import fr.edu.bp.m1info.structure.common.GraphProperties;
import fr.edu.bp.m1info.structure.graph.DirectedGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.UnDirectedGraph;
import fr.edu.bp.m1info.structure.graph.edge.Arc;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstPath<Edge extends IEdge,Node extends Vertex> extends AbstractPath<Edge,Node>{

    public BreadthFirstPath(Graph<Edge,Node> graph,int source){
        super(graph,source);
        breadthFirstSearch(source);
    }

    private void breadthFirstSearch(int source){
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(source);
        marked[source] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for (Edge w : graph.adjacencys(v)){
                int vs = w.getTarget().getValue();
                if(!marked[vs]){
                    queue.offer(vs);
                    marked[vs] = true;
                    edgeTo[vs] = w;
                }
            }
        }
    }

    public static void main(String ...arg){
        Graph<fr.edu.bp.m1info.structure.graph.edge.Edge,Vertex> graph =
                new UnDirectedGraph<fr.edu.bp.m1info.structure.graph.edge.Edge, Vertex>(GraphProperties.CONSOLE) {};
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v0, v1);
        graph.addEdge(v0, v2);
        graph.addEdge(v0, v3);
        graph.addEdge(v0, v5);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v5, v4);

        System.out.println(graph.toString());

        AbstractPath<Arc,Vertex> paths = new BreadthFirstPath(graph, 3);

        for (int v = 0; v<graph.sizeVertex();v++)
            if(paths.hasPathTo(v)){
                System.out.println("belong to:"+v);
            }

        for(IEdge v : paths.pathTo(0)){
            System.out.println(v);
        }
    }


}