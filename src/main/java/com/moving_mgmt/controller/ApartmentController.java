package com.moving_mgmt.controller;
import com.moving_mgmt.model.Amenities;
import com.moving_mgmt.model.Apartment;
import com.moving_mgmt.model.Location;
import com.moving_mgmt.model.Rooms;
import com.moving_mgmt.repositories.AmenitiesRepository;
import com.moving_mgmt.repositories.ApartmentRepository;
import com.moving_mgmt.repositories.LocationRepository;
import com.moving_mgmt.repositories.RoomsRepository;
import com.moving_mgmt.utils.JwtAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ApartmentController {
    @Autowired
    ApartmentRepository repository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    AmenitiesRepository amenitiesRepository;
    @Autowired
    RoomsRepository roomsRepository;

    // get a user's saved apartments
    @GetMapping("/api/{username}/apartments")
    public List<Apartment> findAllByUserName(@PathVariable String username) throws Exception {
        return (List<Apartment>) repository.findAllByUsername(username);
    }

    // get a single apartment by id
    @GetMapping("/api/apartments/{id}")
    public Apartment findById(@PathVariable Integer id) throws Exception {
        return (Apartment) repository.findApartmentById(id);
    }

    // add an apartment
    @PostMapping("/api/apartments")
    public Apartment addApartment(@RequestBody Apartment apartment, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.save(apartment);
            return apartment;
        }
        throw new IllegalAccessException("invalid token");
    }

    // update an apartment
    @PutMapping("/api/apartments/{id}")
    public Apartment updateApartment(@PathVariable Integer id, @RequestBody Apartment apartment, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            Apartment tempApartment = repository.findApartmentById(id);

            if(!tempApartment.equals(null)) {
                apartment.setId(tempApartment.getId());
                repository.save(apartment);
            }
            return apartment;
        }
        throw new IllegalAccessException("invalid token");
    }

    // remove an apartment
    @DeleteMapping("/api/apartments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteApartment(@PathVariable Integer id, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.deleteById(id);
        }
        throw new IllegalAccessException("invalid token");
    }
}
