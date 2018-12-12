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
			final String postList = "post.index";
			final String postCreate = "post.create";
			final String postEdit = "post.edit";
			final String redirectPost = "redirect:/posts";
		}
	}
	
}
