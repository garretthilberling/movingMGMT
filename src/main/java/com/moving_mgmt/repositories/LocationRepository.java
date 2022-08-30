package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Apartment;
import com.moving_mgmt.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Modifying
    @Query(value="select * from Location where apartmentId = ?1", nativeQuery = true)
    Location findLocationByApartmentId(Integer id) throws Exception;

    Location findLocationByLocationId(Integer id);
}
