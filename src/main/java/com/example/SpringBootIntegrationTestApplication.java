package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

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

@RestController
@AllArgsConstructor
class EmployeeController {
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}

