/**
 * 
 */
package com.hungit.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hungit.api.response.StatusResponse;
import com.hungit.constants.ApiConstants;
import com.hungit.controller.BaseApiController;
import com.hungit.dto.DTOEntity;
import com.hungit.dto.PostDTO;
import com.hungit.service.PostService;
import com.hungit.util.DtoUtils;

/**
 * @author Kashiwagi
 *
 */
@RestController
public class PostApiController extends BaseApiController {

	@Autowired
	PostService postService;

	@RequestMapping(value = ApiConstants.LIST_POSTS, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String listPosts() throws JsonProcessingException {

		List<DTOEntity> postDTO = postService.findAll().stream().map(post -> DtoUtils.convertToDto(post, new PostDTO()))
				.collect(Collectors.toList());

		return writeObjectToJson(new StatusResponse<>(HttpStatus.OK.value(), postDTO));

	}

}
