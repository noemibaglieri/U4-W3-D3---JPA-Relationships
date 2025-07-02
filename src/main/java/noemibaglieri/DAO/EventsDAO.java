package noemibaglieri.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import noemibaglieri.entities.Event;
import noemibaglieri.exceptions.NotFoundException;

public class EventsDAO {
    private EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvent);
        transaction.commit();

        System.out.println("Event " + newEvent.getTitle() + " successfully added to the database.");
    }

    public Event findById(long eventId) {
        Event found = entityManager.find(Event.class, eventId);
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }

    public void deleteById(long eventId) {
        Event found = this.findById(eventId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Event " + found.getTitle() + " successfully deleted from the database.");
    }
}
