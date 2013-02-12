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
 * 					Moussa Kalil 
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
import fr.edu.bp.m1info.structure.graph.GraphNoOrient;

import java.awt.*;

public class MainPresenter extends Presenter<UIMainPrueba> {

    public GraphNoOrient<Line,Circle> graph;

    @Override
    protected void createrView() {
        super.view = new UIMainPrueba(new Frame(),true);
    }

    @Override
    protected void createrRepository() {
        super.repository = Factory.getRp(EdgeRepository.class);
    }

    @Override
    protected void initComponent() {

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