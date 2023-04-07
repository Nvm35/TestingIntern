package com.testingintern.repos;

import com.testingintern.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {

    List<UserLocation> findUserLocationBy(Long locationId);

    Optional<UserLocation> findByPersonAndLocation(Long locationId, Long userId);

    List<UserLocation> findByPersonId(Long userId);
}
