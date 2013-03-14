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
 *                  Kalil DAHER MOHAMED
 *                  Aden Nouh Abdirazak
 * Changes
 * -------
 * 21/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.swing.design;

import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.operation.LineOperation;
import fr.edu.bp.m1info.structure.geometric.operation.impl.Line2DOperationImpl;
import fr.edu.bp.m1info.structure.geometric.plane.*;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.structure.geometric.plane.Rectangle;
import fr.edu.bp.m1info.structure.geometric.Point;

import java.awt.*;
import java.awt.geom.*;

/**
 * Nous avons une class appelle DesignGeometric2D et
 * qui sera implementé dans la class Graphics
 */
public class DesignGeometric2D implements Graphics {

    private Graphics2D graphics2D;
    private LineOperation operation = new Line2DOperationImpl();

    /**
     * Permette de designer la graphe
     *
     * @parameter Graphics2D graphics2D
     */
    public DesignGeometric2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    /**
     * Permette de designer les ligne
     *
     * @parameter Line line
     */
    public Shape draw(Line line) {
        graphics2D.setColor(line.getColor());
        Stroke strokeDefault = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        Shape shape = new java.awt.geom.Line2D.Double(line.getStart().getX(), line.getStart().getY(),
                line.getEnd().getX(), line.getEnd().getY());
        graphics2D.draw(shape);
        graphics2D.setStroke(strokeDefault);
        return shape;
    }

    /**
     * Permette de designer les cercle
     *
     * @parameter Circle circle
     */
    public Shape draw(Circle circle) {
        Shape shape = new Ellipse2D.Double(circle.getCenter().getX() - circle.getRadio(),
                circle.getCenter().getY() - circle.getRadio(),
                2 * circle.getRadio(), 2 * circle.getRadio());
        graphics2D.setColor(circle.getColor());
        graphics2D.draw(shape);
        graphics2D.setPaint(circle.getBackground());
        graphics2D.fill(shape);
        return shape;
    }

    /**
     * Permette de designer les courbe
     *
     * @parameter Curve curve
     */
    public void draw(Curve curve) {
        Shape shape = new CubicCurve2D.Double(curve.getStart().getX(), curve.getStart().getY(),
                curve.getFirstCurve().getX(), curve.getSecondCurve().getY(),
                curve.getSecondCurve().getX(), curve.getSecondCurve().getY(),
                curve.getEnd().getX(), curve.getEnd().getY());
        graphics2D.setColor(curve.getColor());
        graphics2D.draw(shape);
    }

    /**
     * Permette de designer un rectangle
     *
     * @parameter Rectangle rectangle
     */
    public void draw(Rectangle rectangle) {
        graphics2D.setColor(rectangle.getBackground());
        graphics2D.fillRoundRect((int) rectangle.getPoint().getX(), (int) rectangle.getPoint().getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight(), 10, 10);
        graphics2D.setColor(rectangle.getColor());
        graphics2D.drawRoundRect((int) rectangle.getPoint().getX(), (int) rectangle.getPoint().getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight(), 10, 10);
    }

    /**
     * Permette de dessiner les fleche dans chaque ligne et
     * de determiner l'endroit ou la taille de la fleche.
     *
     * @parameter LineArrow lineArrow
     */
    public void draw(LineArrow lineArrow) {

        graphics2D.setColor(lineArrow.getCfecha());

        //Angle de la fleche
        double angleArrow = Math.asin(0.3);
        double angleRotation = Math.atan2(lineArrow.getEnd().getY() - lineArrow.getStart().getY(),
                lineArrow.getEnd().getX() - lineArrow.getStart().getX());
        // taille de la fleche
        double arrowLength = 22;

        Point pointArrow = new Point2D(0.0, 0.0);
        //endroit de la fleche
        switch (lineArrow.getPlaceOfArrow()) {
            case END:
                pointArrow = lineArrow.getEnd();
                break;
            case MIDDLE:
                pointArrow = operation.calculateMidPoint(lineArrow);
                break;
        }

        AffineTransform transform = new AffineTransform();
        transform.translate(pointArrow.getX(), pointArrow.getY());
        transform.rotate(angleRotation);

        // dessin de la fleche
        Path2D.Double path = new Path2D.Double();
        path.moveTo(-arrowLength * Math.cos(angleArrow), arrowLength * Math.sin(angleArrow));
        path.lineTo(0, 0);
        path.lineTo(-arrowLength * Math.cos(angleArrow), -arrowLength * Math.sin(angleArrow));

        graphics2D.fill(transform.createTransformedShape(path));

    }


    public void draw(Message message) {
        graphics2D.setColor(message.getColor());
        Font fonts = new Font("TimesRoman ",Font.BOLD,12);
        message.setFont(fonts);
        graphics2D.setFont(message.getFont());
        graphics2D.drawString(message.getMessage(),(float) message.getPoint().getX(),
                (float)message.getPoint().getY());
    }
}
