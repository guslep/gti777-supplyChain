
package warehouse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the warehouse package. 
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

    private final static QName _ExpedierProduits_QNAME = new QName("http://warehouse/", "expedierProduits");
    private final static QName _Hello_QNAME = new QName("http://warehouse/", "hello");
    private final static QName _ExpedierProduitsResponse_QNAME = new QName("http://warehouse/", "expedierProduitsResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://warehouse/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: warehouse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link ExpedierProduitsResponse }
     * 
     */
    public ExpedierProduitsResponse createExpedierProduitsResponse() {
        return new ExpedierProduitsResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link ExpedierProduits }
     * 
     */
    public ExpedierProduits createExpedierProduits() {
        return new ExpedierProduits();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExpedierProduits }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse/", name = "expedierProduits")
    public JAXBElement<ExpedierProduits> createExpedierProduits(ExpedierProduits value) {
        return new JAXBElement<ExpedierProduits>(_ExpedierProduits_QNAME, ExpedierProduits.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExpedierProduitsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse/", name = "expedierProduitsResponse")
    public JAXBElement<ExpedierProduitsResponse> createExpedierProduitsResponse(ExpedierProduitsResponse value) {
        return new JAXBElement<ExpedierProduitsResponse>(_ExpedierProduitsResponse_QNAME, ExpedierProduitsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
