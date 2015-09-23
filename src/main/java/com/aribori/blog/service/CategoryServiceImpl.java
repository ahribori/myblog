package com.aribori.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aribori.blog.dao.CategoryDao;
import com.aribori.blog.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category insertCategory(Category category) {
		return categoryDao.insertCategory(category);
	}

	@Override
	public Category getCategory(int categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryDao.deleteCategory(categoryId);
	}

	@Override
	public void upPriority(int categoryId) {
		Category category = categoryDao.getCategory(categoryId);
		List<Category> categoryList = categoryDao.getCategories();
		for (Category loopCategory : categoryList) {
			if(category.getPriority() < loopCategory.getPriority()) {
				category.setPriority(category.getPriority() + 1);
				loopCategory.setPriority(loopCategory.getPriority() -1);
				categoryDao.updateCategory(category);
				categoryDao.updateCategory(loopCategory);
				break;
			}
		}
	}

	@Override
	public void downPriority(int categoryId) {
		Category category = categoryDao.getCategory(categoryId);
		List<Category> categoryList = categoryDao.getCategories();
		for (Category loopCategory : categoryList) {
			if(category.getPriority() > loopCategory.getPriority()) {
				category.setPriority(category.getPriority() - 1);
				loopCategory.setPriority(loopCategory.getPriority() +1);
				categoryDao.updateCategory(category);
				categoryDao.updateCategory(loopCategory);
				break;
			}
		}
	}

	@Override
	public void upPostCount(int categoryId) {
		categoryDao.upPostCount(categoryId);
	}

	@Override
	public void deleteAll() {
		categoryDao.deleteAll();
	}

}
