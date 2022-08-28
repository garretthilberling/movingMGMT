package com.moving_mgmt.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private Integer salary;
    private Integer budget;
    @Transient  // signals to Spring Data JPA that this data is NOT to be persisted in the database
    boolean loggedIn;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Apartment> apartments;

    public User(Integer id, String username, String email, String password, Integer salary, Integer budget) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return isLoggedIn() == user.isLoggedIn() && java.util.Objects.equals(getId(), user.getId()) && java.util.Objects.equals(getUsername(), user.getUsername()) && java.util.Objects.equals(getEmail(), user.getEmail()) && java.util.Objects.equals(getPassword(), user.getPassword()) && java.util.Objects.equals(getSalary(), user.getSalary()) && java.util.Objects.equals(getBudget(), user.getBudget()) && java.util.Objects.equals(getApartments(), user.getApartments());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getUsername(), getEmail(), getPassword(), getSalary(), getBudget(), isLoggedIn(), getApartments());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", budget=" + budget +
                ", loggedIn=" + loggedIn +
                ", apartments=" + apartments +
                '}';
    }
}