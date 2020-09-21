package com.ahmed.adel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.adel.model.AuthenticationRequest;
import com.ahmed.adel.model.AuthenticationResponse;
import com.ahmed.adel.security.JwtUtil;
import com.ahmed.adel.security.MyUserDetailsService;
import com.ahmed.adel.services.RequestUserService;

@RestController
class RequestController {
    
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private RequestUserService RequestUserService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	@PostMapping("/addUserNews")
	public AuthenticationRequest addUser_News(@RequestBody AuthenticationRequest theUser) {
		
		theUser.setId(theUser.getId());
		
		RequestUserService.addUserNews(theUser);
		
		return theUser;
	}
	
	@GetMapping("/userAllnews")
	public List<AuthenticationRequest> findUserAllNews() {
		return RequestUserService.findUserAllNews(userDetailsService.getUser().get().getId());
	}
	
	@DeleteMapping("/deleteNewsType/{UserId}/{NewsTypeId}")
	public String deleteNewsType(@PathVariable(value = "UserId") int UserId ,
			        @PathVariable(value = "NewsTypeId") int NewsTypeId ) {
		 RequestUserService.deleteNewsTypeFromUser(UserId, NewsTypeId);
		 return "Deleted News Type_id = "+NewsTypeId+" from User_Id = "+UserId;
		 
	}
	
	
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
          
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
