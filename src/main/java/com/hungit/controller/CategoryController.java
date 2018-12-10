/**
 * 
 */
package com.hungit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.hungit.constants.SystemConstant;
import com.hungit.entity.Category;
import com.hungit.form.CategoryForm;
import com.hungit.service.CategoriesService;
import com.hungit.util.NumberUtil;
import com.hungit.util.StringUtil;

/**
 * @author Kashiwagi
 *
 */
@Controller
@RequestMapping(value = "categories")
public class CategoryController extends BaseController {

	@Autowired
	CategoriesService categoriesService;

	/**
	 * index
	 * 
	 * @param search
	 * @return view
	 */
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(value = "q", defaultValue = "") String search,
			@RequestParam(value = "page", defaultValue = "1") int page) {

		int page_number = page < 0 ? 1 : page;
		ModelAndView mv = new ModelAndView(ControllerConstants.Tiles.Categories.categoriesList);
		Page<Category> categories = categoriesService
				.findAllByPage(PageRequest.of(page_number - 1, SystemConstant.PAGE_SIZE), search);
		mv.addObject("categories", categories);
		return mv;
	}

	/**
	 * create
	 * 
	 * @return view
	 */
	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView(ControllerConstants.Tiles.Categories.categoriesCreate);
		mv.addObject("categoryForm", new CategoryForm());
		mv.addObject("parents", categoriesService.findAll());
		return mv;
	}

	/**
	 * store
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = { "/store" }, method = RequestMethod.POST)
	public String store(@Valid CategoryForm categoryForm, BindingResult result) {

//		if (result.hasErrors()) {
//			ModelAndView mv = new ModelAndView("categoriesCreatePage");
//			mv.addObject("parents", categoriesService.findAll());
//			return "categoriesCreatePage";
//		}

		categoriesService.create(convertToCategory(categoryForm));

		return ControllerConstants.Tiles.Categories.redirectCategories;
	}

	/**
	 * convertToCategory
	 * 
	 * @param categoryForm
	 * @return
	 */
	public Category convertToCategory(CategoryForm categoryForm) {
		Category category = new Category();
		category.setDescription(categoryForm.getDescription());
		category.setName(categoryForm.getName());
		if (categoryForm.getParentId() != null) {
			Category categoryParent = categoriesService.findOne(categoryForm.getParentId());
			category.setParentId(categoryParent);
		}
		category.setPosition(categoryForm.getPosition());
		category.setStatus(categoryForm.getStatus());
		return category;
	}

	/**
	 * edit
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") String id) {

		if (!NumberUtil.isNumber(id)) {
			return new ModelAndView(ControllerConstants.Tiles.Categories.redirectCategories);
		}

		ModelAndView mv = new ModelAndView(ControllerConstants.Tiles.Categories.categoriesEdit);
		mv.addObject("categoryForm", categoriesService.findOne(NumberUtil.parseLong(id)));
		mv.addObject("parents", categoriesService.findAll());
		return mv;
	}

	/**
	 * update
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public String update(Category category) {
		Category categoryUpdate = categoriesService.findOne(category.getId());

		Category parentCategory = categoriesService.findOne(category.getParentId().getId());
		
		categoryUpdate.setDescription(category.getDescription());
		categoryUpdate.setName(category.getName());
		categoryUpdate.setParentId(parentCategory);
		categoryUpdate.setPosition(category.getPosition());
		categoryUpdate.setStatus(category.getStatus());
		categoriesService.update(categoryUpdate);
		return ControllerConstants.Tiles.Categories.redirectCategories;
	}

	/**
	 * delete
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {

		if (!NumberUtil.isNumber(id)) {
			return ControllerConstants.Tiles.Categories.redirectCategories;
		}

		categoriesService.deleteById(NumberUtil.parseLong(id));
		return ControllerConstants.Tiles.Categories.redirectCategories;
	}
}
