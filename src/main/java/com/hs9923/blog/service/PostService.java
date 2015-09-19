package com.hs9923.blog.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.hs9923.blog.domain.Post;
import com.hs9923.common.lib.ListContainer;

public interface PostService {
	
	public Post insertPost(Post post);

	public Post getPost(int postId, Cookie cookie, HttpServletResponse response);

	public void updatePost(Post post);

	public void deletePost(int postId);
	
	public ListContainer getPosts(int currentPage);

	public ListContainer getPostsWithoutContent(int currentPage);

}
