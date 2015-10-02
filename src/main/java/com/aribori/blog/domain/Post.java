package com.aribori.blog.domain;

import java.util.Date;
import java.util.List;

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
	private String calculatedRegDate;
	private String calculatedModDate;
	

	private Category category;
	
	private List<Tag> tags;
	
	private List<String> thumbnailImagePathList;


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
		setCalculatedRegDate(dateCalculate(regDate));
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	

	public String getCalculatedRegDate() {
		return calculatedRegDate;
	}

	public void setCalculatedRegDate(String calculatedRegDate) {
		this.calculatedRegDate = calculatedRegDate;
	}

	public String getCalculatedModDate() {
		return calculatedModDate;
	}

	public void setCalculatedModDate(String calculatedModDate) {
		this.calculatedModDate = calculatedModDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	

	public List<String> getThumbnailImagePathList() {
		return thumbnailImagePathList;
	}

	public void setThumbnailImagePathList(List<String> thumbnailImagePathList) {
		this.thumbnailImagePathList = thumbnailImagePathList;
	}
	
	public String dateCalculate(Date time) {
		long currentTime = System.currentTimeMillis();
		long inputTime = time.getTime();
		long resultTime = ((currentTime - inputTime) / 1000);
		String resultStr = null;

		if (resultTime >= 60 * 60 * 24 * 365) {
			resultStr = resultTime / (60 * 60 * 24 * 365) + "년 전";
		} else if (resultTime >= 60 * 60 * 24 * 30) {
			resultStr = resultTime / (60 * 60 * 24 * 30) + "개월 전";
		} else if (resultTime >= 60 * 60 * 24) {
			resultStr = resultTime / (60 * 60 * 24) + "일 전";
		} else if (resultTime >= 60 * 60) {
			resultStr = resultTime / (60 * 60) + "시간 전";
		} else if (resultTime >= 60) {
			resultStr = resultTime / (60) + "분 전";
		} else {
			resultStr = resultTime + "초 전";
		}
		return resultStr;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", categoryId=" + categoryId
				+ ", title=" + title + ", tagString=" + tagString + ", writer="
				+ writer + ", content=" + content + ", hits=" + hits
				+ ", regDate=" + regDate + ", modDate=" + modDate
				+ ", calculatedRegDate=" + calculatedRegDate
				+ ", calculatedModDate=" + calculatedModDate + ", category="
				+ category + ", tags=" + tags + ", thumbnailImagePathList="
				+ thumbnailImagePathList + "]";
	}
	
}
