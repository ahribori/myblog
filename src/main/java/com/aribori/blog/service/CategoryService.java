package com.aribori.blog.service;

import java.util.List;

import com.aribori.blog.domain.Category;

public interface CategoryService {
	
	public Category insertCategory(Category category);

	public Category getCategory(int categoryId);

	public List<Category> getCategories();

	public void deleteCategory(int categoryId);

	public void upPriority(int categoryId);
	
	public void downPriority(int categoryId);

	public void upPostCount(int categoryId);

	public void downPostCount(int categoryId);

	public void deleteAll();

	
}
