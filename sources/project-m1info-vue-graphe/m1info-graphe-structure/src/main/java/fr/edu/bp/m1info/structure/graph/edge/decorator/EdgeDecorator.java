package fr.edu.bp.m1info.structure.graph.edge.decorator;

import fr.edu.bp.m1info.structure.graph.edge.AbstractEdge;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;


public abstract class EdgeDecorator<Value> extends AbstractEdge<Value> {

    protected IEdge edge;

    /**
     * C'est une methode ou un constructeur proteger qui contienne deux  parameter
     * pour crer l'objet et a initialisés en meme temps
     *
     * @parameter sources c'est le debut
     * @parameter target  c'est le fin
     */
    protected EdgeDecorator(Vertex source, Vertex target) {
        super(source, target);
    }
}
