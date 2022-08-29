package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {
    Amenities findAmenitiesByApartmentId(Integer id) throws Exception;
}