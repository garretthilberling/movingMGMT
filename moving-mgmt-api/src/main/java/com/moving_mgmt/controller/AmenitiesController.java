package com.moving_mgmt.controller;
import com.moving_mgmt.model.Amenities;
import com.moving_mgmt.repositories.AmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
        return (Amenities) repository.findAmenitiesById(id);
    }
    // add amenities
    @PostMapping("/api/amenities")
    public Amenities addAmenities(@PathVariable Amenities amenities) {
        repository.save(amenities);
        return amenities;
    }
    // update amenities
    @PutMapping("/api/amenities/{id}")
    public Amenities updateAmenities(@PathVariable Integer id, @RequestBody Amenities amenities) throws Exception {
        Amenities tempAmenities = repository.findAmenitiesById(id);

        if(!tempAmenities.equals(null)) {
            amenities.setId(tempAmenities.getId());
            repository.save(amenities);
        }
        return amenities;
    }
    // remove an amenities
    @DeleteMapping("/api/amenities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteAmenities(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
