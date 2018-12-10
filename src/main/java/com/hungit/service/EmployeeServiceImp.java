package com.hungit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungit.entity.Employee;
import com.hungit.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp extends AbstractBaseService implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Iterable<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee e) {
		return employeeRepository.save(e);
	}


	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.hungit.common.IOperations#findOne(long)
	 */
	public Employee findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hungit.common.IOperations#create(java.io.Serializable)
	 */
	public Employee create(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hungit.common.IOperations#update(java.io.Serializable)
	 */
	public Employee update(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hungit.common.IOperations#delete(java.io.Serializable)
	 */
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.hungit.common.IOperations#deleteById(long)
	 */
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
