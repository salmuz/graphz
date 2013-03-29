/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;
import generated.Edge;
import generated.Node;
import graph.exception.ArcException;
import graph.exception.EdgeException;
import graph.exception.NodeException; 
import java.util.List;

/**
 *
 * @author jemorgon1
 */
public interface GraphCRUD {
    public boolean isEdge(Node s1,Node s2);
    public int degre(Node s);
    public void add(Node s) throws NodeException;
    public  Node getNode(String labelNode);
    public  Node getNode(int num);
    public void delete(Node s) throws NodeException;
    public void addArc(Node s1, Node s2, int poid)throws ArcException;
    public void deleteArc(Node s1, Node s2) throws ArcException;
    public void addEdge(Node s1, Node s2,int poid) throws EdgeException;
    public void deleteEdge(Node s1 , Node s2) throws EdgeException;
    public List<Node> adjacentsNode(Node s);
    public List<Edge> getEdge(int node);
    
}
