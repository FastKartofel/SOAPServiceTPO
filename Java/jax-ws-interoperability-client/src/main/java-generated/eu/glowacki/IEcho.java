package eu.glowacki;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.2
 * 2023-05-19T18:34:45.683+02:00
 * Generated source version: 3.5.2
 *
 */
@WebService(targetNamespace = "http://glowacki.eu", name = "IEcho")
@XmlSeeAlso({com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, org.datacontract.schemas._2004._07.glowacki_soap.ObjectFactory.class, ObjectFactory.class})
public interface IEcho {

    @WebMethod(operationName = "Echo", action = "http://glowacki.eu/IEcho/Echo")
    @Action(input = "http://glowacki.eu/IEcho/Echo", output = "http://glowacki.eu/IEcho/EchoResponse")
    @RequestWrapper(localName = "Echo", targetNamespace = "http://glowacki.eu", className = "eu.glowacki.Echo")
    @ResponseWrapper(localName = "EchoResponse", targetNamespace = "http://glowacki.eu", className = "eu.glowacki.EchoResponse")
    @WebResult(name = "EchoResult", targetNamespace = "http://glowacki.eu")
    public org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse echo(

        @WebParam(name = "request", targetNamespace = "http://glowacki.eu")
        org.datacontract.schemas._2004._07.glowacki_soap.EchoRequest request
    );
}