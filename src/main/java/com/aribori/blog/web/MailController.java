package com.aribori.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aribori.blog.domain.ContactMe;
import com.aribori.blog.service.MailService;

@Controller
public class MailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping (value="/contact", method=RequestMethod.POST)
	public String contact(ContactMe contactMe) {
		if(contactMe != null && contactMe.getSender() != null && contactMe.getMessage() != null) {
			try {
				mailService.contactMe(contactMe);
			} catch (Exception e) {
				System.out.println(e);
				return "redirect:/";
			}
		}
		return "redirect:/";
	}
	
}
