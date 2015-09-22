package com.aribori.blog.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.aribori.blog.domain.Post;
import com.aribori.common.lib.ListContainer;

public interface PostService {
	
	public Post insertPost(Post post);

	public Post getPost(int postId, Cookie cookie, HttpServletResponse response);

	public Post getPostNoHits(int postId);

	public void updatePost(Post post);

	public void deletePost(int postId);
	
	public ListContainer getPosts(int currentPage);

	public ListContainer getPosts(int currentPage, int pageSize, int pageGroupSize);

	public void imageUpload(HttpServletRequest request,
			HttpServletResponse response, MultipartFile upload);

	
}
