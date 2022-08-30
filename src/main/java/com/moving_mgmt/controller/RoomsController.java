package com.moving_mgmt.controller;
import com.moving_mgmt.repositories.RoomsRepository;
import com.moving_mgmt.model.Rooms;
import com.moving_mgmt.utils.JwtAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RoomsController {
    @Autowired
    RoomsRepository repository;

    // get an apartment's rooms info
    @GetMapping("/api/apartments/{id}/rooms")
    public Rooms findRoomsByApartmentId(@PathVariable Integer id) throws Exception {
        return (Rooms) repository.findRoomsByApartmentId(id);
    }
    // get rooms by id
    @GetMapping("/api/rooms/{id}")
    public Rooms findRoomsById(@PathVariable Integer id) throws Exception {
        return (Rooms) repository.findRoomsByRoomsId(id);
    }
    // add rooms
    @PostMapping("/api/rooms")
    public Rooms addRooms(@RequestBody Rooms rooms, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.save(rooms);
            return rooms;
        }
        throw new IllegalAccessException("invalid token");
    }
    // update rooms
    @PutMapping("/api/rooms/{id}")
    public Rooms updateRooms(@PathVariable Integer id, @RequestBody Rooms rooms, HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            Rooms tempRooms = repository.findRoomsByRoomsId(id);

            if(!tempRooms.equals(null)) {
                rooms.setRoomsId(tempRooms.getRoomsId());
                repository.save(rooms);
            }
            return rooms;
        }
        throw new IllegalAccessException("invalid token");
    }
    // delete rooms
    @DeleteMapping("/api/rooms/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteRooms(@PathVariable Integer id, HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.deleteById(id);
        }
    }
}
