package com.aribori.user.domain;

import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	@Pattern(regexp="^[0-9a-zA-Z]*$" , message="아이디는 영문자 숫자 조합만 가능 합니다.")
	@Size(min=6, max=16)
	private String username;
	@Size(min=6, max=16)
	private String password;
	@Size(min=6, max=16)
	private String passwordCheck;
	@NotEmpty
	@Email
	private String email;
	
	private boolean enabled;
	
	@AssertTrue(message = "패스워드와 패스와드 확인란이 일치하지 않습니다.")
	public boolean isAvailablePassword() {
	    return (password!=null && passwordCheck!=null) && (password.equals(passwordCheck));
	}

	private List<String> authorities;

	public User() {
		super();
	}

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(String username, String password, String email,
			boolean enabled, List<String> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authority) {
		this.authorities = authority;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + ", enabled=" + enabled + ", authorities="
				+ authorities + "]";
	}
	
}
