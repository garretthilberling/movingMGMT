package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {
    @Modifying
    @Query(value="select * from Amenities where apartmentId = ?1", nativeQuery = true)
    Amenities findAmenitiesByApartmentId(Integer id) throws Exception;

    Amenities findAmenitiesById(Integer id);
}