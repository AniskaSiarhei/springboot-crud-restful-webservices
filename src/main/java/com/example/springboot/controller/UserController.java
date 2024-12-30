package com.example.springboot.controller;

import com.example.springboot.dto.UserDto;
import com.example.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build CREATE User REST API
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save User in a DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build GET User id REST API
    // http://localhost:8080/api/users/1
    @Operation(
            summary = "Get User by ID REST API",
            description = "Get User by ID REST API is used to get User from the DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // build GET All User REST API
    // http://localhost:8080/api/users
    @Operation(
            summary = "Get All Users REST API",
            description = "Get All User REST API is used to get all Users from the DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // build UPDATE User REST API
    // http://localhost:8080/api/users/1
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular User in the DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @Valid @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // build DELETE User REST API
    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a particular User in the DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User with id: " + userId + " successfully deleted", HttpStatus.OK);
    }

}
