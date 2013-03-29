/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.algorithm;

import generated.Node;
import graph.exception.EdgeException;
import graph.modelgraph.Graph;
import graph.modelgraph.ModelManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony
 */
public class App {

    public static void main(String[] args) {

        ModelManager M;
        M = ModelManager.getInstance();
        System.out.println(M.toString());

        int idG1 = M.createGraph(true, "G1");
        int idG2 = M.createGraph(false, "G2");

        Graph g1 = M.get(idG1);
        Graph g2 = M.get(idG2);
        M.addNode(idG1, "a");
        M.addNode(idG1, "b");
        M.addNode(idG1, "c");
        M.addNode(idG1, "d");
        M.addNode(idG1, "e");
        M.addNode(idG1, "f");
        M.addNode(idG1, "g");
        //M.addNode(idG1, "h");

        // M.addEdge(idG1, "a", "b", 0);
        M.addEdge(idG1, "b", "c", 0);
        M.addEdge(idG1, "c", "d", 0);
        M.addEdge(idG1, "d", "e", 0);
        M.addEdge(idG1, "e", "f", 0);
        // M.addEdge(idG1, "f", "g", 0);
        //M.addEdge(idG1, "g", "a", 0);
        M.addEdge(idG1, "b", "f", 0);




        System.out.println(M.toString());

        algorithm instance = new algorithm();

        /*  System.out.println("---- DFS ----");
         List<Integer> l2 = null;
         l2 = new ArrayList();
         l2 = instance.DFS(g1, g1.getNode("a"),l2);
            
         System.out.println( l2.toString());
            
         System.out.println("---- BFS ----");
         List l = instance.BFS(g1, g1.getNode("a"));
         System.out.println( l.toString());*/

        /*System.out.println("---- EdgeContraction ----");
         g2 = instance.EdgeContraction(g1, g1.getNode("b"), g1.getNode("f"));
         System.out.println(g2.toString());*/

        /* System.out.println("---- complement ----");
         try {
         try {
         g2 = instance.Complement(g1);
         } catch (EdgeException ex) {
         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
         }
         } catch (NodeException ex) {
         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println(g2.toString());
         System.out.println(M.get(idG1).toString());*/


        System.out.println("---- sidel switch ----");

        List<Node> lst = new ArrayList<Node>();
        lst.add(g1.getNode("c"));
        lst.add(g1.getNode("d"));
        lst.add(g1.getNode("e"));

        List<Node> lst2 = new ArrayList<Node>();
        lst2.add(g1.getNode("b"));
        lst2.add(g1.getNode("f"));
        try {
            g2 = instance.SeidelSwitch(g1, lst, lst2);
        } catch (EdgeException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


        //    System.out.println(g2.toString());
        //  System.out.println(M.get(idG1).toString());
        M.marshalling(1);
        int nnum= M.unMarshalling("src/main/resources/G1.xml");
         Graph g3 = M.get(nnum);
         System.out.println(g1.toString());
         System.out.println(g3.toString());
    }
}
