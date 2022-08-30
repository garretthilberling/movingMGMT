package com.moving_mgmt.controller;
import com.moving_mgmt.model.Amenities;
import com.moving_mgmt.repositories.AmenitiesRepository;
import com.moving_mgmt.utils.JwtAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AmenitiesController {
    @Autowired
    AmenitiesRepository repository;

    // get an apartment's amenities
    @GetMapping("/api/apartments/{id}/amenities")
    public Amenities findAmenitiesByApartmentId(@PathVariable Integer id) throws Exception {
        return (Amenities) repository.findAmenitiesByApartmentId(id);
    }
    // get amenities by id
    @GetMapping("/api/amenities/{id}")
    public Amenities findAmenitiesById(@PathVariable Integer id) throws Exception {
        return (Amenities) repository.findAmenitiesByAmenitiesId(id);
    }
    // add amenities
    @PostMapping("/api/amenities")
    public Amenities addAmenities(@RequestBody Amenities amenities, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.save(amenities);
            return amenities;
        }
        throw new IllegalAccessException("invalid token");
    }
    // update amenities
    @PutMapping("/api/amenities/{id}")
    public Amenities updateAmenities(@PathVariable Integer id, @RequestBody Amenities amenities, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            Amenities tempAmenities = repository.findAmenitiesByAmenitiesId(id);

            if(!tempAmenities.equals(null)) {
                amenities.setAmenitiesId(tempAmenities.getAmenitiesId());
                repository.save(amenities);
            }
            return amenities;
        }
        throw new IllegalAccessException("invalid token");
    }
    // remove an amenities
    @DeleteMapping("/api/amenities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteAmenities(@PathVariable Integer id, HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.deleteById(id);
        }
    }

}
