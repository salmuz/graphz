package fr.edu.bp.m1info.structure.graph.edge.decorator;

import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;


public abstract class EdgeDecorator<Value extends Number> extends AbstractEdge<Value> {

    protected IEdge edge;

    public EdgeDecorator(AbstractEdge edge){
        super(edge.from(), edge.to());
        this.edge = edge;
    }
}
