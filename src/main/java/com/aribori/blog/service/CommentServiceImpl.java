package com.aribori.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aribori.blog.dao.CommentDao;
import com.aribori.blog.domain.Comment;
import com.aribori.blog.exception.AuthenticateFailureException;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public Comment insertComment(Comment comment) {
		if(comment != null) {
			if(comment.getRefId()==0)
				commentDao.insertComment(comment);
			else
				commentDao.insertChildComment(comment);
		}
		return comment;
	}

	@Override
	public List<Comment> getComments(int postId) {
		return commentDao.getComments(postId);
	}

	@Override
	public void updateComment(Comment comment) throws AuthenticateFailureException {
		if(comment != null) {
			Comment dbComment = commentDao.getComment(comment.getCommentId());
			if(dbComment != null) {
				String dbpasswd = dbComment.getPasswd();
				String passwd = comment.getPasswd();
				if(passwd.equals(dbpasswd)) {
					commentDao.updateComment(comment);
				} else {
					throw new AuthenticateFailureException("패스워드가 일치하지 않습니다.");
				}
			}
		}
	}

	@Override
	public void deleteComment(Comment comment) throws AuthenticateFailureException {
		if(comment != null) {
			Comment dbComment = commentDao.getComment(comment.getCommentId());
			if(dbComment != null) {
				String dbpasswd = dbComment.getPasswd();
				String passwd = comment.getPasswd();
				if(passwd.equals(dbpasswd)) {
					commentDao.deleteComment(comment.getCommentId());
				} else {
					throw new AuthenticateFailureException("패스워드가 일치하지 않습니다.");
				}
			}
		}
	}

	@Override
	public void deleteAll() {
		commentDao.deleteAll();
	}
	
}
