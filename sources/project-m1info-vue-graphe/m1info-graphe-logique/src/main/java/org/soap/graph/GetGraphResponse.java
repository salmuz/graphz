
package org.soap.graph;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getGraphResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGraphResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nbNode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="idGraph" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="numNextNode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="node" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="nodeNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="visited" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="edge" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="nodeA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="nodeB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "getGraphResponse", propOrder = {
    "_return"
})
public class GetGraphResponse {

    @XmlElement(name = "return")
    protected GetGraphResponse.Return _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link GetGraphResponse.Return }
     *     
     */
    public GetGraphResponse.Return getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetGraphResponse.Return }
     *     
     */
    public void setReturn(GetGraphResponse.Return value) {
        this._return = value;
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
     *         &lt;element name="nbNode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="idGraph" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="numNextNode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="node" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="nodeNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="visited" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="edge" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="nodeA" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="nodeB" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
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
        "nbNode",
        "idGraph",
        "numNextNode",
        "name",
        "node"
    })
    public static class Return {

        protected int nbNode;
        protected int idGraph;
        protected int numNextNode;
        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected List<GetGraphResponse.Return.Node> node;

        /**
         * Gets the value of the nbNode property.
         * 
         */
        public int getNbNode() {
            return nbNode;
        }

        /**
         * Sets the value of the nbNode property.
         * 
         */
        public void setNbNode(int value) {
            this.nbNode = value;
        }

        /**
         * Gets the value of the idGraph property.
         * 
         */
        public int getIdGraph() {
            return idGraph;
        }

        /**
         * Sets the value of the idGraph property.
         * 
         */
        public void setIdGraph(int value) {
            this.idGraph = value;
        }

        /**
         * Gets the value of the numNextNode property.
         * 
         */
        public int getNumNextNode() {
            return numNextNode;
        }

        /**
         * Sets the value of the numNextNode property.
         * 
         */
        public void setNumNextNode(int value) {
            this.numNextNode = value;
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
         * {@link GetGraphResponse.Return.Node }
         * 
         * 
         */
        public List<GetGraphResponse.Return.Node> getNode() {
            if (node == null) {
                node = new ArrayList<GetGraphResponse.Return.Node>();
            }
            return this.node;
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
        public static class Node {

            protected int nodeNum;
            protected int weight;
            @XmlElement(required = true)
            protected String name;
            protected boolean visited;
            @XmlElement(required = true)
            protected List<GetGraphResponse.Return.Node.Edge> edge;

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
             * {@link GetGraphResponse.Return.Node.Edge }
             * 
             * 
             */
            public List<GetGraphResponse.Return.Node.Edge> getEdge() {
                if (edge == null) {
                    edge = new ArrayList<GetGraphResponse.Return.Node.Edge>();
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
         @Override
            public String toString() {
                return "Graph{ nbNode=" + nbNode + ", idGraph=" + idGraph + ", name=" + name + "}\n";
            }

    }

}
