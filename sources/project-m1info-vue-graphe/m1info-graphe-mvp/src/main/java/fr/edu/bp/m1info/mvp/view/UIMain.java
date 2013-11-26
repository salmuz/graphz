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

public class UIMain extends javax.swing.JFrame implements View {
    
    /** Creates new form UIMain */
    public UIMain() {
        initComponents();
        invisible();
    }

    private void invisible(){
        jmiContrater.setVisible(false);
        jmiSepare.setVisible(false);
        jmiNewGeometric.setVisible(false);
        btnSepare.setVisible(false);
        btnContracter.setVisible(false);
        jmGeometric.setVisible(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jpPrincipal = new javax.swing.JPanel();
        jspDroits = new javax.swing.JSplitPane();
        jpdroit = new javax.swing.JPanel();
        jpGauche = new javax.swing.JPanel();
        jtbGraphe = new javax.swing.JToolBar();
        btnASommets = new javax.swing.JButton();
        btnSSommet = new javax.swing.JButton();
        btnGAuto  = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAArete = new javax.swing.JButton();
        btnSArete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnDesplacer = new javax.swing.JButton();
        btnSepare = new javax.swing.JButton();
        btnContracter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnEffacer = new javax.swing.JButton();
        jtbGeometric = new javax.swing.JToolBar();
        btnADroit = new javax.swing.JButton();
        btnSDroit = new javax.swing.JButton();
        btnDDroit = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFichier = new javax.swing.JMenu();
        jmiNewGraph = new javax.swing.JMenuItem();
        jmiNewGeometric = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jmiSave = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jmiImporte = new javax.swing.JMenuItem();
        jmiExporte = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jmiExit = new javax.swing.JMenuItem();
        jmGraphe = new javax.swing.JMenu();
        jmiAddNode = new javax.swing.JMenuItem();
        jmiDelNode = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jmiAddEdge = new javax.swing.JMenuItem();
        jmiDelEdge = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jmiMoveNode = new javax.swing.JMenuItem();
        jmiSepare = new javax.swing.JMenuItem();
        jmiContrater = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        jmiCleanGraph = new javax.swing.JMenuItem();
        jmGeometric = new javax.swing.JMenu();
        jmiAddLine = new javax.swing.JMenuItem();
        jmiMoveLine = new javax.swing.JMenuItem();
        jmiDelLine = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jmiCleanGeo = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jmiAbout = new javax.swing.JMenuItem();
        jmiAide = new javax.swing.JMenuItem();
        jmiOpen = new javax.swing.JMenuItem();


        jmAlgorithms = new javax.swing.JMenu();
        jmiBFS = new javax.swing.JMenuItem();
        jmiDFS = new javax.swing.JMenuItem();
        jmiBellmanFord = new javax.swing.JMenuItem();
        jmiClearIteraction = new javax.swing.JMenuItem();
        jSeparatorAlgo = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jpPrincipal.setLayout(new java.awt.BorderLayout());

        jpPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Espace de travail"));
        jpdroit.setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jpdroit);
        jpdroit.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jspDroits.setLeftComponent(jpdroit);

        jpGauche.setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jpGauche);
        jpGauche.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jspDroits.setRightComponent(jpGauche);

        jpPrincipal.add(jspDroits, java.awt.BorderLayout.CENTER);

        jtbGraphe.setBackground(new java.awt.Color(255, 255, 255));
        btnASommets.setBackground(new java.awt.Color(255, 255, 255));
        btnASommets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/asommet.png")));
        btnASommets.setToolTipText("Ajouter des Sommets");
        jtbGraphe.add(btnASommets);

        btnSSommet.setBackground(new java.awt.Color(255, 255, 255));
        btnSSommet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/ssommet.png")));
        btnSSommet.setToolTipText("Supprimer Sommets");
        jtbGraphe.add(btnSSommet);

        jLabel2.setText("       ");
        jtbGraphe.add(jLabel2);

        btnAArete.setBackground(new java.awt.Color(255, 255, 255));
        btnAArete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/aarete.png")));
        btnAArete.setToolTipText("Ajouter des Ar\u00eates");
        jtbGraphe.add(btnAArete);

        btnSArete.setBackground(new java.awt.Color(255, 255, 255));
        btnSArete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/sarete.png")));
        btnSArete.setToolTipText("Supprimer des Ar\u00eates");
        jtbGraphe.add(btnSArete);

