package com.aribori.blog.service;

import java.util.List;

import com.aribori.blog.domain.Comment;
import com.aribori.blog.exception.AuthenticateFailureException;

public interface CommentService {

	public Comment insertComment(Comment comment);

	public List<Comment> getComments(int postId);

	public void updateComment(Comment comment) throws AuthenticateFailureException;

	public void deleteComment(Comment comment) throws AuthenticateFailureException;	

	public void deleteAll();

	
}
