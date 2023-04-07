package com.testingintern.controller;

import com.testingintern.entity.Location;
import com.testingintern.entity.Person;
import com.testingintern.entity.UserLocation;
import com.testingintern.repos.LocationRepository;
import com.testingintern.repos.PersonRepository;
import com.testingintern.repos.UserLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private UserLocationRepository userLocationRepository;


    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody Person person) {
        Person newPerson = personRepository.save(person);
        return ResponseEntity.ok(newPerson);
    }

    @PostMapping("/locations")
    public ResponseEntity<?> createLocation(@RequestBody Location location) {
        Location newLocation = locationRepository.save(location);
        return ResponseEntity.ok(newLocation);
    }

    @PostMapping("/locations/{locationId}/users")
    public ResponseEntity<?> shareLocation(@PathVariable Long locationId, @RequestBody UserLocation userLocation) {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new ResourceNotFoundException("Location not found, check pls"));
        Person person = personRepository.findByEmail(userLocation.getPerson().getEmail()).orElseThrow(() -> new ResourceNotFoundException("Person not found, check numbers"));
        userLocation.setLocation(location);
        userLocation.setPerson(person);
        UserLocation newUserLocation = userLocationRepository.save(userLocation);
        return ResponseEntity.ok(newUserLocation);
    }

    @GetMapping("/locations/{locationId}/users/")
    public ResponseEntity<?> getUsersFromLocation(@PathVariable Long locationId) {
        List<UserLocation> userLocations = userLocationRepository.findUserLocationBy(locationId);
        List<Person> users = new ArrayList<>();
        userLocations.forEach(
                userLocation -> users.add(userLocation.getPerson())
        );
        return ResponseEntity.ok(users);
    }

    @PutMapping("/locations/{locationId}/users/{userId}")
    public ResponseEntity<?> updateAccessLevel(@PathVariable Long locationId, @PathVariable Long userId, @RequestBody UserLocation userLocation) {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new ResourceNotFoundException("Location is not in this castle, bro"));
        Person person = personRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Person maybe is dead, try another"));
        UserLocation currentUserLocation = userLocationRepository.findByPersonAndLocation(locationId, userId).orElseThrow(() -> new ResourceNotFoundException("No Location+Person"));
        currentUserLocation.setAccessLevel(userLocation.getAccessLevel());
        UserLocation updatedUserLocation = userLocationRepository.save(currentUserLocation);
        return ResponseEntity.ok(updatedUserLocation);
    }

    @GetMapping("/users/{userId}/locations")
    public ResponseEntity<?> getLocationsForUser(@PathVariable Long userId) {
        List<UserLocation> userLocations = userLocationRepository.findByPersonId(userId);
        List<Location> locations = new ArrayList<>();
        userLocations.forEach(
                userLocation -> locations.add(userLocation.getLocation())
        );
        return ResponseEntity.ok(locations);
    }
}
