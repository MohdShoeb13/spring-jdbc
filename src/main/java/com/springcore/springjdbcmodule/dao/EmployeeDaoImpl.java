package com.springcore.springjdbcmodule.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springcore.springjdbcmodule.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
 
	@Override
	public int insert(Employee employee) {
		String query = "INSERT INTO employee(id,name,designation) VALUES(?,?,?)";
		int rowsAffected = jdbcTemplate.update(query, employee.getId(),employee.getName(),employee.getDesignation());
		System.out.println("Inserted data sucessfully");
		return rowsAffected;
	} 

	@Override
	public int update(Employee employee) {
		String query ="UPDATE employee SET name=? , designation=? WHERE id=?";
		int rowsAffected = jdbcTemplate.update(query,employee.getName(),employee.getDesignation(),employee.getId());
		return rowsAffected;
	}
	
	@Override
	public int delete(int id) {
		String query = "DELETE FROM employee WHERE id=?";
		int rowsDeleted = this.jdbcTemplate.update(query,id);
		return rowsDeleted;
	}
	
	@Override
	public Employee getEmployee(int id) {
		String query = "SELECT * FROM employee WHERE id=?";
		RowMapper<Employee> rowMapper = new RowMapperImpl();
		Employee queryForObject = this.jdbcTemplate.queryForObject(query,rowMapper,id);
		return queryForObject;
	}
	
	@Override
	public List<Employee> getEmployees() {
		String query = "SELECT * FROM  employee";
		List<Employee> list = this.jdbcTemplate.query(query, new RowMapperImpl());
		return list;
	}
    
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
