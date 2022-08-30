package com.moving_mgmt.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Integer locationId;
    private String address;
    private Boolean nearStreet;
    private Integer levelOfNoise; // between 1 and 10
    private Integer walkability; // between 1 and 10
    private Integer apartmentId;

    public Location() {
    }

    public Location(Integer locationId, String address, Boolean nearStreet, Integer levelOfNoise, Integer walkability, Integer apartmentId) {
        this.locationId = locationId;
        this.address = address;
        this.nearStreet = nearStreet;
        this.levelOfNoise = levelOfNoise;
        this.walkability = walkability;
        this.apartmentId = apartmentId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getNearStreet() {
        return nearStreet;
    }

    public void setNearStreet(Boolean nearStreet) {
        this.nearStreet = nearStreet;
    }

    public Integer getLevelOfNoise() {
        return levelOfNoise;
    }

    public void setLevelOfNoise(Integer levelOfNoise) {
        this.levelOfNoise = levelOfNoise;
    }

    public Integer getWalkability() {
        return walkability;
    }

    public void setWalkability(Integer walkability) {
        this.walkability = walkability;
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
        Location location = (Location) o;
        return Objects.equals(getLocationId(), location.getLocationId()) && Objects.equals(getAddress(), location.getAddress()) && Objects.equals(getNearStreet(), location.getNearStreet()) && Objects.equals(getLevelOfNoise(), location.getLevelOfNoise()) && Objects.equals(getWalkability(), location.getWalkability()) && Objects.equals(getApartmentId(), location.getApartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocationId(), getAddress(), getNearStreet(), getLevelOfNoise(), getWalkability(), getApartmentId());
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", address='" + address + '\'' +
                ", nearStreet=" + nearStreet +
                ", levelOfNoise=" + levelOfNoise +
                ", walkability=" + walkability +
                ", apartmentId=" + apartmentId +
                '}';
    }
}