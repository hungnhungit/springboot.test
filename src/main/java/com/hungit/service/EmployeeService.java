package com.hungit.service;

import java.util.List;

import com.hungit.common.IOperations;
import com.hungit.entity.Employee;

public interface EmployeeService extends IOperations<Employee> {
	
	Iterable<Employee> getAll();
	
	Employee addEmployee(Employee e);
	
	List<Employee> findAll();

}
