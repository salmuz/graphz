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
import fr.edu.bp.m1info.mvp.view.UIMain;
import fr.edu.bp.m1info.mvp.view.UINewGeometric;
import fr.edu.bp.m1info.mvp.view.UINewGraph;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewGraphPresenter extends Presenter<UINewGraph> {

    private JFrame parent;
    private int optionGraphe;
    public static final int GRAPHE_ORIENTE = 1;
    public static final int GRAPHE_NON_ORIENTE = 2;

    public NewGraphPresenter(JFrame parent) {
        this.parent = parent;
    }

    @Override
    protected void createrView() {
        super.view = new UINewGraph(parent, true);
        this.view.setTitle("Créer Nouveau Graphe");
    }

    @Override
    protected void createrRepository() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void initAcctions() {
        super.initAcctions();
        this.view.getBtnAcepter().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                         if(view.getJrbOriente().isSelected()){
                              optionGraphe = GRAPHE_ORIENTE;
                              view.dispose();
                         }else{
                             if(view.getJrbOriente().isSelected()){
                             optionGraphe = GRAPHE_NON_ORIENTE;
                                  view.dispose();
                             }else{
                                JOptionPane.showMessageDialog(view,"Il faut seleccioner une option.","Warning",JOptionPane.WARNING_MESSAGE);
                             }
                         }

                    }
                }
        );
        this.view.getBtnCanceler().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        optionGraphe = -1;
                        view.dispose();
                    }
                }
        );

    }

    public int getOptionGraphe() {
        return optionGraphe;
    }

    @Override
    public void startUp() {
        super.startUp();
        view.setLocationRelativeTo(view.getParent());
        view.setVisible(true);
    }
}
