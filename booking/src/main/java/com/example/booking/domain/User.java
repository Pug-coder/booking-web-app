package com.example.booking.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
        @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

        @Column(name = "firstName", nullable = false)
        @NotBlank(message =  "First name cannot be empty")
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @NotBlank(message =  "Last name cannot be empty")
    private String lastName;

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
