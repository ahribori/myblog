package com.aribori.blog.dao;

import java.util.List;

import com.aribori.blog.domain.Post;
import com.aribori.common.lib.Page;

public interface PostDao {

	public Post insertPost(Post post);

	public Post getPost(int postId);

	public void updatePost(Post post);

	public void deletePost(int postId);

	public void deleteAll();

	public int getTotalCount();

	public List<Post> getPosts(Page page);

	public List<Post> getPostsWithoutContent(Page page);

	public void upHits(int postId);

}
