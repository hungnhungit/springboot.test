/**
 * 
 */
package com.hungit.facetory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hungit.entity.Role;
import com.hungit.entity.User;
import com.hungit.repository.RoleRepository;
import com.hungit.repository.UserRepository;
import com.hungit.util.ArrayUtil;

/**
 * @author Kashiwagi
 *
 */
@Component
public class LoaderData implements ApplicationRunner {
	
	private static final String PREFIX_ROLE = "ROLE_";
	
	private RoleRepository roleRepository;

	private UserRepository userRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public LoaderData(RoleRepository roleRepository, UserRepository userRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.
	 * ApplicationArguments)
	 */
	public void run(ApplicationArguments args) throws Exception {
		Set<Role> roles = ArrayUtil.asArrayList(roleRepository.save(new Role(ROLES.ADMIN.getName())));
		User userOne = new User();
		userOne.setEmail("hungnhungit123@gmail.com");
		userOne.setPhoneNumber("012345678");
		userOne.setUsername("hungit");
		userOne.setRoles(roles);
		userOne.setPassword(bCryptPasswordEncoder.encode("hungit"));

		User userTwo = new User();
		userTwo.setEmail("hungnhungit123@gmail.com");
		userTwo.setPhoneNumber("012345678");
		userTwo.setUsername("nhungit");
		userTwo.setRoles(roles);
		userTwo.setPassword(bCryptPasswordEncoder.encode("nhungit"));
		userRepository.save(userOne);
		userRepository.save(userTwo);

	}

	public static enum ROLES {
		ADMIN(PREFIX_ROLE + "ADMIN"), MEMBER(PREFIX_ROLE + "MEMBER"), EDITOR(PREFIX_ROLE + "EDITOR");

		private String name;

		ROLES(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
