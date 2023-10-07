package com.kamar.ticketing_system_fin.user.controller;

import com.kamar.ticketing_system_fin.user.data.UserDTO;
import com.kamar.ticketing_system_fin.user.service.NormalUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * the user controller.
 * @author kamar baraka.*/


@RestController
@RequestMapping(value = {"/api/users"})
@Tag(name = "User API", description = "the user api to create and add add users")
@RequiredArgsConstructor
public class UserController {

    private final NormalUserService userService;

    /**
     * get a list of all users.*/
    @GetMapping
    @Operation(tags = {"Get all Users"}, summary = "get all users", description = "get a list of all users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        /*get all users*/
        List<UserDTO> allUsers = userService.getAllUsers();
        /*return the users as the response*/
        return ResponseEntity.ok(allUsers);
    }

    /**
     * get a user by email*/
    @GetMapping(value = {"{email}"})
    @Operation(tags = "Get A User", summary = "get a user by email")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable("email") String email){

        /*get the user with email*/
        UserDTO user = userService.getUserByEmail(email);
        /*return the user as response*/
        return ResponseEntity.ok(user);
    }

    /**
     * register a user.*/
    @PostMapping
    @Operation(tags = "Register User", summary = "register a new user")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserDTO userDTO){

        /*register a new user*/
        userService.registerUser(userDTO);

    }

}
