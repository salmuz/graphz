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
 * 31/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.mvp.presenter;

import fr.edu.bp.m1info.mvp.common.Presenter;
import fr.edu.bp.m1info.mvp.common.factory.Factory;
import fr.edu.bp.m1info.mvp.model.EdgeRepository;
import fr.edu.bp.m1info.mvp.view.UIMainPrueba;
import fr.edu.bp.m1info.structure.geometric.plane.Circle;
import fr.edu.bp.m1info.structure.geometric.plane.Line;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.GraphNoOrient;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.design.GraphCanvas;
import fr.edu.bp.m1info.swing.events.AddEdgeListener;
import fr.edu.bp.m1info.swing.events.AddVertexListener;
import fr.edu.bp.m1info.swing.events.MoveVertexListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;

public class MainPresenter extends Presenter<UIMainPrueba> {

    private Graph<Edge<Line>, Vertex<Integer, Circle>> graph;
    private GraphCanvas<Edge<Line>, Vertex<Integer, Circle>> canvas;

    @Override
    protected void createrView() {
        super.view = new UIMainPrueba(new Frame(), true);
    }

    @Override
    protected void createrRepository() {
        super.repository = Factory.getRp(EdgeRepository.class);
    }

    @Override
    protected void initComponent() {
        graph = new GraphNoOrient<Line, Circle>() {
        };
        canvas = new GraphCanvas<Edge<Line>, Vertex<Integer, Circle>>(graph);
        this.view.getjScrollPane1().setViewportView(canvas);
    }

    @Override
    protected void initAcctions() {
        super.initAcctions();
        final MouseAdapter vertexAction = new AddEdgeListener(canvas);
        final MouseAdapter movedAction = new MoveVertexListener(canvas);
        final MouseListener edgeAction = new AddVertexListener(canvas);

        this.view.getjButton2().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        canvas.removeMouseMotionListener(movedAction);
                        canvas.removeMouseMotionListener(vertexAction);
                        canvas.removeMouseListener(vertexAction);
                        canvas.removeMouseListener(movedAction);
                        canvas.addMouseListener(edgeAction);
                    }
                });

        this.view.getjButton1().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        canvas.removeMouseListener(edgeAction);
                        canvas.removeMouseListener(movedAction);
                        canvas.removeMouseMotionListener(movedAction);
                        canvas.addMouseMotionListener(vertexAction);
                        canvas.addMouseListener(vertexAction);
                    }
                }
        );

        this.view.getjButton3().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        canvas.removeMouseMotionListener(vertexAction);
                        canvas.removeMouseListener(vertexAction);
                        canvas.removeMouseListener(edgeAction);
                        canvas.addMouseMotionListener(movedAction);
                        canvas.addMouseListener(movedAction);
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
        MainPresenter main = new MainPresenter();
        main.startUp();
    }

}
