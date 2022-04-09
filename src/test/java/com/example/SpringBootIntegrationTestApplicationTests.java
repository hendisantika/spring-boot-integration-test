package com.example;

import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

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

    @Test
    public void testWriteToDb_afterBoot_shouldHaveEntries() {
        List<Employee> all = employeeRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(6);
        Assertions.assertThat(all.get(0).getFirstName()).isEqualTo("First");
        Assertions.assertThat(all.get(0).getLastName()).isEqualTo("Last");
    }

    @Test
    public void testGet_returns_200_with_expected_employees() {
        when().
                get(baseUrl + "/employees").
                then()
                .statusCode(200)
                .body("size()", is(6))
                .body("[0].firstName", equalTo("First"))
                .body("[0].lastName", equalTo("Last"));
    }
}
