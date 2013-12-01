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
import graph.algorithm.GenerateGraphTest;
import junit.framework.TestCase;

public class EdmondsKarpTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAlgorithmEdmondsKarpTest01(){

        FlowNetworkGraph<EdgeFlow,Vertex> graph = GenerateGraphTest.generateGraphNetworkFlow01();

        System.out.println(graph.toString());

        EdmondsKarp<EdgeFlow,Vertex> edmondsKarp = new EdmondsKarp<EdgeFlow, Vertex>(graph);

        edmondsKarp.execute();

        assertEquals(edmondsKarp.getFlowMaximal(),4);
    }

    public void testAlgorithmEdmondsKarpTest03(){
        FlowNetworkGraph<EdgeFlow,Vertex> graph = GenerateGraphTest.generateGraphNetworkFlow03();

        System.out.println(graph.toString());

        EdmondsKarp<EdgeFlow,Vertex> edmondsKarp = new EdmondsKarp<EdgeFlow, Vertex>(graph);

        edmondsKarp.execute();

        assertEquals(edmondsKarp.getFlowMaximal(),27);

    }
}
