/**
 * 
 */
package com.hungit.entity;

import javax.persistence.*;

import com.hungit.common.AbstractBaseModel;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author Kashiwagi
 *
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

}