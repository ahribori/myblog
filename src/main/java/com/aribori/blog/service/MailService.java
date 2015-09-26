package com.aribori.blog.service;

import com.aribori.blog.domain.ContactMe;
import com.aribori.blog.domain.Mail;

public interface MailService {
	
	public void sendMail(Mail mail);

	public void contactMe(ContactMe contactMe);
}
