package com.aribori.blog.dao;

import java.util.List;

import com.aribori.blog.domain.PostTag;
import com.aribori.blog.domain.Tag;

public interface PostTagDao {

	public PostTag insertPostTag(PostTag postTag);
	
	public void deletePostTag(int postId, int tagId);

	public List<Tag> findTagsByPostId(int postId);

	public boolean isExistPostTag(int postId, int tagId);

}
