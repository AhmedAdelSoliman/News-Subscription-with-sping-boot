package com.ahmed.adel.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.ahmed.adel.model.NewsType;
import com.ahmed.adel.repository.NewsTypeRepository;



@Service
public class NewsTypeServiceImpl implements NewsTypeService {

	@Autowired
	NewsTypeRepository newsTypeRepository;
	
	
	@Override
	public List<NewsType> getAllNewsType(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
        Page<NewsType> pagedResult = newsTypeRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<NewsType>();
        }
	}

}
