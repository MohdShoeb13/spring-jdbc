package com.springcore.springjdbcmodule.dao;

import java.util.List;

import com.springcore.springjdbcmodule.entity.Employee;

public interface EmployeeDao {
   
	 int insert(Employee employee);
	 int update(Employee employee);
	 int delete(int id);
	 Employee getEmployee(int id);
	 List<Employee> getEmployees();
}
