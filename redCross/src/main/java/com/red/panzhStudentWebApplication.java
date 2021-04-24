package com.red;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.red.mapper"})
public class panzhStudentWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(panzhStudentWebApplication.class, args);
    }

}
