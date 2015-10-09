package com.aribori.blog.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Comment {

	private int commentId;
	
	private int postId;
	
	private int refId;
	
	@NotEmpty(message="작성자를 입력하세요")
	private String writer;
	
	private String ipAddr;
	
	@Size(min=4, max=20, message="비밀번호는 4자 이상 20자 이하만 가능합니다")
	private String passwd;
	
	@Size(max=3000, message="3000자 이하만 가능합니다")
	@NotEmpty(message="내용을 입력하세요")
	private String comment;
	
	private int recommend;
	
	private Date regDate;
	
	private Date modDate;
	
	private String calculatedRegDate;
	
	private String calculatedModDate;
	
	private boolean isChild;
	
	private boolean isSecret;

	public Comment() {
		super();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
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

	public boolean getIsChild() {
		return isChild;
	}

	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}

	public boolean getIsSecret() {
		return isSecret;
	}

	public void setSecret(boolean isSecret) {
		this.isSecret = isSecret;
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
		return "Comment [commentId=" + commentId + ", postId=" + postId
				+ ", refId=" + refId + ", writer=" + writer + ", ipAddr="
				+ ipAddr + ", passwd=" + passwd + ", comment=" + comment
				+ ", recommend=" + recommend + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", calculatedRegDate="
				+ calculatedRegDate + ", calculatedModDate=" + calculatedModDate
				+ ", isChild=" + isChild + ", isSecret=" + isSecret + "]";
	}
	
}
