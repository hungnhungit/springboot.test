/**
 * 
 */
package com.hungit.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungit.entity.Post;
import com.hungit.property.FileStorageProperties;
import com.hungit.repository.PostRepository;
import com.hungit.service.PostService;
import com.hungit.util.FileUtil;

/**
 * @author Kashiwagi
 *
 */
@Service
public class PostServiceImp implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	FileStorageProperties fileStorageProperties;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#findOne(long)
	 */
	@Override
	public Post findOne(long id) {
		return postRepository.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#findAll()
	 */
	@Override
	public List<Post> findAll() {
		return (List<Post>) postRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#create(java.io.Serializable)
	 */
	@Override
	public Post create(Post entity) {
		return postRepository.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#update(java.io.Serializable)
	 */
	@Override
	public Post update(Post entity) {
		return postRepository.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Post entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#deleteById(long)
	 */
	@Override
	public void deleteById(long entityId) {
		Post post = findOne(entityId);
		String fileDelete = fileStorageProperties.getUploadDir().toString() + "/" + post.getImage();
		FileUtil.deleteFile(fileDelete);
		postRepository.delete(post);
		;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
