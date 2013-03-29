/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

/**
 *
 * @author Hyruga
 */
public interface InterfaceManager {
    public int createGraph(boolean matrix, String name);
    public Graph copyGraph(int idGraphToCopy);
    public boolean deleteGraph(int idGraph);
    public Graph get(int idGraph);
    public boolean addNode(int idGraph,String label);
    public boolean deleteNode(int idGraph,String label);
    public boolean deleteNode(int idGraph,int numNode);
    public boolean addArc(int idGraph,String labelNode1,String labelNode2,int weight);
    public boolean addArc(int idGraph,int node1,int node2,int weight);
    public boolean deleteArc(int idGraph,String labelNode1,String labelNode2);
    public boolean deleteArc(int idGraph,int nodeA, int nodeB);
    public boolean addEdge(int idGraph,String labelNode1,String labelNode2,int weight);
    public boolean addEdge(int idGraph,int node1,int node2,int weight);
    public boolean deleteEdge(int idGraph,String labelNode1, String labelNode2);
    public boolean deleteEdge(int idGraph,int node1, int node2);
    public boolean marshalling(int idGraph);
    public int unMarshalling(String file);    
}
