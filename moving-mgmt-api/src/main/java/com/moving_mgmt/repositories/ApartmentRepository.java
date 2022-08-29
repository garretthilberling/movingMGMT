package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    @Modifying
    @Query(value="select * from Apartment where userId = (select id from User u where u.username = ?1)", nativeQuery = true)
    List<Apartment> findAllByUsername(String username) throws Exception;

    Apartment findApartmentById(Integer id);
}