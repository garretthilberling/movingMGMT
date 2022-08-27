package src.main.java.com.moving_mgmt.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "amenities")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer squareFootage;
    private Integer apartmentId;

    public Rooms(Integer id, Integer bedrooms, Integer bathrooms, Integer squareFootage, Integer apartmentId) {
        this.id = id;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.squareFootage = squareFootage;
        this.apartmentId = apartmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Integer squareFootage) {
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
        return Objects.equals(getId(), rooms.getId()) && Objects.equals(getBedrooms(), rooms.getBedrooms()) && Objects.equals(getBathrooms(), rooms.getBathrooms()) && Objects.equals(getSquareFootage(), rooms.getSquareFootage()) && Objects.equals(getApartmentId(), rooms.getApartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBedrooms(), getBathrooms(), getSquareFootage(), getApartmentId());
    }
}