/* ==========================================
 * Cross-Platform-GraphZ : a free Java graph-theory library
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
 *
 * Changes
 * -------
 * 21/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.swing.test;

import fr.edu.bp.m1info.swing.design.DesignGeometric2D;
import fr.edu.bp.m1info.structure.geometric.Point;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.plane.*;

import javax.swing.*;
import java.awt.*;


public class DesignTest {

    public static void testDesignArrow() {
        SwingUtilities.invokeLater(new Runnable() {
            Point start = new Point2D(500, 50);
            Point end = new Point2D(300, 300);
            Point pcurve = new Point2D(70,60);
            Point scurve = new Point2D(85,80);
            //ShapeGeometric arrows = new Line(start,end);
            //ShapeGeometric arrows = new Circle(end, 50.0);
            //ShapeGeometric arrows = new Curve(start,end,pcurve,scurve);
            //ShapeGeometric arrows = new fr.edu.bp.m1info.structure.geometric.plane.Rectangle(start,100.0,100.0);
            ShapeGeometric arrowsizq = new LineArrow(new Point2D(100, 200),new Point2D(50, 20), LineArrow.PLACE_OF_ARROW.END);
            ShapeGeometric arrowsder = new LineArrow(start,end, LineArrow.PLACE_OF_ARROW.MIDDLE);
            ShapeGeometric arrowsRecto = new LineArrow(new Point2D(20, 10),new Point2D(100, 10), LineArrow.PLACE_OF_ARROW.MIDDLE);
            ShapeGeometric arrowsLargo = new LineArrow(new Point2D(120, 20),new Point2D(120, 200), LineArrow.PLACE_OF_ARROW.MIDDLE);
            public void run() {
                JFrame frame = new JFrame("Bevel Arrows");
                //arrowsder.setColor(Color.red);
                //arrowsder.setBackground(Color.GREEN);
                frame.setBackground(Color.white);
                frame.add(new JPanel() {
                    public void paintComponent(Graphics g) {
                        arrowsLargo.draw(new DesignGeometric2D((Graphics2D) g));
                        arrowsRecto.draw(new DesignGeometric2D((Graphics2D) g));
                        arrowsizq.draw(new DesignGeometric2D((Graphics2D) g));
                        arrowsder.draw(new DesignGeometric2D((Graphics2D) g));

                    }
                }
                        , BorderLayout.CENTER);

                frame.setSize(800, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        testDesignArrow();
    }
}
     