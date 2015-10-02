package com.aribori.blog.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aribori.blog.dao.ImageDao;
import com.aribori.blog.dao.PostDao;
import com.aribori.blog.domain.Image;
import com.aribori.blog.domain.Post;
import com.aribori.common.lib.ListContainer;
import com.aribori.common.lib.Page;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ImageDao imageDao;
	
	@Transactional
	@Override
	public Post insertPost(Post post) {
		post = postDao.insertPost(post);
		
		this.imageProcess(post);
		
		if(post.getTagString()!=null)
			tagService.tagProcess(post);
		return post;
	}
	
	@Override
	public Post getPost(int postId, Cookie cookie, HttpServletResponse response) {
		String getPostLog = null;
		if (cookie!=null) { // Cookie !=null
			getPostLog = cookie.getValue();
			if(getPostLog.contains("|"+postId+"|")==false) { // Log에 글 번호가 없을 때
				postDao.upHits(postId);
				getPostLog += "|" + postId + "|";
				cookie.setValue(getPostLog);
				cookie.setMaxAge(60*60*24);
			}
			response.addCookie(cookie);
		} else { // Cookie == null
			postDao.upHits(postId);
			getPostLog = "|"+postId+"|";
			cookie = new Cookie("getPostLog", getPostLog);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
		Post post = postDao.getPost(postId);
		if(post!=null)
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		return post;
	}

	@Override
	public Post getPostNoHits(int postId) {
		Post post = postDao.getPost(postId);
		if(post!=null)
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		return post;
	}

	@Transactional
	@Override
	public void updatePost(int postId, Post post, HttpServletRequest request) {
		if(post.getTagString()!=null)
			tagService.tagProcess(post);
		categoryService.downPostCount(postDao.getPost(postId).getCategoryId());
		categoryService.upPostCount(post.getCategoryId());
		postDao.updatePost(post);
		imageProcessWhenUpdatePost(post, request);
	}

	@Override
	public void deletePost(int postId, HttpServletRequest request) {
		postDao.deletePost(postId);
		List<Image> images = imageDao.getImagesByPostId(postId);
		String contextPath = "resources" + File.separator + "images" + File.separator +"post" + File.separator;
		String realPath = new HttpServletRequestWrapper(request).getRealPath("/") + contextPath;
		for (Image image : images) {
			imageDao.deleteImage(image.getImageId());
			new File(realPath+image.getName()).delete();
		}
	}

	@Override
	public ListContainer getPosts(int currentPage) {
		Page page = new Page(currentPage, postDao.getTotalCount());
		List<Post> postList = postDao.getPosts(page);
		for (Post post : postList) {
			post = setExternalImages(post);
			post.setContent(makeContentThumbnail(post.getContent()));
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		}
		return new ListContainer(postList, page);
	}
	
	@Override
	public ListContainer getPosts(int currentPage, int pageSize, int pageGroupSize) {
		Page page = new Page(currentPage, pageSize, pageGroupSize, postDao.getTotalCount());
		List<Post> postList = postDao.getPosts(page);
		for (Post post : postList) {
			post = setExternalImages(post);
			post.setContent(makeContentThumbnail(post.getContent()));
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		}
		return new ListContainer(postList, page);
	}
	
	@Override
	public ListContainer getPostsByCategory(int currentPage, int categoryId) {
		Page page = new Page(currentPage, postDao.getTotalCountByCategory(categoryId));
		List<Post> postList = postDao.getPostsByCategory(categoryId, page);
		for (Post post : postList) {
			post = setExternalImages(post);
			post.setContent(makeContentThumbnail(post.getContent()));
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		}
		return new ListContainer(postList, page);
	}

	@Override
	public ListContainer getPostsByCategory(int currentPage, int pageSize,
			int pageGroupSize, int categoryId) {
		Page page = new Page(currentPage, pageSize, pageGroupSize, postDao.getTotalCountByCategory(categoryId));
		List<Post> postList = postDao.getPostsByCategory(categoryId, page);
		for (Post post : postList) {
			post = setExternalImages(post);
			post.setContent(makeContentThumbnail(post.getContent()));
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		}
		return new ListContainer(postList, page);
	}

	@Override
	public ListContainer getPostsByTag(int currentPage, int tagId) {
		Page page = new Page(currentPage, postDao.getTotalCountByTag(tagId));
		List<Post> postList = postDao.getPostsByTag(tagId, page);
		for (Post post : postList) {
			post = setExternalImages(post);
			post.setContent(makeContentThumbnail(post.getContent()));
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		}
		return new ListContainer(postList, page);
	}

	@Override
	public ListContainer getPostsByTag(int currentPage, int pageSize,
			int pageGroupSize, int tagId) {
		Page page = new Page(currentPage, pageSize, pageGroupSize, postDao.getTotalCountByTag(tagId));
		List<Post> postList = postDao.getPostsByTag(tagId, page);
		for (Post post : postList) {
			post = setExternalImages(post);
			post.setContent(makeContentThumbnail(post.getContent()));
			post.setTags(tagService.getTagsByPostId(post.getPostId()));
		}
		return new ListContainer(postList, page);
	}

	public String makeContentThumbnail(String content) {
		String text = null;
		Document doc = Jsoup.parseBodyFragment(content);
		doc.select("pre").remove();
		text = new HtmlToPlainText().getPlainText(doc);
		if (text!=null && text.length()>200) {
			text = text.substring(0, 200);
			text += "... <span class='label label-primary'>더 보기</span>";
		} else if (text!=null && text.trim().length()==0) {
			text += "내용이 없습니다.";
		}
		return text;
	}
	
	@Override
	public void imageUpload(HttpServletRequest request,
			HttpServletResponse response, MultipartFile upload) {
		
		if(upload!=null && upload.getSize()!=0) {
			
			// resources/images/post
			String contextPath = "resources" + File.separator + "images" + File.separator +"post" + File.separator;
			// 파일이 저장될 서버 경로
			String realPath = new HttpServletRequestWrapper(request).getRealPath("/") + contextPath;
			new File(realPath).mkdirs();
		
			
			PrintWriter printWriter = null; 
			
			try {
				// 확장자 추출
				String originalFileName = upload.getOriginalFilename();
				String extension = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				// 파일 업로드
				long currentTime = System.currentTimeMillis();
				Date date = new Date(currentTime);
				SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd_"+currentTime);
				upload.transferTo(new File(realPath + sdf.format(date) + "." + extension));
				String imgFileName = sdf.format(date) + "." + extension;
				String callback = request.getParameter("CKEditorFuncNum");
					printWriter = response.getWriter();
		        
		        // <img src="이곳에 들어갈 파일 경로">
		        String fileUrl = "/blog/resources/images/post/" + imgFileName;//url경로
		
		        printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
		                + callback
		                + ",'"
		                + fileUrl
		                + "','이미지를 업로드 하였습니다.'"
		                + ")</script>");
		        
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } finally {
	        	printWriter.flush();
	        } // try-catch end
			
		} // if end
	}
	
	
	public Post setExternalImages(Post post){
		if(post!=null && post.getContent()!=null) {
			String html = post.getContent();
			Document doc = Jsoup.parse(html);
			Elements media = doc.select("[src]");
			if(media.size()!=0) {
				for (Element img : media) {
					if(img.tagName().equals("img")) {
						String src =  img.attr("src");
								post.setThumbnailImagePathList(new ArrayList<String>());
								post.getThumbnailImagePathList().add(src);
								break; //어차피 썸네일은 하나만 가져오면 되니까
					}
				}
			}
		}
		return post;
	}
	
	/**
	 * post 객체를 받아 content 안의 img 태그를 파싱해서
	 * 이미지 이름을 데이터베이스에 저장.
	 * @param post
	 */
	public void imageProcess(Post post){
		if (post != null && post.getContent() != null) {
			String html = post.getContent();
			Document doc = Jsoup.parse(html);
			Elements media = doc.select("[src]");
			
			for (Element img : media) {
				if(img.tagName().equals("img")) {
					String src =  img.attr("src");
					if(src.startsWith("/blog/resources/images/post/")) {
						String name = src.substring(src.lastIndexOf("/") + 1, src.length());
						imageDao.insertImage(new Image(post.getPostId(), name));
					}
				}
			}
			
		}
	}
	
	public void imageProcessWhenUpdatePost(Post post, HttpServletRequest request){
		if (post != null && post.getContent() != null) {
			String html = post.getContent();
			Document doc = Jsoup.parse(html);
			Elements media = doc.select("[src]");
			List<Image> dbList = imageDao.getImagesByPostId(post.getPostId());
			
			if(dbList!=null && dbList.size()>0) { // 사진이 1개 이상 등록되어있던 게시물일 때
				
			
				// Post 수정시 이미지가 추가되었으면 DB에도 추가
				for (Element img : media) {
					if(img.tagName().equals("img")) {
						String src =  img.attr("src");
						if(src.startsWith("/blog/resources/images/post/")) {
							boolean insertFlag = true;
							String name = src.substring(src.lastIndexOf("/") + 1, src.length());
							for (Image dbImage : dbList) {
								if(dbImage.getName().equals(name)) {
									insertFlag = false;
									break;
								}
							}
							
							if (insertFlag) {
								imageDao.insertImage(new Image(post.getPostId(), name));
								insertFlag = false;
							}
						}
					}
				}
				
				// Post 수정시 이미지가 삭제되었으면 DB와 Local에서 삭제
				String contextPath = "resources" + File.separator + "images" + File.separator +"post" + File.separator;
				String realPath = new HttpServletRequestWrapper(request).getRealPath("/") + contextPath;
					for (Image dbImage : dbList) {
						boolean deleteFlag = true;
						if(media.size()!=0) {
							for (Element img : media) {
								if(img.tagName().equals("img")) {
									String src =  img.attr("src");
									if(src.startsWith("/blog/resources/images/post/")) {
										String name = src.substring(src.lastIndexOf("/") + 1, src.length());
										if(dbImage.getName().equals(name)) {
											deleteFlag = false;
											break;
										} 
									}
								} 
							}
						
						} else {
							deleteFlag = true;
						}
						
						if (deleteFlag) {
							imageDao.deleteImage(dbImage.getImageId());
							new File(realPath+dbImage.getName()).delete();
						}
						
					}
			
			} else { // 원래 사진이 하나도 없었던 게시물일 때
				for (Element img : media) {
					if(img.tagName().equals("img")) {
						String src =  img.attr("src");
						if(src.startsWith("/blog/resources/images/post/")) {
							String name = src.substring(src.lastIndexOf("/") + 1, src.length());
							imageDao.insertImage(new Image(post.getPostId(), name));
						}
					}
				}
			}
		
		
		}
	}
}
