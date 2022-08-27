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
    private Integer walkability; // score between 1 and 10
    private Integer apartmentId;

    public Amenities(Integer id, Boolean washer, Boolean dryer, Boolean dishwasher, Boolean airConditioning, Boolean stove, Boolean gated, Integer walkability, Integer apartmentId) {
        this.airConditioning = airConditioning;
        this.apartmentId = apartmentId;
        this.stove = stove;
        this.dishwasher = dishwasher;
        this.gated = gated;
        this.washer = washer;
        this.dryer = dryer;
        this.walkability = walkability;
        this.id = id;
        this.apartmentId = apartmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
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

    public Boolean getDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(Boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public Boolean getWasher() {
        return washer;
    }

    public void setWasher(Boolean dryer) {
        this.washer = washer;
    }

    public Boolean getDryer() {
        return dryer;
    }

    public void setDryer(Boolean dryer) {
        this.dryer = dryer;
    }

    public Boolean getGated() {
        return gated;
    }

    public void setGated(Boolean gated) {
        this.gated = gated;
    }

    public Integer getWalkability() {
        return walkability;
    }

    public void setWalkability(Integer walkability) {
        this.walkability = walkability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amenities)) return false;
        Amenities amenities = (Amenities) o;
        return  Objects.equals(getId(), amenities.getId()) &&
                Objects.equals(getApartmentId(), amenities.getApartmentId()) &&
                Objects.equals(getDryer(), amenities.getDryer()) &&
                Objects.equals(getWasher(), amenities.getWasher()) &&
                Objects.equals(getDishwasher(), amenities.getDishwasher()) &&
                Objects.equals(getStove(), amenities.getStove()) &&
                Objects.equals(getAirConditioning(), amenities.getAirConditioning()) &&
                Objects.equals(getGated(), amenities.getGated()) &&
                Objects.equals(getWalkability(), amenities.getWalkability());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getApartmentId(), getDryer(), getWasher(), getDishwasher(), getStove(), getAirConditioning(), getGated(), getWalkability());
    }

    @Override
    public String toString() {
        return "Amenities{" +
                "id=" + id +
                ", apartment_id=" + apartmentId +
                ", dryer=" + dryer +
                ", washer=" + washer +
                ", dishwasher=" + dishwasher +
                ", stove=" + stove +
                ", air_conditioning=" + airConditioning +
                ", gated=" + gated +
                ", walkability=" + walkability +
                '}';
    }
}