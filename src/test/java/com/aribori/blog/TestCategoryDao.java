package com.aribori.blog;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aribori.blog.dao.CategoryDao;
import com.aribori.blog.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class TestCategoryDao {

	@Autowired
	private CategoryDao categoryDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	Category category = new Category("테스트 카테고리", 1, "cloud");
	
	/**
	 * 각 단위테스트 실행 전 categoryDao 오브젝트가 살아있는지 체크하고,
	 * Test를 위한 Category Object를 DB에 저장한다.
	 */
	@Before
	public void setUp() {
		assertNotNull(categoryDao);
		log.debug("setUp");
		
		// Insert Category
		this.insertCategory();
	}
	
	public void insertCategory() {
		category = categoryDao.insertCategory(category);
		assertThat(category.getCategoryId(), greaterThan(0));
		log.debug("insertCategory");
	}
	
	@After
	public void deleteAll() {
		categoryDao.deleteAll();
		log.debug("truncate table");
	}

	@Test
	public void testGetCategory() {
		category = categoryDao.getCategory(category.getCategoryId());
		assertNotNull(category);
		log.debug("{}", category);
		
	}
	
	@Test
	public void testGetCategories() {
		for (int i = 0; i < 10; i++) {
			category.setName(category.getName()+"I");
			category.setPriority(category.getPriority()+1);
			this.insertCategory();
		}
		List<Category> categoryList = categoryDao.getCategories();
		assertNotNull(categoryList);
		assertThat(categoryList.size(), greaterThan(0));
		for (Category category : categoryList) {
			log.info("{}", category);
		}
		
	}
	
	@Test
	public void testUpdateCategory() {
		int beforePriority = category.getPriority();
		category.setPriority(beforePriority + 1);
		categoryDao.updateCategory(category);
		category = categoryDao.getCategory(category.getCategoryId());
		assertThat(category.getPriority(), greaterThan(beforePriority));
		log.info("{}", category);
	}
	
	@Test
	public void testDeleteCategory() {
		categoryDao.deleteCategory(category.getCategoryId());
		assertNull(categoryDao.getCategory(category.getCategoryId()));
		log.info("delete category success.");
	}
	
	@Test
	public void testUpPostCount() {
		category = categoryDao.getCategory(category.getCategoryId());
		int beforeCount = category.getPostCount();
		categoryDao.upPostCount(category.getCategoryId());
		category = categoryDao.getCategory(category.getCategoryId());
		int afterCount = category.getPostCount();
		assertThat(afterCount, greaterThan(beforeCount));
	}
	
	@Test
	public void testDownPostCount() {
		category = categoryDao.getCategory(category.getCategoryId());
		int beforeCount = category.getPostCount();
		categoryDao.downPostCount(category.getCategoryId());
		category = categoryDao.getCategory(category.getCategoryId());
		int afterCount = category.getPostCount();
		assertThat(beforeCount, greaterThan(afterCount));
	}
}
