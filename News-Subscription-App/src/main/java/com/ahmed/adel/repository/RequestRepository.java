package com.ahmed.adel.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ahmed.adel.model.AuthenticationRequest;

public interface RequestRepository extends JpaRepository<AuthenticationRequest, Integer> {
	
	
	//Optional<AuthenticationRequest> findById(int id);
	Optional<AuthenticationRequest> findByUserName(String userName);
	
    @Transactional
	@Query(value = "SELECT * FROM user INNER JOIN news_type ON user.id=news_type.id where user.id=?1 ; " , nativeQuery = true)
	public List<AuthenticationRequest> findUserAllNews(int id);
    
    @Modifying
	@Transactional
	@Query(value= "delete from users_news where user_id=?1 and news_id=?2 ;" , nativeQuery =true )
    public void deleteNewsTypeFromUser(int user_id ,int NewsType_id);
    
    

}
