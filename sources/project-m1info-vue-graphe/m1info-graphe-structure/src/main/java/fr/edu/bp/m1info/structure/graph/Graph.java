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
 * 12/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.graph;

import fr.edu.bp.m1info.structure.common.Reflection;
import fr.edu.bp.m1info.structure.geometric.ConstantsGeometric;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.DefaultVertexName;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Cette classe graphe est une classe qui rassemble les propriétés entre UnDirectedGraph et DirectedGraph
 * pour la possibilité des client on a partager les deux classes graphNoOrienté et classe Directedgraph
 *
 * @param <Edge> c'est la variable arrete du graphe
 * @param <Node> c'est la variables sommet
 */

public abstract class Graph<Edge extends IEdge, Node extends Vertex> {

    protected static int TYPE_EXECUTION = -1;
    //structures to do the algorithms
    protected AdjacencyBag<Edge,Node>[] adjacencys;
    private static final int MIN_CAPACITY = 10;
    private int sizeAdj;

    public static int NOT_FOUND_KEY = -1;

    protected final Class<? extends IEdge> clazzEdge;
    protected final Class<? extends ShapeGeometric> clazzEdgeShape;
    protected final Class<? extends Vertex> clazzVertex;
    protected final Class<? extends ShapeGeometric> clazzVertexShape;

    protected List<Node> nodes;
    protected List<Edge> edges;


    protected Graph() {
//        this.clazzEdgeShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 0);
//        this.clazzVertexShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 1);

        this.clazzEdgeShape = Line.class;
        this.clazzVertexShape = Circle.class;

        // modify version 2
        this.clazzEdge = Reflection.getParamGenericOfSuperCLass(this.getClass(), 0);
        this.clazzVertex = Reflection.getParamGenericOfSuperCLass(this.getClass(), 1);

        this.clear();
    }

    public Graph(int typeExecution) {
        this();
        this.TYPE_EXECUTION = typeExecution;
    }

    /**
     *
     * @return
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     *
     * @return
     */
    public List<Node> getVertex(){
        return nodes;
    }

    /**
     *
     * @return
     */
    public int sizeVertex(){
        return nodes.size();
    }

     /**
      * It just adds one direction (DirectedGraph)
      *
      * @param  source
      * @param  target
      */
    public abstract void addEdge(Node source, Node target);

    /**
     * C'est une methode qui permet de tester si on peut  rajouter un node dans le graph
     *
     * @param node c'est une variable de type node quand teste si on  rajouter dans le graph
     * @return de type boolean
    */
    public void addVertex(Node node) {
        nodes.add(node);
        int index = newIndexOfVertex(node);
        adjacencys[index] = new AdjacencyBag<Edge,Node>();
        sizeAdj++;
    }

    /**
     * C'est une methode qui permet de verifier si une  arrete existe ou pas entre deux nodes
     * <p/>
     * ce sont deux variables de types node
     *
     * @param source
     * @param target
     * @return
     */
    public abstract boolean containsEdge(Node source, Node target);

    /**
     * C'est une methode qui permet de verifier si une  arrete existe ou pas a partir de la definition d'une arrete
     * <p/>
     * on verifie si cet edge appartient a graphes
     *
     * @param edge
     * @return de types boolean si elle existe ou pas
     */
    public abstract boolean containsEdge(Edge edge);

    /**
     * C'est une methode qui permet verifier si un Node est dans un graphe
     *
     * @param node on teste si ce Node appartient dans le graphe
     * @return return boolean pour connaitre si elle est contenu dans le graphe ou pas
     */
    public boolean containsVertex(Node node) {
        return nodes.contains(node);
    }

    /**
     * C'est une methode qui permet de supprimer un Edge dans un graphe
     * <p/>
     * pour suprimer il faut suppimer un Edge qui se trouve entre ce deux sommets
     *
     * @param source
     * @param target
     * @return Elle retourne un Edge si ce impossible pour supprimer l'Edge
     */
    public abstract void removeEdge(Node source, Node target);

    /**
     * C'est une methode qui permet de supprimer un Edge dans un graphe
     * <p/>
     * pour suprimer il faut suppimer un Edge qui se trouve dans la liste des edges
     *
     * @param edge
     * @return Elle retourne un boolean si ce impossible pour supprimer l'Edge ou pas
     */
    public boolean removeEdge(Edge edge) {
        return edges.remove(edge);
    }

    /**
     * C'est une methode qui permet de supprimer un Vertex dans un graphe
     * <p/>
     * pour suprimer il faut suppimer un Node il faut preciser le node
     *
     * @param node
     * @return Elle retourne un Edge si ce impossible pour supprimer l'Edge
     */
    public boolean removeVertex(Node node) {
        removeEdgeAll(getEdgesOfVertex(node));
        nodes.remove(node);
        removeVertexAdj(node);
        return true;
    }

    /**
     * Remove all edges
     * @param edges
     */
    protected void removeEdgeAll(Collection<Edge> edges) {
        for (Edge edge : edges) {
            removeEdge(edge);
        }
    }

