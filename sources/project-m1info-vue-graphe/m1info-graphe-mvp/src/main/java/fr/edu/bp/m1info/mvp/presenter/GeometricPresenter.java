/* ==========================================
 * GrapheMultiPlateforme : a free Java graph-theory library
 * ==========================================
 *
 * salmuz : Carranza Alarcon Yonatan Carlos
 *
 * (C) Copyright 2013, by salmuz and Contributors.
 *
 * Project Info:  https://github.com/salmuz/Graphes_Multi_Plateformes
 * Project Creator:  salmuz (https://www.assembla.com/spaces/salmuz-java)
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc.,
 *
 * ------------------
 * Point.java
 * ------------------
 * (C) Copyright 2013, by salmuz and Contributors
 *
 * Original Author: Carranza Alarcon Yonatan Carlos
 * Contributor(s):  Coz Velasquez Antonio
 * 					Kalil DAHER MOHAMED
 *                  Aben Nouh Abdirazak
 *
 * Changes
 * -------
 * 12/02/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.mvp.presenter;

import fr.edu.bp.m1info.mvp.common.Presenter;
import fr.edu.bp.m1info.mvp.view.UIGeometric;
import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.structure.graph.ModelGeometric01;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.common.SwingUtils;
import fr.edu.bp.m1info.swing.design.GraphCanvas;
import fr.edu.bp.m1info.swing.design.ModelGeometric01Canvas;
import fr.edu.bp.m1info.swing.events.geo.AddLineVVertexListener;
import fr.edu.bp.m1info.swing.events.geo.DeleteLineVVertexListener;
import fr.edu.bp.m1info.swing.events.geo.MoveLineVVertexListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GeometricPresenter extends Presenter<UIGeometric> {

    private ModelGeometric01Canvas canvas;
    private ModelGeometric01 modeleGeometric01;
    private GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>> canvasGraphe;

    @Override
    protected void createrView() {
        super.view = new UIGeometric();
    }

    @Override
    protected void createrRepository() {

    }

    @Override
    protected void initComponent() {
        Line topLine = new Line(new Point2D(50, 50), new Point2D(500, 50));
        Line lowerLine = new Line(new Point2D(50, 200), new Point2D(500, 200));
        modeleGeometric01 = new ModelGeometric01(topLine, lowerLine);
    }

    protected void initAcctions() {
        super.initAcctions();
        this.view.getjButton1().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        canvas = new ModelGeometric01Canvas(modeleGeometric01);
                        view.getjScrollPane1().setViewportView(canvas);
                        MouseAdapter addLineVertex = new AddLineVVertexListener(canvas);
                        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);
                        canvas.addMouseMotionListener(addLineVertex);
                        canvas.addMouseListener(addLineVertex);
                    }
                }
        );

        this.view.getjButton2().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

                        MouseAdapter mvLineVertex = new MoveLineVVertexListener(canvas);
                        canvas.addMouseMotionListener(mvLineVertex);
                        canvas.addMouseListener(mvLineVertex);
                        //MouseListener delLineVertex = new DeleteLineVVertexListener(canvas);
                        //canvas.addMouseListener(delLineVertex);
                    }
                }
        );


        this.view.getjButton3().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        Rectangle rectangle = view.getjScrollPane1().bounds();
                        modeleGeometric01.generateGraphe(rectangle.getX(), rectangle.getY(),
                                rectangle.getWidth(), rectangle.getHeight());
                        canvasGraphe = new GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>>(modeleGeometric01.getGraph());
                        view.getjScrollPane1().setViewportView(canvasGraphe);
                        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
                        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);
                    }
                }
        );
    }


    @Override
    public void startUp() {
        super.startUp();
        view.setVisible(true);
    }

    public static void main(String[] args) {
        GeometricPresenter main = new GeometricPresenter();
        main.startUp();
    }
}
