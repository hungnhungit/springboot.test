/**
 * 
 */
package com.hungit.form;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kashiwagi
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryForm {
	private Integer parentId;

	@NotEmpty(message = "{categoryForm.name.empty}")
	private String name;
	private Integer status;
	private Integer position;
	@NotEmpty(message = "{categoryForm.description.empty}")
	private String description;
}
