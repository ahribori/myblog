package com.aribori.blog.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aribori.blog.domain.Image;

@Repository
public class ImageDaoImpl implements ImageDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Image insertImage(Image image) {
		sqlSessionTemplate.insert("image.insertImage", image);
		return image; 
	}
	
	@Override
	public Image findImageByName(String name) {
		return sqlSessionTemplate.selectOne("image.findImageByName", name);
	}

	@Override
	public Image getImage(int imageId) {
		return sqlSessionTemplate.selectOne("image.getImage", imageId);
	}

	@Override
	public void deleteImage(int imageId) {
		sqlSessionTemplate.delete("image.deleteImage", imageId);
	}

	@Override
	public List<Image> getImagesByPostId(int postId) {
		return sqlSessionTemplate.selectList("image.getImagesByPostId",postId);
	}

	
}
