package com.aribori.blog.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.blog.domain.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int getCount(int postId) {
		return sqlSessionTemplate.selectOne("comment.getCount", postId);
	}

	@Override
	public Comment insertComment(Comment comment) {
		sqlSessionTemplate.insert("comment.insertComment", comment);
		sqlSessionTemplate.update("comment.syncRefNo", comment);
		return comment;
	}

	@Override
	public Comment insertChildComment(Comment comment) {
		sqlSessionTemplate.insert("comment.insertChildComment", comment);
		return comment;
	}

	@Override
	public Comment getComment(int commentId) {
		return sqlSessionTemplate.selectOne("comment.getComment", commentId);
	}
	
	@Override
	public List<Comment> getComments(int postId) {
		return sqlSessionTemplate.selectList("comment.getComments", postId);
	}

	@Override
	public void updateComment(Comment comment) {
		sqlSessionTemplate.update("comment.updateComment", comment);
	}

	@Override
	public void deleteComment(int commentId) {
		sqlSessionTemplate.delete("comment.deleteComment", commentId);
	}

	@Override
	public void deleteAll() {
		sqlSessionTemplate.delete("comment.deleteAll");
	}

}
