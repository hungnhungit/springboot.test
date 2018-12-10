/**
 * 
 */
package com.hungit.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hungit.entity.Post;

/**
 * @author Kashiwagi
 *
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

}
