package com.app.Registrations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Registrations.model.Users;

public interface RegistrationRepository extends JpaRepository<Users, Integer> {

	public Users findByEmailId(String emailId);
	public Users findByEmailIdAndPassword(String emailId, String password);

}
