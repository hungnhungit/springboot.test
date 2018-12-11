/**
 * 
 */
package com.hungit.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hungit.entity.Post;

/**
 * @author Kashiwagi
 *
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

	Post findById(@Param("id") long id);
}
