package com.sreenu.online.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sreenu.online.ecommerce.model.UserRegistrationModel;
import com.sreenu.online.ecommerce.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService {
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	public UserRegistrationModel userregister(UserRegistrationModel user) {
		UserRegistrationModel urm = null;
		if(user.password.equals( user.confirmpassword)) {
		 urm =	userRegistrationRepository.save(user);
		}
		return urm;
	}

}
