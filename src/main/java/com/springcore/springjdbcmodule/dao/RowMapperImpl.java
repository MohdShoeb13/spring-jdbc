package com.springcore.springjdbcmodule.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springcore.springjdbcmodule.entity.Employee;

public class RowMapperImpl implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Employee emp = new Employee();
		  emp.setId(rs.getInt(1));
		  emp.setName(rs.getString(2));
		  emp.setDesignation(rs.getString(3));
		return emp;
	}

}
