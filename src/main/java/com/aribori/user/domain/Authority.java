package com.aribori.user.domain;

public class Authority {

	private String username;
	private String authority;

	public Authority() {
		super();
	}

	public Authority(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [username=" + username + ", authority=" + authority
				+ "]";
	}

}
