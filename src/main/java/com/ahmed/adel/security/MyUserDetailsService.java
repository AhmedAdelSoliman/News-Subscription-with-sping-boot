package com.ahmed.adel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ahmed.adel.model.AuthenticationRequest;
import com.ahmed.adel.repository.RequestRepository;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	RequestRepository requestRepository;
    
	private Optional<AuthenticationRequest> user;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       
    	
    	 user= requestRepository.findByUserName(userName);
		user.orElseThrow(()->new UsernameNotFoundException("user not found : "+userName));
		
		return new User(user.get().getUserName() ,user.get().getPassword() ,new ArrayList<>());
    }

	public Optional<AuthenticationRequest> getUser() {
		return user;
	}

	public void setUser(Optional<AuthenticationRequest> user) {
		this.user = user;
	}
    
    
    
}