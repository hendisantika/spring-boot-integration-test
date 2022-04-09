package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-integration-test
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/04/22
 * Time: 10.39
 */
@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; //we will use this later to convert the Student object to a json string

    @Test
    public void saveTest() throws Exception {
        Student student = new Student();
        student.setName("Uzumaki Naruto");
        student.setAddress("Konohagakure");

        this.mockMvc
                .perform(post("/student")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Uzumaki Naruto"))
                .andExpect(jsonPath("$.address").value("Konohagakure"))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andReturn();
    }
}
