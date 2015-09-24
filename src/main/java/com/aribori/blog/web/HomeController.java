package com.aribori.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aribori.blog.service.CategoryService;
import com.aribori.blog.service.PostService;
import com.aribori.blog.service.TagService;
import com.aribori.common.lib.ListContainer;

@Controller
public class HomeController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TagService tagService;
	
	@RequestMapping(value="/")
	public String home (Model model) {
		ListContainer container = postService.getPosts(1, 5, 5);
		model.addAttribute("listContainer", container);
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("allTags", tagService.getTags());
		return "blog/home";
	}
}