    /**
     * List of edges
     * @param node
     * @return list of edge
     */
    public List<Edge> getEdgesOfVertex(Node node) {
        List<Edge> redges = new ArrayList<Edge>();
        Iterator<Edge> it = edges.iterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            if (edge.getSource().equals(node)) {
                redges.add(edge);
            } else {
                if (edge.getTarget().equals(node)) {
                    redges.add(edge);
                }
            }
        }
        return redges;
    }

    public boolean removeVertexAdj(Node node){
        int index = indexOfVertex(node);

        if(index != NOT_FOUND_KEY){
            adjacencys[index].removeAll();
            for (int i = 0; i < adjacencys.length; i++) {
                if(adjacencys[i]!=null)adjacencys[i].remove(node);
            }
            adjacencys[index] = null;
        }

        return true;
    }


    /**
     * indique la classe  de L'edge
     *
     * @return elle retourne la classe
     */
    public Class<? extends IEdge> getClazzEdge() {
        return clazzEdge;
    }

    /**
     * indique la classe  de l'EdgeShape
     *
     * @return elle retourne la classe
     */
    public Class<? extends ShapeGeometric> getClazzEdgeShape() {
        return clazzEdgeShape;
    }

    /**
     * @return
     */
    public Class<? extends Vertex> getClazzVertex() {
        return clazzVertex;
    }

    /**
     * @return
     */
    public Class<? extends ShapeGeometric> getClazzVertexShape() {
        return clazzVertexShape;
    }

    /**
     * @param x
     * @param y
     * @return
     */
    public Node getVertexShape(double x, double y) {
        Iterator<Node> it = this.nodes.iterator();
        while (it.hasNext()) {
            Node node = it.next();
            ShapeGeometric shape = node.getVertex().parentComponent().shape();
            if (shape.contains(x, y)) {
                return node;
            }
        }

        return null;
    }

    public Iterable<Edge> adjacencys(Node node){
        int v = node.getValue();
        return adjacencys(v);
    }

    public Iterable<Edge> adjacencys(int v){
        if ((v < 0) || (v >= sizeVertex())) throw new IndexOutOfBoundsException("The node/vertex of graph don't has nodes adjacencies:"+v);
        return this.adjacencys[v];
    }

