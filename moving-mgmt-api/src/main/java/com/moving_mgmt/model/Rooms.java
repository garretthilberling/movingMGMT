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
    private Integer id;
    private Integer bedrooms;
    private Integer bathrooms;
    private Long squareFootage;
    @OneToOne(mappedBy = "rooms")
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;

    public Rooms() {
    }

    public Rooms(Integer id, Integer bedrooms, Integer bathrooms, Long squareFootage) {
        this.id = id;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.squareFootage = squareFootage;
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

    public Long getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Long squareFootage) {
        this.squareFootage = squareFootage;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rooms rooms = (Rooms) o;
        return Objects.equals(getId(), rooms.getId()) && Objects.equals(getBedrooms(), rooms.getBedrooms()) && Objects.equals(getBathrooms(), rooms.getBathrooms()) && Objects.equals(getSquareFootage(), rooms.getSquareFootage()) && Objects.equals(getApartment(), rooms.getApartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBedrooms(), getBathrooms(), getSquareFootage(), getApartment());
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", squareFootage=" + squareFootage +
                ", apartment=" + apartment +
                '}';
    }
}