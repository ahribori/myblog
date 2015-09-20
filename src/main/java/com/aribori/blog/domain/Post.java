package com.aribori.blog.domain;

import java.util.Date;

public class Post {
	
	private int postId;
	private int categoryId;
	private String title;
	private String subtitle;
	private String writer;
	private String content;
	private int hits;
	private Date regDate;
	private Date modDate;
	
	public Post() {
		super();
	}

	public Post(String title, String subtitle, String writer, String content) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.writer = writer;
		this.content = content;
	}

	public Post(int postId, int categoryId, String title, String subtitle,
			String writer, String content, int hits, Date regDate, Date modDate) {
		super();
		this.postId = postId;
		this.categoryId = categoryId;
		this.title = title;
		this.subtitle = subtitle;
		this.writer = writer;
		this.content = content;
		this.hits = hits;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", categoryId=" + categoryId
				+ ", title=" + title + ", subtitle=" + subtitle + ", writer="
				+ writer + ", content=" + content + ", hits=" + hits
				+ ", regDate=" + regDate + ", modDate=" + modDate + "]";
	}

}
