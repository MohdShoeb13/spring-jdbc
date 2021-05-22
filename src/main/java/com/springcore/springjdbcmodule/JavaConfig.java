package com.springcore.springjdbcmodule;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.springjdbcmodule.dao.EmployeeDao;
import com.springcore.springjdbcmodule.dao.EmployeeDaoImpl;

@Configuration
public class JavaConfig {
    
	@Bean(name = {"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name = {"employeeDao"})
	public EmployeeDao getEmployeeDao() {
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		dao.setJdbcTemplate(getTemplate());
		return dao;
	}
}
