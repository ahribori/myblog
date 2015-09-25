package com.aribori.blog.dao;

import java.util.List;

import com.aribori.blog.domain.Image;

public interface ImageDao {

	public Image insertImage(Image image);

	public Image findImageByName(String name);

	public Image getImage(int imageId);

	public void deleteImage(int imageId);

	public List<Image> getImagesByPostId(int postId);

}
	