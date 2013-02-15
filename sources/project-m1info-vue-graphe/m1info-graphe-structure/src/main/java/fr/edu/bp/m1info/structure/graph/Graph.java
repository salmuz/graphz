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
 * 12/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.graph;

import fr.edu.bp.m1info.structure.common.Reflection;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.EdgeFactory;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * The instance of the class must be create like anonymous.
 * Graph<...> graph = new SubTypeGraph<...>(){ }
 *
 */
public abstract class Graph<Edge extends AbstractEdge,Node extends Vertex> {

    protected final Class<AbstractEdge> clazzEdge;
    protected final Class<? extends ShapeGeometric> clazzEdgeShape;
    protected final Class<Vertex> clazzVertex;
    protected final Class<? extends ShapeGeometric> clazzVertexShape;

    protected Set<Edge> edgeSet;
    protected Set<Node> vertexSet;

    protected Graph() {
        this.clazzEdgeShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 0);
        this.clazzVertexShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 1);

        this.clazzEdge = Reflection.getParamGenericOfSuperCLass(this.getClass().getSuperclass(),0);
        this.clazzVertex = Reflection.getParamGenericOfSuperCLass(this.getClass().getSuperclass(),1);
    }

    public Set<Edge> getEdgeSet() {
        return edgeSet;
    }

    public Set<Node> getVertexSet() {
        return vertexSet;
    }

    public Edge addEdge(Node source, Node target){
        Edge edge = (Edge) EdgeFactory.createEdge(clazzEdge,source, target);
        edgeSet.add(edge);
        return edge;
    }

    public boolean addEdge(Edge edge){
        if(edgeSet.contains(edge)){
            return false;
        }
        edgeSet.add(edge);
        return true;
    }

    public boolean addVertex(Node vertex){
        if(vertexSet.contains(vertex)){
            return false;
        }
        vertexSet.add(vertex);
        return true;
    }

    public boolean containsEdge(Node source, Node target){
        throw new UnsupportedOperationException();
    }

    public boolean containsEdge(Edge edge){
       return edgeSet.contains(edge);
    }

    public boolean containsVertex(Node vertex){
       return vertexSet.contains(vertex);
    }

    public Edge removeEdge(Node source, Node target){
         throw new UnsupportedOperationException();
    }

    public boolean removeEdge(Edge edge){
        return edgeSet.remove(edge);
    }

    public boolean removeVertex(Node vertex){
        return vertexSet.remove(vertex);
    }

    public Class<AbstractEdge> getClazzEdge() {
        return clazzEdge;
    }

    public Class<? extends ShapeGeometric> getClazzEdgeShape() {
        return clazzEdgeShape;
    }

    public Class<Vertex> getClazzVertex() {
        return clazzVertex;
    }

    public Class<? extends ShapeGeometric> getClazzVertexShape() {
        return clazzVertexShape;
    }


    public Node getVertexShape(double x,double y){

       Iterator<Node> it = getVertexSet().iterator();
       while(it.hasNext()){
          Node node = it.next();
          if(node.getVertex().contains(x,y)){
              return node;
          }
       }

       return null;

    }

}
