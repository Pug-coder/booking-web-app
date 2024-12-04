package com.example.booking.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
        @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;

    @ElementCollection(targetClass = Role.class, fetch=FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name= "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Set<Role> roles;
    public User() {}



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
