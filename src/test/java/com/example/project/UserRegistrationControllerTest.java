package com.example.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUserById() throws Exception {
        // arrange
        int userId = 1;
        String json = "{\"firstName\":\"Jürgen\",\"lastName\":\"Müller\"}";

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/user/" + userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(json));
    }

    @Test
    public void testCreateUser() throws Exception {
    // arrange
    String json = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"password\":\"password\"}";

    // act and assert
    mockMvc.perform(MockMvcRequestBuilders.post("/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(MockMvcResultMatchers.status().isCreated());
}
    
}
