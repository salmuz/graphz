
package org.soap.graph;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
@XmlRootElement(name = "edge")
public class Edge {

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
