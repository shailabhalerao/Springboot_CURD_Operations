package com.hcl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Country;
import com.hcl.entity.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	// API 1
	public String addCountry(Country c) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		int i = (int) session.save(c);
		transaction.commit();

		if (i > 0) {
			return "Country " + c.getCid() + " Added Successfully";
		} else {
			return "Something Went Wrong !!";
		}

	}

	// API 2
	public List<Country> getAllCountry() {
		Session session = sessionFactory.openSession();
		List<Country> list = session.createCriteria(Country.class).list();
		return list;
	}

	// API 3
	public String updateCountry(Country c) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(c);
		transaction.commit();
		return "Country " + c.getCid() + " update successfully !!!";
	}

	// API 4
	public String deleteCountry(String cname) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("cname", cname));
		Country country = (Country) criteria.uniqueResult();
		session.delete(country);
		transaction.commit();
		return "Country " + cname + " is Deleted";
	}

	// API 5
	public Country getParticularCountry(Integer cid) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("cid", cid));
		Country c = (Country) criteria.uniqueResult();
		return c;
	}

	// API 6
	public String addEmployee(Employee e) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(e);
		transaction.commit();
		return "Employee" + e.getId() + " Added Successfully !!!";
	}

	// API 7
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		List<Employee> list = session.createCriteria(Employee.class).list();
		return list;
	}

	// API 8
	public String updateEmployee(Employee e) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(e);
		transaction.commit();
		return "Employee " + e.getId() + " Updated Successfully!!!";
	}

	// API 9
	public String deleteEmployee(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee emp = (Employee) criteria.uniqueResult();
		session.delete(emp);
		transaction.commit();
		return "Employee " + emp.getName() + " is Deleted";

	}

	// API 10
	public Employee getParticularEmployee(Integer id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee e = (Employee) criteria.uniqueResult();
		return e;
	}
}
