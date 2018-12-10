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
@Table(name = "posts")
public class Post extends AbstractBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic(optional = false)
	@Column(name = "title")
	private String title;

	@Basic(optional = false)
	@Column(name = "status")
	private int status = 1;

	@Column(name = "body")
	private String body;

	@Column(name = "slug")
	private String slug;

	@Column(name = "image")
	private String image;

	@Column(name = "view")
	private int view;

}
