/**
 * 
 */
package com.hungit.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hungit.constants.SystemConstant;
import com.hungit.entity.Category;
import com.hungit.form.CategoryForm;
import com.hungit.service.CategoriesService;
import com.hungit.support.MessageHelper;
import com.hungit.util.NumberUtil;

/**
 * @author Kashiwagi
 *
 */
@Controller
@RequestMapping(value = "categories")
@Secured("hasRole('ROLE_ADMIN')")
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
			@RequestParam(value = "page", defaultValue = "1") int page, HttpServletRequest request) {

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
	public String store(@Valid CategoryForm categoryForm, BindingResult result, RedirectAttributes ra, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("parents", categoriesService.findAll());
			return "categoriesCreatePage";
		}

		if (categoriesService.create(convertToCategory(categoryForm)) != null) {
			MessageHelper.addSuccessAttribute(ra, "Create success", "");
		} else {
			MessageHelper.addSuccessAttribute(ra, "Create fail", "");
		}

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
	public String update(Category category, RedirectAttributes ra) {
		Category categoryUpdate = categoriesService.findOne(category.getId());

		if (category.getParentId().getId() != null) {
			Category parentCategory = categoriesService.findOne(category.getParentId().getId());
			categoryUpdate.setParentId(parentCategory);
		}
		categoryUpdate.setDescription(category.getDescription());
		categoryUpdate.setName(category.getName());
		categoryUpdate.setPosition(category.getPosition());
		categoryUpdate.setStatus(category.getStatus());
		categoriesService.update(categoryUpdate);

		MessageHelper.addSuccessAttribute(ra, "Update success", "");

		return ControllerConstants.Tiles.Categories.redirectCategories;
	}

	/**
	 * delete
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id, RedirectAttributes ra) {

		if (!NumberUtil.isNumber(id)) {
			return ControllerConstants.Tiles.Categories.redirectCategories;
		}

		categoriesService.deleteById(NumberUtil.parseLong(id));

		MessageHelper.addSuccessAttribute(ra, "Delete success", "");

		return ControllerConstants.Tiles.Categories.redirectCategories;
	}
}
