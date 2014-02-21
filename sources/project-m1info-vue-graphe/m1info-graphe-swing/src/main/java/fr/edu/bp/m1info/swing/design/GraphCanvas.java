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
 * 13/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.swing.design;

import fr.edu.bp.m1info.structure.common.GraphProperties;
import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeDecorator;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeName;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.IterativeView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphCanvas<Edge extends IEdge,Node extends Vertex>
        extends Canvas implements IterativeView<Edge,Node> {

    private Graph<Edge,Node> graph;
    private List<Edge> draftEdge;

    public GraphCanvas(Graph<Edge,Node> graph) {
        super();
        this.graph = graph;
        this.draftEdge = new ArrayList<Edge>();
    }

    public Graph<Edge, Node> getGraph() {
        return graph;
    }

    @Override
    public void update(java.awt.Graphics g) {
      paint(g);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Graphics2D  g2D = (Graphics2D)g;
        Graphics graphics = new DesignGeometric2D(g2D);

        for (Edge e: draftEdge){
            e.draw(graphics);
        }

        for (Edge e : graph.getEdges()) {
            e.draw(graphics);
        }

        for (Node n : graph.getVertex()) {
            n.draw(graphics);
        }

    }

    public List<Edge> getDraftEdge() {
        return draftEdge;
    }

    public void setGraph(Graph<Edge, Node> graph) {
        this.graph = graph;
    }

    public void updateView(Node node, Edge edge, Color cnode, Color cedge){
        if(node != null) node.getVertex().parentComponent().shape().setBackground(cnode);
        if(edge != null) edge.getShape().shape().setColor(cedge);
        repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void updateView(Graph<Edge, Node> graph) {
        //this.graph = new Cloner().deepClone(ograph);

        // remove edge avec capacity or weigh cero
        for(Node v : graph.getVertex()){
            for(Edge e : graph.adjacencys(v)){
               if(((Integer)e.weight()).intValue()<=0){
                   graph.removeEdge((Node)e.from(),(Node)e.to());
               }else{
                  EdgeName ename = (EdgeName) ((EdgeDecorator) e.getShape()).childEdgeShape();
                  ename.setMessage(e.weight().toString());
               }
            }
        }

        repaint();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void updateView(Iterable<Edge> path) {
        for (Edge edge : path) {
            if(edge != null)
                this.updateView((Node)edge.from(),edge,Color.RED,Color.RED);
        }

        repaint();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        // recuperar valores
        for (Edge edge : path) {
            if(edge != null)
                this.updateView((Node)edge.from(),edge,
                    GraphProperties.VERTEX_COLOR,GraphProperties.EDGE_COLOR);
        }

    }
}
