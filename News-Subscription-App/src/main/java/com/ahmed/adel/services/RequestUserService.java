package com.ahmed.adel.services;

import java.util.List;

import com.ahmed.adel.model.AuthenticationRequest;

public interface RequestUserService {

	public void addUserNews(AuthenticationRequest user);
	
	public List<AuthenticationRequest> findUserAllNews(int id);
	public AuthenticationRequest findById(int theId);
	
	public void deleteNewsTypeFromUser(int user_id ,int NewsType_id);
}
