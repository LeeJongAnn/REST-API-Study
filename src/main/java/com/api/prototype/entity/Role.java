package com.api.prototype.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 255, nullable = false)
    private String description;


    @CreationTimestamp
    private Date creationTime;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;


    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @Override
    public String toString() {
        return this.name;
    }

}