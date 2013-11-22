/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph.algorithm;

/**
 *
 * @author Anthony
 */
public class algorithm {

    /*public List<Integer> BFS(Graph g,Node n){

        List<Node> queue = new LinkedList();
        Node tmp;
        Node son;
        List<Node> adjList =null;
        List<Integer> visitedList = new ArrayList<Integer>();
        queue.add(n);

        while(!queue.isEmpty()){
           tmp = queue.get(0);
           tmp.setVisited(true);
           visitedList.add(tmp.getNodeNum());
           queue.remove(0);
           adjList = g.adjacentsNode(tmp);
           for(int i = 0; i<adjList.size();i++){
               son = adjList.get(i);
               if(!son.isVisited()){
                    queue.add(son);
               }
           }
           if(queue.isEmpty())
           {
            for(int i=0;i< g.getNbNode();i++)
            {
                if(!visitedList.contains(i))
                {
                   queue.add(g.getNode(i));
                   break;
                }
            }
           }
        }
        return visitedList;
    }

    public List<Integer> DFS(Graph g,Node n, List<Integer> visitedList){
        n.setVisited(true);
        visitedList.add(n.getNodeNum());
        List<Node> ln =g.adjacentsNode(n);
        for(Node son :ln ){
            if(!son.isVisited()){
                DFS(g,son,visitedList);
            }
        }
        return visitedList;
    }

    public Graph EdgeContraction(Graph g, Node a, Node b) throws NodeException {
        //throw new UnsupportedOperationException("Not supported yet.");

        Graph g2 = new GraphList(0,g);
        List<Edge> bEdges = g.getShape(b.getNodeNum());
        for(Edge e : bEdges){
            if(e.getNodeB() != a.getNodeNum()) {
                Node t = g2.getNode(e.getNodeB());
                Node x = g2.getNode(a.getNodeNum());
                try {
                    g2.addEdge(x, t, e.getWeight());//on ajoute les aretes de b  à a ds g2
                } catch (EdgeException ex) {
                    Logger.getLogger(algorithm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       g2.delete(g2.getNode(b.getNodeNum()));
       
        return g2;
    }

    public Graph Complement(Graph g) throws NodeException, EdgeException{
        //throw new UnsupportedOperationException("Not supported yet.");
        Graph g2 = new GraphList("t", 0);
        
        List<Node> gNodes = g.getNode();
        List<Node> adjNodes;
        for(int i = 0; i< gNodes.size();i++)
        {
            Node tmp = new Node();
            tmp.setName(gNodes.get(i).getName());
            g2.add(tmp);
        }
        
         for(Node n : gNodes){ //pour chaque sommet n de G
             //si la liste d'adj ne contient pas le sommet i de getNode de g alors on ajoute l'arrete en n et i
           adjNodes = g.adjacentsNode(n);
           for(int i =0; i < gNodes.size(); i++){ 
             Node tmp = gNodes.get(i);
             if(!adjNodes.contains(tmp) && n != tmp){
                 Node a = g2.getNode(n.getName());
                 Node b = g2.getNode(tmp.getName());
                g2.addEdge(a, b, 0);
             }
           }
        }
        return g2;
    }

    public Graph LocalComplement(Graph g, List<Node> nodes) throws EdgeException{
        //throw new UnsupportedOperationException("Not supported yet.");
        Graph g2 =  new GraphList(0, g);//GraphList(g.getIdGraph(),g);
        
       
        Node jNode, tmp;

        for(int i = 0; i < nodes.size(); i++){
            Node n = nodes.get(i);
            tmp = g2.getNode(n.getName());
            for(int j = i; j < nodes.size(); j++){
                jNode = g2.getNode(nodes.get(j).getName());
                if(!g2.adjacentsNode(tmp).contains(jNode) && jNode != tmp){
                    g2.addEdge(tmp, jNode, 0);
                }
                else{
                    if(jNode != tmp) {
                        g2.deleteEdge(tmp,jNode);
                    }
                }
            }
        }
        return g2;
    }

    public Graph SeidelSwitch (Graph g, List<Node> nodesA, List<Node> nodesB) throws EdgeException{
       Graph g2 =  new GraphList(0, g);//GraphList(g.getIdGraph(),g);
        Node jNode, tmp;

        for(int i = 0; i < nodesA.size(); i++){
            Node n = nodesA.get(i);
            tmp = g2.getNode(n.getName());
            for(int j = 0; j < nodesB.size(); j++){
                jNode = g2.getNode(nodesB.get(j).getName());
                if(!g2.adjacentsNode(tmp).contains(jNode) && jNode != tmp){
                    g2.addEdge(tmp, jNode, 0);
                }
                else{
                    if(jNode != tmp) {
                        g2.deleteEdge(tmp,jNode);
                    }
                }
            }
        }
        return g2;

    }               */
}
