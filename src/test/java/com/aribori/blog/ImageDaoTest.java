package com.aribori.blog;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aribori.blog.dao.ImageDao;
import com.aribori.blog.domain.Image;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class ImageDaoTest {
	
	@Autowired
	private ImageDao imageDao;
	
	@Test
	public void testInsertImage() {
		Image image = new Image();
		image.setName("abc.jpg");
		image.setPostId(1);
		image = imageDao.insertImage(image);
		System.out.println(image);
	}
	
	@Test
	public void testFindImageByName() {
		Image image = imageDao.findImageByName("abc.jpg");
		System.out.println(image);
	}
	
	@Test
	public void testGetImage() {
		Image image = imageDao.getImage(1);
		System.out.println(image);
	}
	
	@Test
	public void testDeleteImage() {
		imageDao.deleteImage(1);
		System.out.println(imageDao.getImage(1));
	}
	
	@Test
	public void testGetImagesByPostId() {
		List<Image> images = imageDao.getImagesByPostId(1);
		for (Image image : images) {
			System.out.println(image);
		}
	}
	
	@Test
	public void testFindImagesOnLocal() {
		String path = "C:\\Users\\Daniel\\git\\myblog\\src\\main\\webapp\\resources\\images\\post";
		File file = new File(path);
		File[] fileList = file.listFiles();
		for (File f : fileList) {
			System.out.println(f.getName());
		}
	}
}
