package com.aribori.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public void tagProcess(Post post) {
		List<Tag> dbTagList = postTagDao.findTagsByPostId(post.getPostId());
		String [] tags = post.getTagString().split(",");
		
		for (String name: tags) {
			name = name.replace(" ", "");
			if(name!= null && name != "") {
				name = name.replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]", ""); // 특수문자 제거
				Tag tag = tagDao.findTagByName(name);
				if (tag == null) { // 새로운 태그
					tag = tagDao.insertTag(new Tag(name));
				} else { // 태그가 DB에 이미 존재
					tagDao.upUseCount(tag.getTagId());
				}
				
				if(!postTagDao.isExistPostTag(post.getPostId(), tag.getTagId())) {
					postTagDao.insertPostTag(new PostTag(post.getPostId(), tag.getTagId()));
				}
			
			}
		}
		
		for (Tag dbTag : dbTagList) {
			String dbTagName = dbTag.getName();
			boolean isExist = false;
			for (String tagName : tags) {
				if(dbTagName.equals(tagName)) {
					isExist = true;
					break;
				}
			}
			
			if(!isExist) 
				postTagDao.deletePostTag(post.getPostId(), dbTag.getTagId());
			
		}
		
	}


	@Override
	public List<Tag> getTags() {
		return tagDao.getTags();
	}


	@Override
	public List<Tag> getTagsByPostId(int postId) {
		return tagDao.getTagsByPostId(postId);
	}


	@Override
	public Tag getTag(int tagId) {
		return tagDao.getTag(tagId);
	}


	@Override
	public Tag getTagByName(String name) {
		Tag tag = tagDao.getTagByName(name);
		if (tag!=null)
			tagDao.upUseCount(tag.getTagId());
		return tag;
	}
	
	
}
