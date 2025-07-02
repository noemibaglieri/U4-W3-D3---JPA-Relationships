package noemibaglieri.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID id;

    @Column(name = "location_name")
    private String name;

    @Column(name = "location_city")
    private String city;

    @OneToOne(mappedBy = "location")
    private Event event;

    public Location() {}

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Event getEvent() {
        return event;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", events=" + event +
                '}';
    }
}
