package com.aribori.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public int getTotalCountByCategory(int categoryId) {
		return sqlSessionTemplate.selectOne("post.getTotalCountByCategory", categoryId);
	}

	@Override
	public int getTotalCountByTag(int tagId) {
		return sqlSessionTemplate.selectOne("post.getTotalCountByTag", tagId);
	}

	@Override
	public List<Post> getPosts(Page page) {
		return sqlSessionTemplate.selectList("post.getPosts", page);
	}

	@Override
	public List<Post> getPostsByCategory(int categoryId, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryId", categoryId);
		map.put("page", page);
		return sqlSessionTemplate.selectList("post.getPostsByCategory", map);
	}

	@Override
	public List<Post> getPostsByTag(int tagId, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tagId", tagId);
		map.put("page", page);
		return sqlSessionTemplate.selectList("post.getPostsByTag", map);
	}

	@Override
	public void upHits(int postId) {
		sqlSessionTemplate.update("post.upHits", postId);
	}

}
