package com.example;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
public class SpringBootIntegrationTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationTestApplication.class, args);
    }

}

@Data
@Entity
class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
}

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
