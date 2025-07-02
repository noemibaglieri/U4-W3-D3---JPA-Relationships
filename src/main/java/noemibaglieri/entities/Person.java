package noemibaglieri.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private UUID personID;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private char sex;

    @OneToMany(mappedBy = "participationId")
    private List<Participation> listOfParticipations;

    public Person() {}

    public Person(String name, String lastName, String email, LocalDate dateOfBirth, char sex) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public UUID getPersonID() {
        return personID;
    }

    public char getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Participation> getListOfParticipations() {
        return listOfParticipations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex=" + sex +
                '}';
    }
}
