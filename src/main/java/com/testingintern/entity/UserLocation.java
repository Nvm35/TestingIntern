package com.testingintern.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_locations")
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private String accessLevel;

    public UserLocation() {
    }

    public UserLocation(Person person, Location location, String accessLevel) {
        this.person = person;
        this.location = location;
        this.accessLevel = accessLevel;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}
