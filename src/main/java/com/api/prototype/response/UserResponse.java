package com.api.prototype.response;

import com.api.prototype.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@ToString
@Setter
@Getter
public class UserResponse {


    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    @Length(min = 6,max = 26,message = "password at least 6 strings to 26")
    private String password;


    @Builder
    public UserResponse(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }



    public UserResponse responseDTO(User user) {

        UserResponse userResponse = new UserResponse()
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();

        return userResponse;
    }

    public UserResponse() {

    }
}
