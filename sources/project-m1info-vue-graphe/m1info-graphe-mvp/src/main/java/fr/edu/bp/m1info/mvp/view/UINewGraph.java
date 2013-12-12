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

package fr.edu.bp.m1info.mvp.view;

import fr.edu.bp.m1info.mvp.common.View;

import javax.swing.*;

public class UINewGraph extends javax.swing.JDialog implements View {

    /**
     * Creates new form UINewGraph
     */
    public UINewGraph(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        bgGraphe = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrbOriente = new javax.swing.JRadioButton();
        jrbNetwork = new javax.swing.JRadioButton();
        jrbNonOriente = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnAcepter = new javax.swing.JButton();
        btnCanceler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Choisir de type de Graphe"));
        jrbOriente.setText("Graphe Oriente");
        jrbOriente.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jrbOriente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bgGraphe.add(jrbOriente);
        jrbNetwork.setText("Graphe Network");
        jrbNetwork.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jrbNetwork.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bgGraphe.add(jrbNetwork);
        jrbNonOriente.setText("Graphe Non Oriente");
        jrbNonOriente.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jrbNonOriente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bgGraphe.add(jrbNonOriente);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jrbNonOriente)
                                        .addComponent(jrbOriente)
                                        .addComponent(jrbNetwork))
                                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jrbOriente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbNetwork)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbNonOriente)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAcepter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/acepter.png")));
        btnAcepter.setText("Accepter");

        btnCanceler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/cancel.png")));
        btnCanceler.setText("Annuler");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAcepter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCanceler)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAcepter)
                                .addComponent(btnCanceler))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ButtonGroup getBgGraphe() {
        return bgGraphe;
    }

    public void setBgGraphe(ButtonGroup bgGraphe) {
        this.bgGraphe = bgGraphe;
    }

    public JButton getBtnAcepter() {
        return btnAcepter;
    }

    public void setBtnAcepter(JButton btnAcepter) {
        this.btnAcepter = btnAcepter;
    }

    public JButton getBtnCanceler() {
        return btnCanceler;
    }

    public void setBtnCanceler(JButton btnCanceler) {
        this.btnCanceler = btnCanceler;
    }

    public JRadioButton getJrbOriente() {
        return jrbOriente;
    }

    public void setJrbOriente(JRadioButton jrbOriente) {
        this.jrbOriente = jrbOriente;
    }

    public JRadioButton getJrbNonOriente() {
        return jrbNonOriente;
    }

    public void setJrbNonOriente(JRadioButton jrbNonOriente) {
        this.jrbNonOriente = jrbNonOriente;
    }

    public JRadioButton getJrbNetwork() {
        return jrbNetwork;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGraphe;
    private javax.swing.JButton btnAcepter;
    private javax.swing.JButton btnCanceler;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jrbOriente;
    private javax.swing.JRadioButton jrbNonOriente;
    private javax.swing.JRadioButton jrbNetwork;
    // End of variables declaration//GEN-END:variables

}
