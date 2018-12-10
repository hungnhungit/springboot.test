/**
 * 
 */
package com.hungit.entity;

import javax.persistence.*;

import com.hungit.common.AbstractBaseModel;

import lombok.*;

import java.util.Set;

/**
 * @author Kashiwagi
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends AbstractBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	public Role(String name) {

		this.name = name;

	}

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

}