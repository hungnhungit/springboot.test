/**
 * 
 */
package com.hungit.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hungit.api.response.StatusResponse;
import com.hungit.constants.ApiConstants;
import com.hungit.controller.BaseApiController;
import com.hungit.dto.CategoryDTO;
import com.hungit.entity.Category;
import com.hungit.repository.CategoryRepository;
import com.hungit.service.CategoriesService;

/**
 * @author Kashiwagi
 *
 */
@RestController
public class CategoryApiController extends BaseApiController {

	@Autowired
	CategoriesService categoriesService;

//	@RequestMapping(value = ApiConstants.LIST_CATEGORIES, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//	public ResponseEntity<List<Category>> listCategories() {
//
//		List<Category> categories = categoriesService.findAll();
//		if (categories.isEmpty()) {
//			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
//			// You many decide to return HttpStatus.NOT_FOUND
//		}
//		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
//
//	}

	@RequestMapping(value = ApiConstants.LIST_CATEGORIES, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String listCategories() throws JsonProcessingException {

		List<Category> categories = categoriesService.findAll();

		return writeObjectToJson(new StatusResponse<>(HttpStatus.OK.value(), categories));

	}

	@RequestMapping(value = ApiConstants.SHOW_CATEGORIES, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String showCategories(@PathVariable("id") Long id) throws JsonProcessingException {

		Category categories = categoriesService.findOne(id);

		return writeObjectToJson(new StatusResponse<>(HttpStatus.OK.value(), new CategoryDTO(categories)));

	}

}
