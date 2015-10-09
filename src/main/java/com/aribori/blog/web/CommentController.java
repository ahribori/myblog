package com.aribori.blog.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aribori.blog.domain.Comment;
import com.aribori.blog.domain.Post;
import com.aribori.blog.exception.AuthenticateFailureException;
import com.aribori.blog.service.CategoryService;
import com.aribori.blog.service.CommentService;
import com.aribori.blog.service.PostService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	public void addGlobalAttribute(Model model){
		model.addAttribute("categories", categoryService.getCategories());
	}
	
	@RequestMapping(value = "/post/{id}/comment", method = RequestMethod.POST)
	public String insertComment(@PathVariable String id, Model model, @Valid Comment comment, 
			BindingResult result,HttpServletRequest request, HttpSession session) {
		if(result.hasErrors()) {
			if (id != null) {
				try {
					int postId = Integer.parseInt(id);
					Post post =  postService.getPostNoHits(postId);
					if(post != null) {
						model.addAttribute("post", post);
						model.addAttribute("comments", commentService.getComments(postId));
					}
					else 
						return "redirect:/";
				} catch (NumberFormatException e) {
					return "redirect:/";
				}
			}
			addGlobalAttribute(model);
			return "blog/post";
		}
		
		if(id!=null) {
			comment.setIpAddr(request.getRemoteAddr());
			comment.setPostId(Integer.parseInt(id));
		}
		
		if(session != null && session.getAttribute("session_comment") != null) {
			Comment sessionComment = (Comment) session.getAttribute("session_comment");
			if(!comment.getIpAddr().equals(sessionComment.getIpAddr())) {
				commentService.insertComment(comment);
			}
		} else {
			commentService.insertComment(comment);
		}
		session.setAttribute("session_comment", comment);
		
		return "redirect:/post/" + id; 
	}
	
	@ResponseBody
	@RequestMapping(value = "/post/{id}/comment", method = RequestMethod.GET)
	public List<Comment> getComments(@PathVariable String id) {
		int postId = 0;
		if (id != null) {
			postId = Integer.parseInt(id);
		}
		return commentService.getComments(postId);
	}
	
	@RequestMapping(value = "post/{id}/comment/{commentId}", method = RequestMethod.PUT)
	public String updateComment (@PathVariable String id, @PathVariable String commentId, 
			Comment comment, Model model) {
		try {
			commentService.updateComment(comment);
		} catch (AuthenticateFailureException e) {
			model.addAttribute("exception", e.getMessage());
			return "/blog/exception";
		}
		return "redirect:/post/" + id;
	}
	
	@RequestMapping(value = "post/{id}/comment/{commentId}", method = RequestMethod.DELETE)
	public String deleteComment (@PathVariable String id, @PathVariable String commentId, 
			Comment comment, Model model) {
		try {
			commentService.deleteComment(comment);
		} catch (AuthenticateFailureException e) {
			model.addAttribute("exception", e.getMessage());
			return "/blog/exception";
		}
		return "redirect:/post/" + id;
	}
}
