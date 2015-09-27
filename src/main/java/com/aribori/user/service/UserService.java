package com.aribori.user.service;

import com.aribori.user.domain.FindUserInformationForm;
import com.aribori.user.domain.User;

public interface UserService {
	
	public boolean isExistUsername(String username);
	
	public boolean isExistEmail(String email);

	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	public void registerUser(User user);

	public void sendUserinfoMail(
			FindUserInformationForm findUserInformationForm);

	public void sendRegisterAuthMail(User user);
}
