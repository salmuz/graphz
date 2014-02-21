package org.salmuz.graphz.structure.graph.edge.decorator;

import org.salmuz.graphz.structure.graph.edge.AbstractEdge;
import org.salmuz.graphz.structure.graph.edge.IEdge;


public abstract class EdgeDecorator<Value extends Number> extends AbstractEdge<Value> {

    protected IEdge edge;

    public EdgeDecorator(AbstractEdge edge){
        super(edge.from(), edge.to());
        this.edge = edge;
    }
}
