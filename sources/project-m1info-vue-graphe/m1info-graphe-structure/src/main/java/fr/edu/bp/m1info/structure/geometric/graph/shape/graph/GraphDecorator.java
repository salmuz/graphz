package fr.edu.bp.m1info.structure.geometric.graph.shape.graph;


public abstract class GraphDecorator extends AbstractGraphShape {

    protected AbstractGraphShape graphShape;

    public GraphDecorator(AbstractGraphShape graphShape){
        this.graphShape = graphShape;
    }
}
