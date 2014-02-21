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
 * Contributor(s):  Coz Velasquez Antonio
 * 					Kalil DAHER MOHAMED
 *                  Aben Nouh Abdirazak 
 *
 * Changes
 * -------
 * 13/02/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.graph.edge;


import org.salmuz.graphz.structure.graph.edge.decorator.EdgeFlow;
import org.salmuz.graphz.structure.graph.edge.decorator.EdgeWeight;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

public class EdgeFactory {

    public static AbstractEdge createEdge(Class clazz,Vertex source, Vertex target,Object ...value){

        AbstractEdge<Integer> edge = null;

        if(clazz.isAssignableFrom(Edge.class)){
            edge = new Edge(source,target);
        }else{
            if(clazz.isAssignableFrom(Arc.class)){
                edge = new Arc(source,target);
            }else{
                if(clazz.isAssignableFrom(EdgeWeight.class)){
                   int weight = 0;
                   if(value != null) weight = (Integer)value[0];
                   edge = new EdgeWeight(new Arc(source,target),weight);
                }else{
                    if(clazz.isAssignableFrom(EdgeFlow.class)){
                        int capacity = 0, flow = 0;
                        if(value != null) capacity = (Integer)value[0];
                        edge = new EdgeFlow(new Arc(source,target),capacity,flow);
                    }
                }
            }

        }

        return edge;
    }

}
