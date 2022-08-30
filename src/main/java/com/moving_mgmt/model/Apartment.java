package com.moving_mgmt.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "move_in_date")
    private Date moveInDate;
    private Integer price;
    @Column(name = "site_link")
    private String siteLink;
    private Integer userId;

    @OneToMany(mappedBy = "apartmentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Amenities> amenities;
    @OneToMany(mappedBy = "apartmentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rooms> rooms;
    @OneToMany(mappedBy = "apartmentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Location> location;

    public Apartment() {
    }

    public Apartment(Integer id, Date moveInDate, Integer price, String siteLink, Integer userId) {
        this.id = id;
        this.moveInDate = moveInDate;
        this.price = price;
        this.siteLink = siteLink;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Amenities> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenities> amenities) {
        this.amenities = amenities;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return Objects.equals(getId(), apartment.getId()) && Objects.equals(getMoveInDate(), apartment.getMoveInDate()) && Objects.equals(getPrice(), apartment.getPrice()) && Objects.equals(getSiteLink(), apartment.getSiteLink()) && Objects.equals(getUserId(), apartment.getUserId()) && Objects.equals(getAmenities(), apartment.getAmenities()) && Objects.equals(getRooms(), apartment.getRooms()) && Objects.equals(getLocation(), apartment.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMoveInDate(), getPrice(), getSiteLink(), getUserId(), getAmenities(), getRooms(), getLocation());
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", moveInDate=" + moveInDate +
                ", price=" + price +
                ", siteLink='" + siteLink + '\'' +
                ", userId=" + userId +
                ", amenities=" + amenities +
                ", rooms=" + rooms +
                ", location=" + location +
                '}';
    }
}