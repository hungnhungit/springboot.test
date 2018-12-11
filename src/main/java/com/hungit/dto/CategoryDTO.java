/**
 * 
 */
package com.hungit.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.hungit.entity.Category;
import com.hungit.entity.Post;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Kashiwagi
 *
 */
@Getter
@Setter
@Data
public class CategoryDTO implements DTOEntity {

	private Long id;
	private Set<Post> posts = new HashSet<Post>();
	private String name;
	private int status;
	private Integer position;
	private String description;

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.posts = category.getPosts();
		this.name = category.getName();
		this.status = category.getStatus();
		this.position = category.getPosition();
		this.description = category.getDescription();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.dto.DTOEntity#toJson()
	 */
	@Override
	public DTOEntity toJson() {
		// TODO Auto-generated method stub
		return null;
	}

}
