package fr.edu.bp.m1info.structure.geometric.graph.shape.edge;

import fr.edu.bp.m1info.structure.design.Graphics;

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
}
