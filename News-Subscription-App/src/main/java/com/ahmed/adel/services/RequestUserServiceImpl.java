package com.ahmed.adel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.adel.model.AuthenticationRequest;
import com.ahmed.adel.repository.RequestRepository;

@Service
public class RequestUserServiceImpl implements RequestUserService {
     
	@Autowired
	RequestRepository RequestRepository;
	
	@Override
	public void  addUserNews(AuthenticationRequest user) {
		RequestRepository.save(user);

	}

	@Override
	public List<AuthenticationRequest> findUserAllNews(int id) {
		// TODO Auto-generated method stub
		return RequestRepository.findUserAllNews(id);
	}
	
	@Override
	public AuthenticationRequest findById(int theId) {
		Optional<AuthenticationRequest> result=RequestRepository.findById(theId);
		AuthenticationRequest obj=null;
		  if(result.isPresent()) {
			  obj=result.get();
		  }else {
			throw new RuntimeException("Not find User id : "+theId);
		}
		return obj;
	}
	

	@Override
	public void deleteNewsTypeFromUser(int user_id, int NewsType_id) {
		RequestRepository.deleteNewsTypeFromUser(user_id, NewsType_id);
		
	}

	

	

}
