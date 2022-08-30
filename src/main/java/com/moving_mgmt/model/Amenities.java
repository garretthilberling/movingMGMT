package com.moving_mgmt.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "amenities")
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "amenities_id")
    private Integer amenitiesId;
    private Boolean washer;
    private Boolean dryer;
    private Boolean dishwasher;
    private Boolean airConditioning;
    private Boolean stove;
    private Boolean gated;

    private Integer apartmentId;

    public Amenities() {
    }

    public Amenities(Integer amenitiesId, Boolean washer, Boolean dryer, Boolean dishwasher, Boolean airConditioning, Boolean stove, Boolean gated, Integer apartmentId) {
        this.amenitiesId = amenitiesId;
        this.washer = washer;
        this.dryer = dryer;
        this.dishwasher = dishwasher;
        this.airConditioning = airConditioning;
        this.stove = stove;
        this.gated = gated;
        this.apartmentId = apartmentId;
    }

    public Integer getAmenitiesId() {
        return amenitiesId;
    }

    public void setAmenitiesId(Integer amenitiesId) {
        this.amenitiesId = amenitiesId;
    }

    public Boolean getWasher() {
        return washer;
    }

    public void setWasher(Boolean washer) {
        this.washer = washer;
    }

    public Boolean getDryer() {
        return dryer;
    }

    public void setDryer(Boolean dryer) {
        this.dryer = dryer;
    }

    public Boolean getDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(Boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Boolean getStove() {
        return stove;
    }

    public void setStove(Boolean stove) {
        this.stove = stove;
    }

    public Boolean getGated() {
        return gated;
    }

    public void setGated(Boolean gated) {
        this.gated = gated;
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
        Amenities amenities = (Amenities) o;
        return Objects.equals(getAmenitiesId(), amenities.getAmenitiesId()) && Objects.equals(getWasher(), amenities.getWasher()) && Objects.equals(getDryer(), amenities.getDryer()) && Objects.equals(getDishwasher(), amenities.getDishwasher()) && Objects.equals(getAirConditioning(), amenities.getAirConditioning()) && Objects.equals(getStove(), amenities.getStove()) && Objects.equals(getGated(), amenities.getGated()) && Objects.equals(getApartmentId(), amenities.getApartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmenitiesId(), getWasher(), getDryer(), getDishwasher(), getAirConditioning(), getStove(), getGated(), getApartmentId());
    }

    @Override
    public String toString() {
        return "Amenities{" +
                "amenitiesId=" + amenitiesId +
                ", washer=" + washer +
                ", dryer=" + dryer +
                ", dishwasher=" + dishwasher +
                ", airConditioning=" + airConditioning +
                ", stove=" + stove +
                ", gated=" + gated +
                ", apartmentId=" + apartmentId +
                '}';
    }
}