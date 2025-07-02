package noemibaglieri.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import noemibaglieri.entities.Location;
import noemibaglieri.exceptions.NotFoundException;

public class LocationsDAO {

        private EntityManager entityManager;

        public LocationsDAO(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        public void save(Location newLocation) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newLocation);
            transaction.commit();

            System.out.println("Location " + newLocation.getName() + " successfully added to the database.");
        }

        public Location findById(long locationId) {
            Location found = entityManager.find(Location.class, locationId);
            if (found == null) throw new NotFoundException(locationId);
            return found;
        }

        public void deleteById(long locationId) {
            Location found = this.findById(locationId);
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(found);
            transaction.commit();

            System.out.println("Location " + found.getName() + " successfully deleted from the database.");
        }

}
