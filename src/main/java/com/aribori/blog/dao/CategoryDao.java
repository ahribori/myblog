package com.aribori.blog.dao;

import java.util.List;

import com.aribori.blog.domain.Category;

public interface CategoryDao {

	public Category insertCategory(Category category);

	public Category getCategory(int categoryId);

	public List<Category> getCategories();

	public void updateCategory(Category category);

	public void deleteCategory(int categoryId);

	public void upPostCount(int categoryId);

	public void downPostCount(int categoryId);

	public void deleteAll();



}
