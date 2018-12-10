package com.hungit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hungit.entity.Department;
import com.hungit.entity.Employee;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	@Query("SELECT d FROM Department d")
	List<Department> all();

	@Query("SELECT d FROM Department d WHERE d.DepName = :name")
	List<Department> findByName(@Param("name") String name);

	@Query("SELECT COUNT(d) FROM Department d WHERE d.DepName=?1")
	Integer count(String name);

	@Query("SELECT e FROM Department d INNER JOIN d.employees e WHERE d.id=?1")
	List<Employee> findByCustomer(Integer id);
}
