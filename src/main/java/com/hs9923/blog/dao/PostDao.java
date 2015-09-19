package com.hs9923.blog.dao;

import java.util.List;

import com.hs9923.blog.domain.Post;
import com.hs9923.common.lib.Page;

public interface PostDao {

	public Post insertPost(Post post);

	public Post getPost(int postId);

	public void updatePost(Post post);

	public void deletePost(int postId);

	public void deleteAll();

	public int getTotalCount();

	public List<Post> getPosts(Page page);

	public List<Post> getPostsWithoutContent(Page page);


}
