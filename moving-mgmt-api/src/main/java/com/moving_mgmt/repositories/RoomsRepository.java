package com.moving_mgmt.repositories;
import com.moving_mgmt.model.Location;
import com.moving_mgmt.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    @Modifying
    @Query(value="select * from Rooms where apartmentId = ?1", nativeQuery = true)
    Rooms findRoomsByApartmentId(Integer id) throws Exception;

    Rooms findRoomsById(Integer id);
}