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
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans
 * cette classe.
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
 *         &lt;element ref="{}edge" maxOccurs="anonymous"/>
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
"edge",
"maxMat"
})
@XmlRootElement(name = "graphMatrix")
public class GraphMatrix extends Graph {

    public GraphMatrix() {
        super();
        edgeT = null;
    }
    @XmlElement()
    Edge[][] edgeT;
    int maxMat;

    GraphMatrix(String name, int idGraph) {
        super();
        this.name = name;
        this.idGraph = idGraph;
        maxMat = 0;
    }

    @Override
    public String toString() {

        String res = "GraphMatrix number " + idGraph + " nbNode " + nbNode;
        for (int i = 0; i < node.size(); i++) {
            res += "\n" + node.get(i).getName();
            for (int j = 0; j < maxMat; j++) {
                if (edgeT[i][j] != null) {
                    res += "\n" + edgeT[i][j].getNodeA() + "->" + edgeT[i][j].getNodeB() + "(" + edgeT[i][j].getWeight() + ")";
                }
            }
        }
        return res;
    }

    @Override
    public boolean isEdge(Node s1, Node s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        int num = s1.getNodeNum();
        int num2 = s2.getNodeNum();
        if (edgeT[num][num2] != null) {
            return true;
        }
        return false;
    }

    @Override
    public int degre(Node s) {
        if (s != null) {
            int num = s.getNodeNum();
            int degre = 0;
            for (int j = 0; j < maxMat; j++) {
                if (edgeT[num][j] != null) {
                    degre++;
                }
            }

            return degre;
        }
        return -1;
    }

    @Override
    public void add(Node s) throws NodeException {
        if (s == null) {
            throw new NodeException("not add null node");
        }
        /*numéro de sommet de 0 à n-1*/
        s.setNodeNum(numNextNode);
        node.add(numNextNode, s);
        nbNode++;

        /*reallocation of matrix */
        if (numNextNode == maxMat)/*if we add a new not allowed node*/ {
            Edge[][] Nedge = new Edge[nbNode][nbNode];
            for (int i = 0; i < maxMat; ++i) {
                for (int j = 0; j < maxMat; ++j) {
                    Nedge[i][j] = edgeT[i][j];
                }
            }
            edgeT = Nedge;
            maxMat++;
        }

        numNextNode = nbNode;
        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).getNodeNum() != i) {
                numNextNode = i;
                break;
            }
        }
    }

    @Override
    public void delete(Node s) throws NodeException {
        if (s == null) {
            throw new NodeException("cannot delete null node");
        }

        int numNode = s.getNodeNum();
        for (int i = 0; i < maxMat; i++) {
            edgeT[numNode][i] = null;
        }
        if (numNextNode > numNode) {
            numNextNode = numNode;
        }
        node.remove(s);
        nbNode--;
    }

    @Override
    public void addArc(Node s1, Node s2, int weight) throws ArcException {

        if (s1 == null || s2 == null) {
            throw new ArcException("arc not add, node null");
        }
        Edge nEdge = createEdge(s1, s2, weight, true);
        edgeT[s1.getNodeNum()][s2.getNodeNum()] = nEdge;
    }

    @Override
    public void deleteArc(Node s1, Node s2) throws ArcException {

        if (s1 == null || s2 == null) {
            throw new ArcException("arc not add, node null");
        }
        edgeT[s1.getNodeNum()][s2.getNodeNum()] = null;
    }

    @Override
    public void addEdge(Node s1, Node s2, int weight) throws EdgeException {

        if (s1 == null || s2 == null) {
            throw new EdgeException("edge not add, node null");
        }
        Edge nEdge = createEdge(s1, s2, weight, false);
        Edge nEdge2 = createEdge(s2, s1, weight, false);
        edgeT[s1.getNodeNum()][s2.getNodeNum()] = nEdge;
        edgeT[s2.getNodeNum()][s1.getNodeNum()] = nEdge2;
    }

    @Override
    public List<Node> adjacentsNode(Node s) {
        if (s == null) {
            return new ArrayList<Node>();
        }

        List<Node> ln = new ArrayList<Node>();
        int num = s.getNodeNum();

        for (int j = 0; j < maxMat; j++) {

            if (edgeT[num][j] != null) {
                ln.add(node.get(edgeT[num][j].getNodeB()));
            }
        }
        return ln;
    }

    @Override
    public List<Edge> getEdge(int numnode) {

        List<Edge> le = new ArrayList<Edge>();

        for (int i = 0; i < maxMat; i++) {
            if(edgeT[numnode][i] != null) {
                le.add(edgeT[numnode][i]);
            }
        }
        return le;
    }
}
