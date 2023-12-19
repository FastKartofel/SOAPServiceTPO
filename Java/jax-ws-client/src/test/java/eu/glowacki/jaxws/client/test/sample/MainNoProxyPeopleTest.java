package eu.glowacki.jaxws.client.test.sample;

import eu.glowacki.jaxws.api.IPeopleService;
import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.Person;
import jakarta.xml.ws.Service;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class MainNoProxyPeopleTest {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private IPeopleService _proxy;


    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }


    @Before
    public void before() throws MalformedURLException {
        URL wsdl = new URL(eu.glowacki.jaxws.api.IPeopleService.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu.jaxws.implementation", "PeopleService");
        Service service = Service.create(wsdl, qname);
        _proxy = service.getPort(IPeopleService.class);
    }

    @Test
    public void testAddPerson() {
        Person john = new Person("John", "Doe", new Date(90, Calendar.JANUARY, 1));
        _proxy.addPerson(john.getFirstName(), john.getSurname(), john.getBirthDate());
        LOGGER.info("Added person: " + john);
    }

    @Test
    public void testGetPersonsBySurname() {
        _proxy.getPersonsBySurname("Zaluska").forEach(person -> LOGGER.info("Retrieved person: " + person));
    }

    @Test
    public void testGetPersonsByBirthDate() {
        Date sampleDate = new Date(90, Calendar.JANUARY, 1);
        _proxy.getPersonsByBirthDate(sampleDate).forEach(person -> LOGGER.info("Retrieved person: " + person));
    }

}






