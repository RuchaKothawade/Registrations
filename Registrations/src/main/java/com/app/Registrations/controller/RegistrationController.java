package com.app.Registrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.app.Registrations.model.Users;
import com.app.Registrations.service.RegistrationService;

@RestController
	public class RegistrationController {
		@Autowired
		private RegistrationService service;
	@PostMapping("/registeruser")
	@CrossOrigin(origins= "http://localhost:4200")
	public Users registerUser(@RequestBody Users user) throws Exception {
			String tempEmailId = user.getEmailId();
			if(tempEmailId != null  && "".contentEquals(tempEmailId))
			{
				Users userobj=service.fetchUserByEmailId(tempEmailId);
				if(userobj !=null) {
					throw new Exception("user with"+tempEmailId + "is already exist");
				}
			}
		Users userObj =null;
		service.saveUser(user);
		return userObj;
	}
	@PostMapping("/login")
	@CrossOrigin(origins= "http://localhost:4200")
	public Users loginUser(@RequestBody Users user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPass =user.getPassword();
		Users userObj = null;
		if(tempEmailId != null && tempPass != null) {
			userObj= service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj ==null)
		{
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
}

