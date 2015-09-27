package com.aribori.blog;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aribori.user.dao.UserDao;
import com.aribori.user.domain.Authority;
import com.aribori.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class TestUserDao {
	
	@Autowired
	private UserDao userDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Before
	public void setUp() throws Exception {
		assertNotNull(userDao);
	}
	
	@Test
	public void testInsertAdmin() {
		String username = "admin";
		String password = "1234";
		String email = "admin@kosta.org";
		User user = new User(username, password, email);
		userDao.insertUser(user);
		userDao.insertAuthority(new Authority(username, "ROLE_ADMIN"));
		userDao.insertAuthority(new Authority(username, "ROLE_USER"));
	}
	
	@Test
	public void testInsertUser() {
		String username = "user";
		String password = "1234";
		String email = "user@kosta.org";
		User user = new User(username, password, email);
		userDao.insertUser(user);
		userDao.insertAuthority(new Authority(username, "ROLE_USER"));
	}
	
	@Test
	public void testGetTotalCount() {
		int totalCount = userDao.getTotalCount();
		log.info("총 회원 수는 {}명 입니다.", totalCount);
	}
	
	@Test
	public void testFindUserByUsername() {
		String username="admin";
		User user = userDao.findUserByUsername(username);
		log.info("조회한 사용자 정보 : {}", user);
	}
	
	@Test
	public void testGetAuthoritiesByUsername(){
		String username="admin";
		List<String> authorities = userDao.getAuthoritiesByUsername(username);
		for (String authority : authorities) {
			log.info("{}", authority);
		}
	}
	
	@Test
	@Transactional
	public void testUpdateUser() {
		User user = userDao.findUserByUsername("admin");
		user.setEmail("update@kosta.org");
		userDao.updateUser(user);
		user = userDao.findUserByUsername("admin");
		log.info("{}", user);
	}
	
	@Test
	@Transactional
	public void testDeleteUser() {
		String username = "admin";
		userDao.deleteUser(username);
		userDao.deleteAuthorities(username);
		User user = userDao.findUserByUsername(username);
		List<String> authorities = userDao.getAuthoritiesByUsername(username);
		log.info("{}", user);
		for (String authority : authorities) {
			log.info("{}", authority);
		}
	}
}
