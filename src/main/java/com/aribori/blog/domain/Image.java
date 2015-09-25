package com.aribori.blog.domain;

import java.util.Date;

public class Image {
	
	private int imageId;
	private int postId;
	private String name;
	private Date regDate;

	public Image() {
		super();
	}
	
	public Image(String name) {
		super();
		this.name = name;
	}

	public Image(int postId, String name) {
		super();
		this.postId = postId;
		this.name = name;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", postId=" + postId + ", name="
				+ name + ", regDate=" + regDate + "]";
	}
	
}
