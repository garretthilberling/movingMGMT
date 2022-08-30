package com.moving_mgmt.controller;
import com.moving_mgmt.model.Location;
import com.moving_mgmt.repositories.LocationRepository;
import com.moving_mgmt.utils.JwtAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LocationController {
    @Autowired
    LocationRepository repository;

    // get an apartment's location
    @GetMapping("/api/apartments/{id}/location")
    public Location findLocationByApartmentId(@PathVariable Integer id) throws Exception {
        return (Location) repository.findLocationByApartmentId(id);
    }
    // get location by id
    @GetMapping("/api/location/{id}")
    public Location findLocationById(@PathVariable Integer id) throws Exception {
        return (Location) repository.findLocationByLocationId(id);
    }
    // add location
    @PostMapping("/api/location")
    public Location addLocation(@RequestBody Location location, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.save(location);
            return location;
        }
        throw new IllegalAccessException("invalid token");
    }
    // update location
    @PutMapping("/api/location/{id}")
    public Location updateLocation(@PathVariable Integer id, @RequestBody Location location, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            Location tempLocation = repository.findLocationByLocationId(id);

            if(!tempLocation.equals(null)) {
                location.setLocationId(tempLocation.getLocationId());
                repository.save(location);
            }
            return location;
        }
        throw new IllegalAccessException("invalid token");
    }
    // delete location
    @DeleteMapping("/api/location/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteLocation(@PathVariable Integer id, @RequestBody Location location, HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.deleteById(id);
        }
    }
}
