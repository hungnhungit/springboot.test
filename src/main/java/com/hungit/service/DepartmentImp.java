package com.hungit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungit.entity.Department;
import com.hungit.repository.DepartmentRepository;

@Service
public class DepartmentImp extends AbstractBaseService implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public Department addDepartment(Department d) {

		return departmentRepository.save(d);
	}

	public List<Department> all() {
		return departmentRepository.all();
	}

	public List<Department> findByName(String name) {
		return departmentRepository.findByName(name);
	}

	public Integer count(String name) {

		return departmentRepository.count(name);
	}

	public Department findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Department create(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Department update(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Department entity) {
		// TODO Auto-generated method stub

	}

	public void deleteById(long entityId) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.hungit.common.IOperations#deleteAll()
	 */
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
