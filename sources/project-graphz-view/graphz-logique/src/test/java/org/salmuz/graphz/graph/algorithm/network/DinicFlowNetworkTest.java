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

import junit.framework.TestCase;

import org.salmuz.graphz.graph.algorithm.GenerateGraphTest;

import org.salmuz.graphz.structure.graph.FlowNetworkGraph;
import org.salmuz.graphz.structure.graph.edge.decorator.EdgeFlow;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

public class DinicFlowNetworkTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testDinicAlgorithm01(){
        FlowNetworkGraph<EdgeFlow,Vertex> graph = GenerateGraphTest.generateGraphNetworkFlow01();

        System.out.println(graph.toString());

        DinicFlowNetwork<EdgeFlow,Vertex> dinicFlowNetwork = new DinicFlowNetwork<EdgeFlow, Vertex>(graph);

        dinicFlowNetwork.execute();

        assertEquals(dinicFlowNetwork.getFlowMaximal(),4);
    }

    public void testDinicAlgorithm03(){
        FlowNetworkGraph<EdgeFlow,Vertex> graph = GenerateGraphTest.generateGraphNetworkFlow03();

        System.out.println(graph.toString());

        DinicFlowNetwork<EdgeFlow,Vertex> dinicFlowNetwork = new DinicFlowNetwork<EdgeFlow, Vertex>(graph);

        dinicFlowNetwork.execute();

        assertEquals(dinicFlowNetwork.getFlowMaximal(),27);

    }

    public void testDinicAlgorithm02(){
        FlowNetworkGraph<EdgeFlow,Vertex> graph = GenerateGraphTest.generateGraphNetworkFlow02();

        System.out.println(graph.toString());

        DinicFlowNetwork<EdgeFlow,Vertex> dinicFlowNetwork = new DinicFlowNetwork<EdgeFlow, Vertex>(graph);

        dinicFlowNetwork.execute();

        assertEquals(dinicFlowNetwork.getFlowMaximal(),30);

    }

    public void testDinicAlgorithm05(){

        FlowNetworkGraph<EdgeFlow,Vertex> graph = GenerateGraphTest.generateGraphNetworkFlow05();

        DinicFlowNetwork<EdgeFlow,Vertex> dinicFlowNetwork = new DinicFlowNetwork<EdgeFlow, Vertex>(graph);

        dinicFlowNetwork.execute();

        assertEquals(dinicFlowNetwork.getFlowMaximal(),19);

    }



}
