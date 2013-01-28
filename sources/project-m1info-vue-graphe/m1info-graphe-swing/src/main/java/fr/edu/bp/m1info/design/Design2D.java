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
 *                  Aden Nouh Abdirazak
 * Changes
 * -------
 * 21/01/13 : Version 01;
 *
 */
package fr.edu.bp.m1info.design;

import fr.edu.bp.m1info.geometric.LineOperation;
import fr.edu.bp.m1info.geometric.impl2D.Line2DOperationImpl;
import fr.edu.bp.m1info.structure.design.Graphics;
import fr.edu.bp.m1info.structure.geometric.plane.*;
import fr.edu.bp.m1info.structure.geometric.plane.Point2D;
import fr.edu.bp.m1info.structure.geometric.plane.Rectangle;
import fr.edu.bp.m1info.structure.geometric.Point;

import java.awt.*;
import java.awt.geom.*;

 /*nous avons une class appelle Design2D et qui sera implementé dans la class Graphics*/
public class Design2D implements Graphics {
     /*ici nous avons declarer deux variable de type  Graphics2D et de LineOperation et qui serons privée*/
    private Graphics2D graphics2D;
    private LineOperation operation = new Line2DOperationImpl();

     /*@parameter Graphics2D graphics2D
     * permette de designer la graphe */
    public Design2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }
      /*@parameter Line line
     * permette de designer les ligne  */
    public void draw(Line line) {
        graphics2D.setColor(line.getColor());
        Stroke strokeDefault = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        graphics2D.draw(new java.awt.geom.Line2D.Double(line.getStart().getX(), line.getStart().getY(),
                line.getEnd().getX(), line.getEnd().getY()));
        graphics2D.setStroke(strokeDefault);
    }
           /*@parameter Circle circle
     * permette de designer les cercle  */
    public void draw(Circle circle) {
        Shape shape = new Ellipse2D.Double(circle.getCenter().getX(), circle.getCenter().getY(), circle.getRadio(), circle.getRadio());
        graphics2D.setColor(circle.getColor());
        graphics2D.draw(shape);
        graphics2D.setPaint(circle.getBackground());
        graphics2D.fill(shape);
    }
              /*@parameter Curve curve
     * permette de designer les courbe  */
    public void draw(Curve curve) {
        Shape shape = new CubicCurve2D.Double(curve.getStart().getX(), curve.getStart().getY(),
                curve.getFirstCurve().getX(), curve.getSecondCurve().getY(),
                curve.getSecondCurve().getX(), curve.getSecondCurve().getY(),
                curve.getEnd().getX(), curve.getEnd().getY());
        graphics2D.setColor(curve.getColor());
        graphics2D.draw(shape);
    }
         /*@parameter Rectangle rectangle
     * permette de designer un rectangle  */
    public void draw(Rectangle rectangle) {
        graphics2D.setColor(rectangle.getBackground());
        graphics2D.fillRoundRect((int) rectangle.getPoint().getX(), (int) rectangle.getPoint().getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight(), 10, 10);
        graphics2D.setColor(rectangle.getColor());
        graphics2D.drawRoundRect((int) rectangle.getPoint().getX(), (int) rectangle.getPoint().getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight(), 10, 10);
    }
          /*@parameter LineArrow lineArrow
          * permette de dessiner les fleche dans chaque ligne et de determiner l'endroit ou la taille de
          * la fleche*/
    public void draw(LineArrow lineArrow) {

        //Angle de la fleche
        double angleArrow = Math.asin(0.3);
        double angleRotation = Math.atan2(lineArrow.getEnd().getY() - lineArrow.getStart().getY(),
                lineArrow.getEnd().getX() - lineArrow.getStart().getX());
        // taille de la fleche
        double arrowLength = operation.calculateSize(lineArrow)*0.18;

        Point pointArrow = new Point2D(0.0,0.0);
        //endroit de la fleche
        switch ( lineArrow.getPlaceOfArrow() ){
            case END: pointArrow = lineArrow.getEnd();
                break;
            case MIDDLE: pointArrow =  operation.calculateMidPoint(lineArrow);
                break;
        }

        AffineTransform transform = new AffineTransform();
        transform.translate(pointArrow.getX(), pointArrow.getY());
        transform.rotate(angleRotation);

        // dessin de la fleche
        Path2D.Double path = new Path2D.Double();
        path.moveTo(-arrowLength*Math.cos(angleArrow),arrowLength*Math.sin(angleArrow));
        path.lineTo(0, 0);
        path.lineTo(-arrowLength*Math.cos(angleArrow),-arrowLength*Math.sin(angleArrow));

        graphics2D.setColor(Color.BLUE);
        graphics2D.fill(transform.createTransformedShape(path));

    }


}
