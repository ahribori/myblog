package com.aribori.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aribori.blog.service.PostService;
import com.aribori.common.lib.ListContainer;

@Controller
public class HomeController {
	
	@Autowired
	PostService postService;
	
	
	@RequestMapping(value="/")
	public String index() {
		return "redirect:/home";
	}
	
	@RequestMapping(value="/home")
	public String home (Model model) {
		ListContainer container = postService.getPosts(1, 5, 5);
		model.addAttribute("listContainer", container);
		return "blog/home";
	}
}
