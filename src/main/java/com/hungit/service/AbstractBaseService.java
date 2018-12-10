package com.hungit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBaseService {

	@PersistenceContext
	protected EntityManager entityManager;

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	protected <T> List<T> QueryBuilder(String query){
		return null;
	} 
}
