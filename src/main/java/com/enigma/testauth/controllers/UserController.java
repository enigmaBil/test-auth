package com.enigma.testauth.controllers;

import com.enigma.testauth.dto.UserEntityDto;
import com.enigma.testauth.entities.UserEntity;
import com.enigma.testauth.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserEntityDto>> getAllUSers(){
        List<UserEntityDto> userEntityList = userService.getAllUser();
        return ResponseEntity.ok(userEntityList);
    }

    @PostMapping
    public ResponseEntity<UserEntityDto> createUser(@RequestBody UserEntityDto user) {
        UserEntityDto createdUserEntity = this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserEntity);
    }
}
