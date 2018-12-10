/**
 * 
 */
package com.hungit.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hungit.entity.User;

/**
 * @author Kashiwagi
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findByUsername(String username);
}
