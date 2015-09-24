package com.aribori.blog.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.blog.domain.PostTag;
import com.aribori.blog.domain.Tag;

@Repository
public class TagDaoImpl implements TagDao{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Tag findTagByName(String name) {
		return sqlSessionTemplate.selectOne("tag.findTagByName", name);
	}
		
	@Override
	public Tag getTag(int tagId) {
		return sqlSessionTemplate.selectOne("tag.getTag", tagId);
	}

	@Override
	public Tag getTagByName(String name) {
		return sqlSessionTemplate.selectOne("tag.getTagByName", name);
	}

	@Override
	public List<Tag> getTags() {
		return sqlSessionTemplate.selectList("tag.getTags");
	}

	@Override
	public Tag insertTag(Tag tag) {
		sqlSessionTemplate.insert("tag.insertTag", tag);
		return tag;
	}

	@Override
	public void upUseCount(int tagId) {
		sqlSessionTemplate.update("tag.upUseCount", tagId);
	}

	@Override
	public void deleteAll() {
		sqlSessionTemplate.delete("tag.deleteAll");
	}

	@Override
	public List<Tag> getTagsByPostId(int postId) {
		return sqlSessionTemplate.selectList("tag.getTagsByPostId", postId);
	}

}
