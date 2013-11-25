package fr.edu.bp.m1info.structure.graph.edge.decorator;

import fr.edu.bp.m1info.structure.graph.vertex.Vertex;


public class EdgeFlow<Value extends Number> extends EdgeDecorator<Value> {

    protected Value capacity;
    protected Value flow;

    /**
     * C'est une methode ou un constructeur proteger qui contienne deux  parameter
     * pour crer l'objet et a initialisés en meme temps
     *
     * @parameter sources c'est le debut
     * @parameter target  c'est le fin
     */
    protected EdgeFlow(Vertex source, Vertex target,Value capacity, Value flow) {
        super(source, target);
        this.capacity = capacity;
        this.flow =flow;
    }

    /**
     *
     * @param node
     * @param newFlow
     */
    public void addFlowTo(Vertex node,Value newFlow){

    }

    /**
     *
     * @return
     */
    public Value residualCapacityTo(){
      return null;
    }

    /**
     *
     * @return
     */
    @Override
    public Value flow(){
        return flow;
    }

    /**
     *
     * @return
     */
    @Override
    public Value capacity(){
        return capacity;
    }

}
