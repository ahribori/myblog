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
import com.aribori.blog.dao.PostDao;
import com.aribori.blog.domain.Category;
import com.aribori.blog.domain.Post;
import com.aribori.common.lib.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class TestPostDao {

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	Post post = new Post("제목", "글쓴이", "컨텐츠");
	Category category = new Category("테스트 카테고리", 0, "cloud");
	
	/**
	 * 각 단위테스트 실행 전 postDao 오브젝트가 살아있는지 체크하고,
	 * Test를 위한 Post Object를 DB에 저장한다.
	 */
	@Before
	public void setUp() {
		assertNotNull(postDao);
		log.debug("setUp");
		
		//this.insertCategory();
		//post.setCategoryId(1);
		//this.insertPost();
	}
	
	public void insertCategory() {
		category = categoryDao.insertCategory(category);
		assertThat(category.getCategoryId(), greaterThan(0));
		log.debug("insertPost");
	}
	
	public void insertPost() {
		post = postDao.insertPost(post);
		assertThat(post.getPostId(), greaterThan(0));
		log.debug("insertPost");
	}
	
	@After
	public void deleteAll() {
		//postDao.deleteAll();
		//categoryDao.deleteAll();
		//log.debug("truncate table");
	}

	@Test
	public void testGetPost() {
		post = postDao.getPost(post.getPostId());
		assertNotNull(post);
		log.debug("{}", post);
		
	}
	
	@Test
	public void testGetTotalCount() {
		int totalCount = postDao.getTotalCount();
		assertThat(totalCount, greaterThan(0));
		log.info("totalCount = {}", totalCount);
	}
	
	@Test
	public void testGetTotalCountByTag() {
		int totalCount = postDao.getTotalCountByTag(1);
		assertThat(totalCount, greaterThan(0));
		log.info("totalCount = {}", totalCount);
	}
	
	@Test
	public void testGetPosts() {
		for (int i = 0; i < 30; i++) {
			this.insertPost();
		}
		Page page = new Page(postDao.getTotalCount());
		List<Post> postList = postDao.getPosts(page);
		assertNotNull(postList);
		assertThat(postList.size(), greaterThan(0));
		for (Post post : postList) {
			log.debug("{}", post);
		}
		
	}
	
	@Test
	public void testGetPostsByTag() {
		Page page = new Page(postDao.getTotalCountByTag(1));
		List<Post> postList = postDao.getPostsByTag(1, page);
		for (Post post : postList) {
			log.debug("{}", post);
		}
		
	}
	
	@Test
	public void testUpdatePost() {
		int beforeHits = post.getHits();
		post.setHits(beforeHits + 1);
		postDao.updatePost(post);
		System.out.println(post);
		post = postDao.getPost(post.getPostId());
		assertThat(post.getHits(), greaterThan(beforeHits));
		log.info("{}", post);
	}
	
	@Test
	public void testDeletePost() {
		postDao.deletePost(post.getPostId());
		assertNull(postDao.getPost(post.getPostId()));
		log.info("delete post success.");
	}
	
	@Test
	public void testUpHits() {
		post = postDao.getPost(post.getPostId());
		int beforeHits = post.getHits();
		postDao.upHits(post.getPostId());
		post = postDao.getPost(post.getPostId());
		int afterHits = post.getHits();
		assertThat(afterHits, greaterThan(beforeHits));
	}
}
