package com.example.project.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.project.UserRegistrationController;
import com.example.project.model.UserRegistrationRequest;
import java.util.stream.Stream;

@WebMvcTest(UserRegistrationController.class)
public class TestUserRegistrationController {
     @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private UserRegistrationController userRegistrationController;

        static Stream<UserRegistrationRequest> userRequestProvider() {
        // Define a stream of UserRegistrationRequest objects with different data for parameterized testing
        return Stream.of(
            createSampleUserRequest("John", "Doe"),
            createSampleUserRequest("Jane", "Smith"),
            createSampleUserRequest("Bob", "Johnson")
            // Add more test cases as needed
        );
    }

    private static UserRegistrationRequest createSampleUserRequest(String firstName, String lastName) {
        UserRegistrationRequest userRequest = new UserRegistrationRequest();
        // Set user details
        return userRequest;
    }

    @ParameterizedTest
    @MethodSource("userRequestProvider")
    void testCreateUser() throws Exception {
        // arrange

        // action

        // assert

    }
    
}
