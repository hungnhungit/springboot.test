/**
 * 
 */
package com.hungit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PostDTO implements DTOEntity {
	private Long id;
	private Category categoryId;
	private String title;
	private int status;
	private String body;
	private String slug;
	private String image;
	private int view;

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
