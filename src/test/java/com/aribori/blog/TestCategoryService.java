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

import com.aribori.blog.service.CategoryService;
import com.aribori.blog.dao.CategoryDao;
import com.aribori.blog.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class TestCategoryService {

	@Autowired
	private CategoryService categoryService;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	Category category = new Category("테스트 카테고리", 1, "cloud");
	
	/**
	 * 각 단위테스트 실행 전 categoryService 오브젝트가 살아있는지 체크하고,
	 * Test를 위한 Category Object를 DB에 저장한다.
	 */
	@Before
	public void setUp() {
		assertNotNull(categoryService);
		log.debug("setUp");
		
		// Insert Category
		this.insertCategory();
	}
	
	public void insertCategory() {
		category = categoryService.insertCategory(category);
		assertThat(category.getCategoryId(), greaterThan(0));
		log.debug("insertCategory");
	}
	
	@After
	public void deleteAll() {
		categoryService.deleteAll();
		log.debug("truncate table");
	}

	@Test
	public void testGetCategory() {
		category = categoryService.getCategory(category.getCategoryId());
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
		List<Category> categoryList = categoryService.getCategories();
		assertNotNull(categoryList);
		assertThat(categoryList.size(), greaterThan(0));
		for (Category category : categoryList) {
			log.info("{}", category);
		}
		
	}
	
	@Test
	public void testDeleteCategory() {
		categoryService.deleteCategory(category.getCategoryId());
		assertNull(categoryService.getCategory(category.getCategoryId()));
		log.info("delete category success.");
	}
	
	@Test
	public void testUpPostCount() {
		category = categoryService.getCategory(category.getCategoryId());
		int beforeCount = category.getPostCount();
		categoryService.upPostCount(category.getCategoryId());
		category = categoryService.getCategory(category.getCategoryId());
		int afterCount = category.getPostCount();
		assertThat(afterCount, greaterThan(beforeCount));
	}
	
	@Test
	public void testDownPostCount() {
		category = categoryService.getCategory(category.getCategoryId());
		int beforeCount = category.getPostCount();
		categoryService.downPostCount(category.getCategoryId());
		category = categoryService.getCategory(category.getCategoryId());
		int afterCount = category.getPostCount();
		assertThat(beforeCount, greaterThan(afterCount));
	}
	
	@Test
	public void testUpPriority() {
		for (int i = 0; i < 1; i++) {
			category.setName(category.getName()+"I");
			category.setPriority(category.getPriority()+1);
			this.insertCategory();
		}
		
		int before_priority1 = categoryService.getCategory(1).getPriority();
		int before_priority2 = categoryService.getCategory(2).getPriority();
		
		assertThat(before_priority2, greaterThan(before_priority1));
		
		categoryService.upPriority(1);
		
		int after_priority1 = categoryService.getCategory(1).getPriority();
		int after_priority2 = categoryService.getCategory(2).getPriority();

		assertThat(after_priority1, greaterThan(after_priority2));
		
		assertEquals(before_priority2, after_priority1);
		assertEquals(before_priority1, after_priority2);
	}
	
	@Test
	public void testDownPriority() {
		for (int i = 0; i < 1; i++) {
			category.setName(category.getName()+"I");
			category.setPriority(category.getPriority()+1);
			this.insertCategory();
		}
		
		int before_priority1 = categoryService.getCategory(1).getPriority();
		int before_priority2 = categoryService.getCategory(2).getPriority();
		
		assertThat(before_priority2, greaterThan(before_priority1));
		
		categoryService.downPriority(2);
		
		int after_priority1 = categoryService.getCategory(1).getPriority();
		int after_priority2 = categoryService.getCategory(2).getPriority();

		assertThat(after_priority1, greaterThan(after_priority2));
		
		assertEquals(before_priority2, after_priority1);
		assertEquals(before_priority1, after_priority2);
	}
	
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	public void resortPriority() {
		// 이거 테스트 다하고 test.xml 바꿔야댐
		List<Category> categoryList = categoryService.getCategories();
		int count = 0;
		for (Category category : categoryList) {
			int p = category.getPriority();
			System.out.println(p);
			category.setPriority(count++);
			categoryDao.updateCategory(category);
		}
		System.out.println("--------------");
		categoryList = categoryService.getCategories();
		for (Category category : categoryList) {
			System.out.println(category);
		}
	}
	
}
