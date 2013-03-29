//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.02.08 à 11:08:13 AM CET 
//


package graph.modelgraph;

import generated.Edge;
import generated.Node;
import graph.exception.ArcException;
import graph.exception.EdgeException;
import graph.exception.NodeException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nbNode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idGraph" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}node" maxOccurs="unbounded"/>
 *         &lt;element ref="{}edge" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
 /* "nbNode",
    "idGraph",
    "numNextNode",
    "name",
    "node",*/
})
@XmlRootElement(name = "graphList")
public class GraphList extends Graph {

    public GraphList()
    {
        super();
    }
    public GraphList(String name,int idGraph) {
        super();
        this.name = name;
        this.idGraph = idGraph;
    }

   public  GraphList(int idGraph,Graph g)
    {
        super();
        this.name = g.name;
        this.idGraph = idGraph;
        this.numNextNode = g.numNextNode;
        nbNode = g.getNbNode();
        for(int i = 0; i< g.getNbNode();i++)
        {
            Node s = new Node();
            s.setName(g.getNode(i).getName());
            s.setNodeNum(i);
           List<Edge> le = g.getEdge(i);
           for( Edge e : le)
           {
               Edge ne = new Edge();
               ne.setNodeA(e.getNodeA());
               ne.setNodeB(e.getNodeB());
               ne.setWeight(e.getWeight());
               s.getEdge().add(ne);
           }
          node.add(s);
        }
       
    }
    @Override
    public String toString() {
        String res= "GraphList number " + idGraph + " nbNode " +nbNode ;
        
        for (int i =0;i<node.size();i++)
        {
           res += "\n" + node.get(i).getName();
           List<Edge> le = node.get(i).getEdge();
           if(node.get(i).getEdge().size()>0)
           {
               for(Edge e : le)
               {
                   res+= "\n" + e.getNodeA()+ "->" + e.getNodeB() +"("+ e.getWeight()+")";
               }
           }
        }
        return res; 
    }
    
    
    @Override
    public boolean isEdge(Node s1, Node s2)
    {
        if( s1 == null || s2 == null)
        {
            return false;
        }
        
        List<Edge> le = s1.getEdge();
        int num = s2 .getNodeNum(); 
        for(Edge e : le )
        {
            if(num == e.getNodeB())
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int degre(Node s)
    {
        if(s!= null) {
            return s.getEdge().size();
        }
        return -1;
    }
    
    @Override
    public void add(Node s) throws NodeException {
        if(s == null)
        {
           throw new NodeException("not add null node");
        }
        /*numéro de sommet de 0 à n-1*/
        s.setNodeNum(numNextNode);
        node.add(numNextNode,s);
        nbNode++;
        numNextNode=nbNode;
        for(int i = 0;i<node.size();i++)
        {
            if(node.get(i).getNodeNum() != i)
            {
                numNextNode = i;
                break;
            }
        }
    }
    @Override
    public void delete(Node s) throws NodeException {
        if(s == null) {
            throw new NodeException("cannot delete null node");
        }
        int numNode = s.getNodeNum();
        for( int i=0;i<node.size();++i)
        {
            if(i == numNode) {
                continue;
            }
            List<Edge> edge = node.get(i).getEdge();
            for(int j = 0;j<edge.size();j++)
            {
                Edge cE = edge.get(j);
                if(cE.getNodeA() == numNode ||cE.getNodeB() == numNode)
                {
                    edge.remove(j);
                }
            }
        }
        boolean remove = node.remove(s);
        if(!remove) {
            throw new NodeException("remove node error");
        }
        if(numNextNode >numNode)
        {
            numNextNode = numNode;
        }
        nbNode--;
    }
    
    @Override
    public void addArc(Node s1, Node s2, int weight) throws ArcException {
        if(s1 == null || s2==null)
        {
            throw new ArcException("Arc not add: null node ");
        }
       Edge edge = createEdge(s1, s2, weight, true);
        boolean add;
        add = s1.getEdge().add(edge);
        if(!add)
        {
            throw new ArcException("Arc not add");
        }   
    }
    @Override
    public void deleteArc(Node s1, Node s2) throws ArcException
    {
       if( s1 == null || s2 ==null)
       {
           throw new ArcException("arc not delete, node null");
       }
       List<Edge> edge = s1.getEdge();
       int num = s2.getNodeNum();
       for(int i = 0 ; i< edge.size();i++)
       {
           Edge e = edge.get(i);
           if(e.getNodeB() == num)
           {
               edge.remove(i);
               return ;
           }
       }
       throw new ArcException("Arc not delete");
    }
    
    @Override
    public void addEdge(Node s1, Node s2, int weight) throws EdgeException {
        
        List<Edge> list = s1.getEdge();
        for(Edge e : list)
        {
            if(e.getNodeB() == s2.getNodeNum())
            {
                return;
            }
        }
        
        Edge edge = createEdge(s1, s2, weight, false),edge2 = createEdge(s2, s1, weight, false);
        boolean add;
        add = s1.getEdge().add(edge);
        if(!add)
        {
            throw new EdgeException("Edge not add");
        }
 
        add = s2.getEdge().add(edge2);
        if(!add)
        {
            deleteEdge(s1, s2);
            throw new EdgeException("Edge not add");
        }
    }
    
   
    @Override
    public List<Node> adjacentsNode(Node s) {
        List<Node> ln = new ArrayList<Node>();
        List<Edge> le = s.getEdge();
        
        for(Edge e : le)
        {
            ln.add(node.get(e.getNodeB()));
        }
        return ln;
    } 
    
    @Override
    public List<Edge> getEdge(int numnode) {
        
        return node.get(numnode).getEdge();
    }
}
