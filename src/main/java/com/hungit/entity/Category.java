package com.hungit.entity;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
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

	@ManyToOne()
	@JoinColumn(name = "parent_id")
	private Category parentId;

	@JsonIgnore
	@OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL)
	private Set<Category> subCategories = new HashSet<Category>();

	@JsonIgnore
	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
	private Set<Post> posts = new HashSet<Post>();

	@JsonIgnore
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
