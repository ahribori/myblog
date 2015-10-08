package com.aribori.blog;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aribori.blog.dao.CommentDao;
import com.aribori.blog.domain.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class TestCommentDao {

	@Autowired
	private CommentDao commentDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	Comment comment = null;
	
	/**
	 * 각 단위테스트 실행 전 commentDao 오브젝트가 살아있는지 체크하고,
	 * Test를 위한 Comment Object를 DB에 저장한다.
	 */
	@Before
	public void setUp() {
		assertNotNull(commentDao);
		log.debug("setUp");
		
		// Insert Comment
		this.insertComment();
	}
	
	public void insertComment() {
		comment = new Comment();
		comment.setPostId(1);
		comment.setWriter("testWriter");
		comment.setIpAddr("127.0.0.7");
		comment.setPasswd("1234");
		comment.setComment("댓글 내용입니다");
		comment.setChild(false);
		comment.setSecret(true);
		comment = commentDao.insertComment(comment);
		assertThat(comment.getCommentId(), greaterThan(0));
		log.debug("insertComment");
	}
	
	@After
	public void deleteAll() {
		commentDao.deleteAll();
		log.debug("truncate table");
	}
	
	@Test
	public void testGetComment() {
		comment = commentDao.getComment(1);
		System.out.println(comment);
		
	}

	@Test
	public void testGetComments() {
		List<Comment> commentList = commentDao.getComments(1);
		for (Comment comment : commentList) {
			System.out.println(comment);
		}
	}
	
	@Test
	public void testUpdateComment() {
		comment.setComment("업데이트 테스트랑께");
		commentDao.updateComment(comment);
		List<Comment> commentList = commentDao.getComments(1);
		for (Comment comment : commentList) {
			System.out.println(comment);
		}
	}
	
	@Test
	public void testDeleteComment() {
		commentDao.deleteComment(comment.getCommentId());
		List<Comment> commentList = commentDao.getComments(1);
		for (Comment comment : commentList) {
			System.out.println(comment);
		}
		log.info("delete comment success.");
	}
	
}
