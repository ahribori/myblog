package com.aribori.blog.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aribori.blog.domain.Category;
import com.aribori.blog.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	public void addGlobalAttribute(Model model){
		model.addAttribute("categories", categoryService.getCategories());
	}
	
	@RequestMapping(value="/category/config")
	public String categoryConfig(Category category, Model model) {
		addGlobalAttribute(model);
		return "blog/category";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String insertCategory(@Valid Category category, BindingResult result, Model model) {
		addGlobalAttribute(model);
		if(result.hasErrors()) 
			return "blog/category";
		categoryService.insertCategory(category);
		return "redirect:/category/config";
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.DELETE)
	public String deleteCategory(@PathVariable int id, Model model) {
		categoryService.deleteCategory(id);
		return "redirect:/category/config";
	}
	
	@RequestMapping(value="/category/up", method=RequestMethod.PUT)
	public String categoryUp(int categoryId, Model model) {
		categoryService.upPriority(categoryId);
		return "redirect:/category/config";
	}

	@RequestMapping(value="/category/down", method=RequestMethod.PUT)
	public String categoryDown(int categoryId, Model model) {
		categoryService.downPriority(categoryId);
		return "redirect:/category/config";
	}
}
