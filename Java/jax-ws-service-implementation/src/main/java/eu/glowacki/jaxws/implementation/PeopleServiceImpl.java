package eu.glowacki.jaxws.implementation;

import eu.glowacki.jaxws.api.IPeopleService;
import eu.glowacki.jaxws.api.Person;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebService(name = "IPeopleService",
        targetNamespace = "http://glowacki.eu.jaxws.implementation",
        serviceName="PeopleService")
/*
 we are using 'serviceName' to connect with the client(MainNoProxyPeople) or (MainNoProxyPeopleTest)
 the change is also visible in the wsdl
 * */

public class PeopleServiceImpl implements IPeopleService {

    private static Map<String, List<Person>> personMap = new HashMap<>();

    private static final Logger LOGGER = Logger.getLogger(PeopleServiceImpl.class.getName());

    static {
        addPersonToMap(new Person("Patryk", "Zaluska", new Date(90, Calendar.JANUARY, 1)));
        addPersonToMap(new Person("Jane", "Zelenska", new Date(95, 4, 15)));
        addPersonToMap(new Person("Helena", "Boguslawska", new Date(85, 7, 20)));
        addPersonToMap(new Person("Sarah", "Johnson", new Date(88, 11, 5)));
    }

    public static void main(String... args) {
        Endpoint.publish(IPeopleService.URI, new PeopleServiceImpl());
        LOGGER.info("Server started!");
    }

    private static void addPersonToMap(Person person) {
        personMap.computeIfAbsent(person.getSurname().toLowerCase(), k -> new ArrayList<>()).add(person);
    }

    @Override
    public void addPerson(String firstName, String surname, Date birthDate) {
        Person newPerson = new Person(firstName, surname, birthDate);
        addPersonToMap(newPerson);
        LOGGER.info("Added person: " + newPerson);
    }

    @Override
    public List<Person> getPersonsBySurname(String surname) {
        return personMap.getOrDefault(surname.toLowerCase(), Collections.emptyList());
    }

    @Override
    public List<Person> getPersonsByBirthDate(Date birthDate) {
        return personMap.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.getBirthDate() != null && p.getBirthDate().equals(birthDate))
                .collect(Collectors.toList());
    }
}