package graph.modelgraph;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ModelManager M;
        M = ModelManager.getInstance();
        System.out.println(M.toString());
        
        M.createGraph(true, "GMat1");
        M.createGraph(false, "GList1");
        
        Graph g1 = M.get(1);
        M.addNode(1, "a");
        M.addNode(1,"b");
        
        System.out.println(g1.toString());
        M.deleteNode(1, "a");
        M.addNode(1, "c");
        System.out.println(g1.toString());
        M.addEdge(1, "b", "c", 3);
        System.out.println(g1.toString());
        
        M.deleteEdge(1, "c", "b");
        System.out.println(g1.adjacentsNode(g1.getNode("b")).size());
        Graph g2 = M.get(2);
        
        M.addNode(2, "a");
        M.addNode(2,"b");
        M.addArc(2,"a","b",5);
        M.addArc(2,"b","a",10);
        System.out.println(g2.toString());
        M.deleteNode(2, "a");
        M.addNode(2, "c");
        //M.addNode(2,"b");
     
        System.out.println(M.get(2).toString());
        System.out.println(M.toString());

        M.deleteGraph(1);
        System.out.println(M.toString());
    }
}
