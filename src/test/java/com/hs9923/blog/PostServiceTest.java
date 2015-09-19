package com.hs9923.blog;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

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

import com.hs9923.blog.dao.PostDao;
import com.hs9923.blog.domain.Post;
import com.hs9923.blog.service.PostService;
import com.hs9923.common.lib.ListContainer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class PostServiceTest {

	@Autowired
	private PostService postService;
	
	@Autowired
	private PostDao postDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	Post post = new Post("제목", "부제목", "글쓴이", "컨텐츠");

	@Before
	public void setUp() {
		assertNotNull(postService);
		log.debug("setUp");
		
		// Insert Post
		this.insertPost();
	}
	
	@After
	public void deleteAll() {
		postDao.deleteAll();
		log.debug("truncate table");
	}
	
	public void insertPost() {
		post = postService.insertPost(post);
		assertThat(post.getPostId(), greaterThan(0));
		log.debug("insertPost");
	}
	
	@Test
	public void testGetPost() {
	}
	
	@Test
	public void testUpdatePost() {
		int beforeHits = post.getHits();
		post.setHits(beforeHits + 1);
		postService.updatePost(post);
		post = postDao.getPost(post.getPostId());
		assertThat(post.getHits(), greaterThan(beforeHits));
		log.info("{}", post);
	}
	
	@Test
	public void testDeletePost() {
		postService.deletePost(post.getPostId());
		assertNull(postDao.getPost(post.getPostId()));
		log.info("delete post success.");
	}
	
	@Test
	public void testGetPosts() {
		for (int i = 0; i < 30; i++) {
			this.insertPost();
		}
		ListContainer container = postService.getPosts(1);
		assertNotNull(container);
		assertThat(container.getList().size(), greaterThan(0));
		List<Post> postList = (List<Post>) container.getList();
		for (Post post : postList) {
			log.debug("{}", post);
		}
		
	}
	
	@Test
	public void testGetPostsWithoutContent () {
		for (int i = 0; i < 30; i++) {
			this.insertPost();
		}
		ListContainer container = postService.getPostsWithoutContent(1);
		assertNotNull(container);
		assertThat(container.getList().size(), greaterThan(0));
		List<Post> postList = (List<Post>) container.getList();
		for (Post post : postList) {
			log.debug("{}", post);
		}
	}

}