//    private void changeVertexOfEdge(Edge edge, Vertex vertex, Point point, Vertex newVertex) {
//        EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getShape();
//        if (edge.getSource().equals(vertex)) {
//            edge.setSource(newVertex);
//            e0.getPointStart().setX(point.getX());
//            e0.getPointStart().setY(point.getY());
//        } else {
//            edge.setTarget(newVertex);
//            e0.getPointEnd().setX(point.getX());
//            e0.getPointEnd().setY(point.getY());
//        }
//    }

 /*   public void contractEdge(Edge edge) {
        Vertex vertex = new Vertex();
        Point midPoint = ((EdgeShapeGraph) edge.getShape()).geMidPoint();
        vertex.setVertex(ShapePlaneFactory.createShape(getClazzVertexShape(), midPoint.getX(), midPoint.getY()));
        vertex.getVertex().setBackground(Color.ORANGE);
        vertex.getVertex().setColor(Color.ORANGE);

        if (removeEdge(edge)) {
            List<Edge> edgeSources = getEdgesOfVertex(edge.getSource());
            for (Edge item : edgeSources) {
                changeVertexOfEdge(item, edge.getSource(), midPoint, vertex);
            }
            List<Edge> edgeTarget = getEdgesOfVertex(edge.getTarget());
            for (Edge item : edgeTarget) {
                changeVertexOfEdge(item, edge.getTarget(), midPoint, vertex);
            }
            removeVertex((Node) edge.getSource());
            removeVertex((Node) edge.getTarget());
            addVertex((Node) vertex);
        }
    }



    public void separateVertex(Node node) {
        Vertex vertex01 = new Vertex();
        Vertex vertex02 = new Vertex();
        Point point = ((VertexShapeGraph) node.getVertex()).centreShape();
        // firts vertex
        Point pointV1 = new Point2D(point.getX() - 4 * ConstantsGeometric.RADIO, point.getY());
        vertex01.setVertex(ShapePlaneFactory.createShape(getClazzVertexShape(),
                pointV1.getX(), pointV1.getY()));
        vertex01.getVertex().setBackground(Color.ORANGE);
        vertex01.getVertex().setColor(Color.ORANGE);
        // second vertex
        Point pointV2 = new Point2D(point.getX() + 4 * ConstantsGeometric.RADIO, point.getY());
        vertex02.setVertex(ShapePlaneFactory.createShape(getClazzVertexShape(),
                pointV2.getX(), pointV2.getY()));
        vertex02.getVertex().setBackground(Color.ORANGE);
        vertex02.getVertex().setColor(Color.ORANGE);
        addVertex((Node) vertex01);
        addVertex((Node) vertex02);

        List<Edge> edgeSources = getEdgesOfVertex(node);
        for (Edge edge : edgeSources) {
            createEdgeInRelationToSource(node, (Node) vertex01, pointV1, edge);
            createEdgeInRelationToSource(node, (Node) vertex02, pointV2, edge);
        }

        //Edge between Vertex01 and Vertex02
        Edge newEdge = (Edge) EdgeFactory.createEdge(clazzEdge, vertex01, vertex02, null);
        newEdge.setShape(ShapePlaneFactory.createShape(clazzEdgeShape,
                pointV1.getX(), pointV1.getY(), pointV2.getX(), pointV2.getY()));
        addEdge(newEdge);

        removeVertex(node);
    }

    private void createEdgeInRelationToSource(Node source, Node target, Point point, Edge edge) {
        EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getShape();
        if (edge.getSource().equals(source)) {
            Edge newEdge = (Edge) EdgeFactory.createEdge(clazzEdge, target, edge.getTarget(), null);
            newEdge.setShape(ShapePlaneFactory.createShape(clazzEdgeShape,
                    point.getX(), point.getY(), e0.getPointEnd().getX(), e0.getPointEnd().getY()));
            newEdge.createWeight();
            addEdge(newEdge);
        } else {
            Edge newEdge = (Edge) EdgeFactory.createEdge(clazzEdge, edge.getSource(), target, null);
            newEdge.setShape(ShapePlaneFactory.createShape(clazzEdgeShape,
                    e0.getPointStart().getX(), e0.getPointStart().getY(), point.getX(), point.getY()));
            newEdge.createWeight();
            addEdge(newEdge);
        }
    }



    public void generateGraphe(int nroVertex, Rectangle rectangle) {
        double x = rectangle.getX();
        double y = rectangle.getY();
        double width = rectangle.getWidth() + rectangle.getX();
        double height = rectangle.getHeight() + rectangle.getY();
        for (int i=0; i < nroVertex; i++) {
            Vertex vertex = new Vertex();
            Point point = new Point2D((int)(Math.random() * (width-x)) + 1,(int)(Math.random() * (height-y)) + 1);
            vertex.setVertex(ShapePlaneFactory.createShape(getClazzVertexShape(),
                point.getX(), point.getY()));
            vertex.getVertex().setBackground(Color.ORANGE);
            vertex.getVertex().setColor(Color.ORANGE);

            for(Node node : vertexList){
                VertexShapeGraph v0 = (VertexShapeGraph)node.getVertex();
                Edge newEdge = (Edge) EdgeFactory.createEdge(clazzEdge, node, vertex, null);
                newEdge.setShape(ShapePlaneFactory.createShape(clazzEdgeShape,
                        v0.centreShape().getX(), v0.centreShape().getY(), point.getX(), point.getY()));
                addEdge(newEdge);
            }

            addVertex((Node) vertex);
        }
    }                 */

    /**
     *
     * @param source
     * @param target
     * @return
     */
    public Edge getEdge(Node source, Node target) {
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            Node v0 = (Node) edge.getSource();
            Node v1 = (Node) edge.getTarget();
            if ((v0.equals(source) && v1.equals(target)) ||
                    (v0.equals(target) && v1.equals(source))) {
                return edge;
            }
        }
        return null;
    }

    public void clear(){
        DefaultVertexName.nameVertex = -1;
        ConstantsGeometric.RADIO = 15;
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
        this.adjacencys = ((AdjacencyBag<Edge,Node>[])new AdjacencyBag[MIN_CAPACITY]);
        for (int i = 0; i < MIN_CAPACITY; i++)
            this.adjacencys[i] = null;
    }

    /**
     *
     * @param node
     * @return
     */
    public int indexOfVertex(Node node) {
        if (node == null)
            throw new NullPointerException();

        if(adjacencys[node.getValue()] != null)
            return node.getValue();

        return NOT_FOUND_KEY;
    }

    /**
     *
     * @param node
     * @return index of vertex if found
     */
    public int newIndexOfVertex(Node node){
        int i = indexOfVertex(node);

        if(i == NOT_FOUND_KEY){
            if (sizeAdj + 1 >= adjacencys.length) {
                growArrayAdjacency(sizeAdj + MIN_CAPACITY);
            }
            i = sizeAdj;
        }

        return i;
    }

    /**
     * Grow the Array Adjacency to a new size
     */
    private void growArrayAdjacency(int newSize) {
        AdjacencyBag<Edge,Node>[] newAdja = new AdjacencyBag[newSize];
        for (int i = 0; i < adjacencys.length; i++) {
            newAdja[i] = adjacencys[i];
        }
        adjacencys = newAdja;
    }

    /**
     *
     * @return string, graph adj list
     */
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        for (Node v : getVertex()){
            buff.append(v.getValue() + " -> ");
            for (Edge w : adjacencys(v))
                buff.append(w.getTarget().getValue()+", ");
            buff.append("\n");
        }
        return buff.toString();
    }
}
