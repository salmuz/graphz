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
 * 13/02/13 : Version 01;
 *
 */
package org.salmuz.graphz.structure.geometric.plane;

import org.salmuz.graphz.structure.geometric.Arrow;
import org.salmuz.graphz.structure.geometric.ConstantsGeometric;
import org.salmuz.graphz.structure.geometric.Point;
import org.salmuz.graphz.structure.geometric.ShapeGeometric;

/**
 * C'est une classe
 */
public class ShapePlaneFactory {

    public static ShapeGeometric createShape(Class<? extends ShapeGeometric> clazz,double ...coordinate){
        ShapeGeometric shape = null;

        if(clazz.isAssignableFrom(Circle.class)){
            shape = new Circle(new Point2D(coordinate[0],coordinate[1]), ConstantsGeometric.RADIO);
        }else{
            if(clazz.isAssignableFrom(Line.class)){
                shape = new Line(new Point2D(coordinate[0],coordinate[1]), new Point2D(coordinate[2],coordinate[3]));
            }else{
               if(clazz.isAssignableFrom(LineArrow.class)){
                shape = new LineArrow(new Point2D(coordinate[0],coordinate[1]),
                        new Point2D(coordinate[2],coordinate[3]), Arrow.PLACE_OF_ARROW.END);
               }else{
                   if(clazz.isAssignableFrom(Message.class)){
                       shape = new Message(new Point2D(coordinate[0],coordinate[1]),"2");
                   }else{
                       if(clazz.isAssignableFrom(Curve.class)){
                           shape = new Curve(new Point2D(coordinate[0],coordinate[1]),
                                   new Point2D(coordinate[2],coordinate[3]));
                       }else{
                           if(clazz.isAssignableFrom(CurvedArrow.class)){
                               shape = new CurvedArrow(new Point2D(coordinate[0],coordinate[1]),
                                       new Point2D(coordinate[2],coordinate[3]), Arrow.PLACE_OF_ARROW.END);
                           }
                       }
                   }
               }
            }
        }


        if(shape == null){
            throw new UnsupportedOperationException("Shape "+clazz.getName()+" Unsupported");
        }

        return shape;
    }


    public static ShapeGeometric createShape(Class<? extends ShapeGeometric> clazz, Point from, Point to) {
        return createShape(clazz, from.getX(),from.getY(),to.getX(),to.getY());
    }
}
