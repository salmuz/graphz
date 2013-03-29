
package org.soap.graph;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GraphsSOAP", targetNamespace = "http://soap/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GraphsSOAP {


    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addEdge", targetNamespace = "http://soap/", className = "org.soap.graph.AddEdge")
    @ResponseWrapper(localName = "addEdgeResponse", targetNamespace = "http://soap/", className = "org.soap.graph.AddEdgeResponse")
    @Action(input = "http://soap/GraphsSOAP/addEdgeRequest", output = "http://soap/GraphsSOAP/addEdgeResponse")
    public boolean addEdge(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addNode", targetNamespace = "http://soap/", className = "org.soap.graph.AddNode")
    @ResponseWrapper(localName = "addNodeResponse", targetNamespace = "http://soap/", className = "org.soap.graph.AddNodeResponse")
    @Action(input = "http://soap/GraphsSOAP/addNodeRequest", output = "http://soap/GraphsSOAP/addNodeResponse")
    public boolean addNode(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createGraph", targetNamespace = "http://soap/", className = "org.soap.graph.CreateGraph")
    @ResponseWrapper(localName = "createGraphResponse", targetNamespace = "http://soap/", className = "org.soap.graph.CreateGraphResponse")
    @Action(input = "http://soap/GraphsSOAP/createGraphRequest", output = "http://soap/GraphsSOAP/createGraphResponse")
    public boolean createGraph(
        @WebParam(name = "arg0", targetNamespace = "")
        boolean arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saveGraph", targetNamespace = "http://soap/", className = "org.soap.graph.SaveGraph")
    @ResponseWrapper(localName = "saveGraphResponse", targetNamespace = "http://soap/", className = "org.soap.graph.SaveGraphResponse")
    @Action(input = "http://soap/GraphsSOAP/saveGraphRequest", output = "http://soap/GraphsSOAP/saveGraphResponse")
    public boolean saveGraph(
        @WebParam(name = "arg0", targetNamespace = "")
        org.soap.graph.SaveGraph.Arg0 arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns org.soap.graph.GetGraphResponse.Return
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getGraph", targetNamespace = "http://soap/", className = "org.soap.graph.GetGraph")
    @ResponseWrapper(localName = "getGraphResponse", targetNamespace = "http://soap/", className = "org.soap.graph.GetGraphResponse")
    @Action(input = "http://soap/GraphsSOAP/getGraphRequest", output = "http://soap/GraphsSOAP/getGraphResponse")
    public org.soap.graph.GetGraphResponse.Return getGraph(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteGraph", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteGraph")
    @ResponseWrapper(localName = "deleteGraphResponse", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteGraphResponse")
    @Action(input = "http://soap/GraphsSOAP/deleteGraphRequest", output = "http://soap/GraphsSOAP/deleteGraphResponse")
    public boolean deleteGraph(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteNodeByLabel", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteNodeByLabel")
    @ResponseWrapper(localName = "deleteNodeByLabelResponse", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteNodeByLabelResponse")
    @Action(input = "http://soap/GraphsSOAP/deleteNodeByLabelRequest", output = "http://soap/GraphsSOAP/deleteNodeByLabelResponse")
    public boolean deleteNodeByLabel(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteNode", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteNode")
    @ResponseWrapper(localName = "deleteNodeResponse", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteNodeResponse")
    @Action(input = "http://soap/GraphsSOAP/deleteNodeRequest", output = "http://soap/GraphsSOAP/deleteNodeResponse")
    public boolean deleteNode(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addArcByLabel", targetNamespace = "http://soap/", className = "org.soap.graph.AddArcByLabel")
    @ResponseWrapper(localName = "addArcByLabelResponse", targetNamespace = "http://soap/", className = "org.soap.graph.AddArcByLabelResponse")
    @Action(input = "http://soap/GraphsSOAP/addArcByLabelRequest", output = "http://soap/GraphsSOAP/addArcByLabelResponse")
    public boolean addArcByLabel(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addArc", targetNamespace = "http://soap/", className = "org.soap.graph.AddArc")
    @ResponseWrapper(localName = "addArcResponse", targetNamespace = "http://soap/", className = "org.soap.graph.AddArcResponse")
    @Action(input = "http://soap/GraphsSOAP/addArcRequest", output = "http://soap/GraphsSOAP/addArcResponse")
    public boolean addArc(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteArcByLabel", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteArcByLabel")
    @ResponseWrapper(localName = "deleteArcByLabelResponse", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteArcByLabelResponse")
    @Action(input = "http://soap/GraphsSOAP/deleteArcByLabelRequest", output = "http://soap/GraphsSOAP/deleteArcByLabelResponse")
    public boolean deleteArcByLabel(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteArc", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteArc")
    @ResponseWrapper(localName = "deleteArcResponse", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteArcResponse")
    @Action(input = "http://soap/GraphsSOAP/deleteArcRequest", output = "http://soap/GraphsSOAP/deleteArcResponse")
    public boolean deleteArc(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addEdgeByLabel", targetNamespace = "http://soap/", className = "org.soap.graph.AddEdgeByLabel")
    @ResponseWrapper(localName = "addEdgeByLabelResponse", targetNamespace = "http://soap/", className = "org.soap.graph.AddEdgeByLabelResponse")
    @Action(input = "http://soap/GraphsSOAP/addEdgeByLabelRequest", output = "http://soap/GraphsSOAP/addEdgeByLabelResponse")
    public boolean addEdgeByLabel(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteEdgeByLabel", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteEdgeByLabel")
    @ResponseWrapper(localName = "deleteEdgeByLabelResponse", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteEdgeByLabelResponse")
    @Action(input = "http://soap/GraphsSOAP/deleteEdgeByLabelRequest", output = "http://soap/GraphsSOAP/deleteEdgeByLabelResponse")
    public boolean deleteEdgeByLabel(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteEdge", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteEdge")
    @ResponseWrapper(localName = "deleteEdgeResponse", targetNamespace = "http://soap/", className = "org.soap.graph.DeleteEdgeResponse")
    @Action(input = "http://soap/GraphsSOAP/deleteEdgeRequest", output = "http://soap/GraphsSOAP/deleteEdgeResponse")
    public boolean deleteEdge(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "marshalling", targetNamespace = "http://soap/", className = "org.soap.graph.Marshalling")
    @ResponseWrapper(localName = "marshallingResponse", targetNamespace = "http://soap/", className = "org.soap.graph.MarshallingResponse")
    @Action(input = "http://soap/GraphsSOAP/marshallingRequest", output = "http://soap/GraphsSOAP/marshallingResponse")
    public boolean marshalling(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "unMarshalling", targetNamespace = "http://soap/", className = "org.soap.graph.UnMarshalling")
    @ResponseWrapper(localName = "unMarshallingResponse", targetNamespace = "http://soap/", className = "org.soap.graph.UnMarshallingResponse")
    @Action(input = "http://soap/GraphsSOAP/unMarshallingRequest", output = "http://soap/GraphsSOAP/unMarshallingResponse")
    public boolean unMarshalling(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

}
