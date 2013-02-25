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
package fr.edu.bp.m1info.mvp.common;

import java.awt.*;

/**
 * C'est une classe qui permet de presenter notre travaille
 *
 * @param <UI> a partir du view quand peut presenter cad l'image
 */
public abstract class Presenter<UI extends Window & View> {

    protected UI view;
    protected Repository repository;

    /**
     * cette methode permet pour créer le view
     */
    protected abstract void createrView();

    /**
     * Cet methode permet de créer repository qui fait l'enregistrement dans la base des données
     */
    protected abstract void createrRepository();

    /**
     * Cet methode permet d'initialiser le composant
     */
    protected abstract void initComponent();

    /**
     * Cet methode permet d'initialiser les actions
     */
    protected void initAcctions(){};

    /**
     * Cet methode permet de valider les champs
     */
    protected void validateFields(){};

    /**
     * cette methode rassemble plusieur methode qui succede pour réaliser certain tache du projet
     * elle demare ce tache du projet
     */
    public void startUp() {
        createrRepository();
        createrView();
        initComponent();
        validateFields();
        initAcctions();
    }

}
