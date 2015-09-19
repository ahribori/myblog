package com.hs9923.blog;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hs9923.blog.dao.PostDao;
import com.hs9923.blog.domain.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class PostDaoTest {

	@Autowired
	private PostDao postDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	Post post = new Post("제목", "부제목", "글쓴이", "컨텐츠");
	
	/**
	 * 각 단위테스트 실행 전 postDao 오브젝트가 살아있는지 체크하고,
	 * Test를 위한 Post Object를 DB에 저장한다.
	 */
	@Before
	public void setUp() {
		assertNotNull(postDao);
		log.debug("setUp");
		
		// Insert Post
		this.insertPost();
	}
	
	public void insertPost() {
		post = postDao.insertPost(post);
		assertThat(post.getPostId(), greaterThan(0));
		log.debug("insertPost");
	}
	
	@After
	public void deleteAll() {
		postDao.deleteAll();
		log.debug("truncate table");
	}

	@Test
	public void TestGetPost() {
		post = postDao.getPost(post.getPostId());
		assertNotNull(post);
		log.debug("{}", post);
		
	}
	
	@Test
	public void testUpdatePost() {
		int beforeHits = post.getHits();
		post.setHits(beforeHits + 1);
		postDao.updatePost(post);
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
}
