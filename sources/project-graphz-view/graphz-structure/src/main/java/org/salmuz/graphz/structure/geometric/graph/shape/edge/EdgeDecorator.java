package org.salmuz.graphz.structure.geometric.graph.shape.edge;

import org.salmuz.graphz.structure.design.Graphics;

public abstract class EdgeDecorator extends AbstractEdgeShape {

    protected AbstractEdgeShape edgeShape;
    private AbstractEdgeShape parent;

    public EdgeDecorator(AbstractEdgeShape edgeShape) {
        this.edgeShape = edgeShape;
    }

    public void draw(Graphics graphics) {
        edgeShape.draw(graphics); // debe removerse porque solo debe dibujar la flecha el otro
    }

    public AbstractEdgeShape parentComponent() {
        if (parent == null){
            if(edgeShape instanceof EdgeDecorator){
                parent = ((EdgeDecorator) edgeShape).parentComponent();
            }else{
                parent = edgeShape;
            }
        }
        return parent;
    }

    public AbstractEdgeShape childEdgeShape(){
        return edgeShape;
    }
}
