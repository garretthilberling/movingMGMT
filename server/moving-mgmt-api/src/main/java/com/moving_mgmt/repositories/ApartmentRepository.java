package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    List<Apartment> findAllApartmentsByUserId(Integer id) throws Exception;
}