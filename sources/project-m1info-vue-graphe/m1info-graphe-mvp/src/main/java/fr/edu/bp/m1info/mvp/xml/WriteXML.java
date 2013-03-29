package fr.edu.bp.m1info.mvp.xml;

import fr.edu.bp.m1info.logique.InterfaceOfConverteStructureGraphe;
import fr.edu.bp.m1info.structure.graph.Graph;
import graph.modelgraph.ModelManager;

/**
 * Created by IntelliJ IDEA.
 * User: Karindiaz
 * Date: 29/03/13
 * Time: 02:06
 * To change this template use File | Settings | File Templates.
 */
public class WriteXML {

    public static boolean getGraphe(String ruta, Graph graph) {
        ModelManager manager = ModelManager.getInstance();
        graph.modelgraph.Graph graphT1=InterfaceOfConverteStructureGraphe.converterGrapheT5ToGrapheT1(graph,"graphe");
        return manager.marshalling(graphT1.getIdGraph(),ruta);
    }
}
