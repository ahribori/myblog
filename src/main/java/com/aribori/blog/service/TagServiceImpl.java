package com.aribori.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aribori.blog.dao.PostTagDao;
import com.aribori.blog.dao.TagDao;
import com.aribori.blog.domain.Post;
import com.aribori.blog.domain.PostTag;
import com.aribori.blog.domain.Tag;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private PostTagDao postTagDao;
	
	@Override
	public void tagProcess(Post post) {
		
		String [] tags = post.getTagString().split(",");
		
		for (String name: tags) {
			Tag tag = tagDao.findTagByName(name);
			if (tag == null) { // 새로운 태그
				tag = tagDao.insertTag(tag);
			} else { // 태그가 DB에 이미 존재
				tagDao.upUseCount(tag.getTagId());
			}
			postTagDao.insertPostTag(new PostTag(post.getPostId(), tag.getTagId()));
		}
		
	}

	@Override
	public List<Tag> getTagsByPostId(int postId) {
		return tagDao.getTagsByPostId(postId);
	}
	
	
}
