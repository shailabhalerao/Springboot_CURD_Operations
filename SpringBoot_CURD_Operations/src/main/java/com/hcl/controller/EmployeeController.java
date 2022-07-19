package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Country;
import com.hcl.entity.Employee;
import com.hcl.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	// API 1- ADD COUNTRY
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country c) {
		String str = service.addCountry(c);
		return str;

	}

	// API 2 - GET ALL COUNTRY
	@GetMapping("/getallcountry")
	public List<Country> getAllCountry() {
		List<Country> list = service.getAllCountry();
		return list;

	}

	// API 3 - UPDATE COUNTRY
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country c) {
		String str = service.updateCountry(c);
		return str;

	}

	// API 4 - DELETE COUNTRY BY CNAME
	@DeleteMapping("/deletecountry/{cname}")
	public String deleteCountry(@PathVariable String cname) {
		String str = service.deleteCountry(cname);
		return str;

	}

	// API 5 - GET COUNTRY BY ID
	@GetMapping("/getparticularrecord/{cid}")
	public Country getParticularCountry(@PathVariable Integer cid) {
		Country c = service.getParticularCountry(cid);
		return c;

	}

	// API 6 - ADD EMPLOYEE
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee e) {
		String str = service.addEmployee(e);
		return str;
	}

	// API 7 - GET ALL EMPLOYEE
	@GetMapping("/getallemployee")
	public List<Employee> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		return list;
	}

	// API 8 - UPDATE EMPLOYEE
	@PutMapping("/updateemployee")
	public String updateEmployee(@RequestBody Employee e) {
		String str = service.updateEmployee(e);
		return str;
	}

	// API 9 - DELETE EMPLOYEE
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		String str = service.deleteEmployee(id);
		return str;

	}

	// API 10 - GET EMPLOYEE BY ID
	@GetMapping("/getemployeebyid/{id}")
	public Employee getParticularEmployee(@PathVariable Integer id) {
		Employee e = service.getParticularEmployee(id);
		return e;
	}

}
