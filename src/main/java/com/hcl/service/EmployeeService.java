package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.EmployeeDAO;
import com.hcl.entity.Country;
import com.hcl.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO dao;

	// API 1
	public String addCountry(Country c) {
		String str = dao.addCountry(c);
		return str;
	}

	// API -2
	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		return list;
	}

	// API 3
	public String updateCountry(Country c) {
		String str = dao.updateCountry(c);
		return str;
	}

	// API 4
	public String deleteCountry(String cname) {
		String str = dao.deleteCountry(cname);
		return str;
	}

	// API 5

	public Country getParticularCountry(Integer cid) {
		Country c = dao.getParticularCountry(cid);
		return c;
	}

	// API 6
	public String addEmployee(Employee e) {
		String str = dao.addEmployee(e);
		return str;
	}

	// API 7
	public List<Employee> getAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		return list;
	}

	// API 8
	public String updateEmployee(Employee e) {
		String str = dao.updateEmployee(e);
		return str;
	}

	// API 9
	public String deleteEmployee(Integer id) {
		String str = dao.deleteEmployee(id);
		return str;
	}

	// API 10
	public Employee getParticularEmployee(Integer id) {
		Employee e = dao.getParticularEmployee(id);
		return e;
	}
}
