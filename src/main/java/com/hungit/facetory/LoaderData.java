/**
 * 
 */
package com.hungit.facetory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hungit.entity.Category;
import com.hungit.entity.Post;
import com.hungit.entity.Role;
import com.hungit.entity.User;
import com.hungit.repository.CategoryRepository;
import com.hungit.repository.PostRepository;
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

	private CategoryRepository categoryRepository;

	private PostRepository postRepository;

	@Autowired
	public LoaderData(RoleRepository roleRepository, UserRepository userRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder, CategoryRepository categoryRepository,
			PostRepository postRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.categoryRepository = categoryRepository;
		this.postRepository = postRepository;
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

		// =======Save Categories =======

		Category categoryOne = new Category();
		categoryOne.setName("Php");
		categoryOne.setDescription("Php");
		categoryOne.setPosition(1);
		categoryOne = categoryRepository.save(categoryOne);

		Category categoryTow = new Category();
		categoryTow.setName("C++");
		categoryTow.setDescription("C++");
		categoryTow.setPosition(2);
		categoryRepository.save(categoryTow);

		Set<Category> subcategories = new HashSet<>();

		subcategories.add(categoryOne);

		Category categoryThree = new Category();
		categoryThree.setName("Ruby");
		categoryThree.setDescription("Ruby");
		categoryThree.setParentId(categoryOne);
		categoryThree.setPosition(3);
		categoryRepository.save(categoryThree);

		Category categoryFour = new Category();
		categoryFour.setName("Java");
		categoryFour.setDescription("Java");
		categoryFour.setPosition(4);
		categoryFour = categoryRepository.save(categoryFour);

		// ============= Save Post =======
		Post postOne = new Post();
		postOne.setTitle("Developer Php");
		postOne.setImage("php.png");
		postOne.setSlug("developer-php");
		postOne.setCategoryId(categoryOne);
		postOne.setBody("Developer Php");
		postRepository.save(postOne);

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
