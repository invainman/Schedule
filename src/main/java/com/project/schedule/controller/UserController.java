package com.project.schedule.controller;

import com.project.schedule.dto.UserDto;
import com.project.schedule.entity.User;
import com.project.schedule.jwt.JwtLoginRequest;
import com.project.schedule.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> getTokenForLogin(@RequestBody JwtLoginRequest loginRequest) {
        return new ResponseEntity<>(userService.getTokenForLogin(loginRequest), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByEmail(@RequestBody String email) {
        userService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/current")
    public ResponseEntity<User> getCurent() {
        return new ResponseEntity<>(userService.getCurrent(), HttpStatus.OK);
    }
}
