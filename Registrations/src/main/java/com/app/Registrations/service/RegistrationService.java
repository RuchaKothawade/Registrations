package com.app.Registrations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Registrations.model.Users;
import com.app.Registrations.repository.RegistrationRepository;

@Service
public class RegistrationService {
@Autowired
private RegistrationRepository repo;
public Users saveUser(Users user) {
	return repo.save(user);
}
public Users fetchUserByEmailId(String email) {
	return repo.findByEmailId(email);
	
}
public Users fetchUserByEmailIdAndPassword(String email,String password) {
	return repo.findByEmailIdAndPassword(email, password);
	
}
}
