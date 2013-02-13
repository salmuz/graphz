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

import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.EdgeFactory;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.Set;

/**
 *
 * C'est une interface qui heritent lui aussi des autres classes comme AbstractEdge
 * elle permet de definir la propriete d'un graphe donc c'est quel rassemble les elements commun de deux classes DirecedGraph et GraphNoOrient
 * elle possede de type de variables Edge et node
 *
 * @param <Edge>   cette parametre c'est l'aret
 * @param <Node>   cette parametre c'est le sommet
 *
 */

public abstract class Graph<Edge extends AbstractEdge,Node extends Vertex> {
   /**
     * ce sont les variables de la classe Graph
     *
     * @param clazz est de type Class<Edge>
     * @param edgeSet est de type Set<Edge>
     * @param vertexSet est de type Set<Node
     */
    public Class<Edge> clazz;
    public Set<Edge> edgeSet;
    public Set<Node> vertexSet;

    /**
     *
     * c'est une methode qui permet de modifier  l'Edge(arrete)du graphe
     *
     * pas de paremetre pour la methode get
     *
     * @return    la methode retourne de type  Set<Edge>
     *
     */
    public Set<Edge> getEdgeSet() {
        return edgeSet;
    }

    /**
     *  c'est une methode qui permet d'afficher la valeur du VertexSetdu graphe
     *
     * pas de paremetre pour la methode get
     *
     * @return   : la methode retourne de type  Set<Node>
     *
     */
    public Set<Node> getVertexSet() {
        return vertexSet;
    }

    /**
     * C'est une methdode qui permet d'ajouter une Edge(arrete) au graphe qui relie entre deux Node (sommet)
     *
     * @param source: c'est le premier Node
     *
     * @param target: C'est le seconde Node
     *
     * @return: cette methode retourne un Edge(arrete)
     */
    public Edge addEdge(Node source, Node target){
        Edge edge = (Edge) EdgeFactory.createEdge(clazz,source, target);
        edgeSet.add(edge);
        return edge;
    }

    /**
     * Cette methode permet de verifier si on peut ajouter une edge(arrete)
     * au graphe c'est a dire elle verifie dans le graphe si cet edge(arrete) existe
     * sinon elle rajoute
     *
     * @param edge: c'est l'edge(arrete)  que vous avez definis pour verifier si il est dans le graphe ou pas
     *
     * @return  :la methode retourne de type boolean     si la methode return true vous pouvez ajouter
     * ce Edge au graphe sinon vous pouvez pas
     */
    public boolean addEdge(Edge edge){
        if(edgeSet.contains(edge)){
            return false;
        }
        edgeSet.add(edge);
        return true;
    }

    /**
     * C'est methode aussi verifie si on peut ajouter une Node au graphe de meme si on a
     * pas dans le graphe ce type de Node definis pour ajouter alors
     * rajoute dans le graphe sino return false pour ajouter un tel Node
     *
     * @param vertex  : C'est une parametre qui verifie avant d'ajouter le Node si il existe ou pas
     * @return
     */

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

}
