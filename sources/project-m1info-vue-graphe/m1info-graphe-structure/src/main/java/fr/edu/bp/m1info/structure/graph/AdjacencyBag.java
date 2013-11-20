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
 * Contributor(s): ---
 *
 * Changes
 * -------
 *
 *
 */

package fr.edu.bp.m1info.structure.graph;

import fr.edu.bp.m1info.structure.graph.edge.IEdge;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyBag<Edge extends IEdge> implements Iterable<Edge> {

    private int size;
    private Neighbor first;

    public AdjacencyBag(){
        size = 0;
        first = null;
    }

    public int size(){
        return size;
    }

    public void add(Edge item){
        Neighbor old = first;
        this.first = new Neighbor(item);
        this.first.next = old;
        this.size++;
    }

    public Iterator<Edge> iterator() {
        return new Iterator<Edge>() {
            private Neighbor cursor = first;

            public boolean hasNext() {
                return cursor != null;
            }

            public Edge next() {
                if(!hasNext()) throw new NoSuchElementException();
                Edge value = cursor.value;
                cursor = cursor.next;
                return value;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public boolean containsEdge(int from) {
        for (Edge edge : this){
            if (edge.getSource().getValue() == from)
                return true;
        }
        return false;
    }


    private class Neighbor{
        private Edge value;
        private Neighbor next;
        public Neighbor(Edge value){
            this.value = value;
            next = null;
        }
    }
}
