package com.learning.springbootcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.learning.springbootcrud.controller")
public class SpringBootCrudApplication extends SpringBootServletInitializer {
 
     public static void main(String[] args) { 
           SpringApplication.run(SpringBootCrudApplication.class, args);
     }
}
