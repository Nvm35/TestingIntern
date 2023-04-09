package com.testingintern.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Location(String locationName, String address) {
        this.locationName = locationName;
        this.address = address;
    }

    public Location() {
    }

    @NotNull
    private String locationName;
    @NotNull
    private String address;

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