        jLabel3.setText("      ");
        jtbGraphe.add(jLabel3);

        btnDesplacer.setBackground(new java.awt.Color(255, 255, 255));
        btnDesplacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/desplacer.png")));
        btnDesplacer.setToolTipText("D\u00e9splacer");
        jtbGraphe.add(btnDesplacer);

        btnSepare.setBackground(new java.awt.Color(255, 255, 255));
        btnSepare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/separer.png")));
        btnSepare.setToolTipText("Separer Sommet");
        jtbGraphe.add(btnSepare);

        btnContracter.setBackground(new java.awt.Color(255, 255, 255));
        btnContracter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/contracter.png")));
        btnContracter.setToolTipText("Contracter");
        jtbGraphe.add(btnContracter);

        jLabel4.setText("     ");
        jtbGraphe.add(jLabel4);

        btnEffacer.setBackground(new java.awt.Color(255, 255, 255));
        btnEffacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/trash.png")));
        btnEffacer.setToolTipText("Effacer Graphe");
        jtbGraphe.add(btnEffacer);

        btnGAuto.setBackground(new java.awt.Color(255, 255, 255));
        btnGAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/gauto.png")));
        btnGAuto.setToolTipText("Géneré Graphe");
        jtbGraphe.add(btnGAuto);

        jtbGeometric.setBackground(new java.awt.Color(255, 255, 255));
        btnADroit.setBackground(new java.awt.Color(255, 255, 255));
        btnADroit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/ajdroit.png")));
        btnADroit.setToolTipText("Ajouter des Droits");
        btnADroit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jtbGeometric.add(btnADroit);

        btnSDroit.setBackground(new java.awt.Color(255, 255, 255));
        btnSDroit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/sdroit.png")));
        btnSDroit.setToolTipText("Supprimer des Droit");
        jtbGeometric.add(btnSDroit);

        btnDDroit.setBackground(new java.awt.Color(255, 255, 255));
        btnDDroit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/mdroit.png")));
        btnDDroit.setToolTipText("D\u00e9splacer Droit");
        jtbGeometric.add(btnDDroit);

        jLabel1.setText("Description de tous les etats qui arrivent ");

        jmFichier.setMnemonic('F');
        jmFichier.setText("Fichier");
        jmiNewGraph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/new.png")));
        jmiNewGraph.setMnemonic('G');
        jmiNewGraph.setText("Nouveau Graphe");
        jmFichier.add(jmiNewGraph);

        jmiNewGeometric.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/new.png")));
        jmiNewGeometric.setMnemonic('F');
        jmiNewGeometric.setText("Nouveau G\u00e9om\u00e9trique");
        jmFichier.add(jmiNewGeometric);

        jmFichier.add(jSeparator1);

        jmiSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/save.png")));
        jmiSave.setText("Enregistrer Graphe");
        jmFichier.add(jmiSave);

        jmiOpen.setText("Ouvrir un Graphe");
        jmFichier.add(jmiOpen);
        jmFichier.add(jSeparator5);

        jmiImporte.setText("Importer Graphe");
        jmFichier.add(jmiImporte);

        jmiExporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/exporte.png")));
        jmiExporte.setText("Exporter Graphe");
        jmFichier.add(jmiExporte);

        jmFichier.add(jSeparator2);

        jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/edu/bp/m1info/mvp/image/cancelar.png")));
        jmiExit.setMnemonic('S');
        jmiExit.setText("Sortir");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });

        jmFichier.add(jmiExit);

        jMenuBar1.add(jmFichier);

        jmGraphe.setText("Graphe");
        jmiAddNode.setText("Ajouter des Sommets");
        jmGraphe.add(jmiAddNode);

        jmiDelNode.setText("Suprimer des Sommets");
        jmGraphe.add(jmiDelNode);

        jmGraphe.add(jSeparator3);

        jmiAddEdge.setText("Ajouter des Ar\u00eates");
        jmGraphe.add(jmiAddEdge);

        jmiDelEdge.setText("Supprimer des Ar\u00eates");
        jmGraphe.add(jmiDelEdge);

        jmGraphe.add(jSeparator4);

        jmiMoveNode.setText("Desplacer Sommet");
        jmGraphe.add(jmiMoveNode);

        jmiSepare.setText("S\u00e9parer des Sommets");
        jmGraphe.add(jmiSepare);

        jmiContrater.setText("Contracter des Ar\u00eates");
        jmGraphe.add(jmiContrater);

        jmGraphe.add(jSeparator6);

        jmiCleanGraph.setText("Effacer Graphe");
        jmGraphe.add(jmiCleanGraph);

        jMenuBar1.add(jmGraphe);

        jmGeometric.setText("G\u00e9om\u00e9trique");
        jmiAddLine.setText("Ajouter des Droits");
        jmGeometric.add(jmiAddLine);

        jmiMoveLine.setText("Desplacer des Droits");
        jmGeometric.add(jmiMoveLine);

        jmiDelLine.setText("Suprimer des Droits");
        jmGeometric.add(jmiDelLine);

        jmGeometric.add(jSeparator7);

        jmiCleanGeo.setText("Effacer G\u00e9om\u00e9trique");
        jmGeometric.add(jmiCleanGeo);

        jMenuBar1.add(jmGeometric);

        jmHelp.setText("Aide");
        jmiAbout.setText("About");
        jmHelp.add(jmiAbout);

        jmiAide.setText("Support");
        jmHelp.add(jmiAide);

        jMenuBar1.add(jmHelp);

        jmAlgorithms.setText("Algorithms");

        jmiBFS.setText("Breadth-First-Search");
        jmAlgorithms.add(jmiBFS);

        jmiDFS.setText("Depth-First-Search");
        jmAlgorithms.add(jmiDFS);

        jmiBellmanFord.setText("Bellman-Ford");
        jmAlgorithms.add(jmiBellmanFord);

        jmAlgorithms.add(jSeparatorAlgo);

        jmiClearIteraction.setText("Re-initialition");
        jmAlgorithms.add(jmiClearIteraction);

        jMenuBar1.add(jmAlgorithms);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(jtbGraphe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                    .addComponent(jtbGeometric, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jtbGraphe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtbGeometric, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jmiExitActionPerformed


    public JButton getBtnSepare() {
        return btnSepare;
    }

    public JButton getBtnSSommet() {
        return btnSSommet;
    }

    public JButton getBtnAArete() {
        return btnAArete;
    }

    public JButton getBtnASommets() {
        return btnASommets;
    }

    public JButton getBtnDesplacer() {
        return btnDesplacer;
    }

    public JButton getBtnContracter() {
        return btnContracter;
    }

    public JButton getBtnADroit() {
        return btnADroit;
    }

    public JButton getBtnSDroit() {
        return btnSDroit;
    }

    public JButton getBtnDDroit() {
        return btnDDroit;
    }

    public JButton getBtnEffacer() {
        return btnEffacer;
    }

    public JButton getBtnSArete() {
        return btnSArete;
    }

    public JMenu getJmFichier() {
        return jmFichier;
    }

    public JMenuItem getJmiAbout() {
        return jmiAbout;
    }

    public JMenuItem getJmiAddEdge() {
        return jmiAddEdge;
    }

    public JMenuItem getJmiAddLine() {
        return jmiAddLine;
    }

    public JMenuItem getJmiAddNode() {
        return jmiAddNode;
    }

    public JMenuItem getJmiAide() {
        return jmiAide;
    }

    public JMenuItem getJmiCleanGeo() {
        return jmiCleanGeo;
    }

    public JMenuItem getJmiCleanGraph() {
        return jmiCleanGraph;
    }

    public JMenuItem getJmiContrater() {
        return jmiContrater;
    }

    public JMenuItem getJmiDelEdge() {
        return jmiDelEdge;
    }

    public JMenuItem getJmiDelLine() {
        return jmiDelLine;
    }

    public JMenuItem getJmiDelNode() {
        return jmiDelNode;
    }

    public JMenuItem getJmiExit() {
        return jmiExit;
    }

    public JMenuItem getJmiExporte() {
        return jmiExporte;
    }

    public JMenuItem getJmiImporte() {
        return jmiImporte;
    }

    public JMenuItem getJmiMoveLine() {
        return jmiMoveLine;
    }

    public JMenuItem getJmiMoveNode() {
        return jmiMoveNode;
    }

    public JMenuItem getJmiNewGeometric() {
        return jmiNewGeometric;
    }

    public JMenuItem getJmiNewGraph() {
        return jmiNewGraph;
    }

    public JMenuItem getJmiSave() {
        return jmiSave;
    }

    public JMenuItem getJmiSepare() {
        return jmiSepare;
    }

    public JPanel getJpdroit() {
        return jpdroit;
    }

    public JPanel getJpGauche() {
        return jpGauche;
    }

    public JSplitPane getJspDroits() {
        return jspDroits;
    }

    public JMenu getJmGeometric() {
        return jmGeometric;
    }

    public JMenu getJmGraphe() {
        return jmGraphe;
    }

    public JMenu getJmHelp() {
        return jmHelp;
    }

    public JToolBar getJtbGraphe() {
        return jtbGraphe;
    }

    public JToolBar getJtbGeometric() {
        return jtbGeometric;
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public JMenu getJmAlgorithms() {
        return jmAlgorithms;
    }

    public JMenuItem getJmiBFS() {
        return jmiBFS;
    }

    public JMenuItem getJmiDFS() {
        return jmiDFS;
    }

    public JMenuItem getJmiBellmanFord() {
        return jmiBellmanFord;
    }

    public JMenuItem getJmiClearIteraction() {
        return jmiClearIteraction;
    }

    public void ennableBtnGraphe(boolean pFlag){
        btnAArete.setEnabled(pFlag);
        btnASommets.setEnabled(pFlag);
        btnContracter.setEnabled(pFlag);
        btnDesplacer.setEnabled(pFlag);
        btnSArete.setEnabled(pFlag);
        btnSSommet.setEnabled(pFlag);
        btnSepare.setEnabled(pFlag);
        btnEffacer.setEnabled(pFlag);
        btnGAuto.setEnabled(pFlag);
    }

    public JMenuItem getJmiOpen() {
        return jmiOpen;
    }

    public void ennableBtnDroit(boolean pFlag){
        btnADroit.setEnabled(pFlag);
        btnSDroit.setEnabled(pFlag);
        btnDDroit.setEnabled(pFlag);
    }

    public JButton getBtnGAuto() {
        return btnGAuto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSepare;
    private javax.swing.JButton btnGAuto;
    private javax.swing.JButton btnSSommet;
    private javax.swing.JButton btnAArete;
    private javax.swing.JButton btnASommets;
    private javax.swing.JButton btnDesplacer;
    private javax.swing.JButton btnContracter;
    private javax.swing.JButton btnADroit;
    private javax.swing.JButton btnSDroit;
    private javax.swing.JButton btnDDroit;
    private javax.swing.JButton btnEffacer;
    private javax.swing.JButton btnSArete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jmGraphe;
    private javax.swing.JMenu jmGeometric;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpdroit;
    private javax.swing.JPanel jpGauche;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSplitPane jspDroits;
    private javax.swing.JToolBar jtbGraphe;
    private javax.swing.JToolBar jtbGeometric;
    private javax.swing.JMenu jmFichier;
    private javax.swing.JMenu jmAlgorithms;
    private javax.swing.JMenuItem jmiAbout;
    private javax.swing.JMenuItem jmiAddEdge;
    private javax.swing.JMenuItem jmiAddLine;
    private javax.swing.JMenuItem jmiAddNode;
    private javax.swing.JMenuItem jmiAide;
    private javax.swing.JMenuItem jmiCleanGeo;
    private javax.swing.JMenuItem jmiCleanGraph;
    private javax.swing.JMenuItem jmiContrater;
    private javax.swing.JMenuItem jmiOpen;
    private javax.swing.JMenuItem jmiDelEdge;
    private javax.swing.JMenuItem jmiDelLine;
    private javax.swing.JMenuItem jmiDelNode;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiExporte;
    private javax.swing.JMenuItem jmiImporte;
    private javax.swing.JMenuItem jmiMoveLine;
    private javax.swing.JMenuItem jmiMoveNode;
    private javax.swing.JMenuItem jmiNewGeometric;
    private javax.swing.JMenuItem jmiNewGraph;
    private javax.swing.JMenuItem jmiSave;
    private javax.swing.JMenuItem jmiSepare;
    private javax.swing.JMenuItem jmiBFS;
    private javax.swing.JMenuItem jmiDFS;
    private javax.swing.JMenuItem jmiBellmanFord;
    private javax.swing.JMenuItem jmiClearIteraction;
    private javax.swing.JSeparator jSeparatorAlgo;
    // End of variables declaration//GEN-END:variables
    
}
