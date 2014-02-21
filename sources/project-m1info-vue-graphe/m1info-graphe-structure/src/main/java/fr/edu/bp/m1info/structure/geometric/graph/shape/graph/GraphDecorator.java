package fr.edu.bp.m1info.structure.geometric.graph.shape.graph;


import fr.edu.bp.m1info.structure.geometric.graph.shape.Shape;

public abstract class GraphDecorator extends AbstractGraphShape {

    protected AbstractGraphShape graphShape;

    public GraphDecorator(AbstractGraphShape graphShape){
        this.graphShape = graphShape;
    }

    public Shape parentComponent() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
