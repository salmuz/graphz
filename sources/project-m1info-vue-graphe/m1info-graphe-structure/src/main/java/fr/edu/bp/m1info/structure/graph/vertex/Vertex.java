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
 *                  Aden Nouh Abdirazak
 * Changes
 * -------
 * 20/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.structure.graph.vertex;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.ConstantsGeometric;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.graph.VertexShapeGraph;
import fr.edu.bp.m1info.structure.geometric.plane.Message;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;

/*nous avons une class Vertex<Shape qui herite certain methode de la class VertexShapeGraph> */
public class Vertex<Value, Shape extends ShapeGeometric & VertexShapeGraph> {

    private Shape vertex;
    private Message valVertex;

    private Value value;  // Value of Node

    public Vertex() {
        this.value = (Value) DefaultVertexName.getNextName().toString();
    }

    public Vertex(Value value) {
        this.value = value;
    }

    /**
     * Permette de modifier le contenu de la variable shapeGraph
     *
     * @return shapeGraph
     */
    public Shape getVertex() {
        return vertex;
    }

    /**
     * Permette de modifier le contenu de la variable shapeGraph
     *
     * @parameter Shape shapeGraph
     */
    public void setVertex(Shape vertex) {
        this.vertex = vertex;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    private void createValue() {
        if (vertex != null && value != null) {
            Point point = ((VertexShapeGraph) vertex).centreShape();
            int less = getLess(value);
            if (valVertex == null) {
                valVertex = (Message) ShapePlaneFactory.createShape(Message.class,
                        point.getX() - less, point.getY() + 5);
                valVertex.setMessage(value.toString());
            } else {
                valVertex.getPoint().setX(point.getX() - less);
                valVertex.getPoint().setY(point.getY() + 5);
            }
        }
    }

    private int getLess(Value value) {
        if (value instanceof String) {
            Integer val = Integer.valueOf(value.toString());
            return (val < 10 ? 4 : (val < 100) ? 7 : 10);
        }
        return 10;
    }

    public void draw(Graphics graphics) {
        createValue();
        vertex.draw(graphics);
        if (valVertex != null) valVertex.draw(graphics);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertex=" + vertex +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (value != null ? !value.equals(vertex.value) : vertex.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}

