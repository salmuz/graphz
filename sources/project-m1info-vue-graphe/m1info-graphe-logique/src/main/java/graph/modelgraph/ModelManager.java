/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

import generated.*;
import graph.exception.ArcException;
import graph.exception.EdgeException;
import graph.exception.NodeException;
import graph.modelgraph.Graph;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author jemorgon1
 */
public class ModelManager implements InterfaceManager {

    private static ModelManager instance = null;
    private HashMap GList;
    private int nbGraph;

    private ModelManager() {
        GList = new HashMap();
        nbGraph = 0;
    }

    /**
     * @return
     */
    public static ModelManager getInstance() {
        if (instance == null) {
            return instance = new ModelManager();
        }
        return instance;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "ModelManager{" + ", nbGraph=" + GList.size() + '}';
    }

    /**
     * @param matrix
     * @param name
     * @return
     */

    public int createGraph(boolean matrix, String name) {
        Graph g;
        nbGraph++;
        if (matrix) {
            g = new GraphMatrix(name, nbGraph);
        } else {
            g = new GraphList(name, nbGraph);
        }

        GList.put(nbGraph, g);

        return nbGraph;
    }

    /**
     * @param idGraphToCopy
     * @return
     */

    public Graph copyGraph(int idGraphToCopy) {
        nbGraph++;

        if (((Graph) GList.get(idGraphToCopy)) == null) {
            return null;
        }

        Graph G;
        G = new GraphList(nbGraph, (Graph) GList.get(idGraphToCopy));
        GList.put(nbGraph, G);
        return G;
    }

    /**
     * @param idGraph
     * @return
     */

    public boolean deleteGraph(int idGraph) {
        GList.remove(idGraph);
        return true;
    }

    /**
     * @param idGraph
     * @return
     */

    public Graph get(int idGraph) {
        return (Graph) GList.get(idGraph);
    }

    /**
     * @param idGraph
     * @param label
     * @return
     */

    public boolean addNode(int idGraph, String label) {

        Node s = new Node();
        s.setName(label);
        Graph g = (Graph) GList.get(idGraph);
        try {
            g.add(s);
        } catch (NodeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * @param idGraph
     * @param label
     * @return
     */

    public boolean deleteNode(int idGraph, String label) {

        Graph g = (Graph) GList.get(idGraph);
        Node n = g.getNode(label);
        try {
            g.delete(n);
        } catch (NodeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * @param idGraph
     * @param numNode
     * @return
     */

    public boolean deleteNode(int idGraph, int numNode) {
        Graph g = (Graph) GList.get(idGraph);
        Node n = g.getNode(numNode);
        try {
            g.delete(n);
        } catch (NodeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * @param idGraph
     * @param labelNode1
     * @param labelNode2
     * @param weight
     * @return
     */

    public boolean addArc(int idGraph, String labelNode1, String labelNode2, int weight) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(labelNode1);
        Node s2 = g.getNode(labelNode2);

        try {
            g.addArc(s1, s2, weight);
        } catch (ArcException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * @param idGraph
     * @param node1
     * @param node2
     * @param weight
     * @return
     */

    public boolean addArc(int idGraph, int node1, int node2, int weight) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(node1);
        Node s2 = g.getNode(node2);
        try {
            g.addArc(s1, s2, weight);
        } catch (ArcException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * @param idGraph
     * @param nodeA
     * @param nodeB
     * @return
     */

    public boolean deleteArc(int idGraph, int nodeA, int nodeB) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(nodeA);
        Node s2 = g.getNode(nodeB);
        try {
            g.deleteArc(s1, s2);
        } catch (ArcException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * @param idGraph
     * @param labelNode1
     * @param labelNode2
     * @return
     */

    public boolean deleteArc(int idGraph, String labelNode1, String labelNode2) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(labelNode1);
        Node s2 = g.getNode(labelNode2);
        try {
            g.deleteArc(s1, s2);
        } catch (ArcException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * @param idGraph
     * @param labelNode1
     * @param labelNode2
     * @param weight
     * @return
     */

    public boolean addEdge(int idGraph, String labelNode1, String labelNode2, int weight) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(labelNode1);
        Node s2 = g.getNode(labelNode2);
        try {
            g.addEdge(s1, s2, weight);
        } catch (EdgeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * @param idGraph
     * @param node1
     * @param node2
     * @param weight
     * @return
     */

    public boolean addEdge(int idGraph, int node1, int node2, int weight) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(node1);
        Node s2 = g.getNode(node2);
        try {
            g.addEdge(s1, s2, weight);
        } catch (EdgeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * @param idGraph
     * @param labelNode1
     * @param labelNode2
     * @return
     */

    public boolean deleteEdge(int idGraph, String labelNode1, String labelNode2) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(labelNode1);
        Node s2 = g.getNode(labelNode2);
        try {
            g.deleteEdge(s1, s2);
        } catch (EdgeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * @param idGraph
     * @param node1
     * @param node2
     * @return
     */

    public boolean deleteEdge(int idGraph, int node1, int node2) {
        Graph g = (Graph) GList.get(idGraph);
        Node s1 = g.getNode(node1);
        Node s2 = g.getNode(node2);
        try {
            g.deleteEdge(s1, s2);
        } catch (EdgeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * @param idGraph
     * @return
     */

    public boolean marshalling(int idGraph) {
        Graph G = get(idGraph);
        File outputFile = new File("src/main/resources/" + G.getName() + ".xml");

        JAXBContext context;
        try {

            if (G.getClass().getName().contains("GraphMatrix")) {
                context = JAXBContext.newInstance(GraphMatrix.class);
                System.out.println("matrix");
            } else {
                context = JAXBContext.newInstance(GraphList.class);
                System.out.println(G.getClass().getName());
            }
            Marshaller mGraph = context.createMarshaller();

            mGraph.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mGraph.marshal(G, outputFile);
        } catch (JAXBException ex) {
            Logger.getLogger(ModelManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return true;

// on persiste les  Graphed de la listeGraph dans le xml    
    }

    /**
     * @param file
     * @return
     */

    public int unMarshalling(String file) {

        Graph g = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("graph.modelgraph");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(file));
            if (o.getClass().getName().contains("List")) {
                g = (GraphList) o;
            } else {
                g = (GraphMatrix) o;
            }

        } catch (JAXBException ex) {
            Logger.getLogger(ModelManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        nbGraph++;
        int num = g.getIdGraph();
        if (get(num) != null) {
            g.setIdGraph(nbGraph);
            num = nbGraph;
        }
        GList.put(num, g);
        return num;
    }


    public boolean marshalling(int idGraph, String ruta) {
        Graph G = get(idGraph);
        File outputFile = new File(ruta);

        JAXBContext context;
        try {

            if (G.getClass().getName().contains("GraphMatrix")) {
                context = JAXBContext.newInstance(GraphMatrix.class);
                System.out.println("matrix");
            } else {
                context = JAXBContext.newInstance(GraphList.class);
                System.out.println(G.getClass().getName());
            }
            Marshaller mGraph = context.createMarshaller();

            mGraph.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mGraph.marshal(G, outputFile);
        } catch (JAXBException ex) {
            Logger.getLogger(ModelManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return true;

// on persiste les  Graphed de la listeGraph dans le xml
    }
}
