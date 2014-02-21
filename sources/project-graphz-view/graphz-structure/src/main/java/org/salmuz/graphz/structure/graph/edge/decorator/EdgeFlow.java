package org.salmuz.graphz.structure.graph.edge.decorator;


import org.salmuz.graphz.structure.graph.edge.AbstractEdge;
import org.salmuz.graphz.structure.graph.vertex.Vertex;


public class EdgeFlow extends EdgeDecorator<Integer> {

    protected int capacity;
    protected int flow;

    /**
     * C'est une methode ou un constructeur proteger qui contienne deux  parameter
     * pour crer l'objet et a initialisés en meme temps
     *
     * @parameter sources c'est le debut
     * @parameter target  c'est le fin
     */
    public EdgeFlow(AbstractEdge edge, int capacity, int flow) {
        super(edge);
        this.capacity = capacity;
        this.flow = flow;
    }


    /**
     *
     */
    public Vertex other(Vertex node) {
        if (node.getValue() == from().getValue()) return to();
        else return from();
    }

    /**
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @param node
     * @param newFlow
     */
    public void addFlowTo(Vertex node, int newFlow) {
        if (node.getValue() == from().getValue()) flow -= newFlow;
        else if (node.getValue() == to().getValue()) flow += newFlow;
        else
            throw new IllegalArgumentException("Le node n'existe pas sur l'arc (" + from().getValue() + "," + to().getValue() + ") avec le:" + node.getValue());
    }

    /**
     * @return
     */
    public int residualCapacityTo(Vertex node) {
        if (node.getValue() == from().getValue()) return flow;
        else if (node.getValue() == to().getValue()) return capacity - flow;
        throw new IllegalArgumentException("Le node n'existe pas sur l'arc (" + from() + "," + to() + ")avec le:" + node);
    }

    /**
     * @return
     */
    @Override
    public Integer flow() {
        return flow;
    }

    /**
     * @return
     */
    @Override
    public Integer capacity() {
        return capacity;
    }

    /**
     * @param flow
     */
    public void setFlow(int flow) {
        this.flow = flow;
    }

    @Override
    public void setWeight(Integer weight) {
        this.setCapacity(weight);
    }

    /**
     *
     * @return
     */
    @Override
    public Integer weight() {
        return capacity;
    }
}
