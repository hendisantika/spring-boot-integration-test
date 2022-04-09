package com.example;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {SpringBootIntegrationTestApplicationTests.Initializer.class})
class SpringBootIntegrationTestApplicationTests {
    @ClassRule
    public static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres")
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("docker");

    @Value("http://localhost:${local.server.port}")
    String baseUrl;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

}
