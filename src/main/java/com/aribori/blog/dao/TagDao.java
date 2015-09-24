package com.aribori.blog.dao;

import java.util.List;

import com.aribori.blog.domain.PostTag;
import com.aribori.blog.domain.Tag;

public interface TagDao {

	public Tag findTagByName(String name);

	public Tag getTag(int tagId);

	public List<Tag> getTags();

	public Tag insertTag(Tag tag);

	public void upUseCount(int tagId);

	public void deleteAll();

	public List<Tag> getTagsByPostId(int postId);


}
