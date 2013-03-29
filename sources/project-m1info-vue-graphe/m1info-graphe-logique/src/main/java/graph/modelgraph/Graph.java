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
import javax.xml.bind.annotation.XmlElement;
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
    "nbNode",
    "idGraph",
    "numNextNode",
    "name",
    "node"
})
@XmlRootElement(name = "graph")
public class Graph implements GraphCRUD{
    
    protected int nbNode;

    protected int numNextNode;
    protected int idGraph;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected List<Node> node;
    
    public Graph() {
       node = new ArrayList<Node>();
       nbNode = 0;
       numNextNode = 0;
       name = ""; 
    }
    /**
     * Obtient la valeur de la propriété nbNode.
     * 
     */
    public int getNbNode() {
        return nbNode;
    }

    /**
     * Définit la valeur de la propriété nbNode.
     * 
     */
    public void setNbNode(int value) {
        this.nbNode = value;
    }

    /**
     * Obtient la valeur de la propriété idGraph.
     * 
     */
    public int getIdGraph() {
        return idGraph;
    }

    /**
     * Définit la valeur de la propriété idGraph.
     * 
     */
    public void setIdGraph(int value) {
        this.idGraph = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the node property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the node property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Node }
     * 
     * 
     */
    public List<Node> getNode() {
        return this.node;
    }
    
    @Override
    public String toString() {
        return "Graph{ nbNode=" + nbNode + ", idGraph=" + idGraph + ", name=" + name + "}\n";
    }
    


    public boolean isEdge(Node s1, Node s2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public int degre(Node s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Node getNode(String labelNode){
       
        for(int i=0; i<node.size();i++)
        {
            Node s = node.get(i);
            if(s.getName().equals(labelNode)){
                return s;
            }
        }
        return null;
    }

    public Node getNode(int num) {
        if(num <= nbNode && node.get(num) != null)
        {
            return node.get(num);
        }
        return null;
    }
    
    

    public void add(Node s) throws NodeException {

        throw new UnsupportedOperationException("Not supported yet.");
    }

   


    public void delete(Node s) throws NodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void addArc(Node s1, Node s2, int poid) throws ArcException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void deleteArc(Node s1, Node s2) throws ArcException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void addEdge(Node s1, Node s2, int poid) throws EdgeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void deleteEdge(Node s1, Node s2) throws EdgeException
    {
        try {
            deleteArc(s1, s2);
        } catch (ArcException ex) {
            throw new EdgeException("Edge not delete");
        }
        try {
            deleteArc(s2,s1);
        } catch (ArcException ex) {
            throw new EdgeException("Edge not delete");
        }
    }
    

    public List<Node> adjacentsNode(Node s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected Edge createEdge(Node s1,Node s2,int weight,boolean oriented)
    {
         Edge edge = new Edge();
            edge.setNodeA(s1.getNodeNum());
            edge.setNodeB(s2.getNodeNum());
            edge.setWeight(weight);
            edge.setDirected(oriented);
            return edge;
    }


    public List<Edge> getEdge(int node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
