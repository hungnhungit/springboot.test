/**
 * 
 */
package com.hungit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hungit.constants.SystemConstant;
import com.hungit.entity.Category;

/**
 * @author Kashiwagi
 *
 */

@Controller
@RequestMapping(name = "posts")
public class PostController extends BaseController {

	
	/**
	 * index
	 * 
	 * @param search
	 * @return view
	 */
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(@RequestParam(value = "q", defaultValue = "") String search,
			@RequestParam(value = "page", defaultValue = "1") int page, HttpServletRequest request) {

		return "index";
	}

}
