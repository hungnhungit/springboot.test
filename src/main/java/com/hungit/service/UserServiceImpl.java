/**
 * 
 */
package com.hungit.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hungit.entity.Role;
import com.hungit.entity.User;
import com.hungit.repository.RoleRepository;
import com.hungit.repository.UserRepository;

/**
 * @author Kashiwagi
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#findOne(long)
	 */
	public User findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#findAll()
	 */
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#create(java.io.Serializable)
	 */
	public User create(User entity) {
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		entity.setRoles(new HashSet<Role>(roleRepository.findAll()));
		userRepository.save(entity);

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#update(java.io.Serializable)
	 */
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#delete(java.io.Serializable)
	 */
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#deleteById(long)
	 */
	public void deleteById(long entityId) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#deleteAll()
	 */
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.service.UserService#findByUsername(java.lang.String)
	 */
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}