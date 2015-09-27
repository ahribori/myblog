package com.aribori.user.domain;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class FindUserInformationForm {

	@NotEmpty
	@Email
	@Pattern(regexp="^[_0-9a-zA-Z-]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$", message="올바른 이메일을 입력하세요.")
	private String email;

	public FindUserInformationForm() {
		super();
	}

	public FindUserInformationForm(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FindUserInformationForm [email=" + email + "]";
	}
}
