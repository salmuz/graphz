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
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyList<Edge extends IEdge, Node extends Vertex> implements Iterable<Edge>{

    private int size;
    private Neighbor first;

    public AdjacencyList() {
        size = 0;
        first = null;
    }

    public void removeAll() {
        Neighbor next = first;
        for (; next != null; next = next.next) {
            next.edge = null;
        }
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(Edge item) {
        Neighbor old = first;
        item.to().augmentInDegree();
        item.from().augmentOutnDegree();
        this.first = new Neighbor(item, (Node) item.to());
        this.first.next = old;
        this.size++;
    }

    public Iterable<Neighbor> iteratorNode() {
        return new Iterable<Neighbor>() {
            public Iterator<Neighbor> iterator() {
                return new ListIter<Neighbor>() {
                    public Neighbor next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        Neighbor value = cursor;
                        cursor = cursor.next;
                        return value;
                    }
                };
            }
        };
    }


    public Iterator<Edge> iterator() {
        return new ListIter<Edge>() {
            public Edge next() {
                if (!hasNext()) throw new NoSuchElementException();
                Edge value = cursor.edge;
                cursor = cursor.next;
                return value;
            }
        };
    }


    private abstract class ListIter<V> implements Iterator<V> {

        protected Neighbor cursor = first;

        public boolean hasNext() {
            return cursor != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Edge containsEdge(int to) {
        for (Edge edge : this) {
            if (edge.to().getValue() == to)
                return edge;
        }
        return null;
    }

    public void remove(Node value) {
        Neighbor next = first;
        Neighbor prev = next;
        for (; next != null; prev = next, next = next.next) {
            Edge edge = next.edge;
            if (edge.from().getValue() == value.getValue()
                    || edge.to().getValue() == value.getValue()) {
                Neighbor remove = remove(prev, next);
                remove.edge.to().decreaseInDegree();
                remove.edge.from().decreaseOutDegree();
                remove = null;
                break;
            }
        }
    }

    private Neighbor remove(Neighbor prev, Neighbor next) {
        Neighbor remove = null;
        if (next == first) {
            first = prev.next;
            remove = prev;
        } else {
            prev.next = next.next;
            remove = next;
        }
        return remove;
    }


    public final class Neighbor {
        private Edge edge;
        private Node node;
        private Neighbor next;

        public Neighbor(Edge edge, Node node) {
            this.edge = edge;
            this.node = node;
            next = null;
        }

        public Edge getEdge() {
            return edge;
        }

        public Node getNode() {
            return node;
        }
    }
}
