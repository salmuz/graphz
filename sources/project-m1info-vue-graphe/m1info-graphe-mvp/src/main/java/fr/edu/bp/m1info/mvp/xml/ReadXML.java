package fr.edu.bp.m1info.mvp.xml;

import fr.edu.bp.m1info.mvp.presenter.NewGraphPresenter;
import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.LineArrow;
import fr.edu.bp.m1info.structure.graph.DirectedGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.GraphNoOrient;

/**
 * Created by IntelliJ IDEA.
 * User: Karindiaz
 * Date: 28/03/13
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class ReadXML {
    public static Graph getGraphe(String ruta, Integer optionGraphe,java.awt.Rectangle rectangle) {
        Graph graph = null;
        if (optionGraphe == NewGraphPresenter.GRAPHE_NON_ORIENTE) {
            graph = new GraphNoOrient<Line, Circle, Integer, Integer>() {
            };
        } else {
            if (optionGraphe == NewGraphPresenter.GRAPHE_ORIENTE) {
                graph = new DirectedGraph<LineArrow, Circle, Integer, Integer>() {
                };
            }
        }

//        ModelManager manager = ModelManager.getInstance();
//        int id = manager.unMarshalling(ruta);
//        graph.modelgraph.Graph graphT1 = manager.get(id);
//        InterfaceOfConverteStructureGraphe.converterGrapheT1ToGrapheT5(graphT1,graph,rectangle);
//        System.out.println(graph.getEdgeList().size());
        return graph;
    }
}
