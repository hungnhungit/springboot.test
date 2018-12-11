/**
 * 
 */
package com.hungit.controller;

import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.hungit.constants.ApiConstants;
import com.hungit.dto.DTOEntity;
import com.hungit.dto.PostDTO;
import com.hungit.entity.Post;

/**
 * @author Kashiwagi
 *
 */
public class BaseApiController {

	public final static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setDateFormat(new SimpleDateFormat(ApiConstants.API_FORMAT_DATE));
	}

	protected String writeObjectToJson(Object obj) throws JsonProcessingException {

		return mapper.writeValueAsString(obj);

	}

}
