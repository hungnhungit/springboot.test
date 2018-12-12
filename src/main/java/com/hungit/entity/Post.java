package com.hungit.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hungit.common.AbstractBaseModel;
import com.hungit.util.SlugUtil;

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

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category categoryId;

	@Basic(optional = false)
	@Column(name = "title")
	@NotEmpty(message = "{NotEmpty.post.title}")
	private String title;

	@Basic(optional = false)
	@Column(name = "status")
	private int status = 1;

	@Column(name = "body")
	@NotEmpty(message = "{NotEmpty.post.body}")
	private String body;

	@Column(name = "slug")
	private String slug;

	@Column(name = "image")
	private String image;

	@Column(name = "view")
	private int view = 0;

	@PrePersist
	public void prePersist() {
		this.slug = SlugUtil.slugStr(this.title);
	}

	@PreUpdate
	public void preUpdate() {
		this.slug = SlugUtil.slugStr(this.title);
	}

}
