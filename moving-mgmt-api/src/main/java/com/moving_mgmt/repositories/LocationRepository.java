package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findLocationByApartmentId(Integer id) throws Exception;
}
