/**
 * 
 */
package com.hungit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hungit.entity.Product;

/**
 * @author Kashiwagi
 *
 */
public interface ProductRepository
		extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	Product findById(@Param("id") Integer id);

	List<Product> findByName(@Param("name") String name);

	List<Product> findByNameLike(@Param("name") final String name);
}
