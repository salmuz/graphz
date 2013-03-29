
package org.soap.graph;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for saveGraph complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="saveGraph">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" minOccurs="0">
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
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveGraph", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class SaveGraph {

    protected SaveGraph.Arg0 arg0;
    protected String arg1;
    protected String arg2;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link SaveGraph.Arg0 }
     *     
     */
    public SaveGraph.Arg0 getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveGraph.Arg0 }
     *     
     */
    public void setArg0(SaveGraph.Arg0 value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg1(String value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg2(String value) {
        this.arg2 = value;
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
    public static class Arg0 {

        protected int nbNode;
        protected int idGraph;
        protected int numNextNode;
        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected List<SaveGraph.Arg0 .Node> node;

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
         * {@link SaveGraph.Arg0 .Node }
         * 
         * 
         */
        public List<SaveGraph.Arg0 .Node> getNode() {
            if (node == null) {
                node = new ArrayList<SaveGraph.Arg0 .Node>();
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
            protected List<SaveGraph.Arg0 .Node.Edge> edge;

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
             * {@link SaveGraph.Arg0 .Node.Edge }
             * 
             * 
             */
            public List<SaveGraph.Arg0 .Node.Edge> getEdge() {
                if (edge == null) {
                    edge = new ArrayList<SaveGraph.Arg0 .Node.Edge>();
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

    }

}
