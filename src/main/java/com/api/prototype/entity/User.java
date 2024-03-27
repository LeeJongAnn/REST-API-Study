package com.api.prototype.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(indexes = {@Index(name = "IDX_USER_EMAIL", columnList = "username,email")})
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "username must not be null")
    @Column(length = 10, nullable = false)
    private String username;
    @NotNull(message = "password must not be null")
    @Column(length = 256, nullable = false)
    private String password;
    @NotNull(message = "email must not be null")
    @Column(length = 25, nullable = false)
    private String email;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Board> board = new ArrayList<>();
    public User() {

    }

    @Builder
    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void editUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
