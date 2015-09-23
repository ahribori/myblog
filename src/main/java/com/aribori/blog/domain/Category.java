package com.aribori.blog.domain;

import java.util.Date;

public class Category {
	
	private int categoryId;
	private String name;
	private int postCount;
	private int priority;
	private String glyphicon;
	private Date regDate;
	
	public Category() {
		super();
	}
	
	public Category(String name, int priority, String glyphicon) {
		super();
		this.name = name;
		this.priority = priority;
		this.glyphicon = glyphicon;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getGlyphicon() {
		return glyphicon;
	}

	public void setGlyphicon(String glyphicon) {
		this.glyphicon = glyphicon;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name
				+ ", postCount=" + postCount + ", priority=" + priority
				+ ", glyphicon=" + glyphicon + ", regDate=" + regDate + "]";
	}

}
