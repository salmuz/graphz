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
package fr.edu.bp.m1info.structure.graph;


public class ModelGeometric01 {
                  /*
    private List<VertexVerticalLine> lineList;
    private Line topLine;
    private Line lowerLine;
    private Graph<Edge<Integer, Line>, Vertex<Integer, Circle>> graph;
    private LineOperation operation = new Line2DOperationImpl();
    private Integer nameVertex;
    private boolean isLowerSearch;
    private boolean isTopSearch;


    public ModelGeometric01(Line topLine, Line lowerLine) {
        this.topLine = topLine;
        this.lowerLine = lowerLine;
        lineList = new ArrayList<VertexVerticalLine>();
        graph = new UnDirectedGraph<Line, Circle, Integer, Integer>() {
        };
        ConstantsGeometric.RADIO = 8;
        nameVertex = 0;
        isLowerSearch = false;
        isTopSearch = false;
    }

    public Line getTopLine() {
        return topLine;
    }

    public Line getLowerLine() {
        return lowerLine;
    }

    public void generateGraphe(double x, double y, double width, double height) {
        for (Vertex vertex : graph.getVertexList()) {
            Point point = new Point2D((int) (Math.random() * (width - x)) + 1, (int) (Math.random() * (height - y)) + 1);
            vertex.setVertex(ShapePlaneFactory.createShape(Circle.class, point.getX(), point.getY()));
            vertex.getVertex().setBackground(Color.ORANGE);
            vertex.getVertex().setColor(Color.ORANGE);
        }

        for (Edge node : graph.getEdgeList()) {
            VertexShapeGraph v0 = (VertexShapeGraph) node.from().getVertex();
            VertexShapeGraph v1 = (VertexShapeGraph) node.to().getVertex();
            node.setShape(ShapePlaneFactory.createShape(Line.class,
                    v0.centreShape().getX(), v0.centreShape().getY(),
                    v1.centreShape().getX(), v1.centreShape().getY()));
        }

    }

    public boolean addLineVertex(Line line, String name, Rectangle rectangle, Point pointVertex) {

        double x = rectangle.getX();
        double y = rectangle.getY();
        double width = rectangle.getWidth() + rectangle.getX();
        double height = rectangle.getHeight() + rectangle.getY();
        Point point01 = operation.getPointIntersectLines(line, topLine);
        Point point02 = operation.getPointIntersectLines(line, lowerLine);

        if (isVertexInSamePlace(point01, point02)) return false;

        line.setStart(point01);
        line.setEnd(point02);
        line.setColor(Color.RED);

        VertexVerticalLine lineVertical = new VertexVerticalLine();

        lineVertical.setTop((Circle) ShapePlaneFactory.createShape(Circle.class, point01.getX(), point01.getY()));
        lineVertical.setLower((Circle) ShapePlaneFactory.createShape(Circle.class, point02.getX(), point02.getY()));

        Vertex vertex = new Vertex();

        Point point;
        if (pointVertex == null) {
            point = new Point2D((int) (Math.random() * (width - x)) + 1, (int) (Math.random() * (height - y)) + 1);
        } else {
            point = pointVertex;
        }

        vertex.setVertex(ShapePlaneFactory.createShape(Circle.class, point.getX(), point.getY()));
        vertex.getVertex().setBackground(Color.ORANGE);
        vertex.getVertex().setColor(Color.ORANGE);
        System.out.println(graph.addVertex(vertex));

        for (VertexVerticalLine vLine : lineList) {
            if (vLine.getLine().intersect(line)) {
                AbstractEdge<Integer, Line> edge = EdgeFactory.createEdge(Edge.class, vertex, vLine.getVertex(), null);
                VertexShapeGraph v0 = (VertexShapeGraph) vertex.getVertex();
                VertexShapeGraph v1 = (VertexShapeGraph) vLine.getVertex().getVertex();
                ((Edge) edge).setShape(ShapePlaneFactory.createShape(Line.class,
                        v0.centreShape().getX(), v0.centreShape().getY(),
                        v1.centreShape().getX(), v1.centreShape().getY()));
                graph.addEdge((Edge) edge);
            }
        }

        String message = "";
        if (name == null) {
            message = String.valueOf(++nameVertex);
        } else {
            message = name;
        }
        vertex.setValue(message);
        Point messageTop = (Point) point01.clone();
        messageTop.setY(messageTop.getY() - 10);
        messageTop.setX(messageTop.getX() - 5);
        lineVertical.setMessageTop(new Message(messageTop, message));

        Point messageLower = (Point) point02.clone();
        messageLower.setY(messageLower.getY() + 20);
        messageLower.setX(messageLower.getX() - 5);
        lineVertical.setMessageLower(new Message(messageLower, message));

        lineVertical.setLine(line);
        lineVertical.setVertex(vertex);

        return lineList.add(lineVertical);
    }

    public boolean intersect(Line line) {
        return topLine.intersect(line) && lowerLine.intersect(line);
    }

    public boolean isVertexInSamePlaceTop(Point pointTop, VertexVerticalLine exclude) {
        for (VertexVerticalLine vLine : lineList) {
            if (!vLine.equals(exclude) && vLine.getTop().intersect(pointTop)) {
                return true;
            }
        }
        return false;
    }

    public boolean isVertexInSamePlaceLower(Point pointLower, VertexVerticalLine exclude) {
        for (VertexVerticalLine vLine : lineList) {
            if (!vLine.equals(exclude) && vLine.getLower().intersect(pointLower)) {
                return true;
            }
        }
        return false;
    }

    public boolean isVertexInSamePlace(Point pointTop, Point pointLower) {
        for (VertexVerticalLine vLine : lineList) {
            if (vLine.getLower().intersect(pointLower) ||
                    vLine.getTop().intersect(pointTop)) {
                return true;
            }
        }
        return false;
    }

    public List<VertexVerticalLine> getLineList() {
        return lineList;
    }

    public Graph<Edge<Integer, Line>, Vertex<Integer, Circle>> getGraph() {
        return graph;
    }

    public VertexVerticalLine getVexterVerticalLine(double x, double y) {
        for (VertexVerticalLine vLine : lineList) {
            if (vLine.getLower().contains(x, y)) {
                isLowerSearch = true;
                return vLine;
            }

            if (vLine.getTop().contains(x, y)) {
                isTopSearch = true;
                return vLine;
            }
        }

        return null;
    }

    public boolean removeVexterVerticalLine(VertexVerticalLine vertexLine) {
        return graph.removeVertex(vertexLine.getVertex()) && lineList.remove(vertexLine);
    }

    public boolean isLowerSearch() {
        return isLowerSearch;
    }

    public void setLowerSearch(boolean lowerSearch) {
        isLowerSearch = lowerSearch;
    }

    public boolean isTopSearch() {
        return isTopSearch;
    }

    public void setTopSearch(boolean topSearch) {
        isTopSearch = topSearch;
    }

    public boolean modifyVertexVerticalLine(VertexVerticalLine vertexLine, Rectangle rectangle) {
        Line line = new Line((Point) vertexLine.getLine().getStart().clone(), (Point) vertexLine.getLine().getEnd().clone());
        Point point = (Point) ((VertexShapeGraph) vertexLine.getVertex().getVertex()).centreShape().clone();
        if (removeVexterVerticalLine(vertexLine)) {
            addLineVertex(line, vertexLine.getMessageTop().getMessage(), rectangle, point);
            return true;
        } else {
            return false;
        }
    }

    public class VertexVerticalLine {
        private Line line;
        private Message messageTop;
        private Message messageLower;
        private Circle top;
        private Circle lower;
        private Vertex vertex;

        public void draw(fr.edu.bp.m1info.structure.design.Graphics graphics) {
            line.draw(graphics);
            messageTop.draw(graphics);
            messageLower.draw(graphics);
            top.draw(graphics);
            lower.draw(graphics);
        }

        public Line getLine() {
            return line;
        }

        public void setLine(Line line) {
            this.line = line;
        }

        public Message getMessageTop() {
            return messageTop;
        }

        public void setMessageTop(Message messageTop) {
            this.messageTop = messageTop;
        }

        public Message getMessageLower() {
            return messageLower;
        }

        public void setMessageLower(Message messageLower) {
            this.messageLower = messageLower;
        }

        public Circle getTop() {
            return top;
        }

        public void setTop(Circle top) {
            this.top = top;
            this.top.setBackground(Color.ORANGE);
        }

        public Circle getLower() {
            return lower;
        }

        public void setLower(Circle lower) {
            this.lower = lower;
            this.lower.setBackground(Color.ORANGE);
        }

        public Vertex getVertex() {
            return vertex;
        }

        public void setVertex(Vertex vertex) {
            this.vertex = vertex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VertexVerticalLine that = (VertexVerticalLine) o;

            if (line != null ? !line.equals(that.line) : that.line != null) return false;
            if (lower != null ? !lower.equals(that.lower) : that.lower != null) return false;
            if (messageLower != null ? !messageLower.equals(that.messageLower) : that.messageLower != null)
                return false;
            if (messageTop != null ? !messageTop.equals(that.messageTop) : that.messageTop != null) return false;
            if (top != null ? !top.equals(that.top) : that.top != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = line != null ? line.hashCode() : 0;
            result = 31 * result + (messageTop != null ? messageTop.hashCode() : 0);
            result = 31 * result + (messageLower != null ? messageLower.hashCode() : 0);
            result = 31 * result + (top != null ? top.hashCode() : 0);
            result = 31 * result + (lower != null ? lower.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "VertexVerticalLine{" +
                    "line=" + line +
                    ", messageTop=" + messageTop +
                    ", messageLower=" + messageLower +
                    ", top=" + top +
                    ", lower=" + lower +
                    '}';
        }
    }              */
}
