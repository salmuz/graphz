
package org.soap.graph;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GraphsSOAP", targetNamespace = "http://soap/", wsdlLocation = "http://localhost:8080/Server/GraphsSOAP?wsdl")
public class GraphsSOAP_Service
    extends Service
{

    private final static URL GRAPHSSOAP_WSDL_LOCATION;
    private final static WebServiceException GRAPHSSOAP_EXCEPTION;
    private final static QName GRAPHSSOAP_QNAME = new QName("http://soap/", "GraphsSOAP");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Server/GraphsSOAP?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GRAPHSSOAP_WSDL_LOCATION = url;
        GRAPHSSOAP_EXCEPTION = e;
    }

    public GraphsSOAP_Service() {
        super(__getWsdlLocation(), GRAPHSSOAP_QNAME);
    }

    public GraphsSOAP_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GRAPHSSOAP_QNAME, features);
    }

    public GraphsSOAP_Service(URL wsdlLocation) {
        super(wsdlLocation, GRAPHSSOAP_QNAME);
    }

    public GraphsSOAP_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GRAPHSSOAP_QNAME, features);
    }

    public GraphsSOAP_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GraphsSOAP_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GraphsSOAP
     */
    @WebEndpoint(name = "GraphsSOAPPort")
    public GraphsSOAP getGraphsSOAPPort() {
        return super.getPort(new QName("http://soap/", "GraphsSOAPPort"), GraphsSOAP.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GraphsSOAP
     */
    @WebEndpoint(name = "GraphsSOAPPort")
    public GraphsSOAP getGraphsSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap/", "GraphsSOAPPort"), GraphsSOAP.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GRAPHSSOAP_EXCEPTION!= null) {
            throw GRAPHSSOAP_EXCEPTION;
        }
        return GRAPHSSOAP_WSDL_LOCATION;
    }

}
