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
 * 31/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.mvp.model;

import fr.edu.bp.m1info.logique.InterfaceOfConverteStructureGraphe;
import fr.edu.bp.m1info.mvp.common.Repository;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.modelgraph.ModelManager;
import org.soap.graph.GetGraphResponse;
import org.soap.graph.GraphsSOAP;
import org.soap.graph.GraphsSOAP_Service;

import java.awt.*;

/**
 * ce classe permet a faire les actions a faire dans une base des données pour la table Edge
 */
public class GrapheRepository extends Repository{

    public boolean enregistreGraphe(Graph<AbstractEdge,Vertex> graphe,String name) {


        GraphsSOAP_Service service=new   GraphsSOAP_Service();
        GraphsSOAP soap = service.getGraphsSOAPPort();

        soap.createGraph(false,name,"salmuz","123456");
        for(Vertex node:graphe.getVertexList()){
             soap.addNode(name,node.getValue().toString(),"salmuz","123456");
        }

        for(AbstractEdge edge:graphe.getEdgeList()){
          soap.addEdgeByLabel(name,edge.getSource().getValue().toString(),
                  edge.getTarget().getValue().toString(),
                  Integer.valueOf(edge.getWeight().toString()),"salmuz","123456");
        }



        return false;
    }

    @Override
    public void openGraphe(Graph grapheDesi,Rectangle rectangle,String name) {
        GraphsSOAP_Service service=new   GraphsSOAP_Service();
        GraphsSOAP soap = service.getGraphsSOAPPort();
        org.soap.graph.GetGraphResponse.Return returnG = soap.getGraph(name, "salmuz", "123456");


        ModelManager manager = ModelManager.getInstance();

        int idGraph = manager.createGraph(false, returnG.getName());

        for(GetGraphResponse.Return.Node nodeR:returnG.getNode()){
            manager.addNode(idGraph,nodeR.getName());
        }

        for(GetGraphResponse.Return.Node nodeR:returnG.getNode()){
            for(GetGraphResponse.Return.Node.Edge edge: nodeR.getEdge()){
              manager.addEdge(idGraph, String.valueOf(edge.getNodeA()), String.valueOf(edge.getNodeB()), edge.getWeight());
            }
        }

        graph.modelgraph.Graph graphe = manager.get(idGraph);
        InterfaceOfConverteStructureGraphe.converterGrapheT1ToGrapheT5(graphe,grapheDesi,rectangle);
    }
}
