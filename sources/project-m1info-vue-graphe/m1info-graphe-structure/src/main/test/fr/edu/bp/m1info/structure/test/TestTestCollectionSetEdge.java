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
 * Contributor(s):  Coz Velasquez Antonio
 * 					Kalil DAHER MOHAMED
 *                  Aben Nouh Abdirazak 
 *
 * Changes
 * -------
 * 16/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.test;


import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestTestCollectionSetEdge extends TestCase{

    public void testSetCollection(){
        Set<AbstractEdge>  edgeSet = new HashSet<AbstractEdge> ();

        Vertex<Integer,Circle> v0 = new Vertex<Integer, Circle>();
        v0.setVertex(new Circle(new Point2D(196,154),10));
        Vertex<Integer,Circle> v1 = new Vertex<Integer, Circle>();
        v1.setVertex(new Circle(new Point2D(290,83),10));

        Edge<Integer,Line> e0 = new Edge<Integer,Line>(v0,v1,0);
        e0.setEdge(new Line(new Point2D(196,154),new Point2D(290,83)));

        Edge<Integer,Line> e1 = new Edge<Integer,Line>(v0,v1,0);
        e1.setEdge(new Line(new Point2D(100,154),new Point2D(290,83)));

        edgeSet.add(e0);
        edgeSet.add(e1);
        //e1.getEdge().().setX(196);
        System.out.println(e0.hashCode() == e1.hashCode());
        System.out.println(edgeSet.contains(e1));
        System.out.println(edgeSet.size());
        assertEquals(edgeSet.size(), 1);
    }

    public int countTestCases() {
        return 0;
    }


    @Override
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
     