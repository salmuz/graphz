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
import fr.edu.bp.m1info.swing.events.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
public class GrapheAction {

    private GraphCanvas canvas;
    private Graph graph;
    private UIMain view;
    private javax.swing.JScrollPane spanel;

    public GrapheAction(UIMain view, int optionGraphe) {

        if (optionGraphe == NewGraphPresenter.GRAPHE_NON_ORIENTE) {
            graph = new GraphNoOrient<Line, Circle, Integer, Integer>() {
            };
            canvas = new GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>>(graph);
        } else {
            if (optionGraphe == NewGraphPresenter.GRAPHE_ORIENTE) {
                graph = new DirectedGraph<LineArrow, Circle, Integer, Integer>() {
                };
                canvas = new GraphCanvas<Arc<Integer, LineArrow>, Vertex<Integer, Circle>>(graph);
            }
        }

        if (optionGraphe != -1) {

            for (Component cp: view.getJpPrincipal().getComponents()){
                view.getJpPrincipal().remove(cp);
            }

            spanel = new javax.swing.JScrollPane();
            spanel.setBackground(new java.awt.Color(255, 255, 255));
            view.getJpPrincipal().add(spanel, java.awt.BorderLayout.CENTER);
            spanel.setViewportView(canvas);
            view.ennableBtnGraphe(true);
            view.ennableBtnDroit(false);
            if (optionGraphe == NewGraphPresenter.GRAPHE_ORIENTE) {
                view.getBtnContracter().setEnabled(false);
                view.getJmiContrater().setEnabled(false);
                view.getBtnGAuto().setEnabled(false);
            }
            view.getJmGraphe().setEnabled(true);
            view.getJmGeometric().setEnabled(false);
            view.pack();
            this.view = view;
            actions();
        }
    }

    public void addVertexAction() {
        MouseListener addVertexAction = new AddVertexListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseListener(addVertexAction);
    }

    public void movedVertexAction() {
        MouseAdapter movedAction = new MoveVertexListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(movedAction);
        canvas.addMouseListener(movedAction);
    }

    public void addEdgeAction() {
        MouseAdapter edgeAction = new AddEdgeListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(edgeAction);
        canvas.addMouseListener(edgeAction);
    }

    public void deleteEdgeAction() {
        MouseAdapter deEdgeAction = new DeleteEdgeListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(deEdgeAction);
        canvas.addMouseListener(deEdgeAction);
    }

    public void contrationEdgeAction() {
        MouseAdapter coEdgeAction = new ContrationEdgeListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(coEdgeAction);
        canvas.addMouseListener(coEdgeAction);
    }

    public void separateEdgeAction() {
        MouseListener seVertexAction = new SeparateVertexListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseListener(seVertexAction);
    }

    public void generateGrapheAction(JButton jComponent) {
        AbstractAction geVertexAction = new GenerateGrapheAction(canvas,spanel);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        jComponent.addActionListener(geVertexAction);
    }

    public void actions() {

        this.view.getBtnASommets().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        addVertexAction();
                    }
                });

        this.view.getBtnSSommet().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        deleteVertexAction();
                    }
                });

        this.view.getBtnAArete().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        addEdgeAction();
                    }
                });

        this.view.getBtnSArete().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        deleteEdgeAction();
                    }
                });

        this.view.getBtnDesplacer().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        movedVertexAction();
                    }
                });


        this.view.getBtnSepare().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        separateEdgeAction();
                    }
                });

        this.view.getBtnContracter().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        contrationEdgeAction();
                    }
                });

        this.view.getBtnEffacer().addActionListener(new ClearGraphAction(canvas));

        this.view.getJmiAddNode().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVertexAction();
            }
        });

        this.view.getJmiDelNode().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVertexAction();
            }
        });

        this.view.getJmiAddEdge().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEdgeAction();
            }
        });

        this.view.getJmiDelEdge().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEdgeAction();
            }
        });

        this.view.getJmiMoveNode().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movedVertexAction();
            }
        });

        this.view.getJmiSepare().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                separateEdgeAction();
            }
        });

        this.view.getJmiContrater().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrationEdgeAction();
            }
        });

        this.view.getJmiCleanGraph().addActionListener(new ClearGraphAction(canvas));
        this.generateGrapheAction(view.getBtnGAuto());
    }


    public void deleteVertexAction() {
        MouseListener deVertexAction = new DeleteVertexListener(canvas);

        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseListener(deVertexAction);
    }

}
