/**
 * 
 */
package com.hungit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hungit.entity.Post;
import com.hungit.form.CategoryForm;
import com.hungit.service.CategoriesService;
import com.hungit.service.PostService;
import com.hungit.support.MessageHelper;
import com.hungit.util.NumberUtil;

/**
 * @author Kashiwagi
 *
 */
@Controller
@RequestMapping(value = "posts")
public class PostController extends BaseController {

	@Autowired
	PostService postService;

	@Autowired
	CategoriesService categoriesService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("post.index");
		mv.addObject("posts", postService.findAll());
		return mv;
	}

	/**
	 * create
	 * 
	 * @return view
	 */
	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("post.create");
		mv.addObject("postForm", new Post());
		mv.addObject("parents", categoriesService.findAll());
		return mv;
	}

	/**
	 * store
	 * 
	 * @return view
	 */
	@RequestMapping(value = { "/store" }, method = RequestMethod.POST)
	public String store(@ModelAttribute("postForm") @Valid Post post, BindingResult result, Model model,
			RedirectAttributes ra) {

		if (result.hasErrors()) {
			result.getAllErrors().forEach(err -> {
				LOGGER.info("ERROR {}", err.getDefaultMessage());
			});
			model.addAttribute("parents", categoriesService.findAll());
			return "post.create";
		}

		if (postService.create(post) != null) {
			MessageHelper.addSuccessAttribute(ra, "Create success", "");
		} else {
			MessageHelper.addSuccessAttribute(ra, "Create fail", "");
		}

		return ControllerConstants.Tiles.Post.redirectPost;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id, RedirectAttributes ra) {

		if (!NumberUtil.isNumber(id)) {
			return ControllerConstants.Tiles.Post.redirectPost;
		}

		postService.deleteById(NumberUtil.parseLong(id));

		MessageHelper.addSuccessAttribute(ra, "Delete success", "");

		return ControllerConstants.Tiles.Post.redirectPost;
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
			return new ModelAndView(ControllerConstants.Tiles.Post.redirectPost);
		}

		ModelAndView mv = new ModelAndView(ControllerConstants.Tiles.Categories.categoriesEdit);
		mv.addObject("postForm", postService.findOne(NumberUtil.parseLong(id)));
		mv.addObject("parents", categoriesService.findAll());
		return mv;
	}

}
