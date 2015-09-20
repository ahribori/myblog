package com.aribori.blog.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.blog.domain.Post;
import com.aribori.common.lib.Page;

@Repository
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Post insertPost(Post post) {
		sqlSessionTemplate.insert("post.insertPost", post);		
		return post;
	}

	@Override
	public Post getPost(int postId) {
		return sqlSessionTemplate.selectOne("post.getPost", postId);
	}

	@Override
	public void updatePost(Post post) {
		sqlSessionTemplate.update("post.updatePost", post);
	}

	@Override
	public void deletePost(int postId) {
		sqlSessionTemplate.delete("post.deletePost", postId);
	}

	@Override
	public void deleteAll() {
		sqlSessionTemplate.delete("post.deleteAll");
	}

	@Override
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("post.getTotalCount");
	}

	@Override
	public List<Post> getPosts(Page page) {
		return sqlSessionTemplate.selectList("post.getPosts", page);
	}

	@Override
	public List<Post> getPostsWithoutContent(Page page) {
		return sqlSessionTemplate.selectList("post.getPostsWithoutContent", page);
	}

	@Override
	public void upHits(int postId) {
		sqlSessionTemplate.update("post.upHits", postId);
	}

}
