
package org.soap.graph;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="visited" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="edge" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nodeA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="nodeB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "nodeNum",
    "weight",
    "name",
    "visited",
    "edge"
})
@XmlRootElement(name = "node")
public class Node {

    protected int nodeNum;
    protected int weight;
    @XmlElement(required = true)
    protected String name;
    protected boolean visited;
    @XmlElement(required = true)
    protected List<Node.Edge> edge;

    /**
     * Gets the value of the nodeNum property.
     * 
     */
    public int getNodeNum() {
        return nodeNum;
    }

    /**
     * Sets the value of the nodeNum property.
     * 
     */
    public void setNodeNum(int value) {
        this.nodeNum = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     */
    public void setWeight(int value) {
        this.weight = value;
    }

    /**
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
     * Gets the value of the visited property.
     * 
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Sets the value of the visited property.
     * 
     */
    public void setVisited(boolean value) {
        this.visited = value;
    }

    /**
     * Gets the value of the edge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Node.Edge }
     * 
     * 
     */
    public List<Node.Edge> getEdge() {
        if (edge == null) {
            edge = new ArrayList<Node.Edge>();
        }
        return this.edge;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nodeA" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="nodeB" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "nodeA",
        "nodeB",
        "weight",
        "directed"
    })
    public static class Edge {

        protected int nodeA;
        protected int nodeB;
        protected int weight;
        protected boolean directed;

        /**
         * Gets the value of the nodeA property.
         * 
         */
        public int getNodeA() {
            return nodeA;
        }

        /**
         * Sets the value of the nodeA property.
         * 
         */
        public void setNodeA(int value) {
            this.nodeA = value;
        }

        /**
         * Gets the value of the nodeB property.
         * 
         */
        public int getNodeB() {
            return nodeB;
        }

        /**
         * Sets the value of the nodeB property.
         * 
         */
        public void setNodeB(int value) {
            this.nodeB = value;
        }

        /**
         * Gets the value of the weight property.
         * 
         */
        public int getWeight() {
            return weight;
        }

        /**
         * Sets the value of the weight property.
         * 
         */
        public void setWeight(int value) {
            this.weight = value;
        }

        /**
         * Gets the value of the directed property.
         * 
         */
        public boolean isDirected() {
            return directed;
        }

        /**
         * Sets the value of the directed property.
         * 
         */
        public void setDirected(boolean value) {
            this.directed = value;
        }

    }

}
