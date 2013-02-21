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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Cette classe graphe est une classe qui rassemble les propriétés entre GraphNoOrient et DirectedGraph
 * pour la possibilité des client on a partager les deux classes graphNoOrienté et classe Directedgraph
 *
 * @param <Edge>     c'est la variable arrete du graphe
 * @param <Node>     c'est la variables sommet
 */

public abstract class Graph<Edge extends AbstractEdge,Node extends Vertex> {

    protected final Class<AbstractEdge> clazzEdge;
    protected final Class<? extends ShapeGeometric> clazzEdgeShape;
    protected final Class<Vertex> clazzVertex;
    protected final Class<? extends ShapeGeometric> clazzVertexShape;

    protected List<Edge> edgeList;
    protected List<Node> vertexList;

    protected Graph() {
        this.clazzEdgeShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 0);
        this.clazzVertexShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 1);

        this.clazzEdge = Reflection.getParamGenericOfSuperCLass(this.getClass().getSuperclass(),0);
        this.clazzVertex = Reflection.getParamGenericOfSuperCLass(this.getClass().getSuperclass(),1);
    }
    /**
     * C'est une methode getEdgeSet qui permet d'acceder la valeur du variable Edege
     *
     * @return  la methode  retour une liste des edge cela veut dire que dans cette methode on peut mettre plusieur objet different
     */
    public List<Edge> getEdgeList() {
        return edgeList;
    }


    public List<Node> getVertexList() {
        return vertexList;
    }

    public Edge createEdge(Node source, Node target){
       return (Edge) EdgeFactory.createEdge(clazzEdge,source, target);
    }

    public Edge addEdge(Node source, Node target){
        Edge edge = (Edge) EdgeFactory.createEdge(clazzEdge,source, target);
        edgeList.add(edge);
        return edge;
    }
    /**
     * C'est une methode qui permet de verifier si on peut ajouter une Edge dans un graphes ou non
     * car avec deux Node qui sont deja relier tu peut pas une autre fois relier donc la methode avant a besoin cette methode
     *et puis elle rajout dans le graph
     * @param edge ce parametre est une edge quand teste si on peut inserer dans le graph ou pas
     *
     * @return  elle reourne boolean
    */
    public boolean addEdge(Edge edge){
        if(edgeList.contains(edge)){
            return false;
        }
        edgeList.add(edge);
        return true;
    }

    /**
     * C'est une methode qui permet de tester si on peut  rajouter un node dans le graph
     *
     * @param vertex   c'est une variable de type node quand teste si on  rajouter dans le graph
     *
     * @return de type boolean
     */
    public boolean addVertex(Node vertex){
        if(vertexList.contains(vertex)){
            return false;
        }
        vertexList.add(vertex);
        return true;
    }
    /**
     * C'est une methode qui permet de verifier si une  arrete existe ou pas entre deux nodes
     *
     * ce sont deux variables de types node
     * @param source
     * @param target
     *
     * @return
     */
    public boolean containsEdge(Node source, Node target){
        throw new UnsupportedOperationException();
    }
    /**
     * C'est une methode qui permet de verifier si une  arrete existe ou pas a partir de la definition d'une arrete
     *
     * on verifie si cet edge appartient a graphes
     * @param edge
     *
     * @return  de types boolean si elle existe ou pas
     */
    public boolean containsEdge(Edge edge){
       return edgeList.contains(edge);
    }
    /**
     * C'est une methode qui permet verifier si un Node est dans un graphe
     *
     * @param vertex   on teste si ce Node appartient dans le graphe
     *
     * @return return boolean pour connaitre si elle est contenu dans le graphe ou pas
     */
    public boolean containsVertex(Node vertex){
       return vertexList.contains(vertex);
    }
    /**
     * C'est une methode qui permet de supprimer un Edge dans un graphe
     *
     *  pour suprimer il faut suppimer un Edge qui se trouve entre ce deux sommets
     * @param source
     * @param target
     *
     * @return Elle retourne un Edge si ce impossible pour supprimer l'Edge
     */
    public void removeEdge(Node source, Node target){
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            Vertex v0 = edge.getSource();
            Vertex v1 = edge.getTarget();
            if ((v0.equals(source) && v1.equals(target))) {
                edgeList.remove(edge);
            }
        }
    }
    /**
     * C'est une methode qui permet de supprimer un Edge dans un graphe
     *
     *  pour suprimer il faut suppimer un Edge qui se trouve dans la liste des edges
     *
     * @param source
     * @param target
     *
     * @return Elle retourne un boolean si ce impossible pour supprimer l'Edge ou pas
     */
    public boolean removeEdge(Edge edge){
        return edgeList.remove(edge);
    }
    /**
     * C'est une methode qui permet de supprimer un Vertex dans un graphe
     *
     * pour suprimer il faut suppimer un Node il faut preciser le node
     * @param Vertex
     *
     * @return Elle retourne un Edge si ce impossible pour supprimer l'Edge
     */
    public boolean removeVertex(Node vertex){
        return vertexList.remove(vertex);
    }

    /**
     *
     * indique la classe  de L'edge
     *
     * @return elle retourne la classe
     *
     */
    public Class<AbstractEdge> getClazzEdge() {
        return clazzEdge;
    }
    /**
     *
     * indique la classe  de l'EdgeShape
     *
     * @return elle retourne la classe
     *
     */
    public Class<? extends ShapeGeometric> getClazzEdgeShape() {
        return clazzEdgeShape;
    }

    /**
     *
     * @return
     */
    public Class<Vertex> getClazzVertex() {
        return clazzVertex;
    }

    /**
     *
     * @return
     */
    public Class<? extends ShapeGeometric> getClazzVertexShape() {
        return clazzVertexShape;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Node getVertexShape(double x,double y){

       Iterator<Node> it = getVertexList().iterator();
       while(it.hasNext()){
          Node node = it.next();
          if(node.getVertex().contains(x,y)){
              return node;
          }
       }

       return null;
    }

    /**
     *
     * @param vertex
     * @param excludes
     * @return
     */
    public boolean isVertexSamePlace(Node vertex,Node ... excludes){
        Iterator<Node> it = getVertexList().iterator();
        while(it.hasNext()){
            Node item = it.next();
            boolean exclude = false;
            for(int i=0;i<excludes.length;i++){
                if(excludes[i].equals(item)){
                   exclude=true;break;
                }
            }
            if(!exclude && item.getVertex().intersect(vertex.getVertex())){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param vertex0
     * @return
     */
    public Set<Edge> getEdgesOfVertex(Vertex vertex0){
        Set<Edge> edges = new HashSet<Edge>();
        Iterator<Edge> it = edgeList.iterator();
        while(it.hasNext()){
            Edge edge = it.next();
            if(edge.getSource().equals(vertex0)){
               edges.add(edge);
            }else{
               if(edge.getTarget().equals(vertex0)){
                  edges.add(edge);
               }
            }
        }
        return edges;
    }
}
