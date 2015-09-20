package com.aribori.blog.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aribori.blog.dao.PostDao;
import com.aribori.blog.domain.Post;
import com.aribori.common.lib.ListContainer;
import com.aribori.common.lib.Page;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostDao postDao;

	@Override
	public Post insertPost(Post post) {
		return postDao.insertPost(post);
	}

	@Override
	public Post getPost(int postId, Cookie cookie, HttpServletResponse response) {
		String getPostLog = null;
		if (cookie!=null) { // Cookie !=null
			getPostLog = cookie.getValue();
			if(getPostLog.contains("|"+postId+"|")==false) { // Log에 글 번호가 없을 때
				postDao.upHits(postId);
				getPostLog += "|" + postId + "|";
				cookie.setValue(getPostLog);
				cookie.setMaxAge(60*60*24);
			}
			response.addCookie(cookie);
		} else { // Cookie == null
			postDao.upHits(postId);
			getPostLog = "|"+postId+"|";
			cookie = new Cookie("getPostLog", getPostLog);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
		return postDao.getPost(postId);
	}

	@Override
	public void updatePost(Post post) {
		postDao.updatePost(post);
	}

	@Override
	public void deletePost(int postId) {
		postDao.deletePost(postId);
	}

	@Override
	public ListContainer getPosts(int currentPage) {
		Page page = new Page(currentPage, postDao.getTotalCount());
		List<Post> postList = postDao.getPosts(page);
		return new ListContainer(postList, page);
	}

	@Override
	public ListContainer getPostsWithoutContent(int currentPage) {
		Page page = new Page(currentPage, postDao.getTotalCount());
		List<Post> postList = postDao.getPostsWithoutContent(page);
		return new ListContainer(postList, page);
	}


}
