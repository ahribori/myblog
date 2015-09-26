package com.aribori.blog.domain;

public class Mail {
	
	private String subject;
	private String content;
	private String recipient;
	
	public Mail() {
		super();
	}

	public Mail(String subject, String content, String recipient) {
		super();
		this.subject = subject;
		this.content = content;
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@Override
	public String toString() {
		return "Mail [subject=" + subject + ", content=" + content
				+ ", recipient=" + recipient + "]";
	}
	
}
