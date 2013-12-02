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

package graph.algorithm;

import fr.edu.bp.m1info.structure.common.GraphProperties;
import fr.edu.bp.m1info.structure.graph.DirectedGraph;
import fr.edu.bp.m1info.structure.graph.FlowNetworkGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.UnDirectedGraph;
import fr.edu.bp.m1info.structure.graph.edge.Arc;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class GenerateGraphTest {

    public static FlowNetworkGraph<EdgeFlow, Vertex> generateGraphNetworkFlow01() {
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        FlowNetworkGraph<EdgeFlow, Vertex> graph =
                new FlowNetworkGraph<EdgeFlow, Vertex>(v0, v5, GraphProperties.CONSOLE) {
                };

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v0, v1, 2);
        graph.addEdge(v0, v2, 3);
        graph.addEdge(v1, v3, 3);
        graph.addEdge(v1, v4, 1);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v2, v4, 1);
        graph.addEdge(v3, v5, 2);
        graph.addEdge(v4, v5, 3);

        return graph;
    }

    public static FlowNetworkGraph<EdgeFlow, Vertex> generateGraphNetworkFlow02() {
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        FlowNetworkGraph<EdgeFlow, Vertex> graph =
                new FlowNetworkGraph<EdgeFlow, Vertex>(v0, v5, GraphProperties.CONSOLE) {
                };

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v0, v1, 10);
        graph.addEdge(v0, v2, 5);
        graph.addEdge(v0, v3, 15);
        graph.addEdge(v1, v4, 10);
        graph.addEdge(v2, v4, 10);
        graph.addEdge(v3, v4, 10);
        graph.addEdge(v1, v5, 5);
        graph.addEdge(v3, v5, 5);
        graph.addEdge(v4, v5, 20);

        return graph;
    }


    public static FlowNetworkGraph<EdgeFlow, Vertex> generateGraphNetworkFlow03() {
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        Vertex v6 = new Vertex();
        Vertex v7 = new Vertex();
        Vertex v8 = new Vertex();
        Vertex v9 = new Vertex();
        FlowNetworkGraph<EdgeFlow, Vertex> graph =
                new FlowNetworkGraph<EdgeFlow, Vertex>(v0, v9, GraphProperties.CONSOLE) {
                };

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);
        graph.addVertex(v9);

        graph.addEdge(v0, v1, 30);
        graph.addEdge(v0, v2, 10);
        graph.addEdge(v1, v3, 15);
        graph.addEdge(v1, v4, 5);
        graph.addEdge(v2, v4, 5);
        graph.addEdge(v2, v5, 5);
        graph.addEdge(v3, v6, 10);
        graph.addEdge(v3, v7, 10);
        graph.addEdge(v4, v7, 5);
        graph.addEdge(v4, v8, 5);
        graph.addEdge(v5, v8, 6);
        graph.addEdge(v6, v9, 15);
        graph.addEdge(v7, v9, 7);
        graph.addEdge(v8, v9, 10);

        return graph;
    }

    public static Graph<Edge, Vertex> generateUnDirectedGraph() {
        Graph<Edge, Vertex> graph =
                new UnDirectedGraph<Edge, Vertex>(GraphProperties.CONSOLE) {
                };
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

        return graph;
    }

    public static Graph<Arc, Vertex> generateDirectedGraph() {
        Graph<Arc, Vertex> graph =
                new DirectedGraph<Arc, Vertex>(GraphProperties.CONSOLE) {
                };
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
        return graph;
    }


    public static FlowNetworkGraph<EdgeFlow, Vertex> generateGraphNetworkFlow04() {
        FlowNetworkGraph<EdgeFlow, Vertex> graph =  null;
        File file = new File("/Users/user/Documents/git/Graphes_Multi_Plateformes/data/flowNetwork/flowNetwok_500_1200_01122013_0425.txt");
        try {
            Scanner in = new Scanner(file);
            int nbV = in.nextInt();

            List<Vertex> V = new ArrayList<Vertex>();
            Vertex v0 = new Vertex();
            V.add(v0);
            for (int i = 1; i < nbV - 1; i++) {
                 V.add(new Vertex());
            }
            Vertex vn = new Vertex();
            V.add(vn);

            graph = new FlowNetworkGraph<EdgeFlow, Vertex>(v0, vn, GraphProperties.CONSOLE) { };

            for(Vertex v : V){
                graph.addVertex(v);
            }

            int nbE = in.nextInt();
            for (int i = 0; i < nbE; i++) {
                int s = in.nextInt();
                int t = in.nextInt();
                int capacity = in.nextInt();
                graph.addEdge(V.get(s-1), V.get(t-1), capacity);
            }

            System.out.println("it's done");

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return graph;

    }

    public static FlowNetworkGraph<EdgeFlow, Vertex> generateGraphNetworkFlow05() {
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        FlowNetworkGraph<EdgeFlow, Vertex> graph =
                new FlowNetworkGraph<EdgeFlow, Vertex>(v0, v5, GraphProperties.CONSOLE) {
                };

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v0, v1, 10);
        graph.addEdge(v0, v2, 10);
        graph.addEdge(v1, v2, 2);
        graph.addEdge(v1, v3, 4);
        graph.addEdge(v1, v4, 8);
        graph.addEdge(v2, v4, 9);
        graph.addEdge(v4, v3, 6);
        graph.addEdge(v3, v5, 10);
        graph.addEdge(v4, v5, 10);

        return graph;
    }



}
