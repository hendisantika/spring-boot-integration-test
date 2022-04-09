package com.example;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-integration-test
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/04/22
 * Time: 10.34
 */
public interface StudentService {
    Student save(Student student);

    Student findByName(String name);

    void delete(String id);
}
