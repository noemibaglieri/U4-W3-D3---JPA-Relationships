package noemibaglieri.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import noemibaglieri.entities.Person;
import noemibaglieri.exceptions.NotFoundException;

public class PeopleDAO {

    private EntityManager entityManager;

    public PeopleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person newPerson) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPerson);
        transaction.commit();

        System.out.println("New person " + newPerson.getName() + " was successfully added to the database.");
    }

    public Person findById(long personId) {
        Person found = entityManager.find(Person.class, personId);
        if (found == null) throw new NotFoundException(personId);
        return found;
    }

    public void deleteById(long personId) {
        Person found = this.findById(personId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("The person " + found.getName() + " was successfully deleted from the database.");
    }

}