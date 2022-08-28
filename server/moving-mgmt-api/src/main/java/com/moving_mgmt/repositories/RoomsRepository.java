package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    Rooms findRoomsByApartmentId(Integer id) throws Exception;
}