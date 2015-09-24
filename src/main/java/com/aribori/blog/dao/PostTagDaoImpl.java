package com.aribori.blog.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.blog.domain.PostTag;

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
		sqlSessionTemplate.delete("post_tag.deletePostTagByTagId", map);
	}


}
