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

import fr.edu.bp.m1info.mvp.view.UIMain;
import fr.edu.bp.m1info.mvp.common.Presenter;
import fr.edu.bp.m1info.mvp.common.factory.Factory;
import fr.edu.bp.m1info.mvp.model.EdgeRepository;

public class MainPresenter extends Presenter<UIMain> {

    private GrapheAcction grapheAcction;
    //private Graph<Edge<Integer, Line>, Vertex<Integer, Circle>> graph;
    // private GraphCanvas<Edge<Integer, Line>, Vertex<Integer, Circle>> canvas;
    //private Graph<Arc<Integer,LineArrow>, Vertex<Integer, Circle>> graph;
    //private GraphCanvas<Arc<Integer,LineArrow>, Vertex<Integer, Circle>> canvas;

    @Override
    protected void createrView() {
        super.view = new UIMain();
        this.view.setTitle("Projet des Graphes - Master M1 Informatique - Version [1.0.0]");
    }

    @Override
    protected void createrRepository() {
        super.repository = Factory.getRp(EdgeRepository.class);
    }

    @Override
    protected void initComponent() {
        this.view.getJmGraphe().setEnabled(false);
        this.view.getJmGeometric().setEnabled(false);
        this.view.ennableBtnGraphe(false);
        this.view.ennableBtnDroit(false);

        //


    }


    @Override
    protected void initAcctions() {
        super.initAcctions();

        this.view.getJmiNewGraph().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGraphPresenter newGraph = new NewGraphPresenter(view);
                newGraph.startUp();
                grapheAcction = new GrapheAcction(view, newGraph.getOptionGraphe());
            }
        });

        this.view.getJmiNewGeometric().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGeometricPresenter newGeometricPresenter = new NewGeometricPresenter(view);
                newGeometricPresenter.startUp();

            }
        });

        this.view.getJmiSave().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        this.view.getJmiExporte().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        this.view.getJmiImporte().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });


    }


    @Override
    public void startUp() {
        super.startUp();
        view.setLocationRelativeTo(view.getParent());
        view.setVisible(true);
    }

    public static void main(String[] args) {
        MainPresenter main = new MainPresenter();
        main.startUp();
    }

}
