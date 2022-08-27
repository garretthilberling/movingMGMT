package src.main.java.com.moving_mgmt.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.beans.Transient;
import java.io.Serializable;
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
    private String siteLink;
    private Integer userId;

    @OneToOne(mappedBy = "apartmentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private <Amenities> amenities;
    @OneToOne(mappedBy = "apartmentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private <Rooms> rooms;
    @OneToOne(mappedBy = "apartmentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private <Location> location;


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

    public String getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public <Amenities> getAmenities() {
        return amenities;
    }

    public void setAmenities(<Amenities> amenities) {
        this.amenities = amenities;
    }

    public <Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(<Rooms> rooms) {
        this.rooms = rooms;
    }

    public <Location> getLocation() {
        return location;
    }

    public void setLocation(<Location> location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        Apartment apartment = (Apartment) o;
        return  Objects.equals(getId(), apartment.getId()) &&
                Objects.equals(getPrice(), apartment.getPrice()) &&
                Objects.equals(getSiteLink(), apartment.getSiteLink()) &&
                Objects.equals(getMoveInDate(), apartment.getMoveInDate()) &&
                Objects.equals(getUserId(), apartment.getUserId()) &&
                Objects.equals(getAmenities(), apartment.getAmenities()) &&
                Objects.equals(getRooms(), apartment.getRooms()) &&
                Objects.equals(getLocation(), apartment.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getSiteLink(), getMoveInDate(), getAmenities(), getRooms(), getLocation());
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", site_link='" + siteLink + '\'' +
                ", move_in_date='" + moveInDate + '\'' +
                ", userId=" + userId +
                ", amenities=" + amenities +
                ", rooms=" + rooms +
                ", location=" + location +
                '}';
    }
}