package com.aribori.blog;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.aribori.blog.dao.CategoryDao;
import com.aribori.blog.dao.PostDao;
import com.aribori.blog.domain.Category;
import com.aribori.blog.domain.Post;
import com.aribori.blog.service.PostService;
import com.aribori.common.lib.ListContainer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class PostServiceTest {

	@Autowired
	private PostService postService;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	Post post = new Post("제목", "부제목", "글쓴이", "컨텐츠");
	Category category = new Category("테스트 카테고리", 0, "cloud");
	
	@Before
	public void setUp() {
		assertNotNull(postService);
		log.debug("setUp");

		// Insert Category
		this.insertCategory();
		// Insert Post
		post.setCategoryId(1);
		this.insertPost();
	}
	
	@After
	public void deleteAll() {
		postDao.deleteAll();
		categoryDao.deleteAll();
		log.debug("truncate table");
	}
	
	public void insertCategory() {
		category = categoryDao.insertCategory(category);
		assertThat(category.getCategoryId(), greaterThan(0));
		log.debug("insertPost");
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
		postService.updatePost(1,post);
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
	public void testJSOUP() {
		String html = "<p>hello</p><img src=sdfsdf><pre><code>publilcvoid</code></pre>";
		Document doc = Jsoup.parseBodyFragment(html);
		HtmlToPlainText htpt = new HtmlToPlainText();
		String text = htpt.getPlainText(doc);
		System.out.println("Text="+text);
	}

}
