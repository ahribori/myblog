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
import com.aribori.blog.dao.PostTagDao;
import com.aribori.blog.dao.TagDao;
import com.aribori.blog.domain.Category;
import com.aribori.blog.domain.PostTag;
import com.aribori.blog.domain.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class PostTagDaoTest {
	
	@Autowired
	private PostTagDao postTagDao;
	
	@Test
	public void testInsertPostTag() {
		PostTag postTag = new PostTag(1, 1);
		postTag = postTagDao.insertPostTag(postTag);
		System.out.println(postTag);
	}
	
	@Test
	public void testFindTagsByPostId() {
		List<Tag> list = postTagDao.findTagsByPostId(14);
		for (Tag tag : list) {
			System.out.println(tag);
		}
	}
}
