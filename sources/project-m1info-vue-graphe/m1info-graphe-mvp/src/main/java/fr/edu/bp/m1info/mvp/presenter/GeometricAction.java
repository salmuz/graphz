package fr.edu.bp.m1info.mvp.presenter;

import fr.edu.bp.m1info.mvp.view.UIMain;
import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.structure.graph.ModelGeometric01;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.common.SwingUtils;
import fr.edu.bp.m1info.swing.design.GraphCanvas;
import fr.edu.bp.m1info.swing.design.ModelGeometric01Canvas;
import fr.edu.bp.m1info.swing.events.MoveVertexListener;
import fr.edu.bp.m1info.swing.events.geo.AddLineVVertexListener;
import fr.edu.bp.m1info.swing.events.geo.DeleteLineVVertexListener;
import fr.edu.bp.m1info.swing.events.geo.MoveLineVVertexListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Antonio
 * Date: 20/03/13
 * Time: 05:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeometricAction {
  /*  private UIMain view;
    private ModelGeometric01Canvas canvasGeo;
    private ModelGeometric01 modeleGeometric01;
    private GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>> canvasGraphe;
    private javax.swing.JScrollPane jspDroit;
    private javax.swing.JScrollPane jspGauche;

    public GeometricAction(UIMain view, int option) {
        if (option == NewGeometricPresenter.GEO_PERMUTATION) {
            Line topLine = new Line(new Point2D(50, 50), new Point2D(500, 50));
            Line lowerLine = new Line(new Point2D(50, 200), new Point2D(500, 200));
            modeleGeometric01 = new ModelGeometric01(topLine, lowerLine);
            canvasGeo = new ModelGeometric01Canvas(modeleGeometric01);
            canvasGraphe = new GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>>(modeleGeometric01.getGraph());
        } else {
            if (option == NewGeometricPresenter.GEO_OTHERS) {
                JOptionPane.showMessageDialog(view, "Il manque de faire cette partie.");
            }
        }

        if (option == NewGeometricPresenter.GEO_PERMUTATION) {
            for (Component cp : view.getJpPrincipal().getComponents()) {
                view.getJpPrincipal().remove(cp);
            }

            javax.swing.JSplitPane jspDroits = new javax.swing.JSplitPane();
            jspDroit = new javax.swing.JScrollPane();
            jspDroit.setBackground(new java.awt.Color(255, 255, 255));
            jspDroit.setViewportView(canvasGeo);
            jspDroits.setLeftComponent(jspDroit);

            jspGauche = new javax.swing.JScrollPane();
            jspGauche.setBackground(new java.awt.Color(255, 255, 255));
            jspGauche.setViewportView(canvasGraphe);
            jspDroits.setRightComponent(jspGauche);

            view.getJpPrincipal().add(jspDroits, java.awt.BorderLayout.CENTER);

            view.ennableBtnDroit(true);
            view.ennableBtnGraphe(false);
            view.getJmGraphe().setEnabled(false);
            view.getJmGeometric().setEnabled(true);
            view.getBtnDesplacer().setEnabled(true);
            view.revalidate();
            view.repaint();
            this.view = view;
            actions();
        }
    }

    private void actions() {
        this.view.getBtnADroit().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        addDroitAction();
                    }
                });
        this.view.getBtnSDroit().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        deleteDroitAction();
                    }
                });

        this.view.getBtnDDroit().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        movedDroit();
                    }
                });

        this.view.getBtnDesplacer().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        MouseAdapter movedAction = new MoveVertexListener(canvasGraphe);
                        SwingUtils.removeListenerMouse(MouseListener.class, canvasGraphe);
                        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvasGraphe);

                        canvasGraphe.addMouseMotionListener(movedAction);
                        canvasGraphe.addMouseListener(movedAction);
                    }
                }
        );
    }

    public void addDroitAction() {
        MouseAdapter addLineVertex = new AddLineVVertexListener(canvasGeo, canvasGraphe, jspGauche);
        SwingUtils.removeListenerMouse(MouseListener.class, canvasGeo);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvasGeo);

        canvasGeo.addMouseMotionListener(addLineVertex);
        canvasGeo.addMouseListener(addLineVertex);
    }

    public void deleteDroitAction() {
        SwingUtils.removeListenerMouse(MouseListener.class, canvasGeo);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvasGeo);


        MouseListener delLineVertex = new DeleteLineVVertexListener(canvasGeo);
        canvasGeo.addMouseListener(delLineVertex);
    }

    public void movedDroit() {
        SwingUtils.removeListenerMouse(MouseListener.class, canvasGeo);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvasGeo);

        MouseAdapter mvLineVertex = new MoveLineVVertexListener(canvasGeo, canvasGraphe, jspGauche);
        canvasGeo.addMouseMotionListener(mvLineVertex);
        canvasGeo.addMouseListener(mvLineVertex);
    }

    public GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>> getCanvasGraphe() {
        return canvasGraphe;
    }*/

    /*
 this.view.getjButton3().addActionListener(
         new AbstractAction() {
             public void actionPerformed(ActionEvent
 e) {
                 Rectangle rectangle = view.getjScrollPane1().bounds();
                 modeleGeometric01.generateGraphe(rectangle.getX(), rectangle.getY(),
                         rectangle.getWidth(), rectangle.getHeight());
                 canvasGraphe = new GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>>(modeleGeometric01.getGraph());
                 view.getjScrollPane1().setViewportView(canvasGraphe);
                 SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                 SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);
             }
         }
 );   */
}
