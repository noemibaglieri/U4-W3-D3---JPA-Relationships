package noemibaglieri;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import noemibaglieri.DAO.EventsDAO;
import noemibaglieri.entities.Event;
import noemibaglieri.entities.EventType;

import java.time.LocalDate;

public class EventManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3D3REL");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO ed = new EventsDAO(em);

        Event bookConference = new Event(
                "Let's talk about George R. R. Martin new upcoming book",
                LocalDate.of(2025, 9, 16), "This is a restricted event. Need to sort out publication date",
                EventType.PRIVATE,
                8);

        Event sansaWedding = new Event(
                "Sansa Stark from Winterfell is marrying Ramsey Bolton",
                LocalDate.of(2025, 8, 23),
                "Long live Lord Ramsey! Protector of the North!",
                EventType.PUBLIC, 200);

        Event dragonHatchingFestival = new Event(
                "Festival of the Hatching - Daenerys' Dragons",
                LocalDate.of(2025, 12, 3),
                "Celebrate the miracle of fire and blood. No real dragons, we promise.",
                EventType.PUBLIC,
                500);

        Event smallCouncilMeeting = new Event(
                "Small Council Closed Meeting",
                LocalDate.of(2025, 7, 10),
                "Matters of the Realm. Strictly confidential.",
                EventType.PRIVATE,
                10);

        /*
        ed.save(bookConference);
        ed.save(sansaWedding);
        ed.save(dragonHatchingFestival);
        ed.save(smallCouncilMeeting);
         */

        em.close();
        emf.close();
    }
}
