package com.aribori.blog.dao;

import java.util.List;

import com.aribori.blog.domain.Comment;

public interface CommentDao {

	public Comment insertComment(Comment comment);

	public Comment insertChildComment(Comment comment);

	public Comment getComment(int commentId);

	public List<Comment> getComments(int postId);

	public void updateComment(Comment comment);

	public void deleteComment(int commentId);

	public void deleteAll();

	
}
