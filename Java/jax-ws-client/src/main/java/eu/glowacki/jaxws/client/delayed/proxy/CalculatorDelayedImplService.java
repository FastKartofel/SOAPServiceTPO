
package eu.glowacki.jaxws.client.delayed.proxy;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CalculatorDelayedImplService", targetNamespace = "http://glowacki.eu/delayed", wsdlLocation = "http://localhost:8080/delayed?wsdl")
public class CalculatorDelayedImplService
    extends Service
{

    private final static URL CALCULATORDELAYEDIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CALCULATORDELAYEDIMPLSERVICE_EXCEPTION;
    private final static QName CALCULATORDELAYEDIMPLSERVICE_QNAME = new QName("http://glowacki.eu/delayed", "CalculatorDelayedImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/delayed?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCULATORDELAYEDIMPLSERVICE_WSDL_LOCATION = url;
        CALCULATORDELAYEDIMPLSERVICE_EXCEPTION = e;
    }

    public CalculatorDelayedImplService() {
        super(__getWsdlLocation(), CALCULATORDELAYEDIMPLSERVICE_QNAME);
    }

    public CalculatorDelayedImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALCULATORDELAYEDIMPLSERVICE_QNAME, features);
    }

    public CalculatorDelayedImplService(URL wsdlLocation) {
        super(wsdlLocation, CALCULATORDELAYEDIMPLSERVICE_QNAME);
    }

    public CalculatorDelayedImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCULATORDELAYEDIMPLSERVICE_QNAME, features);
    }

    public CalculatorDelayedImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorDelayedImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ICalculatorDelayed
     */
    @WebEndpoint(name = "ICalculatorDelayedPort")
    public ICalculatorDelayed getICalculatorDelayedPort() {
        return super.getPort(new QName("http://glowacki.eu/delayed", "ICalculatorDelayedPort"), ICalculatorDelayed.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns ICalculatorDelayed
     */
    @WebEndpoint(name = "ICalculatorDelayedPort")
    public ICalculatorDelayed getICalculatorDelayedPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://glowacki.eu/delayed", "ICalculatorDelayedPort"), ICalculatorDelayed.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALCULATORDELAYEDIMPLSERVICE_EXCEPTION!= null) {
            throw CALCULATORDELAYEDIMPLSERVICE_EXCEPTION;
        }
        return CALCULATORDELAYEDIMPLSERVICE_WSDL_LOCATION;
    }

}
