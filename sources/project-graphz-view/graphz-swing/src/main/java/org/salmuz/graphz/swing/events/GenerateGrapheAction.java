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
 * Contributor(s):  Coz Velasquez Antonio
 * 					Kalil DAHER MOHAMED
 *                  Aben Nouh Abdirazak 
 *
 * Changes
 * -------
 * 24/02/13 : Version 01;
 *
 */
package org.salmuz.graphz.swing.events;

import org.salmuz.graphz.swing.design.GraphCanvas;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GenerateGrapheAction extends AbstractAction {

    private GraphCanvas canvas;
    private JScrollPane spanel;

    public GenerateGrapheAction(GraphCanvas canvas, JScrollPane spanel) {
        this.canvas = canvas;
        this.spanel =spanel;
    }

    public void actionPerformed(ActionEvent e) {
        String nroVertex = JOptionPane.showInputDialog("Vous pouvez clavier le chiffre des sommets?");
        if(!nroVertex.equalsIgnoreCase("")){
           // canvas.getGraph().generateGraphe(Integer.parseInt(nroVertex),spanel.getBounds());
            canvas.repaint();
        }
    }
}
