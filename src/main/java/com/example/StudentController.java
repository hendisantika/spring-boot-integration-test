package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-integration-test
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/04/22
 * Time: 10.37
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Student findByName(@RequestParam String name) {
        return studentService.findByName(name);
    }
}
