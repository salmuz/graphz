package fr.edu.bp.m1info.structure.graph.edge.decorator;

import fr.edu.bp.m1info.structure.graph.vertex.Vertex;


public class EdgeWeight<Value extends Number> extends EdgeDecorator {

    /**
     * C'est une methode ou un constructeur proteger qui contienne deux  parameter
     * pour crer l'objet et a initialisés en meme temps
     *
     * @parameter sources c'est le debut
     * @parameter target  c'est le fin
     */
    protected EdgeWeight(Vertex source, Vertex target,Value value) {
        super(source, target);
    }
}
