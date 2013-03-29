
package org.soap.graph;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.soap.graph package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SaveGraphResponse_QNAME = new QName("http://soap/", "saveGraphResponse");
    private final static QName _AddArc_QNAME = new QName("http://soap/", "addArc");
    private final static QName _DeleteNodeByLabel_QNAME = new QName("http://soap/", "deleteNodeByLabel");
    private final static QName _MarshallingResponse_QNAME = new QName("http://soap/", "marshallingResponse");
    private final static QName _DeleteEdgeByLabelResponse_QNAME = new QName("http://soap/", "deleteEdgeByLabelResponse");
    private final static QName _AddArcByLabelResponse_QNAME = new QName("http://soap/", "addArcByLabelResponse");
    private final static QName _DeleteNode_QNAME = new QName("http://soap/", "deleteNode");
    private final static QName _Marshalling_QNAME = new QName("http://soap/", "marshalling");
    private final static QName _AddArcByLabel_QNAME = new QName("http://soap/", "addArcByLabel");
    private final static QName _UnMarshallingResponse_QNAME = new QName("http://soap/", "unMarshallingResponse");
    private final static QName _AddEdgeByLabelResponse_QNAME = new QName("http://soap/", "addEdgeByLabelResponse");
    private final static QName _DeleteEdge_QNAME = new QName("http://soap/", "deleteEdge");
    private final static QName _SaveGraph_QNAME = new QName("http://soap/", "saveGraph");
    private final static QName _AddArcResponse_QNAME = new QName("http://soap/", "addArcResponse");
    private final static QName _GetGraph_QNAME = new QName("http://soap/", "getGraph");
    private final static QName _DeleteArcByLabel_QNAME = new QName("http://soap/", "deleteArcByLabel");
    private final static QName _UnMarshalling_QNAME = new QName("http://soap/", "unMarshalling");
    private final static QName _DeleteArcResponse_QNAME = new QName("http://soap/", "deleteArcResponse");
    private final static QName _DeleteNodeByLabelResponse_QNAME = new QName("http://soap/", "deleteNodeByLabelResponse");
    private final static QName _DeleteNodeResponse_QNAME = new QName("http://soap/", "deleteNodeResponse");
    private final static QName _AddEdge_QNAME = new QName("http://soap/", "addEdge");
    private final static QName _AddEdgeResponse_QNAME = new QName("http://soap/", "addEdgeResponse");
    private final static QName _AddNode_QNAME = new QName("http://soap/", "addNode");
    private final static QName _AddNodeResponse_QNAME = new QName("http://soap/", "addNodeResponse");
    private final static QName _DeleteArcByLabelResponse_QNAME = new QName("http://soap/", "deleteArcByLabelResponse");
    private final static QName _DeleteGraph_QNAME = new QName("http://soap/", "deleteGraph");
    private final static QName _DeleteArc_QNAME = new QName("http://soap/", "deleteArc");
    private final static QName _AddEdgeByLabel_QNAME = new QName("http://soap/", "addEdgeByLabel");
    private final static QName _DeleteEdgeResponse_QNAME = new QName("http://soap/", "deleteEdgeResponse");
    private final static QName _CreateGraphResponse_QNAME = new QName("http://soap/", "createGraphResponse");
    private final static QName _GetGraphResponse_QNAME = new QName("http://soap/", "getGraphResponse");
    private final static QName _CreateGraph_QNAME = new QName("http://soap/", "createGraph");
    private final static QName _DeleteGraphResponse_QNAME = new QName("http://soap/", "deleteGraphResponse");
    private final static QName _DeleteEdgeByLabel_QNAME = new QName("http://soap/", "deleteEdgeByLabel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soap.graph
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetGraphResponse }
     * 
     */
    public GetGraphResponse createGetGraphResponse() {
        return new GetGraphResponse();
    }

    /**
     * Create an instance of {@link Marshalling }
     * 
     */
    public Marshalling createMarshalling() {
        return new Marshalling();
    }

    /**
     * Create an instance of {@link SaveGraph.Arg0 .Node }
     * 
     */
    public SaveGraph.Arg0 .Node createSaveGraphArg0Node() {
        return new SaveGraph.Arg0 .Node();
    }

    /**
     * Create an instance of {@link DeleteArcResponse }
     * 
     */
    public DeleteArcResponse createDeleteArcResponse() {
        return new DeleteArcResponse();
    }

    /**
     * Create an instance of {@link AddEdgeResponse }
     * 
     */
    public AddEdgeResponse createAddEdgeResponse() {
        return new AddEdgeResponse();
    }

    /**
     * Create an instance of {@link Graph }
     * 
     */
    public Graph createGraph() {
        return new Graph();
    }

    /**
     * Create an instance of {@link SaveGraph }
     * 
     */
    public SaveGraph createSaveGraph() {
        return new SaveGraph();
    }

    /**
     * Create an instance of {@link DeleteArc }
     * 
     */
    public DeleteArc createDeleteArc() {
        return new DeleteArc();
    }

    /**
     * Create an instance of {@link GetGraphResponse.Return.Node }
     * 
     */
    public GetGraphResponse.Return.Node createGetGraphResponseReturnNode() {
        return new GetGraphResponse.Return.Node();
    }

    /**
     * Create an instance of {@link AddArc }
     * 
     */
    public AddArc createAddArc() {
        return new AddArc();
    }

    /**
     * Create an instance of {@link AddNode }
     * 
     */
    public AddNode createAddNode() {
        return new AddNode();
    }

    /**
     * Create an instance of {@link org.soap.graph.Node }
     * 
     */
    public org.soap.graph.Node createNode() {
        return new org.soap.graph.Node();
    }

    /**
     * Create an instance of {@link Graph.Node.Edge }
     * 
     */
    public Graph.Node.Edge createGraphNodeEdge() {
        return new Graph.Node.Edge();
    }

    /**
     * Create an instance of {@link AddEdge }
     * 
     */
    public AddEdge createAddEdge() {
        return new AddEdge();
    }

    /**
     * Create an instance of {@link DeleteNodeByLabel }
     * 
     */
    public DeleteNodeByLabel createDeleteNodeByLabel() {
        return new DeleteNodeByLabel();
    }

    /**
     * Create an instance of {@link SaveGraph.Arg0 .Node.Edge }
     * 
     */
    public SaveGraph.Arg0 .Node.Edge createSaveGraphArg0NodeEdge() {
        return new SaveGraph.Arg0 .Node.Edge();
    }

    /**
     * Create an instance of {@link CreateGraphResponse }
     * 
     */
    public CreateGraphResponse createCreateGraphResponse() {
        return new CreateGraphResponse();
    }

    /**
     * Create an instance of {@link DeleteGraphResponse }
     * 
     */
    public DeleteGraphResponse createDeleteGraphResponse() {
        return new DeleteGraphResponse();
    }

    /**
     * Create an instance of {@link org.soap.graph.Edge }
     * 
     */
    public org.soap.graph.Edge createEdge() {
        return new org.soap.graph.Edge();
    }

    /**
     * Create an instance of {@link DeleteGraph }
     * 
     */
    public DeleteGraph createDeleteGraph() {
        return new DeleteGraph();
    }

    /**
     * Create an instance of {@link UnMarshalling }
     * 
     */
    public UnMarshalling createUnMarshalling() {
        return new UnMarshalling();
    }

    /**
     * Create an instance of {@link org.soap.graph.Node.Edge }
     * 
     */
    public org.soap.graph.Node.Edge createNodeEdge() {
        return new org.soap.graph.Node.Edge();
    }

    /**
     * Create an instance of {@link AddArcByLabelResponse }
     * 
     */
    public AddArcByLabelResponse createAddArcByLabelResponse() {
        return new AddArcByLabelResponse();
    }

    /**
     * Create an instance of {@link SaveGraphResponse }
     * 
     */
    public SaveGraphResponse createSaveGraphResponse() {
        return new SaveGraphResponse();
    }

    /**
     * Create an instance of {@link GetGraphResponse.Return }
     * 
     */
    public GetGraphResponse.Return createGetGraphResponseReturn() {
        return new GetGraphResponse.Return();
    }

    /**
     * Create an instance of {@link DeleteNode }
     * 
     */
    public DeleteNode createDeleteNode() {
        return new DeleteNode();
    }

    /**
     * Create an instance of {@link DeleteEdgeByLabelResponse }
     * 
     */
    public DeleteEdgeByLabelResponse createDeleteEdgeByLabelResponse() {
        return new DeleteEdgeByLabelResponse();
    }

    /**
     * Create an instance of {@link DeleteNodeByLabelResponse }
     * 
     */
    public DeleteNodeByLabelResponse createDeleteNodeByLabelResponse() {
        return new DeleteNodeByLabelResponse();
    }

    /**
     * Create an instance of {@link AddEdgeByLabel }
     * 
     */
    public AddEdgeByLabel createAddEdgeByLabel() {
        return new AddEdgeByLabel();
    }

    /**
     * Create an instance of {@link DeleteArcByLabelResponse }
     * 
     */
    public DeleteArcByLabelResponse createDeleteArcByLabelResponse() {
        return new DeleteArcByLabelResponse();
    }

    /**
     * Create an instance of {@link DeleteArcByLabel }
     * 
     */
    public DeleteArcByLabel createDeleteArcByLabel() {
        return new DeleteArcByLabel();
    }

    /**
     * Create an instance of {@link DeleteEdgeByLabel }
     * 
     */
    public DeleteEdgeByLabel createDeleteEdgeByLabel() {
        return new DeleteEdgeByLabel();
    }

    /**
     * Create an instance of {@link DeleteNodeResponse }
     * 
     */
    public DeleteNodeResponse createDeleteNodeResponse() {
        return new DeleteNodeResponse();
    }

    /**
     * Create an instance of {@link AddArcResponse }
     * 
     */
    public AddArcResponse createAddArcResponse() {
        return new AddArcResponse();
    }

    /**
     * Create an instance of {@link DeleteEdgeResponse }
     * 
     */
    public DeleteEdgeResponse createDeleteEdgeResponse() {
        return new DeleteEdgeResponse();
    }

    /**
     * Create an instance of {@link MarshallingResponse }
     * 
     */
    public MarshallingResponse createMarshallingResponse() {
        return new MarshallingResponse();
    }

    /**
     * Create an instance of {@link AddNodeResponse }
     * 
     */
    public AddNodeResponse createAddNodeResponse() {
        return new AddNodeResponse();
    }

    /**
     * Create an instance of {@link CreateGraph }
     * 
     */
    public CreateGraph createCreateGraph() {
        return new CreateGraph();
    }

    /**
     * Create an instance of {@link Graph.Node }
     * 
     */
    public Graph.Node createGraphNode() {
        return new Graph.Node();
    }

    /**
     * Create an instance of {@link DeleteEdge }
     * 
     */
    public DeleteEdge createDeleteEdge() {
        return new DeleteEdge();
    }

    /**
     * Create an instance of {@link UnMarshallingResponse }
     * 
     */
    public UnMarshallingResponse createUnMarshallingResponse() {
        return new UnMarshallingResponse();
    }

    /**
     * Create an instance of {@link GetGraphResponse.Return.Node.Edge }
     * 
     */
    public GetGraphResponse.Return.Node.Edge createGetGraphResponseReturnNodeEdge() {
        return new GetGraphResponse.Return.Node.Edge();
    }

    /**
     * Create an instance of {@link SaveGraph.Arg0 }
     * 
     */
    public SaveGraph.Arg0 createSaveGraphArg0() {
        return new SaveGraph.Arg0();
    }

    /**
     * Create an instance of {@link AddEdgeByLabelResponse }
     * 
     */
    public AddEdgeByLabelResponse createAddEdgeByLabelResponse() {
        return new AddEdgeByLabelResponse();
    }

    /**
     * Create an instance of {@link GetGraph }
     * 
     */
    public GetGraph createGetGraph() {
        return new GetGraph();
    }

    /**
     * Create an instance of {@link AddArcByLabel }
     * 
     */
    public AddArcByLabel createAddArcByLabel() {
        return new AddArcByLabel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveGraphResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "saveGraphResponse")
    public JAXBElement<SaveGraphResponse> createSaveGraphResponse(SaveGraphResponse value) {
        return new JAXBElement<SaveGraphResponse>(_SaveGraphResponse_QNAME, SaveGraphResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addArc")
    public JAXBElement<AddArc> createAddArc(AddArc value) {
        return new JAXBElement<AddArc>(_AddArc_QNAME, AddArc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNodeByLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteNodeByLabel")
    public JAXBElement<DeleteNodeByLabel> createDeleteNodeByLabel(DeleteNodeByLabel value) {
        return new JAXBElement<DeleteNodeByLabel>(_DeleteNodeByLabel_QNAME, DeleteNodeByLabel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarshallingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "marshallingResponse")
    public JAXBElement<MarshallingResponse> createMarshallingResponse(MarshallingResponse value) {
        return new JAXBElement<MarshallingResponse>(_MarshallingResponse_QNAME, MarshallingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEdgeByLabelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteEdgeByLabelResponse")
    public JAXBElement<DeleteEdgeByLabelResponse> createDeleteEdgeByLabelResponse(DeleteEdgeByLabelResponse value) {
        return new JAXBElement<DeleteEdgeByLabelResponse>(_DeleteEdgeByLabelResponse_QNAME, DeleteEdgeByLabelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArcByLabelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addArcByLabelResponse")
    public JAXBElement<AddArcByLabelResponse> createAddArcByLabelResponse(AddArcByLabelResponse value) {
        return new JAXBElement<AddArcByLabelResponse>(_AddArcByLabelResponse_QNAME, AddArcByLabelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteNode")
    public JAXBElement<DeleteNode> createDeleteNode(DeleteNode value) {
        return new JAXBElement<DeleteNode>(_DeleteNode_QNAME, DeleteNode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Marshalling }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "marshalling")
    public JAXBElement<Marshalling> createMarshalling(Marshalling value) {
        return new JAXBElement<Marshalling>(_Marshalling_QNAME, Marshalling.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArcByLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addArcByLabel")
    public JAXBElement<AddArcByLabel> createAddArcByLabel(AddArcByLabel value) {
        return new JAXBElement<AddArcByLabel>(_AddArcByLabel_QNAME, AddArcByLabel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnMarshallingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "unMarshallingResponse")
    public JAXBElement<UnMarshallingResponse> createUnMarshallingResponse(UnMarshallingResponse value) {
        return new JAXBElement<UnMarshallingResponse>(_UnMarshallingResponse_QNAME, UnMarshallingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEdgeByLabelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addEdgeByLabelResponse")
    public JAXBElement<AddEdgeByLabelResponse> createAddEdgeByLabelResponse(AddEdgeByLabelResponse value) {
        return new JAXBElement<AddEdgeByLabelResponse>(_AddEdgeByLabelResponse_QNAME, AddEdgeByLabelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEdge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteEdge")
    public JAXBElement<DeleteEdge> createDeleteEdge(DeleteEdge value) {
        return new JAXBElement<DeleteEdge>(_DeleteEdge_QNAME, DeleteEdge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveGraph }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "saveGraph")
    public JAXBElement<SaveGraph> createSaveGraph(SaveGraph value) {
        return new JAXBElement<SaveGraph>(_SaveGraph_QNAME, SaveGraph.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addArcResponse")
    public JAXBElement<AddArcResponse> createAddArcResponse(AddArcResponse value) {
        return new JAXBElement<AddArcResponse>(_AddArcResponse_QNAME, AddArcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGraph }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getGraph")
    public JAXBElement<GetGraph> createGetGraph(GetGraph value) {
        return new JAXBElement<GetGraph>(_GetGraph_QNAME, GetGraph.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArcByLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteArcByLabel")
    public JAXBElement<DeleteArcByLabel> createDeleteArcByLabel(DeleteArcByLabel value) {
        return new JAXBElement<DeleteArcByLabel>(_DeleteArcByLabel_QNAME, DeleteArcByLabel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnMarshalling }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "unMarshalling")
    public JAXBElement<UnMarshalling> createUnMarshalling(UnMarshalling value) {
        return new JAXBElement<UnMarshalling>(_UnMarshalling_QNAME, UnMarshalling.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteArcResponse")
    public JAXBElement<DeleteArcResponse> createDeleteArcResponse(DeleteArcResponse value) {
        return new JAXBElement<DeleteArcResponse>(_DeleteArcResponse_QNAME, DeleteArcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNodeByLabelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteNodeByLabelResponse")
    public JAXBElement<DeleteNodeByLabelResponse> createDeleteNodeByLabelResponse(DeleteNodeByLabelResponse value) {
        return new JAXBElement<DeleteNodeByLabelResponse>(_DeleteNodeByLabelResponse_QNAME, DeleteNodeByLabelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteNodeResponse")
    public JAXBElement<DeleteNodeResponse> createDeleteNodeResponse(DeleteNodeResponse value) {
        return new JAXBElement<DeleteNodeResponse>(_DeleteNodeResponse_QNAME, DeleteNodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEdge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addEdge")
    public JAXBElement<AddEdge> createAddEdge(AddEdge value) {
        return new JAXBElement<AddEdge>(_AddEdge_QNAME, AddEdge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEdgeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addEdgeResponse")
    public JAXBElement<AddEdgeResponse> createAddEdgeResponse(AddEdgeResponse value) {
        return new JAXBElement<AddEdgeResponse>(_AddEdgeResponse_QNAME, AddEdgeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addNode")
    public JAXBElement<AddNode> createAddNode(AddNode value) {
        return new JAXBElement<AddNode>(_AddNode_QNAME, AddNode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addNodeResponse")
    public JAXBElement<AddNodeResponse> createAddNodeResponse(AddNodeResponse value) {
        return new JAXBElement<AddNodeResponse>(_AddNodeResponse_QNAME, AddNodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArcByLabelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteArcByLabelResponse")
    public JAXBElement<DeleteArcByLabelResponse> createDeleteArcByLabelResponse(DeleteArcByLabelResponse value) {
        return new JAXBElement<DeleteArcByLabelResponse>(_DeleteArcByLabelResponse_QNAME, DeleteArcByLabelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGraph }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteGraph")
    public JAXBElement<DeleteGraph> createDeleteGraph(DeleteGraph value) {
        return new JAXBElement<DeleteGraph>(_DeleteGraph_QNAME, DeleteGraph.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteArc")
    public JAXBElement<DeleteArc> createDeleteArc(DeleteArc value) {
        return new JAXBElement<DeleteArc>(_DeleteArc_QNAME, DeleteArc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEdgeByLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "addEdgeByLabel")
    public JAXBElement<AddEdgeByLabel> createAddEdgeByLabel(AddEdgeByLabel value) {
        return new JAXBElement<AddEdgeByLabel>(_AddEdgeByLabel_QNAME, AddEdgeByLabel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEdgeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteEdgeResponse")
    public JAXBElement<DeleteEdgeResponse> createDeleteEdgeResponse(DeleteEdgeResponse value) {
        return new JAXBElement<DeleteEdgeResponse>(_DeleteEdgeResponse_QNAME, DeleteEdgeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGraphResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "createGraphResponse")
    public JAXBElement<CreateGraphResponse> createCreateGraphResponse(CreateGraphResponse value) {
        return new JAXBElement<CreateGraphResponse>(_CreateGraphResponse_QNAME, CreateGraphResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGraphResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getGraphResponse")
    public JAXBElement<GetGraphResponse> createGetGraphResponse(GetGraphResponse value) {
        return new JAXBElement<GetGraphResponse>(_GetGraphResponse_QNAME, GetGraphResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGraph }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "createGraph")
    public JAXBElement<CreateGraph> createCreateGraph(CreateGraph value) {
        return new JAXBElement<CreateGraph>(_CreateGraph_QNAME, CreateGraph.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGraphResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteGraphResponse")
    public JAXBElement<DeleteGraphResponse> createDeleteGraphResponse(DeleteGraphResponse value) {
        return new JAXBElement<DeleteGraphResponse>(_DeleteGraphResponse_QNAME, DeleteGraphResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEdgeByLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "deleteEdgeByLabel")
    public JAXBElement<DeleteEdgeByLabel> createDeleteEdgeByLabel(DeleteEdgeByLabel value) {
        return new JAXBElement<DeleteEdgeByLabel>(_DeleteEdgeByLabel_QNAME, DeleteEdgeByLabel.class, null, value);
    }

}
