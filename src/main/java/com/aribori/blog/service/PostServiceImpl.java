package com.aribori.blog.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aribori.blog.dao.PostDao;
import com.aribori.blog.domain.Post;
import com.aribori.common.lib.ListContainer;
import com.aribori.common.lib.Page;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostDao postDao;

	@Override
	public Post insertPost(Post post) {
		return postDao.insertPost(post);
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
		return postDao.getPost(postId);
	}

	@Override
	public Post getPostNoHits(int postId) {
		return postDao.getPost(postId);
	}

	@Override
	public void updatePost(Post post) {
		postDao.updatePost(post);
	}

	@Override
	public void deletePost(int postId) {
		postDao.deletePost(postId);
	}

	@Override
	public ListContainer getPosts(int currentPage) {
		Page page = new Page(currentPage, postDao.getTotalCount());
		List<Post> postList = postDao.getPosts(page);
		for (Post post : postList) {
			post.setContent(makeContentThumbnail(post.getContent()));
		}
		return new ListContainer(postList, page);
	}
	
	@Override
	public ListContainer getPosts(int currentPage, int pageSize, int pageGroupSize) {
		Page page = new Page(currentPage, pageSize, pageGroupSize, postDao.getTotalCount());
		List<Post> postList = postDao.getPosts(page);
		for (Post post : postList) {
			post.setContent(makeContentThumbnail(post.getContent()));
		}
		return new ListContainer(postList, page);
	}
	
	public String makeContentThumbnail(String content) {
		String text = null;
		Document doc = Jsoup.parseBodyFragment(content);
		text = new HtmlToPlainText().getPlainText(doc);
		if (text.length()>200) {
			text = text.substring(0, 200);
			text += "... <span class='label label-default'>내용 전체 보기</span>";
		}
		return text;
	}

	@Override
	public void imageUpload(HttpServletRequest request,
			HttpServletResponse response, MultipartFile upload) {
		
		if(upload!=null && upload.getSize()!=0) {
			
			// resources/images/post
			String contextPath = "resources" + File.separator + "images" + File.separator +"post" + File.separator;
			System.out.println("contextPath = " + contextPath);
			// 파일이 저장될 서버 경로
			String realPath = new HttpServletRequestWrapper(request).getRealPath("/") + contextPath;
			System.out.println("realPath = " + realPath);
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
}
