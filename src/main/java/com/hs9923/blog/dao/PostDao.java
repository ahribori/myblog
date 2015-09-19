package com.hs9923.blog.dao;

import com.hs9923.blog.domain.Post;

public interface PostDao {

	public Post insertPost(Post post);

	public Post getPost(int postId);

	public void updatePost(Post post);

	public void deletePost(int postId);

	public void deleteAll();


}
