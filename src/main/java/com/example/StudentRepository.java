package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-integration-test
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/04/22
 * Time: 10.34
 */
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByName(String name);
}
