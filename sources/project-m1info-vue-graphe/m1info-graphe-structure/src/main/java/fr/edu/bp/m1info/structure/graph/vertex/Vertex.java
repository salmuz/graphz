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
import fr.edu.bp.m1info.structure.geometric.graph.shape.vertex.AbstractVertexShape;

/*nous avons une class Vertex<Shape qui herite certain methode de la class VertexShapeGraph> */
public class Vertex{

    private AbstractVertexShape vertex;
    private int value;

    public Vertex(){
        this.value = -1;
    }

    public Vertex(int value){
        this.value = value;
    }

    /**
     * Permette de modifier le contenu de la variable shapeGraph
     *
     * @return shapeGraph
     */
    public AbstractVertexShape getVertex() {
        return vertex;
    }

    /**
     * Permette de modifier le contenu de la variable shapeGraph
     *
     * @parameter Shape shapeGraph
     */
    public void setVertex(AbstractVertexShape vertex) {
        this.vertex = vertex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
                   /*
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
                 */
    public void draw(Graphics graphics) {
       // createValue();
        vertex.draw(graphics);
       // if (valVertex != null) valVertex.draw(graphics);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertex=" + vertex +
             //   ", value=" + value +
                '}';
    }
            /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex1 = (Vertex) o;

        if (value != null ? !value.equals(vertex1.value) : vertex1.value != null) return false;
        if (vertex != null ? !vertex.equals(vertex1.vertex) : vertex1.vertex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vertex != null ? vertex.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }          */
}

