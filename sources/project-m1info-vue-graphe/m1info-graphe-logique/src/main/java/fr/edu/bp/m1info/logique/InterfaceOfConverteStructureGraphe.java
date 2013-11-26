package fr.edu.bp.m1info.logique;

/**
 * Created by IntelliJ IDEA.
 * User: Karindiaz
 * Date: 28/03/13
 * Time: 06:45
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceOfConverteStructureGraphe {

//    public static Graph converterGrapheT5ToGrapheT1(fr.edu.bp.m1info.structure.graph.Graph<AbstractEdge, Vertex> graph, String name) {
//        ModelManager manager = ModelManager.getInstance();
//
//        int idGraph = manager.createGraph(false, name);
//
//        for (Vertex vertex : graph.getVertexList()) {
//            manager.addNode(idGraph, vertex.getValue().toString());
//        }
//
//        if (graph.getClazzEdge().isAssignableFrom(Edge.class)) {
//            for (AbstractEdge edge : graph.getEdgeList()) {
//                manager.addEdge(idGraph, edge.from().getValue().toString(),
//                        edge.to().getValue().toString(), 0);
//            }
//        } else {
//            for (AbstractEdge arc : graph.getEdgeList()) {
//                manager.addEdge(idGraph, arc.from().getValue().toString(),
//                        arc.to().getValue().toString(), 0);
//            }
//        }
//
//        return manager.get(idGraph);
//    }
//
//    public static void converterGrapheT1ToGrapheT5(Graph graph,
//                                                   fr.edu.bp.m1info.structure.graph.Graph graphT5,
//                                                   java.awt.Rectangle rectangle) {
//
//        Map<Integer, Vertex> vertexs = new HashMap<Integer, Vertex>();
//        double x = rectangle.getX();
//        double y = rectangle.getY();
//        double width = rectangle.getWidth() + rectangle.getX();
//        double height = rectangle.getHeight() + rectangle.getY();
//        for (Node node : graph.getNode()) {
//            for (generated.Edge edge : node.getShape()) {
//                Vertex debut = vertexs.get(edge.getNodeA());
//                Vertex fin = vertexs.get(edge.getNodeB());
//                Point pointDebut = new Point2D((int) (Math.random() * (width - x)) + 1, (int) (Math.random() * (height - y)) + 1);
//                Point pointfin = new Point2D((int) (Math.random() * (width - x)) + 1, (int) (Math.random() * (height - y)) + 1);
//                if (debut == null) {
//                    debut = new Vertex();
//                    debut.setValue(edge.getNodeA());
//                    debut.setVertex(ShapePlaneFactory.createShape(graphT5.getClazzVertexShape(),
//                            pointDebut.getX(), pointDebut.getY()));
//                    debut.getVertex().setBackground(Color.ORANGE);
//                    debut.getVertex().setColor(Color.ORANGE);
//                    graphT5.addVertex(debut);
//                    vertexs.put(edge.getNodeA(), debut);
//                } else {
//                    VertexShapeGraph v0 = (VertexShapeGraph) debut.getVertex();
//                    pointDebut = new Point2D(v0.centreShape().getX(), v0.centreShape().getY());
//                }
//
//                if (fin == null) {
//                    fin = new Vertex();
//                    fin.setValue(edge.getNodeB());
//                    fin.setVertex(ShapePlaneFactory.createShape(graphT5.getClazzVertexShape(),
//                            pointfin.getX(), pointfin.getY()));
//                    fin.getVertex().setBackground(Color.ORANGE);
//                    fin.getVertex().setColor(Color.ORANGE);
//                    graphT5.addVertex(fin);
//                    vertexs.put(edge.getNodeB(), fin);
//                } else {
//                    VertexShapeGraph v0 = (VertexShapeGraph) fin.getVertex();
//                    pointfin = new Point2D(v0.centreShape().getX(), v0.centreShape().getY());
//                }
//
//
//                AbstractEdge Aedge = EdgeFactory.createEdge(graphT5.getClazzEdge(), debut, fin, edge.getWeight());
//                Aedge.setShape(ShapePlaneFactory.createShape(graphT5.getClazzEdgeShape(),
//                        pointDebut.getX(), pointDebut.getY(), pointfin.getX(), pointfin.getY()));
//                if (!graphT5.containsEdge(Aedge)) {
//                    graphT5.addEdgeWithoutVerification(Aedge);
//                }
//
//            }
//        }
//
//    }
}
