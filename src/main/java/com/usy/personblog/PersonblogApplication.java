package com.usy.personblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.usy.personblog.mapper")
public class PersonblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonblogApplication.class, args);
    }

}
