package com.hungit.service;

import java.util.List;

import com.hungit.common.IOperations;
import com.hungit.entity.Department;

public interface DepartmentService extends IOperations<Department> {
	Department addDepartment(Department d);

	List<Department> all();

	List<Department> findByName(String name);

	Integer count(String name);
}
