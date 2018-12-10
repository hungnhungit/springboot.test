package com.hungit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hungit.entity.Category;

public interface CategoryRepository
		extends PagingAndSortingRepository<Category, Long>, JpaSpecificationExecutor<Category> {

	Category findById(@Param("id") long id);

	@Query("SELECT c FROM Category c WHERE c.name LIKE :search")
	Page<Category> findAll(Pageable pageable, @Param("search") String search);

	Page<Category> findAll(Pageable pageable);

}
