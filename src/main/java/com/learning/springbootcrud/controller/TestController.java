package com.learning.springbootcrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.learning.springbootcrud.Employee;

//@EnableWebMvc
@RestController
@RequestMapping("/test")
//@CrossOrigin(origins = "https://angular-project-bucket.s3.us-east-2.amazonaws.com")
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	TestController() {
		logger.info("====I am in TestController===");
	}

	
	@RequestMapping(path = "/get", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee() {
		logger.info("======I am in TestController GET path====");
		return new Employee(1,"siva","dara","sivaapssdc@gmail.com");
	}
	
	@RequestMapping(path = "/post", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee postEmployee(@RequestBody Employee emp) {
		logger.info("======I am in TestController POST path====");
	  	return emp;
	}

}
