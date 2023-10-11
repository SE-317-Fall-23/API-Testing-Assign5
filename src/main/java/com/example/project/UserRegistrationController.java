package com.example.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.model.UserRegistrationRequest;
import com.example.project.model.UserResponse;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRegistrationRequest userRequest) {
        // Implement user creation logic here
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("user-id") String userId) {
        // Implement user retrieval logic here
        return ResponseEntity.ok(new UserResponse());
    }
}