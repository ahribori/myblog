package com.hs9923.blog.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

}
