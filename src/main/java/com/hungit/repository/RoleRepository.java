/**
 * 
 */
package com.hungit.repository;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hungit.entity.Role;

/**
 * @author Kashiwagi
 *
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
	
	Set<Role> findAll();
	
}
