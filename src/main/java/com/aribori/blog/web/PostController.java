package com.aribori.blog.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aribori.blog.domain.Post;
import com.aribori.blog.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/")
	public String home () {
		return "blog/home";
	}
	
	/*
	@RequestMapping(value="/post/{postId}")
	public Post getPost(@PathVariable int postId, 
			@CookieValue(value = "getPostLog", required = false) Cookie cookie, 
			HttpServletResponse response) {
		return postService.getPost(postId, cookie, response);
	}
	*/
	
}
