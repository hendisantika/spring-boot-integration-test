package com.example;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-integration-test
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/04/22
 * Time: 10.33
 */
@Data
@Entity
@Table(name = Student.STUDENT)
public class Student implements Serializable {

    public static final String STUDENT = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = Student.ID)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = Student.NAME)
    private String name;

    @Column(name = Student.ADDRESS)
    private String address;
}
