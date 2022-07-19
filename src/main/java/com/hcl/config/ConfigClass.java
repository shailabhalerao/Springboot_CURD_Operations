package com.hcl.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.hcl.entity.Country;
import com.hcl.entity.Employee;


@Configuration

public class ConfigClass {
	
	@Autowired
	DataSource dataSource;
	
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String AutoUpdate;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		Properties hibernateproperties = new Properties();
		hibernateproperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hibernateproperties.put("hibernate.hbm2ddl.auto", AutoUpdate);
		
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(hibernateproperties);
		sessionFactory.setAnnotatedClasses(Country.class,Employee.class);
		
		return sessionFactory;
		
	}

}
