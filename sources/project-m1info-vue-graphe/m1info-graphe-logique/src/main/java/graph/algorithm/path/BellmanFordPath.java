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
 *
 */

package graph.algorithm.path;

import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import graph.algorithm.IterativeView;

public class BellmanFordPath<Edge extends IEdge, Node extends Vertex>
    extends  AbstractPath<Edge,Node>{

    public BellmanFordPath(Graph<Edge, Node> graph, Node source){
        super(graph, source);
    }

    public BellmanFordPath(Graph<Edge, Node> graph, Node source, IterativeView<Edge, Node> iterative) {
        super(graph, source, iterative);
    }

    @Override
    public void execute() {

    }

    /**
     *  Pseudo-code - Wikipedia
     *  source: http://fr.wikipedia.org/wiki/Algorithme_de_Bellman-Ford
     *
     *  pour i=1 jusqu'à Nombre de sommets - 1 faire
     *   |    poidsInchangés := vrai
     *   |    pour chaque sommet u du graphe dont nouveauPoids(u) = i - 1
     *   |     |    pour chaque arc (u, v) du graphe faire
     *   |     |    paux := poids(u) + poids(arc(u, v));
     *   |     |     |   si paux < poids(v) alors
     *   |     |     |    |    pred(v) := u;
     *   |     |     |    |    poids(v) := paux;
     *   |     |     |    |    nouveauPoids(v) := i
     *   |     |     |    |    poidsInchangés := faux;
     *   |    si poidsInchangés = vrai alors sortir de la boucle
     *   pour chaque arc (u, v) du graphe faire
     *   |    si poids(u) + poids(arc(u, v)) < poids(v) alors
     *   |         retourner faux  // il existe un cycle absorbant
     *   retourner vrai
     *
     * @param source
     */
    private void bellmanFordSearch(Node source){

    }

}
