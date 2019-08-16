package com.newtechcollege.coursecms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //事务注解
public class CoursecmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursecmsApplication.class, args);
    }

}
