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
	
	public int getTotalCountByCategory(int categoryId);

	public int getTotalCountByTag(int tagId);

	public List<Post> getPosts(Page page);

	public List<Post> getPostsByCategory(int categoryId, Page page);

	public List<Post> getPostsByTag(int tagId, Page page);

	public void upHits(int postId);



}
