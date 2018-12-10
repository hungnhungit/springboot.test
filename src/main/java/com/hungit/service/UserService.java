/**
 * 
 */
package com.hungit.service;

import com.hungit.common.IOperations;
import com.hungit.entity.User;

/**
 * @author Kashiwagi
 *
 */
public interface UserService extends IOperations<User> {

	User findByUsername(String username);
}
