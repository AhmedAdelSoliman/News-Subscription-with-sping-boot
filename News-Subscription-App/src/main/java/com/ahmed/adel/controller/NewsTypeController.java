package com.ahmed.adel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.adel.model.NewsType;
import com.ahmed.adel.services.NewsTypeService;

@RestController
@RequestMapping("/")
public class NewsTypeController {
	
		@Autowired
		private NewsTypeService NewsTypeService;
		
	/*	@GetMapping("/newsType")
		public List<NewsType> getNewsType() {
			
			return NewsTypeService.getAllNewsType();
			
		}*/
		
		
		//pagenation
		@GetMapping("/newsType")
	    public ResponseEntity<List<NewsType>> getNewsType(
	                        @RequestParam(defaultValue = "0") Integer pageNo, 
	                        @RequestParam(defaultValue = "10") Integer pageSize
	                       ) 
	    {
	        List<NewsType> list = NewsTypeService.getAllNewsType(pageNo, pageSize);
	 
	        return new ResponseEntity<List<NewsType>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }

}
