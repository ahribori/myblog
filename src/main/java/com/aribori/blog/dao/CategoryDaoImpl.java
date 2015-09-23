package com.aribori.blog.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.blog.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Category insertCategory(Category category) {
		sqlSessionTemplate.insert("category.insertCategory", category);
		return category;
	}

	@Override
	public Category getCategory(int categoryId) {
		return sqlSessionTemplate.selectOne("category.getCategory", categoryId);
	}

	@Override
	public List<Category> getCategories() {
		return sqlSessionTemplate.selectList("category.getCategories");
	}

	@Override
	public void updateCategory(Category category) {
		sqlSessionTemplate.update("category.updateCategory", category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		sqlSessionTemplate.delete("category.deleteCategory", categoryId);
	}

	@Override
	public void upPostCount(int categoryId) {
		sqlSessionTemplate.update("category.upPostCount", categoryId);
	}

	@Override
	public void downPostCount(int categoryId) {
		sqlSessionTemplate.update("category.downPostCount", categoryId);
	}
	
	@Override
	public void deleteAll() {
		sqlSessionTemplate.delete("category.deleteAll");
	}
	
}
