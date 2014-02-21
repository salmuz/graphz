/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
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
package fr.edu.bp.m1info.structure.graph.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.AbstractEdgeShape;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

/**
 * ici nous avons une classe abstract et qui herite certaine methode de la class EdgeShapeGraph
 */
public abstract class AbstractEdge<Value extends Number> implements IEdge<Value> {

    // Shapes for Edge
    private AbstractEdgeShape shape;

    // Attributs
    private Vertex source;
    private Vertex target;

    /**
     * C'est une methode ou un constructeur proteger qui contienne deux  parameter
     * pour crer l'objet et a initialisés en meme temps
     *
     * @parameter sources c'est le debut
     * @parameter target  c'est le fin
     */
    protected AbstractEdge(Vertex source, Vertex target) {
        this.source = source;
        this.target = target;
    }

    /**
     * un methode trival pour les classes qui permet d'acceder au contenu du variable de la classe
     *
     * @return la methode doit nous renvoyer un shape qui est le type d'un Edge
     */
    public AbstractEdgeShape getShape() {
        return shape;
    }

    /**
     * methode trivale aussi pour les classe elle permet de modifier le variable Edge
     *
     * @param shape pour la modifier il vaut une nouvel valeur elle se valeur et echange contre l'ancien valeur
     *             de l'objet
     */
    public void setShape(AbstractEdgeShape shape) {
        this.shape = shape;
    }

    /**
     * C'est une methode qui permet d'afficher le variable Source
     *
     * @return elle retourne un meme type que source qui est Vertex
     */
    public Vertex from() {
        return source;
    }

    /**
     * C'est une methode qui permet de modifier le source
     * <p/>
     * Cet parametre sera remplace par l'ancien
     *
     * @param source
     */
    public void setSource(Vertex source) {
        this.source = source;
    }

    /**
     * C'est une methode qui permet d'afficher le variable Target
     *
     * @return elle retourne un meme type que target qui est Vertex
     */
    public Vertex to() {
        return target;
    }

    /**
     * C'est une methode qui permet de modifier le variable target
     * <p/>
     * Cet parametre sera remplace par l'ancien target
     *
     * @param target
     */
    public void setTarget(Vertex target) {
        this.target = target;
    }

    /**
     *
     * @param graphics
     */
    public void draw(Graphics graphics) {
        shape.draw(graphics);
    }

    /**
     * C'est une methode  comparatif des objets
     *
     * @param o on verifie si cet objet est bien un AbstractEdge
     * @return si elle est bien objet vrai sinn false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEdge edge = (AbstractEdge) o;

        if (source != null ? !source.equals(edge.source) : edge.source != null) return false;
        if (target != null ? !target.equals(edge.target) : edge.target != null) return false;

        return true;
    }

    /**
     * cette methode nous affiche le code de variable
     *
     * @return elle affiche le code
     */
    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (target != null ? target.hashCode() : 0);
        // result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    /**
     * C'est une methode qui permet de convertir en string
     *
     * @return elle retourne une phrase qui definit les variables
     */
    @Override
    public String toString() {
        return "AbstractEdge{" +
                "shape=" + shape +
                ", source=" + source +
                ", target=" + target +
                //  ", weight=" + weight +
                '}';
    }

    /**
     * The abstract class do not support this method
     * @return weight
     */
    public Value weight() {
        throw new UnsupportedOperationException("The edge do not support weight");
    }

    /**
     *
     * @param value
     */
    public void setWeight(Value value) {
        throw new UnsupportedOperationException("The edge do not support weight");
    }

    /**
     * The abstract class do not support this method
     * @return  capacity
     */
    public Value capacity() {
        throw new UnsupportedOperationException("The edge do not support capacity");
    }

    /**
     * The abstract class do not support this method
     * @return flow of network
     */
    public Value flow() {
        throw new UnsupportedOperationException("The edge do not support flow");
    }
}

