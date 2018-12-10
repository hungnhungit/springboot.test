package com.hungit.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hungit.entity.Category;
import com.hungit.repository.CategoryRepository;
import com.hungit.util.StringUtil;

/**
 * 
 * @author Kashiwagi
 *
 */
@Service
public class CategoriesServiceImpl extends AbstractBaseService implements CategoriesService {

	@Autowired
	CategoryRepository categoryRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#findOne(long)
	 */
	public Category findOne(long id) {
		return categoryRepository.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#findAll()
	 */
	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#create(java.io.Serializable)
	 */
	public Category create(Category entity) {
		return categoryRepository.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#update(java.io.Serializable)
	 */
	public Category update(Category entity) {
		return categoryRepository.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#delete(java.io.Serializable)
	 */
	public void delete(Category entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#deleteById(long)
	 */
	public void deleteById(long entityId) {
		categoryRepository.deleteById(entityId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.common.IOperations#deleteAll()
	 */
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.service.CategoriesService#all()
	 */
	public List<Category> all() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
		Root<Category> personRoot = criteria.from(Category.class);
		criteria.select(personRoot);
		List<Category> category = entityManager.createQuery(criteria).getResultList();
		return category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.service.CategoriesService#findWidthName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Category> findWidthName(String name, int offset, int page_size) {
		// TODO Auto-generated method stub
		return (List<Category>) entityManager.createQuery("SELECT c FROM Category c WHERE c.name LIKE ?1")
				.setParameter(1, "%" + name + "%").setFirstResult(offset).setMaxResults(page_size).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hungit.service.CategoriesService#findAllByPage(org.springframework.data.
	 * domain.Pageable)
	 */
	public Page<Category> findAllByPage(Pageable pageable, String search) {
		if (StringUtil.isEmpty(search)) {
			return categoryRepository.findAll(pageable);
		}
		return categoryRepository.findAll(pageable, "%" + search + "%");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hungit.service.CategoriesService#findWidthName(java.lang.String)
	 */

}
