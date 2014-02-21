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

package graph.algorithm.path;

import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.Arc;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.GenerateGraphTest;
import junit.framework.TestCase;

public class BreadthFirstPathTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testBFSAlgorithm(){

        Graph<Edge, Vertex> graph = GenerateGraphTest.generateUnDirectedGraph();

        System.out.println(graph.toString());

        AbstractPath<Arc, Vertex> paths = new BreadthFirstPath(graph, graph.getVertex().get(0));
        paths.execute();

        for (int v = 0; v < graph.sizeVertex(); v++)
            if (paths.hasPathTo(v)) {
                System.out.println("belong sink:" + v);
            }

        Vertex v4 = graph.getVertex().get(graph.sizeVertex()-2);

        int path[] = {4,5,0};
        int index = 0;
        for (Vertex v : paths.pathTo(v4)) {
            System.out.println(v);
            assertEquals(v.getValue(),path[index++]);
        }

        int pathOUT[] = {5,0};
        int pathIn[] = {4,5};
        index = 0;
        for (IEdge e : paths.pathTo(v4.getValue())) {
            System.out.println(e);
            assertEquals(e.from().getValue(),pathOUT[index]);
            assertEquals(e.to().getValue(),pathIn[index]);
            index++;
        }
    }
}
