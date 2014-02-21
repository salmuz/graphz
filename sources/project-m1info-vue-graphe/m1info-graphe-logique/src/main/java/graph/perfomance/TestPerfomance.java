/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
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

package graph.perfomance;

import fr.edu.bp.m1info.structure.common.GraphProperties;
import fr.edu.bp.m1info.structure.graph.FlowNetworkGraph;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.network.CapacityScaling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestPerfomance {

    public static FlowNetworkGraph<EdgeFlow, Vertex> generateGraphNetworkFlowWithFile(String pathfile) {
        FlowNetworkGraph<EdgeFlow, Vertex> graph =  null;
        File file = new File(pathfile);
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

            System.out.println("it's done, graph network");

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return graph;

    }

    public static void main(String ...arg){

        if(arg.length < 0 && arg.length > 2) throw new IllegalArgumentException("Argument illegals");

        FlowNetworkGraph<EdgeFlow,Vertex> graph = generateGraphNetworkFlowWithFile(arg[0]);
        //DinicFlowNetwork<EdgeFlow,Vertex> flow = new DinicFlowNetwork<EdgeFlow, Vertex>(graph);
        //FordFulkerson<EdgeFlow,Vertex> flow = new FordFulkerson<EdgeFlow, Vertex>(graph);
        //EdmondsKarp<EdgeFlow,Vertex> flow = new EdmondsKarp<EdgeFlow, Vertex>(graph);
        CapacityScaling<EdgeFlow,Vertex> flow = new CapacityScaling<EdgeFlow, Vertex>(graph);
        long time = System.currentTimeMillis();
        flow.execute();
        System.out.println(arg[0]);
        System.out.println("scaling Time :"+(System.currentTimeMillis() - time ));

    }
}
