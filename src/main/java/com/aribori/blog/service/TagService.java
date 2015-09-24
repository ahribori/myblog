package com.aribori.blog.service;

import java.util.List;

import com.aribori.blog.domain.Post;
import com.aribori.blog.domain.Tag;

public interface TagService {

	public void tagProcess(Post post);
	
	public List<Tag> getTagsByPostId(int postId);

}
