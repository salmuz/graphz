/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
 * ==========================================
 * 
 * salmuz : Carranza Alarcon Yonatan Carlos
 * 
 * (C) Copyright 2013, by salmuz and Contributors.
 * 
 * Project Info:  https://github.com/salmuz/Cross-Platform-GraphZ
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
 * Contributor(s):
 *
 *
 * Changes
 * -------
 * 31/01/13 : Version 01;
 *
 */
package org.salmuz.graphz.mvp.presenter;

import org.salmuz.graphz.mvp.view.UIMain;
import org.salmuz.graphz.mvp.common.Presenter;
import org.salmuz.graphz.mvp.common.factory.Factory;
import org.salmuz.graphz.mvp.model.GrapheRepository;
import org.salmuz.graphz.mvp.xml.FiltreFichier;
import org.salmuz.graphz.mvp.xml.ReadXML;
import org.salmuz.graphz.mvp.xml.WriteXML;
import org.salmuz.graphz.swing.design.GraphCanvas;

import javax.swing.*;
import java.io.File;

public class MainPresenter extends Presenter<UIMain> {

    private GraphAction grapheAcction;
    private GeometricAction geometricAcction;

    @Override
    protected void createrView() {
        super.view = new UIMain();
        this.view.setTitle("Projet des Graphes - Master M1 Informatique - Version [1.0.0]");
    }

    @Override
    protected void createrRepository() {
        super.repository = Factory.getRp(GrapheRepository.class);
    }

    @Override
    protected void initComponent() {
        this.view.getJmGraphe().setEnabled(false);
        this.view.getJmGeometric().setEnabled(false);
        this.view.ennableBtnGraphe(false);
        this.view.ennableBtnDroit(false);
    }

    @Override
    protected void initAcctions() {
        super.initAcctions();

        this.view.getJmiNewGraph().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGraphPresenter newGraph = new NewGraphPresenter(view);
                newGraph.startUp();
                grapheAcction = new GraphAction(view, newGraph.getOptionGraphe());
            }
        });

        this.view.getJmiNewGeometric().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGeometricPresenter newGeometricPresenter = new NewGeometricPresenter(view);
                newGeometricPresenter.startUp();
                //geometricAcction = new GeometricAction(view, newGeometricPresenter.getOption());
            }
        });

        this.view.getJmiSave().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser choix = new JFileChooser("user");
                choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                choix.addChoosableFileFilter(new FiltreFichier());
                int retour = choix.showSaveDialog(view);
                if (retour == JFileChooser.APPROVE_OPTION) {
                    if (grapheAcction != null) {
                        repository.enregistreGraphe(grapheAcction.getGraph(), choix.getSelectedFile().getPath());
                    } else {
                       JOptionPane.showMessageDialog(view, "Il faut crée à nouveau graph.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }


            }
        });

         this.view.getJmiOpen().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser choix = new JFileChooser("user");
                choix.addChoosableFileFilter(new FiltreFichier());
                int retour = choix.showOpenDialog(view);
                if (retour == JFileChooser.APPROVE_OPTION) {
                    GraphCanvas canvas =  repository.openGraphe(choix.getSelectedFile().getPath());
                    grapheAcction = new GraphAction(view,canvas);
                }
            }
        });

        this.view.getJmiExporte().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser choix = new JFileChooser(".");
                //choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                choix.addChoosableFileFilter(new FiltreFichier());
                int retour = choix.showOpenDialog(view);
                if (retour == JFileChooser.APPROVE_OPTION) {
                    if (grapheAcction != null) {
                        WriteXML.getGraphe(choix.getSelectedFile().getPath(), grapheAcction.getGraph());
                    } else {
                        if (geometricAcction != null) {
                             //WriteXML.getGraphe(choix.getSelectedFile().getPath(), geometricAcction.getCanvasGraphe().getGraph());
                        } else {
                            JOptionPane.showMessageDialog(view, "Il faut crée à nouveau graph.", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        });

        this.view.getJmiImporte().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser choix = new JFileChooser(".");
                choix.addChoosableFileFilter(new FiltreFichier());
                choix.setAcceptAllFileFilterUsed(false);
                int retour = choix.showOpenDialog(view);
                if (retour == JFileChooser.APPROVE_OPTION) {
                    grapheAcction = new GraphAction(view, 2);
                    File file = choix.getSelectedFile();
                    grapheAcction.getCanvas().setGraph(ReadXML.getGraphe(file.getPath(), 2, grapheAcction.getSpanel().getBounds()));
                    grapheAcction.getCanvas().repaint();
                }
            }
        });


    }


    @Override
    public void startUp() {
        super.startUp();
        //view.setLocationRelativeTo(view.getParent());
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
    }

    public static void main(String[] args) {
        MainPresenter main = new MainPresenter();
        main.startUp();
    }

}
