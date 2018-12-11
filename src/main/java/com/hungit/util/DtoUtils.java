/**
 * 
 */
package com.hungit.util;

import org.modelmapper.ModelMapper;

import com.hungit.dto.DTOEntity;

/**
 * @author Kashiwagi
 *
 */
public final class DtoUtils {

	public static DTOEntity convertToDto(Object entity, DTOEntity mapper) {
		return new ModelMapper().map(entity, mapper.getClass());
	}

}
