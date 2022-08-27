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
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String address;
    private Boolean nearStreet;
    private Integer levelOfNoise; // between 1 and 10
    private Integer walkability; // between 1 and 10
    private Integer apartmentId;

    public Location(Integer id, String address, Boolean nearStreet, Integer levelOfNoise, Integer walkability, Integer apartmentId) {
        this.id = id;
        this.address = address;
        this.nearStreet = nearStreet;
        this.levelOfNoise = levelOfNoise;
        this.walkability = walkability;
        this.apartmentId = apartmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Objects.equals(getId(), location.getId()) && Objects.equals(getAddress(), location.getAddress()) && Objects.equals(getNearStreet(), location.getNearStreet()) && Objects.equals(getLevelOfNoise(), location.getLevelOfNoise()) && Objects.equals(getWalkability(), location.getWalkability()) && Objects.equals(getApartmentId(), location.getApartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getNearStreet(), getLevelOfNoise(), getWalkability(), getApartmentId());
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", nearStreet=" + nearStreet +
                ", levelOfNoise=" + levelOfNoise +
                ", walkability=" + walkability +
                ", apartmentId=" + apartmentId +
                '}';
    }
}