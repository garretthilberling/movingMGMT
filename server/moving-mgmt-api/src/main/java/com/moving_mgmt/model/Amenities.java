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
    private Integer id;
    private Boolean washer;
    private Boolean dryer;
    private Boolean dishwasher;
    private Boolean airConditioning;
    private Boolean stove;
    private Boolean gated;

    @OneToOne(mappedBy = "amenities")
    private Apartment apartment;

    public Amenities() {
    }

    public Amenities(Integer id, Boolean washer, Boolean dryer, Boolean dishwasher, Boolean airConditioning, Boolean stove, Boolean gated) {
        this.id = id;
        this.washer = washer;
        this.dryer = dryer;
        this.dishwasher = dishwasher;
        this.airConditioning = airConditioning;
        this.stove = stove;
        this.gated = gated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        Amenities amenities = (Amenities) o;
        return Objects.equals(getId(), amenities.getId()) && Objects.equals(getWasher(), amenities.getWasher()) && Objects.equals(getDryer(), amenities.getDryer()) && Objects.equals(getDishwasher(), amenities.getDishwasher()) && Objects.equals(getAirConditioning(), amenities.getAirConditioning()) && Objects.equals(getStove(), amenities.getStove()) && Objects.equals(getGated(), amenities.getGated()) && Objects.equals(getApartment(), amenities.getApartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWasher(), getDryer(), getDishwasher(), getAirConditioning(), getStove(), getGated(), getApartment());
    }

    @Override
    public String toString() {
        return "Amenities{" +
                "id=" + id +
                ", washer=" + washer +
                ", dryer=" + dryer +
                ", dishwasher=" + dishwasher +
                ", airConditioning=" + airConditioning +
                ", stove=" + stove +
                ", gated=" + gated +
                ", apartment=" + apartment +
                '}';
    }
}