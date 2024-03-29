package com.api.prototype.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Getter
@Entity
public class Session {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accessToken;


    @ManyToOne
    private User user;

    @Builder
    public Session(User user) {
        this.accessToken = UUID.randomUUID().toString();
        this.user = user;
    }

    public Session() {

    }
}
