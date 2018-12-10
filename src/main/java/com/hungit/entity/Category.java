package com.hungit.entity;

import java.util.*;

import javax.persistence.*;

import com.hungit.common.AbstractBaseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends AbstractBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parentId;

	@OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Category> subCategories = new HashSet<Category>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "categories")
	private Set<Product> products = new HashSet<Product>();

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Basic(optional = false)
	@Column(name = "status")
	private int status = 1;

	@Column(name = "position")
	private Integer position;

	@Column(name = "description")
	private String description;

}
