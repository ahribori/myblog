package com.aribori.blog.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Post {
	
	private int postId;
	@NumberFormat(style=Style.NUMBER)
	private int categoryId;
	@NotEmpty(message="제목을 입력하세요")
	private String title;
	private String tagString;
	private String writer;
	@NotEmpty(message="내용을 입력하세요")
	private String content;
	private int hits;
	private Date regDate;
	private Date modDate;
	
	private Category category;
	
	public Post() {
		super();
	}

	public Post(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
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
	
	public String getTagString() {
		return tagString;
	}

	public void setTagString(String tagString) {
		this.tagString = tagString;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", categoryId=" + categoryId
				+ ", title=" + title + ", subtitle=" +  writer + ", content=" + content 
				+ ", hits=" + hits + ", regDate=" + regDate + ", modDate=" + modDate
				+ ", category=" + category + "]";
	}

}
