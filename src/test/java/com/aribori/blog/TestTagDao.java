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
import com.aribori.blog.dao.TagDao;
import com.aribori.blog.domain.Category;
import com.aribori.blog.domain.PostTag;
import com.aribori.blog.domain.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class TestTagDao {
	
	@Autowired
	private TagDao tagDao;
	
	@Test
	public void testInsertTag() {
		Tag tag = new Tag("아리보리");
		tag = tagDao.insertTag(tag);
		System.out.println(tag);
	}
	
	@Test
	public void testFindTagByName() {
		Tag tag = tagDao.findTagByName("태그이름");
		System.out.println(tag);
	}
	
	@Test
	public void getTag() {
		Tag tag = tagDao.getTag(1);
		System.out.println(tag);
	}
	
	@Test
	public void testGetTags() {
		List<Tag> tags = tagDao.getTags();
		for (Tag tag : tags) {
			System.out.println(tag);
		}
	}
	
	@Test
	public void testUpUseCount() {
		testInsertTag();
		tagDao.upUseCount(1);
		System.out.println(tagDao.getTag(1));
	}
	
	@Test
	public void testGetTagsByPostId() {
		List<Tag> list = tagDao.getTagsByPostId(8);
		for (Tag tag : list) {
			System.out.println(tag);
		}
	}
	
	@Test
	public void testParseTagString() {
		String tagString = "하이루,방가,hello,ㅋㅋㅋ";
		String [] tags = tagString.split(",");
		for (String tag : tags) {
			System.out.println(tag);
		}
	}
	
	@Test
	public void test() {
		String name="http://aribori.com.#$#@%^^";
		name = name.replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]", "_");
		System.out.println(name);
	}
	
}
