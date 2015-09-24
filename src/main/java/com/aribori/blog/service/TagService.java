package com.aribori.blog.service;

import java.util.List;

import com.aribori.blog.domain.Post;
import com.aribori.blog.domain.Tag;

public interface TagService {

	public void tagProcess(Post post);
	
	public List<Tag> getTags();
	
	public List<Tag> getTagsByPostId(int postId);
	
	public Tag getTag(int tagId);
	
	public Tag getTagByName(String name);


}
