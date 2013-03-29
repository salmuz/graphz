
package org.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.soap.client package. 
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

    private final static QName _RegisterResponse_QNAME = new QName("http://soap/", "registerResponse");
    private final static QName _Register_QNAME = new QName("http://soap/", "register");
    private final static QName _Connection_QNAME = new QName("http://soap/", "connection");
    private final static QName _ConnectionResponse_QNAME = new QName("http://soap/", "connectionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Connection }
     * 
     */
    public Connection createConnection() {
        return new Connection();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link ConnectionResponse }
     * 
     */
    public ConnectionResponse createConnectionResponse() {
        return new ConnectionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Connection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "connection")
    public JAXBElement<Connection> createConnection(Connection value) {
        return new JAXBElement<Connection>(_Connection_QNAME, Connection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "connectionResponse")
    public JAXBElement<ConnectionResponse> createConnectionResponse(ConnectionResponse value) {
        return new JAXBElement<ConnectionResponse>(_ConnectionResponse_QNAME, ConnectionResponse.class, null, value);
    }

}
