package com.aribori.blog.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.aribori.blog.domain.ContactMe;
import com.aribori.blog.domain.Mail;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMail(Mail mail) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setSubject(mail.getSubject(), "utf-8");
			message.setText(mail.getContent(), "utf-8", "html");
			message.setFrom(new InternetAddress("devnote.kosta@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(mail.getRecipient()));
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void contactMe(ContactMe contactMe) {
		String subject = contactMe.getSender() + " 이 보낸 메세지";
		String content = contactMe.getSender() + " 이 보낸 메세지<br>"
				+ "<div style='margin-top:15px;margin-bottom:15px;padding-top:10px;padding-bottom:10px;"
				+ "border-top:1px solid;border-bottom:1px solid;width:200px;'>"
				+ contactMe.getMessage()
				+ "</div>";
		String recipient = "hs9923@naver.com";
		Mail mail = new Mail(subject, content, recipient);
		sendMail(mail);
	}

}
