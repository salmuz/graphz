package fr.edu.bp.m1info.mvp.presenter;

import fr.edu.bp.m1info.mvp.view.UIMain;
import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.LineArrow;
import fr.edu.bp.m1info.structure.graph.DirectedGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.GraphNoOrient;
import fr.edu.bp.m1info.structure.graph.edge.Arc;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.common.SwingUtils;
import fr.edu.bp.m1info.swing.design.GraphCanvas;
import fr.edu.bp.m1info.swing.events.DeleteEdgeListener;
import fr.edu.bp.m1info.swing.events.DeleteVertexListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Antonio
 * Date: 19/03/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrapheAcction {

    private GraphCanvas canvas;
    private Graph graph;

    /* final MouseAdapter vertexAction = new AddEdgeListener(canvas);
    final MouseAdapter movedAction = new MoveVertexListener(canvas);
    final MouseListener edgeAction = new AddVertexListener(canvas);
    final MouseAdapter deEdgeAction = new DeleteEdgeListener(canvas);
    final MouseAdapter coEdgeAction = new ContrationEdgeListener(canvas);
    final MouseListener seVertexAction = new SeparateVertexListener(canvas);
    final AbstractAction geVertexAction = new GenerateGrapheAction(canvas);

    this.view.getjButton2().addActionListener(
            new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                    SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

                    canvas.addMouseListener(edgeAction);
                }
            });

    this.view.getjButton1().addActionListener(
            new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                    SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

                    canvas.addMouseMotionListener(vertexAction);
                    canvas.addMouseListener(vertexAction);
                }
            }
    );

    this.view.getjButton3().addActionListener(
            new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                    SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

                    canvas.addMouseMotionListener(movedAction);
                    canvas.addMouseListener(movedAction);
                }
            }
    );

    this.view.getjButton4().addActionListener(
            new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                    SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

                    canvas.addMouseMotionListener(deEdgeAction);
                    canvas.addMouseListener(deEdgeAction);
                }
            }
    );

    this.view.getjButton5().addActionListener(
            new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                    SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

                    canvas.addMouseMotionListener(coEdgeAction);
                    canvas.addMouseListener(coEdgeAction);
                }
            }
    );

    this.view.getjButton6().addActionListener(
            new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                    SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

                    canvas.addMouseListener(seVertexAction);
                }
            }
    );

    this.view.getjButton8().addActionListener(geVertexAction);
    */

    public GrapheAcction(UIMain view, int optionGraphe) {

        if(optionGraphe == NewGraphPresenter.GRAPHE_NON_ORIENTE){
            graph = new GraphNoOrient<Line, Circle, Integer, Integer>() {     };
            canvas = new GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>>(graph);
        } else{
            graph = new DirectedGraph<LineArrow, Circle,Integer,Integer>() { };
            canvas = new GraphCanvas<Arc<Integer,LineArrow>, Vertex<Integer, Circle>>(graph);
        }
        //view.getjScrollPane1().setViewportView(canvas);
        view.getJpPrincipal().remove(view.getJspDroits());
    }



    public void deleteVertexAction() {
        MouseListener deVertexAction = new DeleteVertexListener(canvas);

        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseListener(deVertexAction);
    }

}
