package com.hungit.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hungit.common.IOperations;
import com.hungit.entity.Category;

public interface CategoriesService extends IOperations<Category> {
	List<Category> all();

	List<Category> findWidthName(String name, int offset, int size);

	Page<Category> findAllByPage(Pageable pageable, String name);
	
	Set<Category> getSubCategories(long id);
	
}
