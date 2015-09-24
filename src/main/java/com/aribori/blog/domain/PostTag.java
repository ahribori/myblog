package com.aribori.blog.domain;

import java.util.Date;

public class PostTag {

	private int id;
	
	private int postId;
	
	private int tagId;
	
	private Post post;
	
	private Tag tag;
	
	private Date regDate;

	public PostTag() {
		super();
	}
	
	public PostTag(int postId, int tagId) {
		super();
		this.postId = postId;
		this.tagId = tagId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "PostTag [id=" + id + ", postId=" + postId + ", tagId=" + tagId
				+ ", post=" + post + ", tag=" + tag + ", regDate=" + regDate
				+ "]";
	}

}
