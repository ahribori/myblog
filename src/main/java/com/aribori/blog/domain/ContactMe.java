package com.aribori.blog.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class ContactMe {

	@Email(message="E-Mail 형식으로 입력하세요")
	private String sender;
	
	@NotBlank(message="메세지를 입력하세요")
	private String message;

	public ContactMe() {
		super();
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactMe [sender=" + sender + ", message=" + message + "]";
	}
	
}
