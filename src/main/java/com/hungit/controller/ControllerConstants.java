/**
 * 
 */
package com.hungit.controller;

/**
 * @author Kashiwagi
 *
 */
public interface ControllerConstants {

	interface Tiles {
		interface Categories{
			final String categoriesList = "categoriesPage";
			final String categoriesCreate = "categoriesCreatePage";
			final String categoriesEdit = "categoriesEditPage";
			final String redirectCategories = "redirect:/categories";
		}
		
		interface Post{
			final String postList = "categoriesPage";
			final String postCreate = "categoriesCreatePage";
			final String postEdit = "categoriesEditPage";
			final String redirectPost = "redirect:/posts";
		}
	}
	
}
