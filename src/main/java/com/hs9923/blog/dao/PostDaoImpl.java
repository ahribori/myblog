package com.hs9923.blog.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs9923.blog.domain.Post;

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

}
