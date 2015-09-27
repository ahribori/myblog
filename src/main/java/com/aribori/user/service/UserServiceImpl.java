package com.aribori.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aribori.blog.domain.Mail;
import com.aribori.blog.service.MailService;
import com.aribori.user.dao.UserDao;
import com.aribori.user.domain.Authority;
import com.aribori.user.domain.FindUserInformationForm;
import com.aribori.user.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MailService mailService;
	
	@Override
	public boolean isExistUsername(String username) {
		return userDao.findUserByUsername(username)!=null;
	}

	@Override
	public boolean isExistEmail(String email) {
		return userDao.findUserByEmail(email)!=null;
	}

	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	@Override
	public void registerUser(User user) {
		userDao.insertUser(user);
		userDao.insertAuthority(new Authority(user.getUsername(), "ROLE_USER"));
	}
	
	@Override
	public void sendUserinfoMail(FindUserInformationForm findUserInformationForm) {
		User user = userDao.findUserByEmail(findUserInformationForm.getEmail());
		String subject = "aribori.com 아이디/비밀번호 찾기 결과";
		String content = "aribori.com에 등록하실 때 기입하신 사용자 정보 입니다.<br>"
				+ "<div style='margin-top:15px;margin-bottom:15px;padding-top:10px;padding-bottom:10px;"
				+ "border-top:1px solid;border-bottom:1px solid;width:200px;'>"
				+ "Username : " + user.getUsername() + "<br>" 
				+ "Password : " + user.getPassword()
				+ "</div>";
		String recipient = findUserInformationForm.getEmail();
		Mail mail = new Mail(subject, content, recipient);
		mailService.sendMail(mail);
	}

	@Override
	public void sendRegisterAuthMail(User user) {
		String subject = "aribori.com 가입 인증 메일입니다.";
		String content = "aribori.com 가입 인증 메일입니다.<br>"
				+ "<form action='http://danielhs.iptime.org/devnote/user' method='post'>"
				+ "<input type='hidden' name='username' value='"+ user.getUsername() +"'>"
				+ "<input type='hidden' name='password' value='"+ user.getPassword() +"'>"
				+ "<input type='hidden' name='email' value='"+ user.getEmail() +"'>"
				+ "<button type='submit'>이 버튼을 클릭하시면 가입이 완료됩니다.</button>" 
				+ "</form>";
		String recipient = user.getEmail();
		Mail mail = new Mail(subject, content, recipient);
		mailService.sendMail(mail);
	}

}
