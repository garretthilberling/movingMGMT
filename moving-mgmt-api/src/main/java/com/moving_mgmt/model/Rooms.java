package com.moving_mgmt.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rooms_id")
    private Integer roomsId;
    private Integer bedrooms;
    private Integer bathrooms;
    private Long squareFootage;
    private Integer apartmentId;

    public Rooms() {
    }

    public Rooms(Integer roomsId, Integer bedrooms, Integer bathrooms, Long squareFootage, Integer apartmentId) {
        this.roomsId = roomsId;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.squareFootage = squareFootage;
        this.apartmentId = apartmentId;
    }

    public Integer getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(Integer roomsId) {
        this.roomsId = roomsId;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Long getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Long squareFootage) {
        this.squareFootage = squareFootage;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rooms rooms = (Rooms) o;
        return Objects.equals(getRoomsId(), rooms.getRoomsId()) && Objects.equals(getBedrooms(), rooms.getBedrooms()) && Objects.equals(getBathrooms(), rooms.getBathrooms()) && Objects.equals(getSquareFootage(), rooms.getSquareFootage()) && Objects.equals(getApartmentId(), rooms.getApartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomsId(), getBedrooms(), getBathrooms(), getSquareFootage(), getApartmentId());
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomsId=" + roomsId +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", squareFootage=" + squareFootage +
                ", apartmentId=" + apartmentId +
                '}';
    }
}