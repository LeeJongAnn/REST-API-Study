package com.api.prototype.response;

import com.api.prototype.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@Setter
@Getter
public class UserResponse {

    private Integer id;

    @NotNull
    @Column(length = 10, nullable = false)
    private String username;

    @Column(length = 256, nullable = false)
    private String password;

    @Column(length = 25, nullable = false)
    private String email;


    @Builder
    public UserResponse(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserResponse responseDTO(User user) {

        UserResponse userResponse = new UserResponse()
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        return userResponse;
    }

    public UserResponse() {

    }
}
