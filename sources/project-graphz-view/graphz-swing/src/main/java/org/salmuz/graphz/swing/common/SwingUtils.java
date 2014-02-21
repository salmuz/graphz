package org.salmuz.graphz.swing.common;

import org.salmuz.graphz.structure.geometric.plane.Circle;
import org.salmuz.graphz.structure.geometric.plane.Line;
import org.salmuz.graphz.structure.graph.edge.Edge;
import org.salmuz.graphz.structure.graph.vertex.Vertex;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by IntelliJ IDEA.
 * User: DORE
 * Date: 13/03/13
 * Time: 06:13
 * To change this template use File | Settings | File Templates.
 */
public class SwingUtils {
    public static void removeListenerMouse(Class clazz, Canvas canvas) {
        for (Object event : canvas.getListeners(clazz)) {
            if (clazz == MouseListener.class) {
                canvas.removeMouseListener((MouseListener) event);
            } else {
                if (clazz == MouseMotionListener.class) {
                    canvas.removeMouseMotionListener((MouseMotionListener) event);
                }
            }
        }
    }
}
