package com.hs9923.blog;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hs9923.blog.dao.PostDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PostDaoTest {

	@Autowired
	private PostDao postDao;
	
	@Before
	public void setUp() throws Exception {
		assertNotNull(postDao);
	}

	@Test
	public void test() {
		System.out.println("hello");
	}

}
