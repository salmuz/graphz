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
public class Vertex {

    private AbstractVertexShape vertex;
    private int value;
    private int outdegree;
    private int indegree;

    public Vertex() {
        this.value = DefaultVertexName.nextNode();
        this.outdegree = 0;
        this.indegree = 0;
    }

    public Vertex(int value) {
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


    public void draw(Graphics graphics) {
        vertex.draw(graphics);
    }

    public int indegree() {
        return indegree;
    }

    public void augmentInDegree() {
        this.indegree++;
    }

    public void decreaseInDegree() {
        this.indegree--;
    }

    public int outdegree() {
        return outdegree;
    }

    public void augmentOutnDegree() {
        this.outdegree++;
    }

    public void decreaseOutDegree() {
        this.outdegree--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex vertex = (Vertex) o;

        if (value != vertex.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertex=" + vertex +
                ", value=" + value +
                '}';
    }


}

