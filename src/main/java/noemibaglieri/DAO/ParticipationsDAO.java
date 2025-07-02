package noemibaglieri.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import noemibaglieri.entities.Participation;
import noemibaglieri.exceptions.NotFoundException;

public class ParticipationsDAO {

    private EntityManager entityManager;

    public ParticipationsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Participation newParticipation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newParticipation);
        transaction.commit();

        System.out.println("Participation of " + newParticipation.getPerson() + " successfully added to the database.");
    }

    public Participation findById(long participationId) {
        Participation found = entityManager.find(Participation.class, participationId);
        if (found == null) throw new NotFoundException(participationId);
        return found;
    }

    public void deleteById(long participationId) {
        Participation found = this.findById(participationId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Participation of " + found.getPerson() + " successfully deleted from the database.");
    }

}
