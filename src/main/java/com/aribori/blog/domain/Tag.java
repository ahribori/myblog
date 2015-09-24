package com.aribori.blog.domain;

import java.util.Date;

public class Tag {
	
	private int tagId;
	private String name;
	private int useCount;
	private Date regDate;
	private Date modDate;

	public Tag() {
		super();
	}

	public Tag(String name) {
		super();
		this.name = name;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUseCount() {
		return useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
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
		return "Tag [tagId=" + tagId + ", name=" + name + ", useCount="
				+ useCount + ", regDate=" + regDate + ", modDate=" + modDate
				+ "]";
	}

}
