package org.salmuz.graphz.structure.graph.edge.decorator;

import org.salmuz.graphz.structure.graph.edge.AbstractEdge;


public class EdgeWeight<Value extends Number> extends EdgeDecorator<Value> {

    private Value weight;
    /**
     * C'est une methode ou un constructeur proteger qui contienne deux  parameter
     * pour crer l'objet et a initialisés en meme temps
     *
     * @parameter sources c'est le debut
     * @parameter target  c'est le fin
     */
    public EdgeWeight(AbstractEdge edge,Value weight) {
        super(edge);
        this.weight = weight;
    }

    @Override
    public void setWeight(Value weight) {
        this.weight = weight;
    }

    @Override
    public Value weight() {
        return this.weight;
    }
}
