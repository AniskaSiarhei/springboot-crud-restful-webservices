package com.example.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDTO Model information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @Schema(
            description = "User First Name"
    )
    // User first name should be not null or empty
    @NotEmpty(message = "User first name should be not null or empty")
    private String firstName;

    @Schema(
            description = "User Last Name"
    )
    // User last name should be not null or empty
        @NotEmpty(message = "User last name should be not null or empty")
    private String lastName;

    @Schema(
            description = "User Email address"
    )
    // User email should be not null or empty
    // email should be valid
    @NotEmpty(message = "User email should be not null or empty")
    @Email(message = "Email should be valid")
    private String email;

}
