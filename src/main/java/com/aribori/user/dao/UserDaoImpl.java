package com.aribori.user.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.user.domain.Authority;
import com.aribori.user.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("user.getTotalCount");
	}

	@Override
	public void insertUser(User user) {
		System.out.println(user);
		sqlSessionTemplate.insert("user.insertUser", user);
	}

	@Override
	public void insertAuthority(Authority authority) {
		sqlSessionTemplate.insert("user.insertAuthority", authority);
	}

	@Override
	public User findUserByUsername(String username) {
		User user = sqlSessionTemplate.selectOne("user.findUserByUsername", username);
		if(user!=null) {
			user.setAuthorities(this.getAuthoritiesByUsername(username));
		}
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		User user = sqlSessionTemplate.selectOne("user.findUserByEmail", email);
		if(user!=null) {
			user.setAuthorities(this.getAuthoritiesByUsername(user.getUsername()));
		}
		return user;
	}

	@Override
	public List<String> getAuthoritiesByUsername(String username) {
		return sqlSessionTemplate.selectList("user.getAuthoritiesByUsername", username);
	}

	@Override
	public void updateUser(User user) {
		sqlSessionTemplate.update("user.updateUser", user);
	}

	@Override
	public void deleteUser(String username) {
		sqlSessionTemplate.delete("user.deleteUser", username);
	}

	@Override
	public void deleteAuthorities(String username) {
		sqlSessionTemplate.delete("user.deleteAuthorities", username);
	}

	
}
