package com.aribori.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.blog.domain.PostTag;
import com.aribori.blog.domain.Tag;

@Repository
public class PostTagDaoImpl implements PostTagDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public PostTag insertPostTag(PostTag postTag) {
		sqlSessionTemplate.insert("post_tag.insertPostTag", postTag);
		return postTag;
	}

	@Override
	public void deletePostTag(int postId, int tagId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postId", postId);
		map.put("tagId", tagId);
		sqlSessionTemplate.delete("post_tag.deletePostTag", map);
	}

	@Override
	public List<Tag> findTagsByPostId(int postId) {
		return sqlSessionTemplate.selectList("post_tag.findTagsByPostId", postId);
	}

	@Override
	public boolean isExistPostTag(int postId, int tagId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postId", postId);
		map.put("tagId", tagId);
		int count = sqlSessionTemplate.selectOne("post_tag.isExistPostTag", map);
		if (count!=1)
			return false;
		else
			return true;
	}


}
