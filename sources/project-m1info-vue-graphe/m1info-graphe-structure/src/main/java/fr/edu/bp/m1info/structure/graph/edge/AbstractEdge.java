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
package fr.edu.bp.m1info.structure.graph.edge;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.EdgeShapeGraph;
import fr.edu.bp.m1info.structure.geometric.plane.Message;
import fr.edu.bp.m1info.structure.geometric.plane.ShapePlaneFactory;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;

/*ici nous avons une classe abstract et qui herite certaine methode de la class EdgeShapeGraph */
public abstract class AbstractEdge<Value, Shape extends ShapeGeometric> {

    // Shapes for Edge
    private Shape edge;
    private Message weightShape;

    //attributs
    private Vertex source;
    private Vertex target;
    private Value weight; // weight of Edge

    /**
     * C'est une methode ou un constructeur proteger qui contienne deux  parameter
     * pour crer l'objet et a initialisés en meme temps
     *
     * @parameter sources c'est le debut
     * @parameter target  c'est le fin
     * @parameter value  valuer de l'arête
     */
    protected AbstractEdge(Vertex source, Vertex target, Value weight) {
        this.source = source;
        this.target = target;
        if(weight==null){
            this.weight = (Value)((Object) new String("0"));
        }else{
            this.weight = weight;
        }
    }

    /**
     * un methode trival pour les classes qui permet d'acceder au contenu du variable de la classe
     *
     * @return la methode doit nous renvoyer un shape qui est le type d'un Edge
     */
    public Shape getEdge() {
        return edge;
    }

    /**
     * methode trivale aussi pour les classe elle permet de modifier le variable Edge
     *
     * @param edge pour la modifier il vaut une nouvel valeur elle se valeur et echange contre l'ancien valeur
     *             de l'objet
     */
    public void setEdge(Shape edge) {
        this.edge = edge;
    }

    /**
     * C'est une methode qui permet d'afficher le variable Source
     *
     * @return elle retourne un meme type que source qui est Vertex
     */
    public Vertex getSource() {
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
    public Vertex getTarget() {
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

    public Message getWeightShape() {
        return weightShape;
    }

    public void setWeightShape(Message weightShape) {
        this.weightShape = weightShape;
    }


    public Value getWeight() {
        return weight;
    }

    public void createWeight() {
        if (this.source != null && this.target != null && this.edge != null  ) {
            Point point = ((EdgeShapeGraph) this.edge).geMidPoint();
            if (weightShape == null) {
                weightShape = (Message) ShapePlaneFactory.createShape(Message.class, point.getX(), point.getY());
            } else {
                weightShape.getPoint().setX(point.getX());
                weightShape.getPoint().setY(point.getY());
            }
            if(this.weight == null)
                this.weight = (Value)((Object) new String("("+source.getValue().toString()+","+target.getValue().toString()+")"));

            weightShape.setMessage(weight.toString());
        }
    }

    public void draw(Graphics graphics) {
        createWeight();
        edge.draw(graphics);
        if (weightShape != null) weightShape.draw(graphics);
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
        if (weight != null ? !weight.equals(edge.weight) : edge.weight != null) return false;

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
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
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
                "edge=" + edge +
                ", source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                '}';
    }
}

