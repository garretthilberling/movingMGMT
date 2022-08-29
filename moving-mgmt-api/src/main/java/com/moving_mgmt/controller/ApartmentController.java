package com.moving_mgmt.controller;
import com.moving_mgmt.model.Apartment;
import com.moving_mgmt.repositories.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApartmentController {
    @Autowired
    ApartmentRepository repository;

    // get a user's saved apartments
    @GetMapping("/api/{username}/apartments")
    public Apartment findAllByUserName(@PathVariable String username) throws Exception {
        return (Apartment) repository.findAllByUsername(username);
    }

    // get a single apartment by id
    @GetMapping("/api/apartments/{id}")
    public Apartment findById(@PathVariable Integer id) throws Exception {
        return (Apartment) repository.findApartmentById(id);
    }

    // add an apartment
    @PostMapping("/api/apartments")
    public Apartment addApartment(@RequestBody Apartment apartment) {
        repository.save(apartment);
        return apartment;
    }

    // update an apartment
    @PutMapping("/api/apartments/{id}")
    public Apartment updateApartment(@PathVariable Integer id, @RequestBody Apartment apartment) throws Exception {
        Apartment tempApartment = repository.findApartmentById(id);

        if(!tempApartment.equals(null)) {
            apartment.setId(tempApartment.getId());
            repository.save(apartment);
        }
        return apartment;
    }

    // remove an apartment
    @DeleteMapping("/api/apartments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteApartment(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
