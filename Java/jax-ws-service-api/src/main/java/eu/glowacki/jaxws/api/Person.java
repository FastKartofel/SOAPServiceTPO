package eu.glowacki.jaxws.api;
import java.util.Date;

public class Person {
    private String firstName;
    private String surname;
    private Date birthDate;

    public Person(String firstName, String surname, Date birthDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.birthDate = birthDate;
    }
    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + getFirstName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}