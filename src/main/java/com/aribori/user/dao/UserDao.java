package com.aribori.user.dao;

import java.util.List;

import com.aribori.user.domain.Authority;
import com.aribori.user.domain.User;

public interface UserDao {

	public int getTotalCount();

	public void insertUser(User user);

	public void insertAuthority(Authority authority);

	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);

	public List<String> getAuthoritiesByUsername(String username);

	public void updateUser(User user);

	public void deleteUser(String username);

	public void deleteAuthorities(String username);

}
