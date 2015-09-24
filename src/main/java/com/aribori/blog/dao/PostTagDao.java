package com.aribori.blog.dao;

import com.aribori.blog.domain.PostTag;

public interface PostTagDao {

	public PostTag insertPostTag(PostTag postTag);
	
	public void deletePostTag(int postId, int tagId);

}
