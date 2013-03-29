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
import fr.edu.bp.m1info.structure.geometric.*;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.graph.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.graph.VertexShapeGraph;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;
import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.edge.EdgeFactory;
import fr.edu.bp.m1info.structure.graph.vertex.DefaultVertexName;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Cette classe graphe est une classe qui rassemble les propriétés entre GraphNoOrient et DirectedGraph
 * pour la possibilité des client on a partager les deux classes graphNoOrienté et classe Directedgraph
 *
 * @param <Edge> c'est la variable arrete du graphe
 * @param <Node> c'est la variables sommet
 */

public abstract class Graph<Edge extends AbstractEdge, Node extends Vertex> {

    protected final Class<AbstractEdge> clazzEdge;
    protected final Class<? extends ShapeGeometric> clazzEdgeShape;
    protected final Class<Vertex> clazzVertex;
    protected final Class<? extends ShapeGeometric> clazzVertexShape;

    protected List<Edge> edgeList;
    protected List<Node> vertexList;

    protected Graph() {
        this.clazzEdgeShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 0);
        this.clazzVertexShape = (Class<? extends ShapeGeometric>) Reflection.getParamGenericOfSuperCLass(this.getClass(), 1);

        this.clazzEdge = Reflection.getParamGenericOfSuperCLass(this.getClass().getSuperclass(), 0);
        this.clazzVertex = Reflection.getParamGenericOfSuperCLass(this.getClass().getSuperclass(), 1);
        DefaultVertexName.nameVertex = -1;
        ConstantsGeometric.RADIO = 15;
    }

    /**
     * C'est une methode getEdgelist qui permet d'acceder la valeur du variable Edege
     *
     * @return la methode  retour une liste des edge cela veut dire que dans cette methode on peut mettre plusieur objet different
     */
    public List<Edge> getEdgeList() {
        return edgeList;
    }


    public List<Node> getVertexList() {
        return vertexList;
    }

    /**
     * C'est une methode qui permet de verifier si on peut ajouter une Edge dans un graphes ou non
     * car avec deux Node qui sont deja relier tu peut pas une autre fois relier donc la methode avant a besoin cette methode
     * et puis elle rajout dans le graph
     *
     * @param edge ce parametre est une edge quand teste si on peut inserer dans le graph ou pas
     * @return elle reourne boolean
     */
    public boolean addEdge(Edge edge) {
        if (edgeList.contains(edge)) {
            return false;
        }
        edgeList.add(edge);
        return true;
    }


    public boolean addEdgeWithoutVerification(Edge edge) {
        edgeList.add(edge);
        return true;
    }

    /**
     * C'est une methode qui permet de tester si on peut  rajouter un node dans le graph
     *
     * @param vertex c'est une variable de type node quand teste si on  rajouter dans le graph
     * @return de type boolean
     */
    public boolean addVertex(Node vertex) {
        if (vertexList.contains(vertex)) {
            return false;
        }
        vertexList.add(vertex);
        return true;
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
    public boolean containsEdge(Node source, Node target) {
        throw new UnsupportedOperationException();
    }

    /**
     * C'est une methode qui permet de verifier si une  arrete existe ou pas a partir de la definition d'une arrete
     * <p/>
     * on verifie si cet edge appartient a graphes
     *
     * @param edge
     * @return de types boolean si elle existe ou pas
     */
    public boolean containsEdge(Edge edge) {
        return edgeList.contains(edge);
    }

    /**
     * C'est une methode qui permet verifier si un Node est dans un graphe
     *
     * @param vertex on teste si ce Node appartient dans le graphe
     * @return return boolean pour connaitre si elle est contenu dans le graphe ou pas
     */
    public boolean containsVertex(Node vertex) {
        return vertexList.contains(vertex);
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
    public void removeEdge(Node source, Node target) {
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
     * <p/>
     * pour suprimer il faut suppimer un Edge qui se trouve dans la liste des edges
     *
     * @param source
     * @param target
     * @return Elle retourne un boolean si ce impossible pour supprimer l'Edge ou pas
     */
    public boolean removeEdge(Edge edge) {
        return edgeList.remove(edge);
    }

    /**
     * C'est une methode qui permet de supprimer un Vertex dans un graphe
     * <p/>
     * pour suprimer il faut suppimer un Node il faut preciser le node
     *
     * @param Vertex
     * @return Elle retourne un Edge si ce impossible pour supprimer l'Edge
     */
    public boolean removeVertex(Node vertex) {
        removeEdgeAll(getEdgesOfVertex(vertex));
        return vertexList.remove(vertex);
    }

    /**
     * indique la classe  de L'edge
     *
     * @return elle retourne la classe
     */
    public Class<AbstractEdge> getClazzEdge() {
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
    public Class<Vertex> getClazzVertex() {
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

        Iterator<Node> it = getVertexList().iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.getVertex().contains(x, y)) {
                return node;
            }
        }

        return null;
    }

    /**
     * @param vertex
     * @param excludes
     * @return
     */
    public boolean isVertexSamePlace(Node vertex, Node... excludes) {
        Iterator<Node> it = getVertexList().iterator();
        while (it.hasNext()) {
            Node item = it.next();
            boolean exclude = false;
            for (int i = 0; i < excludes.length; i++) {
                if (excludes[i].equals(item)) {
                    exclude = true;
                    break;
                }
            }
            if (!exclude && item.getVertex().intersect(vertex.getVertex())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param vertex0
     * @return
     */
    public List<Edge> getEdgesOfVertex(Vertex vertex0) {
        List<Edge> edges = new ArrayList<Edge>();
        Iterator<Edge> it = edgeList.iterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            if (edge.getSource().equals(vertex0)) {
                edges.add(edge);
            } else {
                if (edge.getTarget().equals(vertex0)) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    private void changeVertexOfEdge(Edge edge, Vertex vertex, Point point, Vertex newVertex) {
        EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getEdge();
        if (edge.getSource().equals(vertex)) {
            edge.setSource(newVertex);
            e0.getPointStart().setX(point.getX());
            e0.getPointStart().setY(point.getY());
        } else {
            edge.setTarget(newVertex);
            e0.getPointEnd().setX(point.getX());
            e0.getPointEnd().setY(point.getY());
        }
    }

    public void contractEdge(Edge edge) {
        Vertex vertex = new Vertex();
        Point midPoint = ((EdgeShapeGraph) edge.getEdge()).geMidPoint();
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

    private void showEdges() {
        for (Edge edge : edgeList) {
            System.out.println(edge);
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
        newEdge.setEdge(ShapePlaneFactory.createShape(clazzEdgeShape,
                pointV1.getX(), pointV1.getY(), pointV2.getX(), pointV2.getY()));
        addEdge(newEdge);

        removeVertex(node);
    }

    private void createEdgeInRelationToSource(Node source, Node target, Point point, Edge edge) {
        EdgeShapeGraph e0 = (EdgeShapeGraph) edge.getEdge();
        if (edge.getSource().equals(source)) {
            Edge newEdge = (Edge) EdgeFactory.createEdge(clazzEdge, target, edge.getTarget(), null);
            newEdge.setEdge(ShapePlaneFactory.createShape(clazzEdgeShape,
                    point.getX(), point.getY(), e0.getPointEnd().getX(), e0.getPointEnd().getY()));
            newEdge.createWeight();
            addEdge(newEdge);
        } else {
            Edge newEdge = (Edge) EdgeFactory.createEdge(clazzEdge, edge.getSource(), target, null);
            newEdge.setEdge(ShapePlaneFactory.createShape(clazzEdgeShape,
                    e0.getPointStart().getX(), e0.getPointStart().getY(), point.getX(), point.getY()));
            newEdge.createWeight();
            addEdge(newEdge);
        }
    }

    protected void removeEdgeAll(Collection<Edge> edges) {
        for (Edge edge : edges) {
            removeEdge(edge);
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
                newEdge.setEdge(ShapePlaneFactory.createShape(clazzEdgeShape,
                        v0.centreShape().getX(), v0.centreShape().getY(), point.getX(), point.getY()));
                addEdge(newEdge);
            }

            addVertex((Node) vertex);
        }
    }

    public abstract Edge getEdge(Node source,Node target);

}
