package noemibaglieri.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participations")
public class Participation {
    @Id
    @GeneratedValue
    @Column(name = "participation_id")
    private UUID participationId;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Event event;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    public Participation() {}

    public Participation(Person person, Event event, StatusType status) {
        this.person = person;
        this.event = event;
        this.status = status;
    }

    public UUID getParticipationId() {
        return participationId;
    }

    public Person getPerson() {
        return person;
    }

    public Event getEvent() {
        return event;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "participationId=" + participationId +
                ", person=" + person +
                ", event=" + event +
                ", status=" + status +
                '}';
    }
}
