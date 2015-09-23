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
		List<Category> categoryList = categoryDao.getCategories();
		if(categoryList!=null & categoryList.size()!=0) {
			int topPriority = categoryList.get(categoryList.size()-1).getPriority();
			category.setPriority(topPriority+1);
		}
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
		resortPeriority();
	}
	
	public void resortPeriority() {
		List<Category> categoryList = categoryDao.getCategories();
		int count = 0;
		for (Category category : categoryList) {
			category.setPriority(count++);
			categoryDao.updateCategory(category);
		}
	}

	@Override
	public void upPriority(int categoryId) {
		Category category = categoryDao.getCategory(categoryId);
		List<Category> categoryList = categoryDao.getCategories();
		for (Category loopCategory : categoryList) {
			if(loopCategory.getPriority()-category.getPriority() == 1) {
				category.setPriority(category.getPriority() + 1);
				loopCategory.setPriority(loopCategory.getPriority() - 1);
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
			if(category.getPriority() - loopCategory.getPriority()== 1) {
				category.setPriority(category.getPriority() - 1);
				loopCategory.setPriority(loopCategory.getPriority() + 1);
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
	public void downPostCount(int categoryId) {
		categoryDao.downPostCount(categoryId);
		
	}

	@Override
	public void deleteAll() {
		categoryDao.deleteAll();
	}

}
