package eu.glowacki.jaxws.client.sample;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.IPeopleService;
import eu.glowacki.jaxws.api.Person;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public final class MainNoProxyPeople {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    public static void main(String... args) throws MalformedURLException {
        URL wsdl = new URL(IPeopleService.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu.jaxws.implementation", "PeopleService");
        Service service = Service.create(wsdl, qname);
        IPeopleService proxy = service.getPort(IPeopleService.class);


        Person john = new Person("John", "Doe", new Date(90, Calendar.JANUARY, 1)); // Jan 1, 1990
        proxy.addPerson(john.getFirstName(), john.getSurname(), john.getBirthDate());
        LOGGER.info("Added person: " + john);


        proxy.getPersonsBySurname("Zaluska").forEach(person -> LOGGER.info("Retrieved person: " + person));


        Date sampleDate = new Date(95, Calendar.APRIL, 14);
        proxy.getPersonsByBirthDate(sampleDate).forEach(person -> LOGGER.info("Retrieved person: " + person));
    }
}
