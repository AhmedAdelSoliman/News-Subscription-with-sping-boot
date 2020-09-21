package com.ahmed.adel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
@Table
public class NewsType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column
    private String Name;
	@Column
    private String IconURL;
	
	@ManyToMany(mappedBy = "newsTypeslist" ,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AuthenticationRequest> AuthenticationRequestlist;
	
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIconURL() {
		return IconURL;
	}
	public void setIconURL(String iconURL) {
		IconURL = iconURL;
	}
	
	/*public List<AuthenticationRequest> getAuthenticationRequestlist() {
		return AuthenticationRequestlist;
	}*/
	public void setAuthenticationRequestlist(List<AuthenticationRequest> authenticationRequestlist) {
		AuthenticationRequestlist = authenticationRequestlist;
	}


	public void AddAuthenticationRequestlist(AuthenticationRequest theAuthenticationRequest) {
		if(AuthenticationRequestlist == null) {
			AuthenticationRequestlist=new ArrayList<>();
		}
		AuthenticationRequestlist.add(theAuthenticationRequest);
	}
	

}
