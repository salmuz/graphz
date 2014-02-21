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

import org.salmuz.graphz.structure.graph.Graph;
import org.salmuz.graphz.structure.graph.edge.decorator.EdgeFlow;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

public final class NetworkUtils {

    public static void showFlowInNetworkWithoutResidualGraph(Graph<EdgeFlow,Vertex> graph){

        StringBuffer buff = new StringBuffer();
        for(Vertex node : graph.getVertex()){
            for(EdgeFlow w : graph.adjacencys(node.getValue())){
                if(node.getValue() == w.from().getValue())
                    buff.append("(Arc =(" + w.from().getValue() + "," + w.to().getValue() + "), Flow=" + w.flow() + ")\n");
            }
        }

        System.out.println(buff.toString());

    }
}
