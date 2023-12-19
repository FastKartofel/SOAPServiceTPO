package eu.glowacki.jaxws.api;

import eu.glowacki.jaxws.api.Person;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(name = "IPeopleService", targetNamespace = "http://glowacki.eu.jaxws.implementation")
public interface IPeopleService {

    public static final String URI ="http://localhost:8080/people";


    @WebMethod(action = "http://glowacki.eu.jaxws.implementation/addPerson")
    void addPerson(String firstName, String surname, Date birthDate);
    /*
    I created this method just for myself to add a Person, to see if I can find them using other methods.
    * */

    @WebMethod(action = "http://glowacki.eu.jaxws.implementation/getPersonsBySurname")
    List<Person> getPersonsBySurname(String surname);

    @WebMethod(action = "http://glowacki.eu.jaxws.implementation/getPersonsByBirthDate")
    List<Person> getPersonsByBirthDate(Date birthDate);
}
