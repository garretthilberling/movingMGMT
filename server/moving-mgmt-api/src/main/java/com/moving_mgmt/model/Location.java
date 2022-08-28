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
    private Integer id;
    private String address;
    private Boolean nearStreet;
    private Integer levelOfNoise; // between 1 and 10
    private Integer walkability; // between 1 and 10
    @OneToOne(mappedBy = "amenities")
    private Apartment apartment;

    public Location(Integer id, String address, Boolean nearStreet, Integer levelOfNoise, Integer walkability) {
        this.id = id;
        this.address = address;
        this.nearStreet = nearStreet;
        this.levelOfNoise = levelOfNoise;
        this.walkability = walkability;
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
        Location location = (Location) o;
        return Objects.equals(getId(), location.getId()) && Objects.equals(getAddress(), location.getAddress()) && Objects.equals(getNearStreet(), location.getNearStreet()) && Objects.equals(getLevelOfNoise(), location.getLevelOfNoise()) && Objects.equals(getWalkability(), location.getWalkability()) && Objects.equals(getApartment(), location.getApartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getNearStreet(), getLevelOfNoise(), getWalkability(), getApartment());
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", nearStreet=" + nearStreet +
                ", levelOfNoise=" + levelOfNoise +
                ", walkability=" + walkability +
                ", apartment=" + apartment +
                '}';
    }
}