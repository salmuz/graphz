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
 * 31/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.mvp.model;

import fr.edu.bp.m1info.mvp.common.Repository;
import fr.edu.bp.m1info.mvp.presenter.NewGraphPresenter;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.shape.vertex.AbstractVertexShape;
import fr.edu.bp.m1info.structure.geometric.graph.shape.vertex.VertexName;
import fr.edu.bp.m1info.structure.geometric.graph.shape.vertex.VertexShape;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;
import fr.edu.bp.m1info.structure.graph.DirectedGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.UnDirectedGraph;
import fr.edu.bp.m1info.structure.graph.edge.*;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.design.GraphCanvas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ce classe permet a faire les actions a faire dans une base des données pour la table Edge
 */
public class GrapheRepository extends Repository {

    @Override
    public boolean enregistreGraphe(Graph<AbstractEdge, Vertex> graphe, String name) {

        try {
            File file = new File(name);
            file.createNewFile();
            FileWriter filewrite = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(filewrite);

            int type = (graphe instanceof DirectedGraph ? 1 : 2);
            bw.write(type+ "\n");
            bw.write(graphe.sizeVertex() + "\n");

            java.util.List<IEdge> edges = new ArrayList<IEdge>();
            for (Vertex v : graphe.getVertex()) {
                bw.write(v.getValue() + " ");
                bw.write((int)v.getVertex().parentComponent().shape().centre().getX() + " ");
                bw.write((int)v.getVertex().parentComponent().shape().centre().getY() + "\n");
                for(IEdge e : graphe.adjacencys(v)){
                    edges.add(e);
                }
            }

            bw.write(edges.size() + "\n");
            for(IEdge e : edges){
                bw.write(e.from().getValue()+" ");
                bw.write(e.to().getValue()+"\n");

            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public GraphCanvas openGraphe(String name) {

        GraphCanvas canvas = null;
        try {
            File file = new File(name);
            Scanner in = new Scanner(file);
            int type = in.nextInt();
            Graph graph;
            if (type == NewGraphPresenter.GRAPHE_NON_ORIENTE) {
                graph = new UnDirectedGraph<Edge, Vertex>() {
                };
                canvas = new GraphCanvas<Edge, Vertex>(graph);
            } else {
                if (type == NewGraphPresenter.GRAPHE_ORIENTE) {
                    graph = new DirectedGraph<Arc, Vertex>() {
                    };
                    canvas = new GraphCanvas<Arc, Vertex>(graph);
                } else {
                    throw new UnsupportedOperationException("Not supported");
                }
            }

            int nV = in.nextInt();
            for (int i = 0; i < nV; i++) {
                int v = in.nextInt();
                double x = in.nextDouble();
                double y = in.nextDouble();
                Vertex vertex = new Vertex();
                ShapeGeometric sh = ShapePlaneFactory.createShape(canvas.getGraph().getClazzVertexShape(), x, y);
                AbstractVertexShape vertexShape = new VertexName(new VertexShape(sh), String.valueOf(vertex.getValue()));
                vertex.setVertex(vertexShape);
                canvas.getGraph().addVertex(vertex);
            }

            int nE = in.nextInt();
            for (int i = 0; i < nE; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                Vertex vfrom = (Vertex) graph.getVertex().get(from);
                Vertex vto = (Vertex) graph.getVertex().get(to);
                canvas.getGraph().addEdge(vfrom, vto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return canvas;
    }

//    public boolean enregistreGraphe(Graph<AbstractEdge,Vertex> graphe,String name) {
//
//        GraphsSOAP_Service service=new   GraphsSOAP_Service();
//        GraphsSOAP soap = service.getGraphsSOAPPort();
//
//        soap.createGraph(false,name,"salmuz","123456");
//        for(Vertex node:graphe.getVertexList()){
//             soap.addNode(name,node.getValue().toString(),"salmuz","123456");
//        }
//
//        for(AbstractEdge edge:graphe.getEdgeList()){
//          soap.addEdgeByLabel(name,edge.source().getValue().toString(),
//                  edge.sink().getValue().toString(),
//                  Integer.valueOf(edge.getWeight().toString()),"salmuz","123456");
//        }
//
//
//
//        return false;
//    }
//
//    @Override
//    public void openGraphe(Graph grapheDesi,Rectangle rectangle,String name) {
//        GraphsSOAP_Service service=new   GraphsSOAP_Service();
//        GraphsSOAP soap = service.getGraphsSOAPPort();
//        org.soap.graph.GetGraphResponse.Return returnG = soap.getGraph(name, "salmuz", "123456");
//
//
//        ModelManager manager = ModelManager.getInstance();
//
//        int idGraph = manager.createGraph(false, returnG.getName());
//
//        for(GetGraphResponse.Return.Node nodeR:returnG.getNode()){
//            manager.addNode(idGraph,nodeR.getName());
//        }
//
//        for(GetGraphResponse.Return.Node nodeR:returnG.getNode()){
//            for(GetGraphResponse.Return.Node.Edge edge: nodeR.getShape()){
//              manager.addEdge(idGraph, String.valueOf(edge.getNodeA()), String.valueOf(edge.getNodeB()), edge.getWeight());
//            }
//        }
//
//        graph.modelgraph.Graph graphe = manager.get(idGraph);
//        InterfaceOfConverteStructureGraphe.converterGrapheT1ToGrapheT5(graphe,grapheDesi,rectangle);
//    }
}
