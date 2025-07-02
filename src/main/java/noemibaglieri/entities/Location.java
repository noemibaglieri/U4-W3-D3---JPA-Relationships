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

    @OneToMany(mappedBy = "location")
    private List<Event> events;

    public Location() {}

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public List<Event> getEvents() {
        return events;
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


}
