package com.learning.springbootcrud.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.learning.springbootcrud.Employee;

@EnableWebMvc
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "https://angular-project-bucket.s3.us-east-2.amazonaws.com")
public class EmployeeController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	EmployeeController() {
		logger.info("======I am in EmployeeController====");
	}

	
	List<Employee> list = new ArrayList<Employee>();
	
	@RequestMapping(path = "/get-all", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployee() {
		return list;
	}
	
	@RequestMapping(path = "/post", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee postEmployee(@RequestBody Employee emp) {
		logger.info("======I am in EmployeeController POST path====");
		list.add(emp);
	  	return emp;
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		list.forEach(emp1 -> {
			if(emp1.getId() == emp.getId()) {
				System.out.println("==="+emp1.getId()+"==="+emp.getId());
				emp1.setFirstName(emp.getFirstName());
				emp1.setLastName(emp.getLastName());
				emp1.setEmail(emp.getEmail());
			}
		});
		return emp;
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> deleteEmployee(@PathVariable("id") Integer id) {
		list.removeIf( emp -> {
		      return (emp.getId() == id);//No return statement will break compilation
		    });
		Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
	}
	
	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return list.stream().filter(emp-> emp.getId() == id).findAny().orElse(new Employee());
	}
}

