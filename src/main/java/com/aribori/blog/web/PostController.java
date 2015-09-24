package com.aribori.blog.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.aribori.blog.domain.Post;
import com.aribori.blog.service.CategoryService;
import com.aribori.blog.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	public void addGlobalAttribute(Model model){
		model.addAttribute("categories", categoryService.getCategories());
	}

	@RequestMapping(value="/post/{id}", method=RequestMethod.GET)
	public String getPost(@PathVariable String id, Model model,
			@CookieValue(value = "getPostLog", required = false) Cookie cookie, 
			HttpServletResponse response) {
		if (id != null) {
			try {
				int postId = Integer.parseInt(id);
				model.addAttribute("post", postService.getPost(postId, cookie, response));
			} catch (NumberFormatException e) {
				return "redirect:/";
			}
		}
		addGlobalAttribute(model);
		return "blog/post";
	}
	
	@RequestMapping(value="category/{category_id}", method=RequestMethod.GET)
	public String getPostsByCategory(@PathVariable String category_id, Model model) {
		if(category_id!=null) {
			int currentPage = 1;
			int categoryId = Integer.parseInt(category_id);
			model.addAttribute("listContainer", postService.getPostsByCategory(currentPage, 5, 5, categoryId));
			model.addAttribute("category", categoryService.getCategory(categoryId));
		}
		addGlobalAttribute(model);
		return "blog/list";
	}
	
	@RequestMapping(value="category/{category_id}/page/{page}", method=RequestMethod.GET)
	public String getPostsByCategory(@PathVariable String category_id, @PathVariable String page, Model model) {
		if(category_id!=null) {
			int currentPage = 1;
			int categoryId = Integer.parseInt(category_id);
			if(page!=null) {
				currentPage = Integer.parseInt(page);
			}
			model.addAttribute("listContainer", postService.getPostsByCategory(currentPage, 5, 5, categoryId));
			model.addAttribute("category", categoryService.getCategory(categoryId));
		}
		addGlobalAttribute(model);
		return "blog/list";
	}
	
	@RequestMapping(value="/posts/{page}" )
	public String getPosts(@PathVariable String page, Model model) {
		if(page == null)
			model.addAttribute("listContainer", postService.getPosts(1));
		else
			model.addAttribute("listContainer", postService.getPosts(Integer.parseInt(page)));
		
		addGlobalAttribute(model);
		return "redirect:/";
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String insertPost(@Valid Post post, BindingResult result, Model model) {
		addGlobalAttribute(model);
		System.out.println(post.getTagString());
		if(result.hasErrors()) {
			return "blog/write";
		}
		//TODO 회원/관리자 구현 후에 이 라인 수정해야함
		post.setWriter("아리보리");
		postService.insertPost(post);
		categoryService.upPostCount(post.getCategoryId());
		return "redirect:/";
	}
	
	@RequestMapping(value="/post/{id}", method=RequestMethod.PUT)
	public String updatePost(@PathVariable String id, @Valid Post post, 
			BindingResult result, Model model) {
		
		addGlobalAttribute(model);
		if(result.hasErrors()) {
			return "blog/update";
		}
		
		if (id != null) {
			int postId = Integer.parseInt(id);
			post.setPostId(postId);
			postService.updatePost(postId, post);
		}
		return "redirect:/post/"+post.getPostId();
	}
	
	@RequestMapping(value="/post/{id}", method=RequestMethod.DELETE)
	public String deletePost(@PathVariable String id) {
		if (id != null) {
			int postId = Integer.parseInt(id);
			System.out.println(id);
			Post post = postService.getPostNoHits(postId);
			System.out.println(post);
			postService.deletePost(postId);
			categoryService.downPostCount(post.getCategoryId());
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/post/write", method=RequestMethod.POST)
	public String getWriteForm(Post post, Model model) {
		addGlobalAttribute(model);
		return "blog/write";
	}
	
	@RequestMapping(value="/post/update", method=RequestMethod.PUT)
	public String getUpdateForm(int postId, Post post, Model model) {
		model.addAttribute("post", postService.getPostNoHits(postId));
		addGlobalAttribute(model);
		return "blog/update";
	}
	
	@RequestMapping(value="/post/imageUpload", method=RequestMethod.POST)
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, 
			MultipartFile upload) {
		postService.imageUpload(request, response, upload);
	}
}
