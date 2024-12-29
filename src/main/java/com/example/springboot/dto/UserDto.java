package com.example.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    // User first name should be not null or empty
    @NotEmpty(message = "User first name should be not null or empty")
    private String firstName;

    // User last name should be not null or empty
    @NotEmpty(message = "User last name should be not null or empty")
    private String lastName;

    // User email should be not null or empty
    // email should be valid
    @NotEmpty(message = "User email should be not null or empty")
    @Email(message = "Email should be valid")
    private String email;

}
